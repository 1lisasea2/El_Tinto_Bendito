package com.tintobendito.etb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.tintobendito.etb.vistas.LoginFirebase;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseUser usuario= FirebaseAuth.getInstance().getCurrentUser();

        if(usuario == null){
            iniciarNuevaActividad(LoginFirebase.class);
        }
        else {
            iniciarNuevaActividad(LoginFirebase.class);
        }


    }

    private void iniciarNuevaActividad(Class clase){
        startActivity(new Intent(this, clase));
        finish();
    }
}