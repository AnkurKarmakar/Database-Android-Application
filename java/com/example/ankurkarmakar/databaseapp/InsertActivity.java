package com.example.ankurkarmakar.databaseapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    EditText insertNameInput,insertEmailInput,insertPasswordInput;Button insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        insertNameInput=(EditText)findViewById(R.id.insertNameInput);
        insertEmailInput=(EditText)findViewById(R.id.insertEmailInput);
       insertPasswordInput=(EditText)findViewById(R.id.insertPasswordInput);
        insert=(Button) findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDBHelper helper=new UserDBHelper(InsertActivity.this);
                SQLiteDatabase db=helper.getWritableDatabase();
                helper.insertData(insertNameInput.getText().toString(),insertEmailInput.getText().toString(),insertPasswordInput.getText().toString(),db);
                Toast.makeText(InsertActivity.this, "Insertion Done", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
