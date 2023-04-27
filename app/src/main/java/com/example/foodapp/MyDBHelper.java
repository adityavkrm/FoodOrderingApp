package com.example.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "UserDB";
    public static final String TABLE_NAME = "signUpData";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE2_NAME = "cartData";

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase myDatabase) {
        myDatabase.execSQL("create table "+TABLE_NAME+"(name TEXT, email TEXT primary key, phone_no TEXT, password TEXT )");
        myDatabase.execSQL("create table "+TABLE2_NAME+"(title TEXT primary key, cost TEXT, quantity INTEGER, image INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDatabase, int oldVersion, int newVersion) {
        myDatabase.execSQL("drop table if exists "+TABLE_NAME);
        myDatabase.execSQL("drop table if exists "+TABLE2_NAME);
    }


    public boolean insertData(String name, String email, String phone_no, String password){
        SQLiteDatabase myDatabase = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("email",email);
        cv.put("phone_no",phone_no);
        cv.put("password",password);

        long result = myDatabase.insert(TABLE_NAME,null,cv);

        if(result == -1){
            return false;
        }else {
            return true;
        }
    }



    public void addDatatoCart(String title, String cost, int quantity, int image ){

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues cv = new ContentValues();
                cv.put("title",title);
                cv.put("cost",cost);
                cv.put("quantity",quantity);
                cv.put("image",image);

                db.insert(TABLE2_NAME,null,cv);
    }

    public void removeFromCart(String title){
        SQLiteDatabase db= this.getWritableDatabase();
        db.delete(TABLE2_NAME,"title = "+ '"'+title+'"',null);
    }

    public void deleteall(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE2_NAME,null,null);
    }
    public ArrayList<cartModel> fetchCart(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE2_NAME,null);

        ArrayList<cartModel> cartArrayList = new ArrayList<>();
        while (cursor.moveToNext()){

            cartModel cm = new cartModel(cursor.getString(0),cursor.getString(1), cursor.getInt(2),cursor.getInt(3) );
            cartArrayList.add(cm);
        }
        return cartArrayList;
    }




    public boolean checkEmail(String email){
        SQLiteDatabase myDatabase = this.getReadableDatabase();

        Cursor cursor = myDatabase.rawQuery("Select * from "+TABLE_NAME+" where email = ?", new String[]{email});

        if(cursor.getCount() >0){
            return true;
        }else {
            return false;
        }


    }

    public boolean checkEmailPassword( String email, String password ){

        SQLiteDatabase myDatabase = this.getReadableDatabase();

        Cursor cursor = myDatabase.rawQuery("Select * from "+TABLE_NAME+" where email = ? and password = ?",new String[]{email, password});

        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

    public Cursor fetchname(String email){
        SQLiteDatabase myDatabase = this.getReadableDatabase();

        Cursor cursor = myDatabase.rawQuery("Select name, email from "+TABLE_NAME+" where email = ?",new String[]{email});

        return cursor;

    }



}
