package com.android.sunny.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NowPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        Intent intent = getIntent();
        String message = intent.getStringExtra(SongListActivity.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.song_name_text_view);
        textView.setText(message);
    }
}
