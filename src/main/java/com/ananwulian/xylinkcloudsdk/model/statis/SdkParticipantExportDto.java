package com.ananwulian.xylinkcloudsdk.model.statis;

public class SdkParticipantExportDto {
    private String participantId;
    private String participantDeviceType;
    private String meetingId;
    private Long joinTimeBegin;
    private Long joinTimeEnd;
    private Long duration;
    private String displayName;
    private String meetingName;
    private String meetingNumber;


    public String getParticipantId() {
        return participantId;
    }
    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getParticipantDeviceType() {
        return participantDeviceType;
    }
    public void setParticipantDeviceType(String participantDeviceType) {
        this.participantDeviceType = participantDeviceType;
    }

    public String getMeetingId() {
        return meetingId;
    }
    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }


    public Long getJoinTimeBegin() {
        return joinTimeBegin;
    }
    public void setJoinTimeBegin(Long joinTimeBegin) {
        this.joinTimeBegin = joinTimeBegin;
    }

    public Long getJoinTimeEnd() {
        return joinTimeEnd;
    }
    public void setJoinTimeEnd(Long joinTimeEnd) {
        this.joinTimeEnd = joinTimeEnd;
    }

    public Long getDuration() {
        return duration;
    }
    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getDisplayName() { return displayName;}
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getMeetingName() { return meetingName;}
    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getMeetingNumber() { return meetingNumber;}
    public void setMeetingNumber(String meetingNumber) {
        this.meetingNumber = meetingNumber;
    }

    public SdkParticipantExportDto(){}

}
