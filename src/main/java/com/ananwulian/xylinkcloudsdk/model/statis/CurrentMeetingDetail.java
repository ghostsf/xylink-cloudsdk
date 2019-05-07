package com.ananwulian.xylinkcloudsdk.model.statis;


import java.util.List;

public class CurrentMeetingDetail {

    private String meetingRoomNumber;
    private String meetingName;
    private long startTime;
    private boolean recording = false;
    private Long recordStartTime;
    private int participantCount;
    private List<MeetingParticipant> participants;
    private MeetingQuality quality;

    public CurrentMeetingDetail() {

    }

    public String getMeetingRoomNumber() {
        return meetingRoomNumber;
    }

    public void setMeetingRoomNumber(String meetingRoomNumber) {
        this.meetingRoomNumber = meetingRoomNumber;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(int participantCount) {
        this.participantCount = participantCount;
    }

    public List<MeetingParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<MeetingParticipant> participants) {
        this.participants = participants;
    }

    public MeetingQuality getQuality() {
        return quality;
    }

    public void setQuality(MeetingQuality quality) {
        this.quality = quality;
    }

    public boolean getRecording() {
        return recording;
    }

    public void setRecording(boolean recording) {
        this.recording = recording;
    }

    public Long getRecordStartTime() {
        return recordStartTime;
    }

    public void setRecordStartTime(Long recordStartTime) {
        this.recordStartTime = recordStartTime;
    }

    @Override
    public String toString() {
        return "CurrentMeetingDetail{" +
                "meetingRoomNumber='" + meetingRoomNumber + '\'' +
                ", meetingName='" + meetingName + '\'' +
                ", startTime=" + startTime +
                ", participantCount=" + participantCount +
                ", participants=" + participants +
                ", quality=" + quality +
                ", recording=" + recording +
                ", recordStartTime=" + recordStartTime +
                '}';
    }
}
