package com.ananwulian.xylinkcloudsdk.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SdkCloudMeetingRoomRequest {
	private String meetingName;//会议的名称
    private long startTime;// 会议开始时间， Unix时间戳（毫秒数）
    private long endTime;// 会议结束时间，Unix时间戳（毫秒数）
    private int maxParticipant;// 最大参加人数
    private boolean requirePassword; //是否需要密码（true/false），如果为true，则会默认生成一个6位数字密码；如为false，则该会议没有密码
    private String password;//指定密码，可选参数。如果用户指定了密码，那么该会议默认有密码。如果用户没有指定密码，但是require_password为true，小鱼会自动生成密码
    private String controlPassword;//主持会议密码
    private int autoMute;//0: 智能静音（默认第5个人以后自动静音）1: 全部静音 2: 不静音

    // 这两个是需要放到config中的
    //private boolean autoRecord;//自动录制（true/false）
    //private int smartMutePerson;//智能静音人数，从低几个人开始，启动智能静音,默认是5

	private Map<String, String> configs;

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

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getMaxParticipant() {
        return maxParticipant;
    }

    public void setMaxParticipant(int maxParticipant) {
        this.maxParticipant = maxParticipant;
    }

    public boolean isRequirePassword() {
        return requirePassword;
    }

    public void setRequirePassword(boolean requirePassword) {
        this.requirePassword = requirePassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getControlPassword() {
        return controlPassword;
    }

    public void setControlPassword(String controlPassword) {
        this.controlPassword = controlPassword;
    }

    public int getAutoMute() {
        return autoMute;
    }

    public void setAutoMute(int autoMute) {
        this.autoMute = autoMute;
    }


    public Map<String, String> getConfigs() {
		return configs;
	}
	public void setConfigs(Map<String, String> configs) {
		this.configs = configs;
	}


    @Override
    public String toString() {
        return "SdkCloudMeetingRoomRequest{" +
                "meetingName='" + meetingName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", maxParticipant=" + maxParticipant +
                ", requirePassword=" + requirePassword +
                ", password='" + password + '\'' +
                ", controlPassword='" + controlPassword + '\'' +
                ", autoMute=" + autoMute +
                ", configs=" + configs +
                '}';
    }
}
