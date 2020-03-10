package com.example.charl.lastfmimagegenerator;

import androidx.appcompat.app.AppCompatActivity;
import de.umass.lastfm.Artist;
import de.umass.lastfm.Caller;
import de.umass.lastfm.Chart;
import de.umass.lastfm.Period;
import de.umass.lastfm.User;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.widget.TextView;

import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.text.DateFormat;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textview);
        tv.setText("User-agent: " + Caller.getInstance().getUserAgent().toString());
        Caller.getInstance().setDebugMode(true);
        Socket socket = new Socket(Proxy.NO_PROXY);
        SocketAddress socketAddress = socket.getRemoteSocketAddress();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, socketAddress);
        Caller.getInstance().setProxy(proxy);

        invokeAPIMethods();
    }

    public void invokeAPIMethods(){
        String key = "7ccb2f3b2b05a58f1020e246ed2ed230";
        String user = "cwtyson";
        Collection<Artist> topArtists = User.getTopArtists(user, Period.WEEK, key);
        for(Artist artist : topArtists){
            Log.d("MainActivity", " invokeAPIMethods(): artist = " + artist.toString());
        }
    }
}
