package com.tintobendito.etb.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.tintobendito.etb.R;
import com.tintobendito.etb.controladores.RegistroControlador;
import com.tintobendito.etb.utiles.ValidarCorreo;

public class Registro extends AppCompatActivity {

    private TextInputEditText  tie_nombre, tie_email, tie_password, tie_confirmaPassword;
    private Button b_registrar;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        view= findViewById(R.id.cl_registro);

        tie_nombre=findViewById(R.id.tie_nombre);
        tie_email=findViewById(R.id.tie_email);
        tie_password=findViewById(R.id.tie_password);
        tie_confirmaPassword=findViewById(R.id.tie_RecuperaPassword);
        b_registrar=findViewById(R.id.b_registrar);

        tie_nombre.addTextChangedListener(textWatcher);
        tie_email.addTextChangedListener(textWatcher);
        tie_password.addTextChangedListener(textWatcher);
        tie_confirmaPassword.addTextChangedListener(textWatcher);

        b_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistroControlador.registrar(Registro.this,getnombre(),getemail(),getpassword() );
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

        String nombre =getnombre().trim();
        String email =getemail().trim();
        String password =getpassword().trim();
        String RecuperaPassword =getRecuperaPassword().trim();


        if(nombre.length()>2 && ValidarCorreo.validar(email) && password.length()>5 && RecuperaPassword.equals(password)){
            b_registrar.setEnabled(true);
            return true;
        }else{
            b_registrar.setEnabled(false);
            return false;
        }
    }

    private String getnombre() {
        return tie_nombre.getText().toString();
    }

    private String getemail() {
        return tie_email.getText().toString();
    }

    private String getpassword() {
        return tie_password.getText().toString();
    }

    private String getRecuperaPassword() {
        return tie_confirmaPassword.getText().toString();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ocultarTeclado(this , view);
        tie_nombre.clearFocus();
        tie_email.clearFocus();
        tie_password.clearFocus();
        tie_confirmaPassword.clearFocus();
        return true;
    }

    private void ocultarTeclado(Context contexto, View view) {
        InputMethodManager inputMethodManager= (InputMethodManager) contexto.getSystemService(Activity.INPUT_METHOD_SERVICE );
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }


}