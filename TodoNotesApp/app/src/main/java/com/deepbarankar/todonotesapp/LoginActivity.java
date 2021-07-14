package com.deepbarankar.todonotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //Declare widgets (Don't define them as before onCrete() is invoked, no widget is created. Define widgets in onCreate(), declare them in class to access them everywhere.)
    EditText editTextFullName, editTextUserName;
    Button buttonLogin;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); //setContentView() defines which layout file to display in this activity whenever we open it.
        //R is for resources folder (res) and layout is the layout folder. Then we put the layout file name

        //Defining the widgets
        bindView();

        //Set On Click Listener to a button
        //1st method:
        /*
        View.OnClickListener clickAction = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //action
            }
        };
        buttonLogin.setOnClickListener(clickAction); //We need to pass a listener or interface of type "View.onClickListener"
        */

        //2nd method:
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("LoginActivity","on click performed");
                
                bindView();
                setupSharedPreferences();

                //Going to MyNotesActivity and passing data
                Intent intent = new Intent(LoginActivity.this, MyNotesActivity.class); //set the intent with the source context and destination context

                String fullName = editTextFullName.getText().toString(); //Storing the text in the editTextFullName as String in the fullName String variable.
                String userName = editTextUserName.getText().toString();

                //Check fullName and userName is not empty.
                if(!TextUtils.isEmpty(fullName) && !TextUtils.isEmpty(userName)) {
                    //putExtra takes a key-value pair. To access the value in the next activity, we refer to the key.
                    intent.putExtra(AppConstant.FULL_NAME, fullName); //Setting the fullName String as AppConstant.FULL_NAME ("full_name) in the intent to pass it to the next Activity.
                    intent.putExtra(AppConstant.USER_NAME, userName);

                    startActivity(intent); //Going to the activity using the set intent.

                    //Login
                    saveLoginStatus();
                    saveFullName(fullName);
                    saveUserName(userName);
                } else if(TextUtils.isEmpty(fullName)) {
                    //Toast: Display a text message
                    Toast.makeText(LoginActivity.this,"Full Name can't be empty", Toast.LENGTH_SHORT).show(); //Activity Context,text,duration
                } else {
                    Toast.makeText(LoginActivity.this,"User Name can't be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveUserName(String userName) {
        editor = sharedPreferences.edit();
        editor.putString(AppConstant.USER_NAME, userName);
        editor.apply();
    }

    private void saveFullName(String fullName) {
        editor = sharedPreferences.edit();
        editor.putString(AppConstant.FULL_NAME, fullName);
        editor.apply();
    }

    private void saveLoginStatus() {
        //editor is the register on which we can write our data and delete or rewrite it.
        editor = sharedPreferences.edit(); //open the register
        editor.putBoolean(PrefConstant.IS_LOGGED_IN, true); //write on register
        editor.apply(); //Changes applied
    }

    private void setupSharedPreferences() {
        sharedPreferences = getSharedPreferences(PrefConstant.SHARED_PREFERENCE_NAME,MODE_PRIVATE); //name, mode
        //MODE_PRIVATE means that this SharedPreferences is accessible by this app only.
    }

    private void bindView() {
        editTextFullName = findViewById(R.id.editTextFullName);
        editTextUserName = findViewById(R.id.editTextUserName);
        buttonLogin = findViewById(R.id.buttonLogin);
    }
}