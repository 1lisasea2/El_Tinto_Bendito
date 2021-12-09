package com.tintobendito.etb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DetalleProducto extends AppCompatActivity {

    private TextView tv_detNombreproducto;
    private Button bt_DetalleProducto;
    private String str_DetNombreProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);

        tv_detNombreproducto = findViewById(R.id.tv_detNombreProducto);
        bt_DetalleProducto = findViewById(R.id.btn_detProducto);

        Bundle bundle = getIntent().getExtras();
        str_DetNombreProducto=bundle.getString("nombreProducto");
        tv_detNombreproducto.setText(str_DetNombreProducto);

    }
}