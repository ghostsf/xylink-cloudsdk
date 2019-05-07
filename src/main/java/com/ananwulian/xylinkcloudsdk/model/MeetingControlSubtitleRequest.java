package com.ananwulian.xylinkcloudsdk.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: gzm
 * Date: 2018-10-20
 */
public class MeetingControlSubtitleRequest {


    /**
     * action : push
     * content : string
     * duration : 0
     * location : top
     * scroll : string
     * targets : [{"ae":"string","di":"string","dn":"string","hd":"string"}]
     */

    private String action;
    private String content;
    private int duration;
    private String location;
    private String scroll;
    private List<TargetsBean> targets;

    public MeetingControlSubtitleRequest() {
    }

    public MeetingControlSubtitleRequest(String content, int duration) {
        this.content = content;
        this.duration = duration;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getScroll() {
        return scroll;
    }

    public void setScroll(String scroll) {
        this.scroll = scroll;
    }

    public List<TargetsBean> getTargets() {
        return targets;
    }

    public void setTargets(List<TargetsBean> targets) {
        this.targets = targets;
    }

    public static class TargetsBean {
        /**
         * ae : string
         * di : string
         * dn : string
         * hd : string
         */

        private String ae;
        private long deviceId;
        private String dn;
        private String hd;
        private int deviceType;

        public TargetsBean() {
        }

        public TargetsBean(long deviceId, int deviceType) {
            this.deviceId = deviceId;
            this.deviceType = deviceType;
        }

        public String getAe() {
            return ae;
        }

        public void setAe(String ae) {
            this.ae = ae;
        }



        public String getDn() {
            return dn;
        }

        public void setDn(String dn) {
            this.dn = dn;
        }

        public String getHd() {
            return hd;
        }

        public void setHd(String hd) {
            this.hd = hd;
        }

        public long getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(long deviceId) {
            this.deviceId = deviceId;
        }

        public int getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(int deviceType) {
            this.deviceType = deviceType;
        }

        @Override
        public String toString() {
            return "TargetsBean{" +
                    "ae='" + ae + '\'' +
                    ", deviceId=" + deviceId +
                    ", dn='" + dn + '\'' +
                    ", hd='" + hd + '\'' +
                    ", deviceType=" + deviceType +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MeetingSubtitleDto{" +
                "action='" + action + '\'' +
                ", content='" + content + '\'' +
                ", duration=" + duration +
                ", location='" + location + '\'' +
                ", scroll='" + scroll + '\'' +
                ", targets=" + targets +
                '}';
    }
}

