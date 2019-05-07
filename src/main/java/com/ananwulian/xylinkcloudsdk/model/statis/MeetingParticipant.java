package com.ananwulian.xylinkcloudsdk.model.statis;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeetingParticipant {

    private String participantId;
    private String participantDeviceType;
    private Long joinTimeBegin;
    private Long joinTimeEnd;
    private String callId;
    private String displayName;
    private String callNumber;
    private ParticipantQuality quality;

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

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public ParticipantQuality getQuality() {
        return quality;
    }

    public void setQuality(ParticipantQuality quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "MeetingParticipant{" +
                "participantId='" + participantId + '\'' +
                ", participantDeviceType='" + participantDeviceType + '\'' +
                ", joinTimeBegin=" + joinTimeBegin +
                ", joinTimeEnd=" + joinTimeEnd +
                ", callId='" + callId + '\'' +
                ", displayName='" + displayName + '\'' +
                ", callNumber='" + callNumber + '\'' +
                ", quality=" + quality +
                '}';
    }
}
