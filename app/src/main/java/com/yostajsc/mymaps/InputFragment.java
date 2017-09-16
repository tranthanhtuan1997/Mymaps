package com.yostajsc.mymaps;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by Ham on 9/10/2017.
 */


public class InputFragment extends Fragment {

    EditText textEmail, textPassword;
    CheckBox Remember;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_input,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textEmail = (EditText) getActivity().findViewById(R.id.text_email);
        textPassword = (EditText) getActivity().findViewById(R.id.text_password);
    }

    public  boolean isValid(){
        String email=getEmail();
        String password = getPass();

        if (email.length()<5){
            textEmail.setError("Your email has at least 8 characters");
            return false;
        }
        if (password.length()<8 || password.length()>32){
            textEmail.setError("Your password must be min = 8 or max = 32 characters");
            return false;
        }
        return true;
    }

    public String getEmail(){
        return textEmail.getText().toString();
    }

    public String getPass(){
        return textPassword.getText().toString();
    }

    public boolean isRemember(){
        return Remember.isChecked();
    }


}
