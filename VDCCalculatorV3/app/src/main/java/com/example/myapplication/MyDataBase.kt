package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class MyDataBase(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {

    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {}

    companion object {
        private const val DB_NAME = "test_db"
        private const val DB_VERSION = 1
    }
}
