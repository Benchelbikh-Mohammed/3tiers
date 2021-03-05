package com.benchelbikh.architecture.presentation.controllers;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.benchelbikh.architecture.models.User;
import com.benchelbikh.architecture.utils.ListViewAdapter;
import com.benchelbikh.architecture.utils.MyContext;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.benchelbikh.architecture.R;



public class MainActivity2 extends AppCompatActivity {

    private ListView listview ;
    private Button addButton;
    private Button removeBtn;
    private ListViewAdapter adapter;
    private MyContext context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        context = (MyContext) getApplicationContext();

        listview = findViewById(R.id.list_view);
        addButton = findViewById(R.id.addButton);
        removeBtn = findViewById(R.id.removeBtn);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity2.this);

                LayoutInflater inflater = LayoutInflater.from(context);
                View vi = inflater.inflate(R.layout.dialog_layout,null);

                EditText nameEditTxt = vi.findViewById(R.id.name);
                EditText usernameEditTxt =  vi.findViewById(R.id.username);
                EditText emailEditTxt = vi.findViewById(R.id.email);

                alertDialog.setView(vi).setTitle("add item");

                alertDialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("canceled" , "can");
                    }
                });


                alertDialog.setPositiveButton("add",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                User user = new User(nameEditTxt.getText().toString() ,
                                        usernameEditTxt.getText().toString(),
                                        emailEditTxt.getText().toString());
                                addItemToListView(user);
                            }
                });

                alertDialog.show();

            }
        });






//        List<String> names = Arrays.asList(new String[] {"med" , "hassan" , "achraf" , "ayman" , "anouar", "med" , "hassan" , "achraf" , "ayman" , "anouar",
//                "med" , "hassan" , "achraf" , "ayman" , "anouar","med" , "hassan" , "achraf" , "ayman" , "anouar","med" , "hassan" , "achraf" , "ayman" , "anouar"});

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this , R.layout.listitem, names);

        adapter = new ListViewAdapter(context);
        listview.setAdapter(adapter);
    }

    void addItemToListView(User user) {
        context.getDs().addUser(user);
        adapter.notifyDataSetChanged();
    }
}