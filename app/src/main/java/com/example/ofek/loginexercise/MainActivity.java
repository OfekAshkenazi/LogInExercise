package com.example.ofek.loginexercise;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Objects.User;

public class MainActivity extends AppCompatActivity {
    TextView regTV;
    EditText userName,password;
    Button loginBtn;
    Intent loginIntent;
    Intent registerIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regTV= (TextView) findViewById(R.id.regTV);
        loginBtn=(Button) findViewById(R.id.loginBtn);
        userName =(EditText) findViewById(R.id.usernameET);
        password =(EditText) findViewById(R.id.passET);
        loginIntent=new Intent(this,ActivityProfilePage.class);
        registerIntent=new Intent(this,ActivityRegister.class);
        listeners();
    }
    public void listeners(){
        final Context context=this;
        regTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(registerIntent);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userName.getText().toString().isEmpty()||password.getText().toString().isEmpty()){
                    Toast.makeText(context, "Please make sure all fields are entered", Toast.LENGTH_LONG).show();
                    return;
                }
                User user=findUserByName(userName.getText().toString());
                if (user==null||(user!=null&&!passMatch(user,password.getText().toString()))){
                    Toast.makeText(context, "the password or username is incorrect", Toast.LENGTH_LONG).show();
                    return;
                }
                loginIntent.putExtra("user", user);
                startActivity(loginIntent);

            }
        });
    }
    public User findUserByName(String name) {
        if (ActivityRegister.users.size()==0){
            return null;
        }
        for (User user : ActivityRegister.users) {
            if (user.getUserName().equals(name))
                return user;
        }
        return null;
    }
    public boolean passMatch(User user,String password){
        return user.getPassword().equals(password);
    }

}
