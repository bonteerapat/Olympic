package com.example.olympic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class LogInUser extends AppCompatActivity {

    private TextView logIn_title;
    private EditText username_text,password_text;
    private Button logIn_button;
    private TextView register_text;

    private UserManager manager;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_user);

        logIn_title = findViewById(R.id.logIn_title);
        username_text = findViewById(R.id.username_text);
        password_text = findViewById(R.id.password_text);
        logIn_button = findViewById(R.id.logIn_button);
        register_text = findViewById(R.id.register_text);

        Profilefragment profilefragment = new Profilefragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.login_page,profilefragment).commit();


        logIn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });

        register_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SignUpUser.class);
                startActivity(intent);
            }
        });
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch(item.getItemId()){
                case R.id.nav_home:
                    break;
                case R.id.nav_booking:
                    break;
                case R.id.nav_profile:
                    break;
            }
            return true;
        }
    };
    // user_detail
    private void checkLogin(){
        String username = username_text.getText().toString().trim();
        String password = password_text.getText().toString().trim();
        String data_user[] = new String[2];

        boolean isSuccess = manager.checkLoginValidate(username,password);

        if(isSuccess){
            data_user[0] = username;
            data_user[1] = password;
            Intent intent = new Intent(context,MainActivity.class);
            intent.putExtra("data_user from login",data_user);
            startActivity(intent);
        }else{
            String message = "Username or Password is incorrect.";
            Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
        }
    }

}
