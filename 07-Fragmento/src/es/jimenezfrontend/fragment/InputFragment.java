package es.jimenezfrontend.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class InputFragment extends Fragment {
	private static EditText edittext;
	ToolbarListener activityCallback;

	public interface ToolbarListener {
		public void onButtonClick ( String text );
	}

	@Override
	public void onAttach ( Activity activity ) {
		super.onAttach ( activity );
		try {
			activityCallback = ( ToolbarListener ) activity;
		}
		catch ( ClassCastException e ) {
			throw new ClassCastException ( activity.toString () + " must implement ToolbarListener" );
		}
	}

	@Override
	public View onCreateView ( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

		// Inflate the layout for this fragment
		View view = inflater.inflate ( R.layout.layout_input_fragment, container, false );
		edittext = ( EditText ) view.findViewById ( R.id.input_text );
		final Button button = ( Button ) view.findViewById ( R.id.button1 );
		button.setOnClickListener ( new View.OnClickListener () {
			public void onClick ( View v ) {
				buttonClicked ( v );
			}
		} );
		return view;
	}

	public void buttonClicked ( View view ) {
		activityCallback.onButtonClick ( edittext.getText ().toString () );
	}
}
