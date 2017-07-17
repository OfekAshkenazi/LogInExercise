package com.example.ofek.loginexercise;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import Objects.User;

public class ActivityRegister extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    Button regBtn;
    EditText usernET, emailET, passwordET, repassET,phoneET,nameET;
    ImageButton cameraBtn;
    ImageView imageView;
    String userName,name, password, email,phone;
    Bitmap photo;
    Context context;
    public static ArrayList<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        users = new ArrayList<User>();
        context = this;
        setViews();
        cameraBtnListener();
        regBtnListener();

    }
    public  static ArrayList<User> getUsers(){
        return users;
    }

    public void regBtnListener() {
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usernET.getText().toString().equals("") || emailET.getText().toString().equals("") || passwordET.getText().toString().equals("")
                        || repassET.getText().toString().equals("") || phoneET.getText().toString().equals("")||nameET.getText().toString().equals("")) {
                    Toast.makeText(context, "Please make sure all fields are entered", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!passwordET.getText().toString().equals(repassET.getText().toString())) {
                    Toast.makeText(context, "passwords are not match", Toast.LENGTH_LONG).show();
                    return;
                }
                userName = usernET.getText().toString();
                email = emailET.getText().toString();
                password = passwordET.getText().toString();
                name=nameET.getText().toString();
                phone=phoneET.getText().toString();
                User user = new User(userName, name , email, password, phone);
                if (hasImage(imageView)) {
                    user.setProfilePhoto(photo);
                }
                users.add(user);
                Intent intent=new Intent(context,MainActivity.class);
                startActivity(intent);

            }
        });
    }
    public void cameraBtnListener() {
        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

    public void setViews() {
        regBtn = (Button) findViewById(R.id.regBtn);
        usernET = (EditText) findViewById(R.id.username);
        emailET = (EditText) findViewById(R.id.email);
        passwordET = (EditText) findViewById(R.id.password);
        repassET = (EditText) findViewById(R.id.password2);
        cameraBtn = (ImageButton) findViewById(R.id.cameraBtn);
        imageView = (ImageView) findViewById(R.id.imageView);
        phoneET = (EditText) findViewById(R.id.phoneET);
        nameET = (EditText) findViewById(R.id.nameET);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }

    private boolean hasImage(@NonNull ImageView view) {
        Drawable drawable = view.getDrawable();
        boolean hasImage = (drawable != null);

        if (hasImage && (drawable instanceof BitmapDrawable)) {
            hasImage = ((BitmapDrawable) drawable).getBitmap() != null;
        }

        return hasImage;
    }
}
