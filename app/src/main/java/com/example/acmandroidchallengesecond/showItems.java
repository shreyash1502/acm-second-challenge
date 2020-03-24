package com.example.acmandroidchallengesecond;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class showItems extends AppCompatActivity {
RecyclerView recyclerView;
listAdapter adapter;
DatabaseReference myRef=FirebaseDatabase.getInstance().getReference().child("items");
ChildEventListener childEventListener;
    private ArrayList<item> info=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_items);
        recyclerView=(RecyclerView)findViewById(R.id.my_recycler_view);
        adapter=new listAdapter(this,R.layout.item_list,info);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
recyclerView.setAdapter(adapter);


     childEventListener=new ChildEventListener() {
         @Override
         public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
             item it=dataSnapshot.getValue(item.class);
             info.add(it);
         }

         @Override
         public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

         }

         @Override
         public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

         }

         @Override
         public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

         }

         @Override
         public void onCancelled(@NonNull DatabaseError databaseError) {

         }
     };
     myRef.addChildEventListener(childEventListener);
    }
    }

