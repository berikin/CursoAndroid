package es.jimenezfrontend.bcreceivercall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

public class LocListener extends BroadcastReceiver {

	LocationManager gps;
	LocationListener miloc;
	final SmsManager sms = SmsManager.getDefault ();

	@Override
	public void onReceive ( final Context context, Intent intent ) {
		gps = ( LocationManager ) context.getSystemService ( Context.LOCATION_SERVICE );
		Log.w ( "GPS", "EN ESPERA" );
		miloc = new LocationListener () {

			@Override
			public void onStatusChanged ( String provider, int status, Bundle extras ) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onProviderEnabled ( String provider ) {
				Log.w ( "GPS", "GPS ACTIVADO" );

			}

			@Override
			public void onProviderDisabled ( String provider ) {
				Log.w ( "GPS", "GPS DESACTIVADO" );

			}

			@Override
			public void onLocationChanged ( Location location ) {
				Double longitude = location.getLongitude ();
				Double latitude = location.getLatitude ();
				Log.w ( "GPS", "LATITUD: " + latitude );
				Log.w ( "GPS", "LONGITUD: " + longitude );
				Toast.makeText ( context, "Coordenadas: "+latitude+", "+longitude, Toast.LENGTH_LONG ).show ();
			}
		};
		gps.requestLocationUpdates ( LocationManager.GPS_PROVIDER, 0, 0, miloc );
	}
}