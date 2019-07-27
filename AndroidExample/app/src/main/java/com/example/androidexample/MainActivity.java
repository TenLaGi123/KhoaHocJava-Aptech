package com.example.androidexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements IActivity {
    private ImageView imgProfile;
    private EditText txtEmail;
    private EditText txtPassword;
    private CheckBox ckRemember;
    private Button btnForgetPass;
    private Button btnLogIn;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpUI();
        setUpAction();

    }

    @Override
    public void setUpUI() {

        imgProfile = (ImageView) findViewById(R.id.imgProfile);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        ckRemember = findViewById(R.id.ckRemember);
        btnForgetPass = findViewById(R.id.btnForgetPass);
        btnLogIn = findViewById(R.id.btnLogIn);
        btnSignUp = findViewById(R.id.btnSignUp);

        txtEmail.setTypeface(Typeface.SANS_SERIF);
        txtPassword.setTypeface(Typeface.SANS_SERIF);
    }

    @Override
    public void setUpAction() {
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ProductsActivity.class);
                startActivity(intent);
            }
        });
    }
}
