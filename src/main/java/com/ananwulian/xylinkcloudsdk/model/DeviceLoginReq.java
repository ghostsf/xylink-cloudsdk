package com.ananwulian.xylinkcloudsdk.model;

import java.io.Serializable;

public class DeviceLoginReq implements Serializable {
    private static final long serialVersionUID = 1L;

    private String category;
    private String deviceModel;
    private String deviceSN;
    private String displayName;
    private String identity;
    private String packageName;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceSN() {
        return deviceSN;
    }

    public void setDeviceSN(String deviceSN) {
        this.deviceSN = deviceSN;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public String toString() {
        return "DeviceLoginReq{" +
                "category='" + category + '\'' +
                ", deviceModel='" + deviceModel + '\'' +
                ", deviceSN='" + deviceSN + '\'' +
                ", displayName='" + displayName + '\'' +
                ", identity='" + identity + '\'' +
                ", packageName='" + packageName + '\'' +
                '}';
    }
}
