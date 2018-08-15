package com.example.ankurkarmakar.databaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Ankur Karmakar on 1/6/2018.
 */

public class UserDBHelper extends SQLiteOpenHelper{
    private static final String DB_NAME = "mywbut";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "users";
    private static final String COL_1 = "name";
    private static final String COL_2 = "email";
    private static final String COL_3 = "password";

    private static final String CREATE_QUERY = "CREATE TABLE "+TABLE_NAME
            +" ( "+COL_1+" text, "+COL_2
            +" text primary key, "+COL_3+" text)";

    public UserDBHelper(Context context)
    {
        super(context,DB_NAME,null,DB_VERSION);
        Log.i("DB MSG","Database Created!");

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.i("DB MSG","Table Created");


    }
    public void insertData(String name,String email,String password,SQLiteDatabase db){
        ContentValues content=new ContentValues();
        content.put(COL_1,name);
        content.put(COL_2,email);
        content.put(COL_3,password);

        db.insert(TABLE_NAME,null,content);
    }

    public Cursor viewData(SQLiteDatabase db)
    {
       Cursor cursor= db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
       return  cursor;
    }

    public Cursor searchData(SQLiteDatabase db, String name){
        Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+COL_1+" LIKE "+"'"+name+"'",null);
        return cursor;
    }

    public int updatedata(SQLiteDatabase db, String name, String email, String password)
    {
        ContentValues content=new ContentValues();
        content.put(COL_1,name);
        content.put(COL_2,email);
        content.put(COL_3,password);
        String where="email=?";
        String[] whereArgs={email};

       int status= db.update(TABLE_NAME,content,where,whereArgs);
       return status;
    }


    public int deleteData(SQLiteDatabase db,String email)
    {
        String where="email=?";
        String[] whereArgs={email};
        int num_rows=db.delete(TABLE_NAME,where,whereArgs);
        return  num_rows;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}