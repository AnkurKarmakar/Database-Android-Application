package com.example.ankurkarmakar.databaseapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {
TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        result=(TextView)findViewById(R.id.result);
        UserDBHelper helper=new UserDBHelper(ViewActivity.this);
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor cursor=helper.viewData(db);
        if(cursor.getCount()==0)
result.setText("No users");
else
{cursor.moveToFirst();

StringBuffer sb=new StringBuffer();
do{
sb.append("Name: "+cursor.getString(0)+"\n");
sb.append("Email: "+cursor.getString(1)+"\n");
sb.append("Passsword: "+cursor.getString(2)+"\n\n\n");

}
while(cursor.moveToNext());
result.setText(sb.toString());
}

}

}