package com.example.acmandroidchallengesecond;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    EditText name,college,address;
    Button add,show;
    public String id;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference=FirebaseDatabase.getInstance().getReference();
        name=(EditText)findViewById(R.id.name);
        address=(EditText)findViewById(R.id.address);
        college=(EditText)findViewById(R.id.college);
        add=(Button)findViewById(R.id.add);
        show=(Button)findViewById(R.id.showitem);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                additem();

            }
        });
show.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(MainActivity.this,showItems.class);
        startActivity(i);

    }
});

    }
public void additem(){
        String mname=name.getText().toString();
        String maddress=address.getText().toString();
        String mcollege=college.getText().toString();

item ite=new item(mname,maddress,mcollege);
databaseReference.child("items").push().setValue(ite);
    Toast.makeText(this,"Added",Toast.LENGTH_SHORT).show();
    name.setText("");
    address.setText("");
    college.setText("");
}
}


