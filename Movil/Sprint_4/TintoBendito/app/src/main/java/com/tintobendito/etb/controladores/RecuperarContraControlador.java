package com.tintobendito.etb.controladores;

import android.app.Activity;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.tintobendito.etb.vistas.RecuperarContra;

public class RecuperarContraControlador {

    public static void recuperar(Activity activity, String email) {

        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()) {
                            activity.finish();
                            Toast.makeText(activity, "Se ha enviado un correo para recuperar contraseña", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(activity, "Error al intentar iniciar sesión", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
