package com.tintobendito.etb.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.tintobendito.etb.R;
import com.tintobendito.etb.controladores.LoginFirebaseControlador;
import com.tintobendito.etb.utiles.ValidarCorreo;

public class LoginFirebase extends AppCompatActivity {

    private TextInputEditText tie_email, tie_password;
    private TextView  tv_recuperarcontra;
    private Button b_registro,b_login_firebas;

    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_firebase);

        view= findViewById(R.id.login_Firebas);

        tie_email=findViewById(R.id.tie_email);
        tie_password=findViewById(R.id.tie_password);
        tv_recuperarcontra=findViewById(R.id.tv_recuperarcontra);
        b_login_firebas=findViewById(R.id.b_login_firebas);
        b_registro=findViewById(R.id.b_registro);

        tie_email.addTextChangedListener(textWatcher);
        tie_password.addTextChangedListener(textWatcher);

        b_login_firebas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFirebaseControlador.loginfirebas(LoginFirebase.this,getemail(), getpassword() );
            }
        });

        tv_recuperarcontra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginFirebase.this , RecuperarContra.class));
            }
        });

        b_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginFirebase.this , Registro.class));
            }
        });

    }


    private TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            habilitar();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private boolean habilitar(){

        String email =getemail().trim();
        String password =getpassword().trim();

        if(ValidarCorreo.validar(email) && password.length()>5){
            b_login_firebas.setEnabled(true);
            return true;
        }else{
            b_login_firebas.setEnabled(false);
            return false;
        }
    }

    private String getemail() {
        return tie_email.getText().toString();
    }

    private String getpassword() {
        return tie_password.getText().toString();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ocultarTeclado(this , view);
        tie_email.clearFocus();
        tie_password.clearFocus();
        return true;
    }

    private void ocultarTeclado(Context contexto, View view) {
        InputMethodManager inputMethodManager= (InputMethodManager) contexto.getSystemService(Activity.INPUT_METHOD_SERVICE );
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }


}