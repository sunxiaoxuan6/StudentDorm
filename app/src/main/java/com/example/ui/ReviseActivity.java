package com.example.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReviseActivity extends AppCompatActivity implements View.OnClickListener {
    private Button returns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revise);
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
                Intent intent = new Intent(ReviseActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
