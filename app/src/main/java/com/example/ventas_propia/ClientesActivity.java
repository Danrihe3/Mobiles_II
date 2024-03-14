package com.example.ventas_propia;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClientesActivity extends AppCompatActivity {

    EditText etIdentificacion,etNombreCompleto,etDireccion,etTelefono;
    Button  btnBuscar,btnGuardar,btnAnular,btnLimpiar,btnRegresar;
    CheckBox cbActivo;
    String Identificacion,NombreCompleto,Telefono,Direccion;
    Long Respuesta;
    OpenHelper Conexion=new OpenHelper(this,"Concesionario.db",null,1);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clientes);

        etIdentificacion=findViewById(R.id.etIdentificacion);
        etNombreCompleto=findViewById(R.id.etNombreCompleto);
        etDireccion=findViewById(R.id.etDireccion);
        etTelefono=findViewById(R.id.etTelefono);
        btnBuscar=findViewById(R.id.btnBuscar);
        btnGuardar=findViewById(R.id.btnGuardar);
        btnAnular=findViewById(R.id.btnAnular);
        btnLimpiar=findViewById(R.id.btnLimpiar);
        btnAnular=findViewById(R.id.btnRegresar);
        cbActivo=findViewById(R.id.cbActivo);
    }

    public void Guardar(View view){
        Identificacion = etIdentificacion.getText().toString();
        NombreCompleto=etNombreCompleto.getText().toString();
        Telefono=etTelefono.getText().toString();
        Direccion=etDireccion.getText().toString();
        if(!Identificacion.isEmpty() && !NombreCompleto.isEmpty() && !Direccion.isEmpty() && !Telefono.isEmpty()){
            SQLiteDatabase admin=Conexion.getWritableDatabase();
            ContentValues Registro=new ContentValues();
            Registro.put("Identificacion",Identificacion);
            Registro.put("NombreCompleto",NombreCompleto);
            Registro.put("Direccion",Direccion);
            Registro.put("Telefono",Telefono);
            Respuesta=admin.insert("tblClientes",null,Registro);
            if(Respuesta>0){
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                Limpiar_Campos();
                }else{
                Toast.makeText(this, "Error al guardar el registro", Toast.LENGTH_SHORT).show();
                }
            }
        else if(Identificacion.isEmpty() && !NombreCompleto.isEmpty() && !Direccion.isEmpty() && !Telefono.isEmpty()){
            Toast.makeText(this, "Todos los campos deben estar llenos.", Toast.LENGTH_SHORT).show();
            etIdentificacion.requestFocus();
        }
        else if(!Identificacion.isEmpty() && NombreCompleto.isEmpty() && !Direccion.isEmpty() && !Telefono.isEmpty()){
                Toast.makeText(this, "Todos los campos deben estar llenos.", Toast.LENGTH_SHORT).show();
                etNombreCompleto.requestFocus();
        }else if(!Identificacion.isEmpty() && !NombreCompleto.isEmpty() && Direccion.isEmpty() && !Telefono.isEmpty()){
                Toast.makeText(this, "Todos los campos deben estar llenos.", Toast.LENGTH_SHORT).show();
                etDireccion.requestFocus();
        }else if(!Identificacion.isEmpty() && !NombreCompleto.isEmpty() && !Direccion.isEmpty() && Telefono.isEmpty()){
            Toast.makeText(this, "Todos los campos deben estar llenos.", Toast.LENGTH_SHORT).show();
            etTelefono.requestFocus();
        }else {
            Toast.makeText(this, "Todos los campos deben estar llenos.", Toast.LENGTH_SHORT).show();
            etIdentificacion.requestFocus();
        }

    }

    public void Consultar(View view){
        Identificacion=etIdentificacion.getText().toString();
        if(!Identificacion.isEmpty()){
            SQLiteDatabase Admin=Conexion.getReadableDatabase();
        }else{
            Toast.makeText(this, "La identificacion es requerida", Toast.LENGTH_SHORT).show();
        }
    }

    public void Limpiar(View view){
        Limpiar_Campos();
    }

    public void Regresar(View view){
        Intent Regresar=new Intent(this,MainActivity.class);
        startActivity(Regresar);
    }

    private void Limpiar_Campos(){
        etIdentificacion.setText("");
        etNombreCompleto.setText("");
        etDireccion.setText("");
        etTelefono.setText("");
        etIdentificacion.requestFocus();
    }
}
