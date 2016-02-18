package com.jcminarro.properdroidexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.jcminarro.properdroid.ProperDroid;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProperDroid properDroid = ProperDroid.with(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(properDroid.getString("publicVariantName", "ProperDroid Example"));
        setSupportActionBar(toolbar);
        ((TextView) findViewById(R.id.tv_hello)).setText(properDroid.getString("stringValue", ""));
        ((TextView) findViewById(R.id.tv_git_sha1)).setText(properDroid.getString("gitSha", ""));
        ((TextView) findViewById(R.id.tv_developer)).setText(properDroid.getString("developer", ""));
        ((TextView) findViewById(R.id.tv_releasable))
                .setText(String.valueOf(properDroid.getBoolean("booleanValue", false)));
        ((TextView) findViewById(R.id.tv_position)).setText(String.valueOf(properDroid.getInt("intValue", 0)));
    }
}
