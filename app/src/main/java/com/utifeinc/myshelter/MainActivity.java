package com.utifeinc.myshelter;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    LocalDatabaseHelper myDb;
    EditText email, password;
    Button login_btn, signup_btn, viewAll_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //simulating app initialization by making thread pause for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //I dey set the theme back to the regular theme after splashScreen
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        myDb = new LocalDatabaseHelper(this);
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        login_btn = findViewById(R.id.buttonLogin);
        signup_btn = findViewById(R.id.buttonSignUp);
        addData();
        viewAll();

    }

    public void addData() {
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = myDb.insertData(email.getText().toString(), password.getText().toString());
                if (isInserted == true) {
                    Toast.makeText(getApplicationContext(), "Credentials Stored Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Storage Failed!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void viewAll(){
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = myDb.getAllData();
                if(res.getCount() == 0) {
                    showMessage("Error", "No Data Found");
                    return;
                } else {
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("ID :"+res.getString(0)+ "\n");
                        buffer.append("Email :"+res.getString(1)+ "\n");
                        buffer.append("Password :"+res.getString(2)+ "\n");

                    }
                    //show all data
                    showMessage("Credentials", buffer.toString());
                }

            }

        });
    }

    public void showMessage (String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}