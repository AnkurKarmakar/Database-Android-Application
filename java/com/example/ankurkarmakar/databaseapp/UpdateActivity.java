package com.example.ankurkarmakar.databaseapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
EditText nameInput,emailInput, passwordInput;SQLiteDatabase db;UserDBHelper helper;
Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        nameInput=(EditText)findViewById(R.id.updateNameInput);
        emailInput=(EditText)findViewById(R.id.updateEmailInput);
        passwordInput=(EditText)findViewById(R.id.updatePasswordInput);
        update=(Button)findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper=new UserDBHelper(UpdateActivity.this);
                db=helper.getWritableDatabase();
                int status=helper.updatedata(db,nameInput.getText().toString(),emailInput.getText().toString(),passwordInput.getText().toString());
            if(status==1)
                Toast.makeText(UpdateActivity.this, "Congrats", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(UpdateActivity.this, "Failed", Toast.LENGTH_SHORT).show();



            }
        });

    }
}
