package com.ananwulian.xylinkcloudsdk.model;

import java.io.Serializable;

/**
 * Created by xinzhixuan on 2018-08-30.
 */
public class RecordingStopResponse implements Serializable {
    private RecordingStatusResponse recordingStatusResponse;
    private String sessionId;

    public RecordingStopResponse() {
    }

    public RecordingStopResponse(RecordingStatusResponse recordingStatusResponse, String sessionId) {
        this.recordingStatusResponse = recordingStatusResponse;
        this.sessionId = sessionId;
    }

    public RecordingStatusResponse getRecordingStatusResponse() {
        return recordingStatusResponse;
    }

    public void setRecordingStatusResponse(RecordingStatusResponse recordingStatusResponse) {
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
