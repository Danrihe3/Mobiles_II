package com.example.ventas_propia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Clientes(View view){
        Intent intClientes=new Intent(this, ClientesActivity.class);
        startActivity(intClientes);
    }

    public void Vehiculos(View view){
        Intent intVehiculos=new Intent(this,VehiculosActivity.class);
        startActivity(intVehiculos);
    }

    public void Facturas(View view){
        Intent intFacturas=new Intent(this,FacturasActivity.class);
        startActivity(intFacturas);
    }
}