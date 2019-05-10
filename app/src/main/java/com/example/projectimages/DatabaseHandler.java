package com.example.projectimages;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "gpng.db";

    private static final String TAG = "DatabaseHandler";
    public static final String TABLE_NAME = "Images";
    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_TIMESTAMP = "stamptime";
    public static final String COLUMN_NAME_IMG_PATH = "path";
    public static final String COLUMN_NAME_GPS_LONG = "gps_long";
    public static final String COLUMN_NAME_GPS_LAT = "gps_lat";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 3);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create table SQL query
            db.execSQL("CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,"
                    + COLUMN_NAME_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP,"
                    + COLUMN_NAME_IMG_PATH + " VARCHAR(128),"
                    + COLUMN_NAME_GPS_LAT + " DOUBLE,"
                    + COLUMN_NAME_GPS_LONG + " DOUBLE"
                    + ")");
        Log.w(TAG, "Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertData(String pathToFile, Double gps_lat, Double gps_long) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME_IMG_PATH, pathToFile);
        contentValues.put(COLUMN_NAME_GPS_LAT, gps_lat);
        contentValues.put(COLUMN_NAME_GPS_LONG, gps_long);
        long result = db.insert(TABLE_NAME, null, contentValues);

        Log.w(TAG, "Data Inserted");

    }

    public Cursor getPath(Double la, Double lo){

        Double lat = la;
        Double longe = lo;

        SQLiteDatabase db = this.getWritableDatabase();
        Log.w(TAG, "Before the cursor");
        Cursor cursor = db.rawQuery("select " + COLUMN_NAME_IMG_PATH + " from " + TABLE_NAME + " where " + COLUMN_NAME_GPS_LAT + " like " +  lat + " and " + COLUMN_NAME_GPS_LONG + " like " + longe , null);
        Log.w(TAG, "After the cursor");

        return cursor;
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME, null);

        return cursor;
    }

}