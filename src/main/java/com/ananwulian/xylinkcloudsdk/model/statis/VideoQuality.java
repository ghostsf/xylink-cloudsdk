package com.ananwulian.xylinkcloudsdk.model.statis;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoQuality {

    private int videoSendLost;
    private int videoRecvLost;
    private int videoScore;
    private int videoDownLinkBw;
    private int videoUpLinkBw;
    private int videoSendJitter;
    private int videoRecvJitter;
    private int videoSendRtt;
    private int videoSendFrameRate;
    //private int videoSendBitRate;
    private String videoSendResolution;
    private int videoRecvFrameRate;
    //private int videoRecvBitRate;
    private String videoRecvResolution;


    public int getVideoSendLost() {
        return videoSendLost;
    }

    public void setVideoSendLost(int videoSendLost) {
        this.videoSendLost = videoSendLost;
    }

    public int getVideoRecvLost() {
        return videoRecvLost;
    }

    public void setVideoRecvLost(int videoRecvLost) {
        this.videoRecvLost = videoRecvLost;
    }

    public int getVideoScore() {
        return videoScore;
    }

    public void setVideoScore(int videoScore) {
        this.videoScore = videoScore;
    }

    public int getVideoDownLinkBw() {
        return videoDownLinkBw;
    }

    public void setVideoDownLinkBw(int videoDownLinkBw) {
        this.videoDownLinkBw = videoDownLinkBw;
    }

    public int getVideoUpLinkBw() {
        return videoUpLinkBw;
    }

    public void setVideoUpLinkBw(int videoUpLinkBw) {
        this.videoUpLinkBw = videoUpLinkBw;
    }

    public int getVideoSendJitter() {
        return videoSendJitter;
    }

    public void setVideoSendJitter(int videoSendJitter) {
        this.videoSendJitter = videoSendJitter;
    }

    public int getVideoRecvJitter() {
        return videoRecvJitter;
    }

    public void setVideoRecvJitter(int videoRecvJitter) {
        this.videoRecvJitter = videoRecvJitter;
    }

    public int getVideoSendRtt() {
        return videoSendRtt;
    }

    public void setVideoSendRtt(int videoSendRtt) {
        this.videoSendRtt = videoSendRtt;
    }

    public int getVideoSendFrameRate() {
        return videoSendFrameRate;
    }

    public void setVideoSendFrameRate(int videoSendFrameRate) {
        this.videoSendFrameRate = videoSendFrameRate;
    }


    public String getVideoSendResolution() {
        return videoSendResolution;
    }

    public void setVideoSendResolution(String videoSendResolution) {
        this.videoSendResolution = videoSendResolution;
    }

    public int getVideoRecvFrameRate() {
        return videoRecvFrameRate;
    }

    public void setVideoRecvFrameRate(int videoRecvFrameRate) {
        this.videoRecvFrameRate = videoRecvFrameRate;
    }


    public String getVideoRecvResolution() {
        return videoRecvResolution;
    }

    public void setVideoRecvResolution(String videoRecvResolution) {
        this.videoRecvResolution = videoRecvResolution;
    }
}
