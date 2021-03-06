package com.tintobendito.etb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class VerProductos_RecV extends AppCompatActivity {

    private RecyclerView rv_VerProductos;

    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;

    private ArrayList<PojoProducto> pojoProductoArrayList;
    private ArrayList<String> nombreArrayList;
    private AdapterVerProductosRecV adapterVerProductosRecV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_productos_rec_v);

        rv_VerProductos = findViewById(R.id.rv_verProductos);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        gridLayoutManager = new GridLayoutManager(this, 2);

        rv_VerProductos.setLayoutManager(linearLayoutManager);

        pojoProductoArrayList = new ArrayList<PojoProducto>();
        pojoProductoArrayList.add(new PojoProducto(R.drawable.cafecamin, "Café del Caminante", "$4.500"));
        pojoProductoArrayList.add(new PojoProducto(R.drawable.tintopanela, "Café y Chocolate", "$5.508"));
        pojoProductoArrayList.add(new PojoProducto(R.drawable.palitoqueso, "Palito de Queso", "$3.500"));
        pojoProductoArrayList.add(new PojoProducto(R.drawable.corazon, "Corazón de Hojaldre", "$3.800"));
        pojoProductoArrayList.add(new PojoProducto(R.drawable.marialuisa, "Maria Luisa","$6.000"));

        adapterVerProductosRecV = new AdapterVerProductosRecV(this, pojoProductoArrayList);
        rv_VerProductos.setAdapter(adapterVerProductosRecV);


        //
    }
}