package es.jimenezfrontend.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Worker_Details_Fragment extends android.support.v4.app.Fragment {
	@Override
	public View onCreateView ( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
		return inflater.inflate ( R.layout.worker_details, container, false );
	}

	public void showDetails ( String text ) {
		TextView worker_details = ( TextView ) getView ().findViewById ( R.id.worker_details );
		worker_details.setText ( text );
	}
}
