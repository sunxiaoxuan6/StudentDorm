package com.example.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class DormActivity extends AppCompatActivity implements View.OnClickListener {
    private Button returns;
    private RadioButton stay;
    private RadioButton revise;
    private RadioButton manage;
    private RadioButton inquiry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dorm);
        returns = findViewById(R.id.returns);

        returns.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.returns:
                returns();
                break;
        }
    }

    private void returns() {
        returns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DormActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}