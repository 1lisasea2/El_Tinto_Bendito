package com.tintobendito.etb.utiles;

import android.util.Patterns;

public class ValidarCorreo {

    public static boolean validar(String mail){
        return Patterns.EMAIL_ADDRESS.matcher(mail).matches();

    }

}
