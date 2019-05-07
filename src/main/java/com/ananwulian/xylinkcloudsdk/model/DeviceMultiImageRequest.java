package com.ananwulian.xylinkcloudsdk.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: gzm
 * Date: 2018-10-09
 */
public class DeviceMultiImageRequest {
    private long deviceId;
    private int type;
    private boolean broadcast = false;
    private MlayoutResquest mlayout;
    private boolean stop;

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isBroadcast() {
        return broadcast;
    }

    public void setBroadcast(boolean broadcast) {
        this.broadcast = broadcast;
    }

    public MlayoutResquest getMlayout() {
        return mlayout;
    }

    public void setMlayout(MlayoutResquest mlayout) {
        this.mlayout = mlayout;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public String toString() {
        return "DeviceMultiImageRequest{" +
                "deviceId=" + deviceId +
                ", type=" + type +
                ", broadcast=" + broadcast +
                ", mlayout=" + mlayout +
                ", stop=" + stop +
                '}';
    }
}
