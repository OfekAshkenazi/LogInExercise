package com.example.ofek.loginexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import Objects.User;

public class ActivityProfilePage extends AppCompatActivity {
    TextView nameTV,emailTV,phoneTV;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        nameTV= (TextView) findViewById(R.id.textViewName);
        emailTV= (TextView) findViewById(R.id.textViewEmail);
        phoneTV= (TextView) findViewById(R.id.textViewPhone);
        imageView=(ImageView) findViewById(R.id.profilePhoto);
        User user= (User) getIntent().getExtras().get("user");
        nameTV.setText(user.getName());
        emailTV.setText(user.getEmail());
        phoneTV.setText(user.getPhoneNum());
        imageView.setImageBitmap(user.getProfilePhoto());
    }
}
