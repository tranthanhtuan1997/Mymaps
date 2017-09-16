package com.yostajsc.mymaps;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.yostajsc.mymaps.maps.MapsActivity;
import com.yostajsc.mymaps.storage.PrefersUtils;

public class MainActivity extends AppCompatActivity {

    InputFragment inputFragment;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //load fragment using Fragment manager
        inputFragment = (InputFragment) getFragmentManager().findFragmentById(R.id.fragment_input);

        login = (Button) findViewById(R.id.text_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        String email = PrefersUtils.getString(MainActivity.this,"email");
        String pass = PrefersUtils.getString(MainActivity.this,"password");
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass))
            return;
        if (checkAdmin(email,pass)){
            //
            Intent intent = new Intent(MainActivity.this,MenuActivity.class);
            startActivity(intent);
            finish();;
        }
    }

    void login(){
        if (inputFragment.isValid()) {

            String email = inputFragment.getEmail();
            String pass = inputFragment.getPass();
            if (checkAdmin(email, pass) || checkGuest(email,pass) ){

                if (inputFragment.isRemember()) {
                    PrefersUtils.store(MainActivity.this, "email", email);
                    PrefersUtils.store(MainActivity.this, "pass", pass);
                }
                Toast.makeText(MainActivity.this, "Login done ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
                finish();
                ;
           } else
                Toast.makeText(MainActivity.this, "Permission deny", Toast.LENGTH_SHORT).show();
        }
    }

    boolean checkAdmin(String email, String password){
        if (email.equals("admin") && password.equals("adminadmin"))
            return true;
        return false;
    }

    boolean checkGuest(String email, String password){
        if (email.equals("guest") && password.equals("guestguest"))
            return true;
        return false;
    }
}
