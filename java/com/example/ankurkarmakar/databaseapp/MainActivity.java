package com.example.ankurkarmakar.databaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button insertBtn,viewBtn,updateBtn,deleteBtn,searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertBtn=(Button)findViewById(R.id.insertBtn);
        viewBtn=(Button)findViewById(R.id.viewBtn);
        updateBtn=(Button)findViewById(R.id.updateBtn);
        deleteBtn=(Button)findViewById(R.id.deleteBtn);
        searchBtn=(Button)findViewById(R.id.searchBtn);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,InsertActivity.class);
                startActivity(i);
            }
        });
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,ViewActivity.class);
                startActivity(i);
            }
        });
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,SearchActivity.class);
                startActivity(i);
            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,UpdateActivity.class);
                startActivity(i);
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,DeleteActivity.class);
                startActivity(i);
            }
        });

    }
}
