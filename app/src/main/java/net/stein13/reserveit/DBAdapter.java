package net.stein13.reserveit;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.MenuItem;

/**
 * Created by gregory on 10/23/14.
 */
public class DBAdapter extends SQLiteOpenHelper {
    public SQLiteDatabase db;
    protected SQLiteOpenHelper DBHelper;

    public static final String TABLE_RESERVATIONS = "reservations";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LNAME = "lname";
    public static final String COLUMN_FNAME = "fname";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_ROOMS = "rooms";
    public static final String COLUMN_DEPARTURE = "departure";
    public static final String COLUMN_XRATE = "xrate";
    public static final String COLUMN_NOTES = "notes";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_STADDRESS = "staddress";

    protected static final String DATABASE_NAME = "reservations.db";
    protected static final int DATABASE_VERSION = 2;

    protected static final String DATABASE_CREATE = "create table "
            + TABLE_RESERVATIONS + "(" + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_LNAME       + " text not null, "
            + COLUMN_FNAME       + " text, "
            + COLUMN_DATE        + " text not null, "
            + COLUMN_ROOMS       + " text not null, "
            + COLUMN_DEPARTURE   + " text, "
            + COLUMN_XRATE       + " text, "
            + COLUMN_NOTES       + " text, "
            + COLUMN_EMAIL       + " text, "
            + COLUMN_PHONE       + " text not null, "
            + COLUMN_STADDRESS   + " text);";

    public DBAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public DBAdapter open() throws SQLException
    {
        
        db = getWritableDatabase();
        return this;
    }
   // public Cursor getAllRows() {
   //     String where = null;
   //     Cursor c = db.query(true, DATABASE_NAME, ALL_COLUMNS, where, null, null, null, null, null);
   //     if (c != null)
   //     {
   //         c.moveToFirst();
   //     }
   //     return c;
   // }

    public long insertReservation(String lastNameValue, String firstNameValue, String arrivalValue, String  departureValue, String roomValue, String emailValue, String phoneValue, String staddressValue)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(COLUMN_LNAME, lastNameValue);
        initialValues.put(COLUMN_FNAME, firstNameValue);
        initialValues.put(COLUMN_DATE, arrivalValue);
        initialValues.put(COLUMN_DEPARTURE, departureValue);
        initialValues.put(COLUMN_ROOMS, roomValue);
        initialValues.put(COLUMN_EMAIL, emailValue);
        initialValues.put(COLUMN_PHONE, phoneValue);
        initialValues.put(COLUMN_STADDRESS, staddressValue);

        return db.insert(TABLE_RESERVATIONS, null, initialValues);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBAdapter.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESERVATIONS);
        onCreate(db);
    }


}
