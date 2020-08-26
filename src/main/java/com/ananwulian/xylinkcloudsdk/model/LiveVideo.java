package com.ananwulian.xylinkcloudsdk.model;

/**
 * Created by maolizhi on 12/15/2016.
 */

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveVideo {
    public static final int TITLE_WIDTH = 32;
    public static final int DETAIL_WIDTH = 128;
    public static final int LOCATION_WIDTH = 64;

    private String enterpriseId;

    /**
     * 直播设备号
     */
    private String nemoNumber;

    /**
     * 云会议室号
     */
    private String confNo;

    /**
     * 直播标题
     */
    private String title;
    /**
     * 直播开始时间，Unix时间戳（毫秒数）
     */
    private long startTime;
    /**
     * 直播结束时间，Unix时间戳（毫秒数）
     */
    private long endTime;
    /**
     * 直播详情 （可选，长度不超过128个字符）
     */
    private String detail;
    /**
     * 直播地点 （可选，长度不超过64个字符）
     */
    private String location;

    /**
     * 是否自动录制，只有设置为true，autoPublishRecording才可以设置为true
     */
    private boolean autoRecording;
    /**
     * 是否自动发布录制，只有设置为true，才能获取直播的回放列表
     */
    private boolean autoPublishRecording;


    /**
     * 第三方推流地址
     */
    private String thirdpartyPushURL;

    /**
     * 邀请观看人,目前只支持硬件终端
     */
    private String liveViewerInvited;

    /**
     * 第三方人物推流地址，注意：如果第三方企业没有推流地址，禁填
     */
    private String thirdpeoplePushURL;

    /**
     * 第三方内容推流地址，注意：如果第三方企业没有推流地址，禁填
     */
    private String thirdcontentPushURL;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getNemoNumber() {
        return nemoNumber;
    }

    public void setNemoNumber(String nemoNumber) {
        this.nemoNumber = nemoNumber;
    }

    public String getConfNo() {
        return confNo;
    }

    public void setConfNo(String confNo) {
        this.confNo = confNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public boolean isAutoRecording() {
        return autoRecording;
    }

    public void setAutoRecording(boolean autoRecording) {
        this.autoRecording = autoRecording;
    }

    public boolean isAutoPublishRecording() {
        return autoPublishRecording;
    }

    public void setAutoPublishRecording(boolean autoPublishRecording) {
        this.autoPublishRecording = autoPublishRecording;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean valid() {
        long now = System.currentTimeMillis();
        if (now >= startTime) {
            return false;
        }
        if (startTime >= endTime) {
            return false;
        }

        if (StringUtils.isBlank(title)) {
            return false;
        }
        if (title.length() > TITLE_WIDTH) {
            return false;
        }

        if (!StringUtils.isBlank(detail) && detail.length() > DETAIL_WIDTH) {
            return false;
        }

        if (!StringUtils.isBlank(location) && location.length() > LOCATION_WIDTH) {
            return false;
        }

        return true;
    }

    public boolean invalid() {
        return !valid();
    }

    public String getThirdpartyPushURL() {
        return thirdpartyPushURL;
    }

    public void setThirdpartyPushURL(String thirdpartyPushURL) {
        this.thirdpartyPushURL = thirdpartyPushURL;
    }

    public String getLiveViewerInvited() {
        return liveViewerInvited;
    }

    public void setLiveViewerInvited(String liveViewerInvited) {
        this.liveViewerInvited = liveViewerInvited;
    }

    public String getThirdpeoplePushURL() {
        return thirdpeoplePushURL;
    }

    public void setThirdpeoplePushURL(String thirdpeoplePushURL) {
        this.thirdpeoplePushURL = thirdpeoplePushURL;
    }

    public String getThirdcontentPushURL() {
        return thirdcontentPushURL;
    }

    public void setThirdcontentPushURL(String thirdcontentPushURL) {
        this.thirdcontentPushURL = thirdcontentPushURL;
    }

    @Override
    public String toString() {
        return "LiveVideo{" +
                "enterpriseId='" + enterpriseId + '\'' +
                ", nemoNumber='" + nemoNumber + '\'' +
                ", confNo='" + confNo + '\'' +
                ", title='" + title + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", detail='" + detail + '\'' +
                ", location='" + location + '\'' +
                ", autoRecording=" + autoRecording +
                ", autoPublishRecording=" + autoPublishRecording +
                ", thirdpartyPushURL='" + thirdpartyPushURL + '\'' +
                ", liveViewerInvited='" + liveViewerInvited + '\'' +
                ", thirdpeoplePushURL='" + thirdpeoplePushURL + '\'' +
                ", thirdcontentPushURL='" + thirdcontentPushURL + '\'' +
                '}';
    }
}