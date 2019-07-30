package com.example.androidexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DownloadManager;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.MissingFormatArgumentException;

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

                  RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.POST,
                        "http://10.0.0.214:8080/login?email=hoang@gmail.com&password=123456",
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try{
                                    String result = response.getString("data");
                                    String message = response.getString("message");
                                    if(result.equals("ok")){
                                        JSONObject data = response.getJSONObject("data");
                                    }
                                    else{

                                    }

                                }catch (JSONException e){
                                    System.out.println("aaa");

                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                System.out.println("aaa");
                            }
                        }
                );

                requestQueue.add(jsonObjectRequest);

//                Intent intent = new Intent(MainActivity.this,ProductsActivity.class);
//                startActivity(intent);

            }
        });
    }
}

