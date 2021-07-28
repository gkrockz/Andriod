package com.example.sqldemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class MyDbHelper extends SQLiteOpenHelper
{
    @RequiresApi(api = Build.VERSION_CODES.P)
    // Initialization Of Database
    MyDbHelper(Context c)
    {
        super(c,"book.db",null,1);
        Log.i("MyDbHelper();","DB Initialized Successfully");
    }
    // Creation of Table (Callback Method)
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table bookinfo(bookid text primary key,bookname text)");
        Log.i("onCreate();","Table Created Successfully");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
    }

    public void insert(String bid,String bname)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("bookid",bid);
        cv.put("bookname",bname);

        long res = db.insert("bookinfo",null,cv);
        if(res==-1)
        {
            Log.i("Insert();", "Error Occurred During insertion");
        }
        else {
            Log.i("Insert();", "Data Inserted Successfully");
        }
    }

    public void read(String bname)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"bookid","bookname"};
        String selection = "bookname=?";
        String[] selectionArgs = {bname};
        Cursor c = db.query("bookinfo",columns,selection,selectionArgs,null,null,null);
        c.moveToFirst();
        String name = c.getString(1);
        String id = c.getString(0);
        Log.i("Read() ","Book Name: "+name+"|| Book Id: "+id);
    }

    public void delete(String bid)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String selection = "bookid=?";

        String[] selectionArgs = {bid};

        int c = db.delete("bookinfo",selection,selectionArgs);
        if(c==0)
        {
            Log.i("Delete() ", "Error while deleting");
        }
        else
        {
            Log.i("Delete() ", "Book Id: "+bid+" || Data Deleted Successfully ");
        }

    }


}
