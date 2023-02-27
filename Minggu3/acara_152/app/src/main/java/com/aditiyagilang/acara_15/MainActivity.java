package com.aditiyagilang.acara_15;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MahasiswaAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<Mahasiswa> mahasiswaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new MahasiswaAdapter(mahasiswaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
    void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa("Aditiya Gilang", "E41211492", "089509579032"));
        mahasiswaArrayList.add(new Mahasiswa("Reyhan Febriansyah", "E41211491", "082229474403"));
        mahasiswaArrayList.add(new Mahasiswa("Wishal Azharyan ", "E41211570", "082232937743"));
        mahasiswaArrayList.add(new Mahasiswa("Lusy Damayanti", "E41211262", "089503415644"));
        mahasiswaArrayList.add(new Mahasiswa("Karen Novita", "E41211595", "08386467271"));
        mahasiswaArrayList.add(new Mahasiswa("Andru Cristo", "E41211466", "085232398005"));
    }
}