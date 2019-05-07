package com.ananwulian.xylinkcloudsdk.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by maolizhi on 12/19/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeetingInfo extends BaseMeetingInfo {

    private int smartMutePerson;
    private boolean autoRecord;
    // add by xinzhixuan at 2018/08/27 start
    // 录制视频中叠加终端名称
    private boolean recordAddDeviceName;
    // 只录制主会场或发言者画面
    private boolean onlyRecordMainImage;
    // add by xinzhixuan at 2018/08/27 end

    public int getSmartMutePerson() {
        return smartMutePerson;
    }

    public void setSmartMutePerson(int smartMutePerson) {
        this.smartMutePerson = smartMutePerson;
    }

    public boolean isAutoRecord() {
        return autoRecord;
    }

    public void setAutoRecord(boolean autoRecord) {
        this.autoRecord = autoRecord;
    }

    public boolean isRecordAddDeviceName() {
        return recordAddDeviceName;
    }

    public void setRecordAddDeviceName(boolean recordAddDeviceName) {
        this.recordAddDeviceName = recordAddDeviceName;
    }

    public boolean isOnlyRecordMainImage() {
        return onlyRecordMainImage;
    }

    public void setOnlyRecordMainImage(boolean onlyRecordMainImage) {
        this.onlyRecordMainImage = onlyRecordMainImage;
    }

    @Override
    public String toString() {
        return "MeetingInfo{" +
                "smartMutePerson=" + smartMutePerson +
                ", autoRecord=" + autoRecord +
                ", recordAddDeviceName=" + recordAddDeviceName +
                ", onlyRecordMainImage=" + onlyRecordMainImage +
                "} " + super.toString();
    }
}
