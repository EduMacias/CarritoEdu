package com.edu.graceful.carritoedu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference carritoeduReference;
    private DatabaseReference ProductoRelojReference ;
    private  String coleccionProductoReloj="ProductoReloj";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carritoeduReference = FirebaseDatabase.getInstance().getReference();
        ProductoRelojReference = carritoeduReference.child(coleccionProductoReloj);
    }


    public void buttonGrabarClick(View view) {
        EditText editTextDescripcion = (EditText) findViewById(R.id.editTextDescripcion);
        EditText editTextMarca = (EditText) findViewById(R.id.editTextMarca);
        EditText editTextStock = (EditText) findViewById(R.id.editTextStock);
        EditText editTextUso = (EditText) findViewById(R.id.editTextUso);
        EditText editTextValor = (EditText) findViewById(R.id.editTextValor);

        ProductoReloj pr = new ProductoReloj(editTextDescripcion.getText().toString(),
                editTextMarca.getText().toString(),
                editTextStock.getText().toString(),
                editTextUso.getText().toString(),
                editTextValor.getText().toString());



        GrabarNuevo(pr);



    }

    private String Grabar(ProductoReloj pr){
        String codigo= pr.getCodigo();
        ProductoRelojReference.child(codigo).setValue(pr);
        return codigo;

    }

    private String GrabarNuevo( ProductoReloj pr) {
        String codigo =  ProductoRelojReference.push().getKey();
        carritoeduReference.child(codigo).setValue(pr);
        return codigo;
    }







    public void Eliminar(View view) {




    }

    public void camara(View view) {

    }
}




