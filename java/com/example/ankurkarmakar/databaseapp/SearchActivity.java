package com.example.ankurkarmakar.databaseapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {
EditText nameInput;
Button search;
SQLiteDatabase db;
UserDBHelper helper;
TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        nameInput=(EditText)findViewById(R.id.searchNameInput);
        search=(Button) findViewById(R.id.search);
        display=(TextView)findViewById(R.id.searchResult);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper=new UserDBHelper(SearchActivity.this);
                db=helper.getReadableDatabase();
                Cursor cursor=helper.searchData(db,nameInput.getText().toString());

                if(cursor.getCount()==0)
                    display.setText("No user found");
                else
                {
                    cursor.moveToFirst();
                    StringBuffer sb=new StringBuffer();
                    do{
                        sb.append("Name: "+cursor.getString(0)+"\n");
                        sb.append("Email: "+cursor.getString(1)+"\n\n");

                    }while(cursor.moveToNext());
                    display.setText(sb.toString());

            }
            }
        });
    }
}
