package com.aditiyagilang.acara18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
btn1 = findViewById(R.id.firstfragment);
btn2 = findViewById(R.id.secundfragment);

btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        load(new fragment());
    }
});
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                load(new fragment2());
            }
        });

}
private void load(Fragment fragment){
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.frame,fragment);
    fragmentTransaction.commit();
}
}