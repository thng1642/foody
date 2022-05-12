package hcmute.edu.vn.foodapp_16.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import hcmute.edu.vn.foodapp_16.Bean.Customer;

public class CustomerModel extends SQLiteOpenHelper {

    private static final String CUSTOMER_TABLE = "CUSTOMER";
    private static final String PHONE_COLUMN = "PHONE";
    private static final String FULLNAME_COLUMN = "FULLNAME";
    private static final String PASSWORD_COLUMN = "PASSWORD";

    public CustomerModel(@Nullable Context context) {
        super(context, "food.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + CUSTOMER_TABLE + " ("
                + PHONE_COLUMN + " TEXT PRIMARY KEY , "
                + FULLNAME_COLUMN + " TEXT, "
                + PASSWORD_COLUMN + " TEXT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(Customer customer) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(FULLNAME_COLUMN, customer.getFullName());
        cv.put(PHONE_COLUMN, customer.getPhone());
        cv.put(PASSWORD_COLUMN, customer.getPassword());

        long insert = db.insert(CUSTOMER_TABLE, null, cv);

        db.close();

        if (insert == -1 ){

            return false;
        }
        else return true;
    }

    public String findPassword(String phone) {

        // get data from database
        String queryString = "SELECT password FROM " + CUSTOMER_TABLE + " WHERE " + PHONE_COLUMN +
                 " =?";

        // only use getReadableDatabase() when SELECT items from the database
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, new String [] {phone});

        if (cursor.moveToFirst()) {

            String password;
            do {

                password = cursor.getString(0);
                break;

            } while (cursor.moveToNext());

            cursor.close();
            db.close();
            return password;
        }
        else {

            cursor.close();
            db.close();
            return null;
        }
    }
}
