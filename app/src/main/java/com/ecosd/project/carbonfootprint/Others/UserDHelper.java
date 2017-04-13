package com.ecosd.project.carbonfootprint.Others;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Models.UserModel;

/**
 * Created by this pc on 11-04-17.
 */

public class UserDHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "User";
    private static final String TABLE_USERS = "Users";
    private static final String USER_ID = "id";
    private static final String USER_NAME = "name";
    private static final String USER_PASSWORD = "password";
    private static final String EMAIL = "email";

    public UserDHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + USER_ID + " INTEGER PRIMARY KEY," + USER_NAME + " TEXT,"
                + USER_PASSWORD + " TEXT," + EMAIL + " TEXT" +")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    public void addContact(UserModel contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_NAME, contact.getUsername());
        values.put(USER_PASSWORD, contact.getPassword());
        values.put(EMAIL, contact.getEmailid());

        // Inserting Row
        db.insert(TABLE_USERS, null, values);

    }

    // Getting single contact
    public UserModel getContact(String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, new String[] { USER_ID,
                        USER_NAME, USER_PASSWORD,EMAIL }, USER_PASSWORD + "=?",
                new String[] { password }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        UserModel contact = new UserModel(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),cursor.getString(3));
        // return contact
        return contact;
    }

    // Getting All Contacts
    public List<UserModel> getAllContacts() {
        List<UserModel> contactList = new ArrayList<UserModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                UserModel contact = new UserModel();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setUsername(cursor.getString(1));
                contact.setPassword(cursor.getString(2));
                contact.setEmailid(cursor.getString(3));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    // Updating single contact
    public int updateContact(UserModel contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_NAME, contact.getUsername());
        values.put(USER_PASSWORD, contact.getPassword());
        values.put(EMAIL, contact.getEmailid());

        // updating row
        return db.update(TABLE_USERS, values, USER_ID + " = ?",
                new String[] { String.valueOf(contact.getId()) });
    }

    // Deleting single contact
    public void deleteContact(UserModel contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, USER_ID + " = ?",
                new String[] { String.valueOf(contact.getId()) });
        db.close();
    }


    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.close();

        // return count
        return cursor.getCount();
    }
}
