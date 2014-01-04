package es.jimenezfrontend.widget;

import java.util.Timer;
import java.util.TimerTask;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.RemoteViews;

public class Internet extends AppWidgetProvider {

	RemoteViews remoteViews;
	AppWidgetManager appWidgetManager;
	ComponentName thisWidget;
	ConnectivityManager connectivity;

	public void onUpdate ( Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds ) {
		Timer timer = new Timer ();
		timer.scheduleAtFixedRate ( new NetTimer ( context, appWidgetManager ), 1, 10000 );

	}

	private class NetTimer extends TimerTask {

		RemoteViews remoteViews;
		AppWidgetManager appWidgetManager;
		ComponentName thisWidget;

		public NetTimer(Context context, AppWidgetManager appWidgetManager) {

			this.appWidgetManager = appWidgetManager;
			remoteViews = new RemoteViews ( context.getPackageName (), R.layout.widget_main );
			thisWidget = new ComponentName(context, Internet.class);
			connectivity = ( ConnectivityManager ) context.getSystemService ( Context.CONNECTIVITY_SERVICE );

		}

		@Override
		public void run () {
			boolean conn = isConnectingToInternet ( connectivity );
			if ( conn ) {
				remoteViews.setTextViewText ( R.id.status_text, "Conectado" );
			}
			else {
				remoteViews.setTextViewText ( R.id.status_text, "¡No conectado!" );
			}

			appWidgetManager.updateAppWidget ( thisWidget, remoteViews );

		}

		private boolean isConnectingToInternet ( ConnectivityManager connectivity ) {
			if ( connectivity != null ) {
				NetworkInfo[] info = connectivity.getAllNetworkInfo ();
				if ( info != null ) {
					for ( int i = 0; i < info.length; i++ ) {
						if ( info[i].getState () == NetworkInfo.State.CONNECTED ) {
							return true;
						}
					}
				}
			}
			return false;
		}

	}
}
