package com.example.localdb.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.localdb.Classes.DatabaseHelper;
import com.example.localdb.Classes.User;
import com.example.localdb.R;

import java.lang.reflect.Array;

public class EnterDataActivity extends AppCompatActivity {


    private Button btnSave;
    private EditText txtName;
    private EditText txtAge;
    private EditText txtJob;
    private CheckBox male;
    private CheckBox female;

    DatabaseHelper mDatabaseHelper;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Enter Data");
        setContentView(R.layout.activity_enter_data);
        mDatabaseHelper = new DatabaseHelper(this);
        btnSave= findViewById(R.id.btnSave);
        txtName= findViewById(R.id.txtName);
        txtAge= findViewById(R.id.txtAge);
        txtJob= findViewById(R.id.txtJob);
        male= findViewById(R.id.checkBoxMale);
        female= findViewById(R.id.checkBoxFemale);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = txtName.getText().toString();
                if (txtName.length() != 0) {
                    txtName.setText("");
                } else {
                    toastMessage("You must put something in the text field!");
                }


                String userAge = txtAge.getText().toString();
                if (txtAge.length() != 0) {
                    txtAge.setText("");
                } else {
                    toastMessage("You must put something in the text field!");
                }


                String userJob = txtJob.getText().toString();
                if (txtJob.length() != 0) {
                    txtJob.setText("");
                } else {
                    toastMessage("You must put something in the text field!");
                }


                String userGender = "";
                if (male.isChecked()) {
                    userGender = "Male";
                    male.setChecked(false);
                }
                if (female.isChecked()) {
                    userGender = "Female";
                    female.setChecked(false);
                }
//                else {
//                    toastMessage("You must check one!");
//                }

                AddData(userName,userAge,userJob,userGender);

               // mDatabaseHelper.addData(userName,userAge,userJob,userGender);


                Intent intent = new Intent(EnterDataActivity.this, SavedDataActivity.class);
                startActivity(intent);

            }
        });


    }

    @Override
    public void onBackPressed()
    {
           EnterDataActivity.this.finish();
           finish();
    }


    public void AddData(String name, String age, String job, String gender) {

        boolean insertData = mDatabaseHelper.addData(name,age,job,gender);

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
