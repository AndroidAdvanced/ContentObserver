package com.app.mgu.contentobserver;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getContentResolver().
                registerContentObserver(
                        ContactsContract.AUTHORITY_URI,
                        true,
                        new MyObserver(new Handler()));
    }

    class MyObserver extends ContentObserver {

        public MyObserver(Handler handler) {
            super(handler);
        }

        @Override
        public void onChange(boolean selfChange) {
            this.onChange(selfChange, null);

            Toast.makeText(getBaseContext(), "On Change", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onChange(boolean selfChange, Uri uri) {
            // do s.th.
            // depending on the handler you might be on the UI
            // thread, so be cautious!

            Toast.makeText(getBaseContext(), "On Added", Toast.LENGTH_LONG).show();

        }
    }
}
