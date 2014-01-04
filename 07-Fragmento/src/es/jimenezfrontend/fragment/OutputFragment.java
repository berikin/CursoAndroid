package es.jimenezfrontend.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OutputFragment extends Fragment {

	private static TextView textview;

	@Override
	public View onCreateView ( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

		View view = inflater.inflate ( R.layout.layout_output_fragment, container, false );

		textview = ( TextView ) view.findViewById ( R.id.result_text );

		return view;
	}

	public void changeTextProperties ( String text ) {
		textview.setText ( text );
	}
}