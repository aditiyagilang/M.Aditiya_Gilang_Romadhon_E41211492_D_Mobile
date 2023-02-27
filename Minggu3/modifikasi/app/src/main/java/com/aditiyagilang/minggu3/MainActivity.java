package com.aditiyagilang.minggu3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.aditiyagilang.minggu3.design.MahasiswaAdapter;
import com.aditiyagilang.minggu3.model.sosmedlist;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private ArrayList<sosmedlist> sosmedlists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = findViewById(R.id.listview);
        sosmedlists = setMedsosAndName();
        MahasiswaAdapter mahasiswaAdapter = new MahasiswaAdapter(MainActivity.this,sosmedlists);
        listView.setAdapter(mahasiswaAdapter);
        listView.setOnItemClickListener(this);

    }

    private ArrayList<sosmedlist> setMedsosAndName(){
        sosmedlists = new ArrayList<>();

        sosmedlists.add(new sosmedlist(R.drawable.facebook, "Facebook"));
        sosmedlists.add(new sosmedlist(R.drawable.in, "Link In"));
        sosmedlists.add(new sosmedlist(R.drawable.gmail, "GMail"));
        sosmedlists.add(new sosmedlist(R.drawable.skype, "Skype"));
//        sosmedlists.add(new sosmedlist(R.drawable.Snapchat, "SnapChat"));
        sosmedlists.add(new sosmedlist(R.drawable.pinterest, "Pinterest"));
        sosmedlists.add(new sosmedlist(R.drawable.telegram, "Telegram"));
//        sosmedlists.add(new sosmedlist(R.drawable.instagram, "Instagram"));
        sosmedlists.add(new sosmedlist(R.drawable.tiktok, "TikTok"));
        sosmedlists.add(new sosmedlist(R.drawable.twitter, "Twitter"));
        sosmedlists.add(new sosmedlist(R.drawable.weibo, "Weiboo"));
        sosmedlists.add(new sosmedlist(R.drawable.whatsap, "WhatsApp"));
        sosmedlists.add(new sosmedlist(R.drawable.youtube, "Youtube"));
        sosmedlists.add(new sosmedlist(R.drawable.zoom, "Zoom"));
        return sosmedlists;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        sosmedlist list = sosmedlists.get(position);
        Toast.makeText(MainActivity.this, "Social Media Name ..." + list.getName(), Toast.LENGTH_SHORT).show();
    }
}