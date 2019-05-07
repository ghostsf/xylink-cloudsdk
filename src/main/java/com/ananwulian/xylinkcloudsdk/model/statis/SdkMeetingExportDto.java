package com.ananwulian.xylinkcloudsdk.model.statis;

public class SdkMeetingExportDto {
    private String meetingId;
    private Long timeBegin;
    private Long timeEnd;
    private Long duration;
    private String displayName;
    private String callNumber;


    public String getMeetingId() {
        return meetingId;
    }
    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public Long getTimeBegin() {
        return timeBegin;
    }
    public void setTimeBegin(Long timeBegin) {
        this.timeBegin = timeBegin;
    }

    public Long getTimeEnd() {
        return timeEnd;
    }
    public void setTimeEnd(Long timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Long getDuration() { return duration;}
    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getDisplayName() { return displayName;}
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCallNumber() { return callNumber;}
    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    @Override
    public String toString() {
        return "SdkMeetingExportDto{" +
                "meetingId='" + meetingId + '\'' +
                ", timeBegin=" + timeBegin +
                ", timeEnd=" + timeEnd +
                ", duration=" + duration +
                ", displayName='" + displayName + '\'' +
                ", callNumber='" + callNumber + '\'' +
                '}';
    }
}
