package com.ananwulian.xylinkcloudsdk.model;

/**
 * Created by root on 3/16/16.
 */
public class ExternalLoginRequest {

    private String userPhone;
    private String password;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ExternalLoginRequest{" +
                "userPhone='" + userPhone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
