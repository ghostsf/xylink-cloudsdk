package com.ananwulian.xylinkcloudsdk.model;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: gzm
 * Date: 2018-12-04
 */
public class UserValidateResponse {

    private String displayName;
    private String cellPhone;
    private long userCreateTime;
    private String email;

    public UserValidateResponse(UserProfile userProfile) {
        this.displayName = userProfile.getDisplayName();
        this.cellPhone = userProfile.getCellPhone();
        this.userCreateTime = userProfile.getUserCreateTime();
        this.email = userProfile.getEmail();
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public long getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(long userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserLoginResponse{" +
                "displayName='" + displayName + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", userCreateTime=" + userCreateTime +
                ", email='" + email + '\'' +
                '}';
    }
}
