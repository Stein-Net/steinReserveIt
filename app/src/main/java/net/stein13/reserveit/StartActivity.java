package net.stein13.reserveit;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import net.stein13.reserveit.DBAdapter;


public class StartActivity extends Activity {
    DBAdapter db = new DBAdapter(this);
    ListView listView;
    EditText lastName, arrivalDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        listView = (ListView)findViewById(R.id.listView);
        lastName = (EditText) findViewById(R.id.lastName);
        arrivalDate = (EditText) findViewById(R.id.arrivalDate);


        // Attach The Data From DataBase Into ListView Using Crusor Adapter
       // Cursor cursor = db.readData();
      //  String[] from = new String[] { DBAdapter.COLUMN_LNAME, DBAdapter.COLUMN_DATE };
     //   int[] to = new int[] { R.id.lastName, R.id.arrivalDate };

    //        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
   //            StartActivity.this, R.layout.list_view_item, cursor, from, to);
  //
 //      adapter.notifyDataSetChanged();
//    listView.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void makeNewReservation(View view) {
        Intent intent = new Intent(this, NewReservation.class);
        startActivity(intent);
    }

 //TODO populate listView with data from SQLite database
 //TODO Create MonthView, MonthViewByRevenue, and Availability view/search the database for specific strings


}
