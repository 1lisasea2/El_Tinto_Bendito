package com.tintobendito.etb.controladores;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.tintobendito.etb.MainActivity;
import com.tintobendito.etb.modelos.Usuario;
import com.tintobendito.etb.utiles.ConstantesFirebase;

public class RegistroControlador {


    public static void registrar(Context contexto, String nombre, String email, String password) {

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            usuariofirestore(contexto,nombre,email);
                    }else{
                            Toast.makeText(contexto, "Error al intentar registrar Usuario", Toast.LENGTH_SHORT).show();
                        }

                        }
                });
    }

    private static void usuariofirestore(Context contexto, String nombre, String email) {
        try {
            FirebaseUser firebaseUser= FirebaseAuth.getInstance().getCurrentUser();

            String id= firebaseUser.getUid();

            long tiempocreado= firebaseUser.getMetadata().getCreationTimestamp();

            Usuario usuario= new Usuario(id,nombre,email,tiempocreado);

            FirebaseFirestore.getInstance().collection(ConstantesFirebase.USUARIO)
                    .document(id)
                    .set(usuario, SetOptions.merge())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()) {
                                Intent intent= new Intent(contexto, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                contexto.startActivity(intent);


                            }else {
                                Toast.makeText(contexto, "Error al intentar guardar datos del usuario", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }catch (NullPointerException e){
            e.getCause();
        }
    }
}
