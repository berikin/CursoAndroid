package es.jimenezfrontend.fragments;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Workers_Fragment extends Fragment {
	private ArrayList<Worker> workers;
	private ListView worker_list;
	private GoToDetailsListener listener;

	@Override
	public View onCreateView ( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
		return inflater.inflate ( R.layout.layout_workers, container, false );
	}

	@Override
	public void onActivityCreated ( Bundle state ) {
		super.onActivityCreated ( state );
		workers = new ArrayList<Worker> ();
		workers.add ( new Worker ( getResources ().getString ( R.string.worker_one ), getResources ().getString ( R.string.worker_one_details ) ) );
		worker_list = ( ListView ) getView ().findViewById ( R.id.worker_list_fragment );
		worker_list.setAdapter ( new WorkersAdapter ( this ,R.layout.list_worker, workers));

		worker_list.setOnItemClickListener ( new OnItemClickListener () {
			@Override
			public void onItemClick ( AdapterView<?> list, View view, int pos, long id ) {
				if ( listener != null ) {
					listener.onWokerSelected ( ( Worker ) worker_list.getAdapter ().getItem ( pos ) );
				}
			}
		} );

	}

	class WorkersAdapter extends ArrayAdapter<Worker> {
		Activity context;
		private ArrayList<Worker> items;
		WorkersAdapter(Fragment context, int textViewResourceId, ArrayList<Worker> items) {
			super ( context.getActivity (), textViewResourceId, items );
			Log.d ( "Cantidad", workers.size () + "" );
			this.context = context.getActivity ();
			this.items=items;
		}
		@Override
		public int getCount() 
		{       
		    return items.size ();
		}

		@Override
		public Worker getItem(int arg0) 
		{
		    return items.get ( arg0 );
		}
		
		@Override
		public View getView ( int position, View convertView, ViewGroup parent ) {
			Log.e ( "Pasadas", position + "" );
			LayoutInflater inflater = context.getLayoutInflater();
		    convertView = inflater.inflate(R.layout.list_worker,null);        
		    Worker work = (Worker)getItem(position);
			TextView worker_name = ( TextView ) convertView.findViewById ( R.id.worker_name );
			worker_name.setText ( work.getName () );
			return ( convertView );
		}

	}

	public interface GoToDetailsListener {
		void onWokerSelected ( Worker c );
	}

	public void setWorkersListener ( GoToDetailsListener listener ) {
		this.listener = listener;
	}
}
