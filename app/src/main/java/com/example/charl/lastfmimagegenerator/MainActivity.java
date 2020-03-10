package com.example.charl.lastfmimagegenerator;

import androidx.appcompat.app.AppCompatActivity;
import de.umass.lastfm.Artist;
import de.umass.lastfm.Caller;
import de.umass.lastfm.Chart;
import de.umass.lastfm.User;

import android.os.Bundle;
import android.widget.TextView;

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

        invokeAPIMethods();
    }

    public void invokeAPIMethods(){
        String key = "b25b959554ed76058ac220b7b2e0a026";
        String user = "cwtyson";
    }
}
