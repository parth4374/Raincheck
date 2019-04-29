package com.csc340.matb.raincheck;

import android.app.ActionBar;
import android.content.Intent;
import android.icu.text.StringSearch;
import android.location.Address;
import android.location.Geocoder;
import android.nfc.Tag;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SearchEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private EditText mSearchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearchText = (EditText) findViewById(R.id.input_search);

        init();
    }



    private void init() {

        mSearchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_SEARCH
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || actionId == KeyEvent.ACTION_DOWN
                        || actionId == KeyEvent.KEYCODE_ENTER) {

                    geoLocate();
                }
                return false;
            }
            });
        }



    private void geoLocate() {

        String searchString = mSearchText.getText().toString();

        Geocoder geocoder = new Geocoder(MainActivity.this);
        List<Address> list = new ArrayList<>();
           try {
               list = geocoder.getFromLocationName(searchString,1);
           }catch (IOException e) {
               e.printStackTrace();
           }

        if (list.size() > 0){
            Address address = list.get(0);
            Toast.makeText(this, address.toString(),Toast.LENGTH_SHORT).show();

            address.getLatitude();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.actionbar1,menu);
        return super.onCreateOptionsMenu(menu);
    }


}
