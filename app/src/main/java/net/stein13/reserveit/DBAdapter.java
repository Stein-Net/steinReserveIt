package net.stein13.reserveit;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by gregory on 10/23/14.
 */
public class DBAdapter extends SQLiteOpenHelper {
    public SQLiteDatabase db;
    private SQLiteOpenHelper DBHelper;

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
    public static final String COLUMN_STADDRESS = "address";

    private static final String DATABASE_NAME = "reservations.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_RESERVATIONS + "(" + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_LNAME  + " text not null);"
            + COLUMN_FNAME  + " text not null);"
            + COLUMN_DATE   + " text not null);"
            + COLUMN_ROOMS  + " text not null);"
            + COLUMN_DEPARTURE  + " text not null);"
            + COLUMN_XRATE  + " text not null);"
            + COLUMN_NOTES  + " text not null);"
            + COLUMN_EMAIL  + " text not null);"
            + COLUMN_PHONE  + " text not null);"
            + COLUMN_STADDRESS  + " text not null);";

    public DBAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public DBAdapter open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        DBHelper.close();
    }
    public long insertReservation(String lastNameValue, String firstNameValue, String arrivalValue, String  departureValue, String roomValue, String emailValue, String phoneValue, String addressValue)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(COLUMN_LNAME, lastNameValue);
        initialValues.put(COLUMN_FNAME, firstNameValue);
        initialValues.put(COLUMN_DATE, arrivalValue);
        initialValues.put(COLUMN_DEPARTURE, departureValue);
        initialValues.put(COLUMN_ROOMS, roomValue);
        initialValues.put(COLUMN_EMAIL, emailValue);
        initialValues.put(COLUMN_PHONE, phoneValue);
        initialValues.put(COLUMN_STADDRESS, addressValue);

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
