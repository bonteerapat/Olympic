package com.example.olympic;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class SignUpUser extends AppCompatActivity {

    private TextView register_title;
    private EditText username_input,password_input,confirm_password_input,card_number_input;
    private Button signUp_button;

    private Context context;
    private UserManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_user);

        manager = new UserManager(this);
        context = this;

        register_title = (TextView) findViewById(R.id.register_title);
        username_input = (EditText) findViewById(R.id.username_input);
        password_input = (EditText) findViewById(R.id.password_input);
        confirm_password_input = (EditText) findViewById(R.id.confirm_password_input);
        card_number_input = (EditText) findViewById(R.id.card_number_input);
        signUp_button = (Button) findViewById(R.id.signUp_button);

        signUp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = username_input.getText().toString().trim();
                String password = password_input.getText().toString();
                String confirmPassword = confirm_password_input.getText().toString();
                String card_num = card_number_input.getText().toString();

                if(password.equals(confirmPassword)){
                    boolean isSuccess = manager.registerUser(username,password,card_num);

                    if(isSuccess){
                        String message = "Register successful";
                        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
                    }else{
                        String message = "Register failed, Try again!";
                        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
                    }
                }else{
                    String message = "Password Error";
                    Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
                }
            }
        });

        BottomNavigationView bnv = findViewById(R.id.bottom_menu_bar_3);
        bnv.setOnNavigationItemSelectedListener(navListener);
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

}
