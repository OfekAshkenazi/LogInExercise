package Objects;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Ofek on 17-Jul-17.
 */
@SuppressWarnings("serial")
public class User implements Serializable {
    String name;
    String userName;
    String password;
    String email;
    String phoneNum;
    Bitmap profilePhoto;

    public User(String userID,String name, String email, String password,String phoneNum) {
        this.userName = userID;
        this.password = password;
        this.email = email;
        this.profilePhoto = null;
        this.name=name;
        this.phoneNum=phoneNum;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setProfilePhoto(Bitmap profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Bitmap getProfilePhoto() {
        return profilePhoto;
    }
}
