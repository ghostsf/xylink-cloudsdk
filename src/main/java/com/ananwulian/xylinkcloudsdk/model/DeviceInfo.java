package com.ananwulian.xylinkcloudsdk.model;

/**
 * Created by maolizhi on 12/15/2016.
 */
import java.io.Serializable;

public class DeviceInfo implements Serializable {
    private String callState;
    private String deviceSN;
    private String number;

    public DeviceInfo() {
    }

    public DeviceInfo(String callState, String deviceSN) {
        this.callState = callState;
        this.deviceSN = deviceSN;
    }

    public String getCallState() {
        return this.callState;
    }

    public void setCallState(String callState) {
        this.callState = callState;
    }

    public String getDeviceSN() {
        return this.deviceSN;
    }

    public void setDeviceSN(String deviceSN) {
        this.deviceSN = deviceSN;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "callState='" + callState + '\'' +
                ", deviceSN='" + deviceSN + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

