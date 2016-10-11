package com.android.sunny.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SongListActivity extends AppCompatActivity {

    final private String LOG_TAG = SongListActivity.class.getSimpleName();
    public final static String EXTRA_MESSAGE = "com.android.sunny.musicapp.SongListActivity.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        ListView listView = (ListView) findViewById(R.id.list_view_music);
        final TextView textView = (TextView) findViewById(R.id.song_name_text_view);
        final String[] musicStrings = getResources().getStringArray(R.array.musiclist);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, musicStrings);
        listView.setAdapter(adapter);
        textView.setText(musicStrings[1]);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(musicStrings[position]);
            }
        });
    }

    public void nowPlaying(View view) {
        Intent intent = new Intent(SongListActivity.this, NowPlaying.class);
        TextView textView = (TextView) findViewById(R.id.song_name_text_view);
        intent.putExtra(EXTRA_MESSAGE, textView.getText().toString());
        startActivity(intent);
    }
}
