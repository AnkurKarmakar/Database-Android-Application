package com.example.ankurkarmakar.databaseapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {
    EditText emailInput;Button delete;
    SQLiteDatabase db;
    UserDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        emailInput=(EditText)findViewById(R.id.deleteEmailInput);
        delete=(Button)findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper=new UserDBHelper(DeleteActivity.this);
                db=helper.getWritableDatabase();
                int num_rows=helper.deleteData(db,emailInput.getText().toString());
                if(num_rows==0)
                    Toast.makeText(DeleteActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DeleteActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
