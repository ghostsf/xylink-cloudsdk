package com.ananwulian.xylinkcloudsdk.model;

import java.io.Serializable;

/**
 * Created by xinzhixuan on 2018-08-30.
 * Change by ghostsf 2021-05-10
 */
public class RecordingStopResponse implements Serializable {
    private String recordingStatusResponse;
    private String sessionId;

    public RecordingStopResponse() {
    }

    public RecordingStopResponse(String recordingStatusResponse, String sessionId) {
        this.recordingStatusResponse = recordingStatusResponse;
        this.sessionId = sessionId;
    }

    public String getRecordingStatusResponse() {
        return recordingStatusResponse;
    }

    public void setRecordingStatusResponse(String recordingStatusResponse) {
        this.recordingStatusResponse = recordingStatusResponse;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "RecordingStopResponse{" +
                "recordingStatusResponse=" + recordingStatusResponse +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
