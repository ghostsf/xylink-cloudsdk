package com.ananwulian.xylinkcloudsdk.model.statis;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AudioQuality {

    private int audioRecvLost;
    private int audioSendLost;
    private int audioScore;
    private int audioDownLinkBw;
    private int audioUpLinkBw;
    private int audioSendJitter;
    private int audioSendRtt;

    public int getAudioRecvLost() {
        return audioRecvLost;
    }

    public void setAudioRecvLost(int audioRecvLost) {
        this.audioRecvLost = audioRecvLost;
    }

    public int getAudioSendLost() {
        return audioSendLost;
    }

    public void setAudioSendLost(int audioSendLost) {
        this.audioSendLost = audioSendLost;
    }

    public int getAudioScore() {
        return audioScore;
    }

    public void setAudioScore(int audioScore) {
        this.audioScore = audioScore;
    }

    public int getAudioDownLinkBw() {
        return audioDownLinkBw;
    }

    public void setAudioDownLinkBw(int audioDownLinkBw) {
        this.audioDownLinkBw = audioDownLinkBw;
    }

    public int getAudioUpLinkBw() {
        return audioUpLinkBw;
    }

    public void setAudioUpLinkBw(int audioUpLinkBw) {
        this.audioUpLinkBw = audioUpLinkBw;
    }

    public int getAudioSendJitter() {
        return audioSendJitter;
    }

    public void setAudioSendJitter(int audioSendJitter) {
        this.audioSendJitter = audioSendJitter;
    }

    public int getAudioSendRtt() {
        return audioSendRtt;
    }

    public void setAudioSendRtt(int audioSendRtt) {
        this.audioSendRtt = audioSendRtt;
    }
}
