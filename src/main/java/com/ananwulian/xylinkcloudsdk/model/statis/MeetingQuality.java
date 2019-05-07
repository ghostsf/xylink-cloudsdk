package com.ananwulian.xylinkcloudsdk.model.statis;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeetingQuality {

    private String meetingId;
    private Integer audioScore;
    private Integer audioCurrentScore;
    private Integer videoScore;
    private Integer videoCurrentScore;
    private Integer score;

    public Integer getAudioScore() {
        return audioScore;
    }

    public void setAudioScore(Integer audioScore) {
        this.audioScore = audioScore;
    }

    public Integer getVideoScore() {
        return videoScore;
    }

    public void setVideoScore(Integer videoScore) {
        this.videoScore = videoScore;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public Integer getAudioCurrentScore() {
        return audioCurrentScore;
    }

    public void setAudioCurrentScore(Integer audioCurrentScore) {
        this.audioCurrentScore = audioCurrentScore;
    }

    public Integer getVideoCurrentScore() {
        return videoCurrentScore;
    }

    public void setVideoCurrentScore(Integer videoCurrentScore) {
        this.videoCurrentScore = videoCurrentScore;
    }

    @Override
    public String toString() {
        return "MeetingQuality{" +
                "meetingId='" + meetingId + '\'' +
                ", audioScore=" + audioScore +
                ", audioCurrentScore=" + audioCurrentScore +
                ", videoScore=" + videoScore +
                ", videoCurrentScore=" + videoCurrentScore +
                ", score=" + score +
                '}';
    }
}
