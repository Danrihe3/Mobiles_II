package com.example.ventas_propia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class OpenHelper extends SQLiteOpenHelper {

    public OpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tblClientes(Identificacion text primary key," +
                "NombreCompleto text not null," +
                "Direccion text not null," +
                "Telefono text not null," +
                "Activo text default 'Si')");
        db.execSQL("CREATE TABLE tblVehiculos(Placa text primary key," +
                "Marca text not null," +
                "Modelo text not null," +
                "Valor integer not null," +
                "Activo text default 'Si')");
        db.execSQL("CREATE TABLE tblFacturas(CodFactura text primary key," +
                "Fecha text not null," +
                "Identificacion text not null," +
                "Activo text default 'Si'," +
                "constraint pk_Factura foreign key(Identificacion) references tblClientes(Identificacion))");
        db.execSQL("CREATE TABLE tblVehiculo_Factura(CodFactura text," +
                "Placa text," +
                "Valor_Venta integer not null," +
                "constraint pk_Detalle primary key(CodFactura,Placa)," +
                "foreign key (CodFactura) references tblFacturas(CodFactura)," +
                "foreign key (Placa) references tblVehiculos(Placa))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE tblVehiculo_Factura");
        db.execSQL("DROP TABLE tblFacturas");
        db.execSQL("DROP TABLE tblVehiculos");
        db.execSQL("DROP TABLE tblClientes");
        onCreate(db);
    }
}

