package com.ananwulian.xylinkcloudsdk.model;

import com.ananwulian.xylinkcloudsdk.util.PinyinUtil;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by maolizhi on 3/14/17.
 */
@JsonIgnoreProperties(value = { "nameCode", "adminName", "avatar" }, ignoreUnknown = true)
public class NemoDto implements Comparable<NemoDto> {
    private String name;
    @SuppressWarnings("unused")
    private String nameCode;
    private String number;
    private String sn;

    @SuppressWarnings("unused")
    private String adminName;
    @SuppressWarnings("unused")
    private String avatar;


    private String category;//  型号
    private String isOnline;// 在线/不在线
    private String clientVersion; // 版本
    private String extendTime;//维修到期时间
    private String portExpireTime;//端口到期时间
    private List<String> departName;//部门
    private String firstBindTime;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCode() {

        return PinyinUtil.getPinYin(name);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public String getExtendTime() {
        return extendTime;
    }

    public void setExtendTime(String extendTime) {
        this.extendTime = extendTime;
    }

    public String getPortExpireTime() {
        return portExpireTime;
    }

    public void setPortExpireTime(String portExpireTime) {
        this.portExpireTime = portExpireTime;
    }

    public List<String> getDepartName() {
        return departName;
    }

    public void setDepartName(List<String> departName) {
        this.departName = departName;
    }

    public String getFirstBindTime() {
        return firstBindTime;
    }

    public void setFirstBindTime(String firstBindTime) {
        this.firstBindTime = firstBindTime;
    }

    @Override
    public int compareTo(NemoDto nemo) {

        if (null != nemo && null != this.getNameCode()) {

            return this.getNameCode().compareToIgnoreCase(nemo.getNameCode());
        }

        return 0;
    }

    @Override
    public String toString() {
        return "NemoDto [number=" + number + ", sn=" + sn + ", name=" + name
                + ", category=" + category + ", isOnline=" + isOnline + ", clientVersion=" + clientVersion + ", extendTime=" + extendTime
                + ", portExpireTime=" + portExpireTime + ", departName=" + departName +", firstBindTime=" + firstBindTime + "]";
    }
}
