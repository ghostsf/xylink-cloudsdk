package com.ananwulian.xylinkcloudsdk.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by wenya on 17/6/27.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentMeeting {

    private String meetingRoomNumber;
    private long startTime;
    private int participantCount;
    private String scheduledMeetingId;
    private boolean recording = false;
    private Long recordStartTime;

    public String getMeetingRoomNumber() {
        return meetingRoomNumber;
    }

    public void setMeetingRoomNumber(String meetingRoomNumber) {
        this.meetingRoomNumber = meetingRoomNumber;
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

    public String getScheduledMeetingId() {
        return scheduledMeetingId;
    }

    public void setScheduledMeetingId(String scheduledMeetingId) {
        this.scheduledMeetingId = scheduledMeetingId;
    }

    public boolean isRecording() {
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
        return "CurrentMeeting{" +
                "meetingRoomNumber='" + meetingRoomNumber + '\'' +
                ", startTime=" + startTime +
                ", participantCount=" + participantCount +
                ", scheduledMeetingId='" + scheduledMeetingId + '\'' +
                ", recording=" + recording +
                ", recordStartTime=" + recordStartTime +
                '}';
    }
}
