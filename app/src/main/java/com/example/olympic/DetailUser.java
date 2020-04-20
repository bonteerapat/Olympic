package com.example.olympic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DetailUser extends AppCompatActivity {

    private TextView username_user,password_user,cardNumber_user;
    private ImageView profile_image;
    private Button logOut_button;

    private UserManager manager;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        manager = new UserManager(this);
        context = this;

        username_user = (TextView) findViewById(R.id.username_user);
        password_user = (TextView) findViewById(R.id.password_user);
        cardNumber_user = (TextView) findViewById(R.id.cardNumber_user);
        logOut_button = (Button) findViewById(R.id.logOut_button);

        if(getIntent().hasExtra("data_user from login")){
            String[] data_user = getIntent().getExtras().getStringArray("data_user from login");
            username_user.setText(data_user[0]);
            password_user.setText(data_user[1]);
        }

        String card_number = manager.getCardNumber();
        cardNumber_user.setText(card_number);

        logOut_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailUser.this,LogInUser.class);
                startActivity(intent);
            }
        });

        BottomNavigationView bnv = findViewById(R.id.bottom_menu_bar_2);
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
