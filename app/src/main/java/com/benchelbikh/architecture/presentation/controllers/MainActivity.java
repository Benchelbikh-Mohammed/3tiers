package com.benchelbikh.architecture.presentation.controllers;

import android.os.Bundle;

import com.benchelbikh.architecture.R;
import com.benchelbikh.architecture.utils.MyContext;
import com.benchelbikh.architecture.utils.UserAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyContext context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = (MyContext) getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // Create adapter passing in the sample user data
        UserAdapter adapter = new UserAdapter(context);
        // Attach the adapter to the recyclerview to populate items
        recyclerView.setAdapter(adapter);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // That's all!


    }
}