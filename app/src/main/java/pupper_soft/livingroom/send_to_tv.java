package pupper_soft.livingroom;

import android.content.Intent;
import android.icu.util.Output;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import android.util.Log;

public class send_to_tv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_to_tv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView texty_box = (TextView) findViewById(R.id.textyBoi);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "How do I get rid of this button", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Get intent, action and MIME type
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type))
            {
                handleTextPlain(intent); //Probs just a link or some shit
            }
            else
            {
                // this should not happen
                texty_box.setText("WHAT HAVE YOU DONE?!?!?!?");
            }
        }
        else {
            // Handle other intents, such as being started from the home screen
            // This is bad
            texty_box.setText("I AM UNHANDLED");
        }
    }

    private class PostLinkTask extends AsyncTask<String, Void, Void>
    {
        private final String TAG = PostLinkTask.class.getSimpleName();
        protected Void doInBackground(String... params) {
            String serverAddress = params[0];
            String shareLink = params[1];
            Log.d(TAG,"WHAT THE ACTUAL SHIT " + serverAddress);
            Log.d(TAG, "DO A " + shareLink);

            return null;
        }
    }
    void handleTextPlain(Intent intent)
    {
        TextView texty_box = (TextView) findViewById(R.id.textyBoi);
        String textToShare = intent.getStringExtra(Intent.EXTRA_TEXT);
        if(textToShare != null)
        {
            texty_box.setText(textToShare);
            new PostLinkTask().execute("http://192.168.1.100:5000/link", textToShare);
        }
    }

}
