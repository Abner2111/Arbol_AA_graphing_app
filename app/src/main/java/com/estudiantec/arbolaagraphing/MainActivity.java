package com.estudiantec.arbolaagraphing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.estudiantec.estructura.*;

public class MainActivity extends AppCompatActivity {

    AATree tree = new AATree();
    TextView nodeEditText = (TextView) findViewById(R.id.nodeEditText);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button viewTreeBtn = (Button) findViewById(R.id.viewTreeBtn);
        viewTreeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), TreeVisualizer.class);

                startActivity(startIntent);
            }
        });

        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nodeData = Integer.parseInt(nodeEditText.getText().toString());

                tree.insert(nodeData);
            }
        });

        Button deleteBtn = (Button) findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nodeData = Integer.parseInt(nodeEditText.getText().toString());

                tree.remove(nodeData);

            }
        });

        Button searchBtn = (Button) findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nodeData = Integer.parseInt(nodeEditText.getText().toString());
                tree.find(nodeData);
            }
        });
    }
}