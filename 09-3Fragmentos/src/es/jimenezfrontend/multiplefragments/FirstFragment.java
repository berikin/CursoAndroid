package es.jimenezfrontend.multiplefragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FirstFragment extends Fragment {
	@Override
	public View onCreateView ( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

		// Inflate the layout for this fragment
		View view = inflater.inflate ( R.layout.superior_fragment, container, false );
		return view;
	}
}
