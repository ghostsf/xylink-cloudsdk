package com.ananwulian.xylinkcloudsdk.model;

import java.io.Serializable;

public class SdkMeetingReq implements Serializable {

	private static final long serialVersionUID = 5525016619724528369L;

	private String meetingName;
	private long startTime;
	private long duration;
	private int maxParticipantCount;
	private boolean requirePassword;
	private boolean autoRecord;
	private String password;
	private String meetingNumber;
    private String controlPassword;

    private int autoMute;
    private int smartMutePerson;


	public String getControlPassword() {
		return controlPassword;
	}

	public void setControlPassword(String controlPassword) {
		this.controlPassword = controlPassword;
	}

	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getMeetingName() {
		return meetingName;
	}
	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}
	public int getMaxParticipantCount() {
		return maxParticipantCount;
	}
	public void setMaxParticipantCount(int maxParticipantCount) {
		this.maxParticipantCount = maxParticipantCount;
	}
	public boolean isRequirePassword() {
		return requirePassword;
	}
	public void setRequirePassword(boolean requirePassword) {
		this.requirePassword = requirePassword;
	}

	public boolean isAutoRecord() {
		return autoRecord;
	}

	public void setAutoRecord(boolean autoRecord) {
		this.autoRecord = autoRecord;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMeetingNumber() {
		return meetingNumber;
	}

	public void setMeetingNumber(String meetingNumber) {
		this.meetingNumber = meetingNumber;
	}

    public int getAutoMute() {
        return autoMute;
    }

    public void setAutoMute(int autoMute) {
        this.autoMute = autoMute;
    }

    public int getSmartMutePerson() {
        return smartMutePerson;
    }

    public void setSmartMutePerson(int smartMutePerson) {
        this.smartMutePerson = smartMutePerson;
    }

    @Override
    public String toString() {
        return "SdkMeetingReq{" +
                "meetingName='" + meetingName + '\'' +
                ", startTime=" + startTime +
                ", duration=" + duration +
                ", maxParticipantCount=" + maxParticipantCount +
                ", requirePassword=" + requirePassword +
                ", autoRecord=" + autoRecord +
                ", password='" + password + '\'' +
                ", meetingNumber='" + meetingNumber + '\'' +
                ", controlPassword='" + controlPassword + '\'' +
                ", autoMute=" + autoMute +
                ", smartMutePerson=" + smartMutePerson +
                '}';
    }
}
