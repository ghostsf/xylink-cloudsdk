package com.ananwulian.xylinkcloudsdk.model;

/**
 * Created by maolizhi on 3/15/17.
 */
public class Status {
    // "start" or "end"
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "status='" + status + '\'' +
                '}';
    }
}
