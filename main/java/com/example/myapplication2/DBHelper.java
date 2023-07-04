package com.example.myapplication2;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private static final String   DATABASE_NAME     = "diary.db";
    private static final int      DATABASE_VERSION  = 2;
    public static final  String   TABLE_NAME        = "information";
    public static final  String   COLUMN_ID         = "id";
    public static final  String   COLUMN_NAME       = "name";
    public static final  String   COLUMN_TITTLE     = "title";
    public static final  String   COLUMN_NOTE       = "note";
    public static final  String   COLUMN_PICTURE    = "picture";
    public static final  String   COLUMN_CREATETIME = "createtime";
    public static final  String[] TABLE_information = {
            COLUMN_ID,
            COLUMN_NAME,
            COLUMN_TITTLE,
            COLUMN_NOTE,
            COLUMN_CREATETIME,
            COLUMN_PICTURE
    };
    private              Context  mContext;

    public DBHelper(Context context) {
        this(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String sql = "CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME + " ( "
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " VARCHAR (32),"
                + COLUMN_TITTLE + " VARCHAR(32),"
                + COLUMN_NOTE + " VARCHAR(32),"
                + COLUMN_CREATETIME + " VARCHAR(32), "
                + COLUMN_PICTURE + " VARCHAR(200)) ";

        database.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        //增加content字段和createtime字段
        if (newVersion > oldVersion) {
            String alterTableQueryContent = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + COLUMN_NOTE + " VARCHAR(32)";
            database.execSQL(alterTableQueryContent);
            String alterTableQueryCreateTime = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + COLUMN_CREATETIME + " VARCHAR(32)"; // 添加createtime字段
            database.execSQL(alterTableQueryCreateTime);
        }
    }

}