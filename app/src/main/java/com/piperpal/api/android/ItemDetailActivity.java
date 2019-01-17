package com.piperpal.api.android;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.TextView;

import com.piperpal.api.App;
import com.piperpal.api.HTTPHandler;
import com.piperpal.api.android.dummy.DummyContent;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URL;

/**
 * An activity representing a single Item detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link ItemListActivity}.
 */

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HTTPHandler sh = new HTTPHandler();
                Context thisActivity = App.getContext();
                String url = "https://piperpal.com/app/android"; // + mContentView.getText().toString();
		String result = sh.makeServiceCall(url, HTTPHandler.GET);
		if (ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
		    Snackbar.make(view, result + "/" + getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID), Snackbar.LENGTH_LONG);
		} else {
		    Snackbar.make(view, "Location Permission Denied", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
		}
                // Making a request to url and getting response
		// TextView mContentView = (TextView) view.findViewById(R.id.item_detail_container);
                // if (ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                //     Snackbar.make(view, "https://piperpal.com/", Snackbar.LENGTH_LONG)
                //             .setAction("Action", null).show();
                // } else {
                //     Snackbar.make(view, "Location Permission Denied", Snackbar.LENGTH_SHORT)
                //             .setAction("Action", null).show();
                // }
                //Snackbar.make(view, "Mark your current geo with" + getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID.toString()), Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                // HttpURLConnection urlConnection = null;
                // try {
                //    URL url = new URL("http://api.piperpal.com/location/push.php?service=" + ItemDetailFragment.ARG_ITEM_ID + "&glat=60&glon=10");
                //    urlConnection = (HttpURLConnection) url.openConnection();
                //    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                //    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                //    StringBuilder result = new StringBuilder();
                //    String line;
                //    while ((line = reader.readLine()) != null) {
                //        result.append(line);
                //    }
                //    System.out.println(result.toString());
                // } catch (IOException e) {
                //    throw new RuntimeException(e);
                // } finally {
                //    urlConnection.disconnect();
                // }

            }
        });

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID));
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, ItemListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
