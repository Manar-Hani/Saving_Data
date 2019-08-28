package com.example.localdb.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.localdb.Classes.DatabaseHelper;
import com.example.localdb.R;

public class EnterDataActivity extends AppCompatActivity {


    private Button btnSave;
    private EditText txtName;
    private EditText txtAge;
    private EditText txtJob;
    private EditText txtGender;

    DatabaseHelper mDatabaseHelper;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Enter Data");
        setContentView(R.layout.activity_enter_data);
        btnSave= findViewById(R.id.btnSave);
        txtName= findViewById(R.id.txtName);
        txtAge= findViewById(R.id.txtAge);
        txtJob= findViewById(R.id.txtJob);
        txtGender= findViewById(R.id.txtGender);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = txtName.getText().toString();
                if (txtName.length() != 0) {
                    AddData(userName);
                    txtName.setText("");
                } else {
                    toastMessage("You must put something in the text field!");
                }


                String userAge = txtAge.getText().toString();
                if (txtAge.length() != 0) {
                    AddData(userAge);
                    txtAge.setText("");
                } else {
                    toastMessage("You must put something in the text field!");
                }


                String userJob = txtJob.getText().toString();
                if (txtJob.length() != 0) {
                    AddData(userJob);
                    txtJob.setText("");
                } else {
                    toastMessage("You must put something in the text field!");
                }


                String userGender = txtGender.getText().toString();
                if (txtGender.length() != 0) {
                    AddData(userGender);
                    txtGender.setText("");
                } else {
                    toastMessage("You must put something in the text field!");
                }



                Intent intent = new Intent(EnterDataActivity.this, SavedDataActivity.class);
                startActivity(intent);

            }
        });

    }

    public void AddData(String newEntry) {

        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

}
