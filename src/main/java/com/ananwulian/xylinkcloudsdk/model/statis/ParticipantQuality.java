package com.ananwulian.xylinkcloudsdk.model.statis;


public class ParticipantQuality {

    private int score;

    private int audioScore;

    private int videoScore;

    private VideoQuality videoQuality;

    private AudioQuality audioQuality;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAudioScore() {
        return audioScore;
    }

    public void setAudioScore(int audioScore) {
        this.audioScore = audioScore;
    }

    public int getVideoScore() {
        return videoScore;
    }

    public void setVideoScore(int videoScore) {
        this.videoScore = videoScore;
    }

    public VideoQuality getVideoQuality() {
        return videoQuality;
    }

    public void setVideoQuality(VideoQuality videoQuality) {
        this.videoQuality = videoQuality;
    }

    public AudioQuality getAudioQuality() {
        return audioQuality;
    }

    public void setAudioQuality(AudioQuality audioQuality) {
        this.audioQuality = audioQuality;
    }

    @Override
    public String toString() {
        return "ParticipantQuality{" +
                "score=" + score +
                ", audioScore=" + audioScore +
                ", videoScore=" + videoScore +
                ", videoQuality=" + videoQuality +
                ", audioQuality=" + audioQuality +
                '}';
    }
}
