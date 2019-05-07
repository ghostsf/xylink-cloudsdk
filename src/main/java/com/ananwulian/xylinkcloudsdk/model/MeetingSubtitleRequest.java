package com.ananwulian.xylinkcloudsdk.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Arrays;

/**
 * Created by changxiangyang on 2017/6/8.
 * 发消息request
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeetingSubtitleRequest {
    private Device [] devices;
    private MeetingSubtitle meetingSubtitle;

    public Device[] getDevices() {
        return devices;
    }

    public void setDevices(Device[] devices) {
        this.devices = devices;
    }

    public MeetingSubtitle getMeetingSubtitle() {
        return meetingSubtitle;
    }

    public void setMeetingSubtitle(MeetingSubtitle meetingSubtitle) {
        this.meetingSubtitle = meetingSubtitle;
    }

    @Override
    public String toString() {
        return "MeetingSubtitleRequest{" +
                "devices=" + Arrays.toString(devices) +
                ", meetingSubtitle=" + meetingSubtitle +
                '}';
    }
}
