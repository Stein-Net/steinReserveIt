package net.stein13.reserveit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class NewReservation extends Activity {
    DBAdapter db = new DBAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reservation);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_reservation, menu);
        return true;
    }
    public void submitReservation(View view) {
        db.open();
        EditText lastName = (EditText) findViewById(R.id.lastName);
        String lastNameValue = lastName.getText().toString();
        EditText firstName = (EditText) findViewById(R.id.firstName);
        String firstNameValue = firstName.getText().toString();
        EditText arrivalDate = (EditText) findViewById(R.id.arrivalDate);
        String arrivalValue = arrivalDate.getText().toString();
        EditText departureDate = (EditText) findViewById(R.id.departureDate);
        String departureValue = departureDate.getText().toString();
        EditText roomNum = (EditText) findViewById(R.id.roomSelector);
        String roomValue = roomNum.getText().toString();
        EditText emailText = (EditText) findViewById(R.id.emailAddress);
        String emailValue = emailText.getText().toString();
        EditText phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        String phoneValue = phoneNumber.getText().toString();
        EditText streetAddress = (EditText) findViewById(R.id.streetAddress);
        String staddressValue = streetAddress.getText().toString();

        db.insertReservation(lastNameValue, firstNameValue, arrivalValue, departureValue, roomValue, emailValue, phoneValue, staddressValue);
        Toast toast = Toast.makeText(getApplicationContext(), "Creating Reservation", Toast.LENGTH_LONG);
        toast.show();
        db.close();
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        finish();
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
}
