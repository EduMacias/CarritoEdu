package com.edu.graceful.carritoedu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConsultaActivity extends AppCompatActivity {

    private DatabaseReference rePr;
    private String coleccionProductoReloj="ProductoReloj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        rePr = FirebaseDatabase.getInstance().getReference().child(coleccionProductoReloj);
        consultar();
        
        
    }

    private void consultar() {

        rePr.orderByKey().limitToFirst(10);
        rePr.orderByKey().limitToLast(10);
        rePr.orderByKey().startAt(11);
        rePr.orderByKey().endAt(15);
        rePr.orderByKey().startAt(11).endAt(20);
        rePr.orderByChild("Marca").addChildEventListener(new ChildEventListener()  {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                ProductoReloj pr = dataSnapshot.getValue(ProductoReloj.class);
                System.out.println(dataSnapshot.getKey() + " es " + pr.getMarca());

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
