package com.example.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class StudentActivity extends AppCompatActivity implements View.OnClickListener {
    private Button returns;
    private RadioButton manager;
    private RadioButton enter;
    private RadioButton revise;
    private RadioButton apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        manager = findViewById(R.id.manager);
        enter = findViewById(R.id.enter);
        revise = findViewById(R.id.revise);
        apply = findViewById(R.id.apply);
        returns = findViewById(R.id.returns);

        manager.setOnClickListener(this);
        enter.setOnClickListener(this);
        revise.setOnClickListener(this);
        apply.setOnClickListener(this);

        returns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.manager:
                manager();
                break;
            case R.id.enter:
                enter();
                break;
            case R.id.apply:
                apply();
                break;
            case R.id.revise:
                revise();
                break;
        }
    }

    private void revise() {
        revise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void apply() {
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, OutActivity.class);
                startActivity(intent);
            }
        });
    }

    private void enter() {
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void manager() {
        manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });
    }
}
