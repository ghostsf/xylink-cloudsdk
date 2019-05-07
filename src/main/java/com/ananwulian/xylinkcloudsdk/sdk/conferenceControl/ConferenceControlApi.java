package com.ananwulian.xylinkcloudsdk.sdk.conferenceControl;

import com.ananwulian.xylinkcloudsdk.config.SDKConfigMgr;
import com.ananwulian.xylinkcloudsdk.model.*;
import com.ananwulian.xylinkcloudsdk.model.statis.CurrentMeetingDetail;
import org.codehaus.jackson.map.ObjectMapper;
import com.ananwulian.xylinkcloudsdk.util.HttpUtil;
import com.ananwulian.xylinkcloudsdk.util.Result;
import com.ananwulian.xylinkcloudsdk.util.SignatureSample;

import java.io.IOException;

/**
 * Created by maolizhi on 12/7/2016.
 */
public class ConferenceControlApi {

    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrl = "/api/rest/external/v1/conferenceControl/";
    private static final String prefixUrlMeetingInfo = "/api/rest/external/v1/meetingInfo/";

    /**
     * get details about the meeting ,if Result Object's success is true,
     * the "data" type of Result is MeetingStatus;if not, the "data" type of Result is RestMessage
     *
     * @param enterpriseId
     * @param token
     * @param callNumber,  meetingRoom number or nemoNumber
     * @return
     * @throws IOException
     */
    public Result<MeetingStatus> getMeetingStatus(String enterpriseId, String token, String callNumber) throws IOException {
        String surl = getPrefixUrl() + callNumber + "/meetingStatus?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", null, MeetingStatus.class);
    }


    /**
     * The nemo ente into meeting or the nemo invites another nemo
     *
     * @param enterpriseId
     * @param token
     * @param nemoNumber   ,inviter
     * @param meetingRoom  ,invittee,has two fields,meetingRoomNumber and nemoNumber,you must give value to the one
     * @return
     * @throws IOException
     */
    public Result inviteNemoCall(String enterpriseId, String token,
                                 String nemoNumber, MeetingRoom meetingRoom) throws IOException {

        String surl = getPrefixUrl() + "nemo/" + nemoNumber + "/invitation?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(meetingRoom);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", jsonEntity, null);

    }

    /**
     * 邀请终端入会v2 ***
     *
     * @param enterpriseId
     * @param token
     * @param callInviteRequest
     * @return
     * @throws IOException
     */
    public Result inviteCall(String enterpriseId, String token,
                             CallInviteRequest callInviteRequest) throws IOException {
        String surl = getPrefixUrl() + "invitation?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(callInviteRequest);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", jsonEntity, null);
    }

    /**
     * kicking device
     *
     * @param enterpriseId
     * @param token
     * @param callNumber
     * @param devices      ,the device list which will be removed from the meeting,Device contains id and type
     * @return
     * @throws IOException
     */
    public Result disconnect(String enterpriseId, String token, String callNumber, Device[] devices) throws IOException {
        String surl = getPrefixUrl() + callNumber + "/disconnect?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(devices);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", jsonEntity, null);
    }

    public Result disconnect(String enterpriseId, String token, String callNumber, String jsonEntity) throws IOException {
        String surl = getPrefixUrl() + callNumber + "/disconnect?enterpriseId=" + enterpriseId;
//        String jsonEntity = new ObjectMapper().writeValueAsString(devices);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", jsonEntity, null);
    }

    /**
     * chang meeting mode
     *
     * @param enterpriseId
     * @param token
     * @param meetingRoomNumber
     * @param mode              mode =1 , chairman mode; mode =0 ,discuss mode
     * @param device            the device which will be setted
     * @return
     * @throws IOException
     */
    @Deprecated
    public Result changeMode(String enterpriseId, String token, String meetingRoomNumber,
                             int mode, Device device)
            throws IOException {
        String surl = getPrefixUrl() + meetingRoomNumber + "/changeMode?enterpriseId=" + enterpriseId + "&mode=" + mode;
        String jsonEntity = new ObjectMapper().writeValueAsString(device);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", jsonEntity, null);

    }

    /**
     * Set or cancle main image.if device is null,cancle the main image;if not ,set the device as the main image.
     * If the device is setted as the main image,the conference's chief mode is 1(true);
     * if not,the chief mode is 0(false)
     *
     * @param enterpriseId
     * @param token
     * @param meetingRoomNumber
     * @param device
     * @return
     * @throws IOException
     */
    public Result setMainImage(String enterpriseId, String token, String meetingRoomNumber, Device device)
            throws IOException {
        String surl = getPrefixUrl() + meetingRoomNumber + "/mainImage?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(device);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", jsonEntity, null);

    }

    /**
     * 获取某公司当前正在进行的会议***
     * @param enterpriseId
     * @param token
     * @return
     * @throws IOException
     */
    public Result<CurrentMeeting[]> getEnterpriseCurrentMeeting(String enterpriseId, String token) throws IOException {
        String surl = getPrefixUrl() +  "currentMeeting?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", null,CurrentMeeting[].class);
    }

    /**
     * 根据会议号当前正在进行的会议***
     * @param enterpriseId .
     * @param token .
     * @param conferenceNumber .
     * @return .
     * @throws IOException .
     */
    public Result<CurrentMeeting> getEnterpriseCurrentMeeting(String enterpriseId, String token, String conferenceNumber) throws IOException {
        String surl = getPrefixUrl() +  "conference/currentMeeting?conferenceNumber=" + conferenceNumber + "&enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", null, CurrentMeeting.class);
    }

    /**
     * mute the devices
     *
     * @param enterpriseId
     * @param token
     * @param callNumber
     * @param devices
     * @return
     * @throws IOException
     */
    public Result mute(String enterpriseId, String token, String callNumber, Device[] devices)
            throws IOException {
        String surl = getPrefixUrl() + callNumber + "/mute?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(devices);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", jsonEntity, null);
    }

    /**
     * mute all devices
     *
     * @param enterpriseId
     * @param token
     * @param callNumber
     * @return
     * @throws IOException
     */
    public Result muteall(String enterpriseId, String token, String callNumber)
            throws IOException {
        String surl = getPrefixUrl() + callNumber + "/muteall?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", null, null);
    }

    /**
     * unmute the device
     *
     * @param enterpriseId
     * @param token
     * @param callNumber
     * @param devices
     * @return
     * @throws IOException
     */
    public Result unmute(String enterpriseId, String token, String callNumber, Device[] devices)
            throws IOException {
        String surl = getPrefixUrl() + callNumber + "/unmute?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(devices);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", jsonEntity, null);
    }

    /**
     * end the meeting
     *
     * @param enterpriseId
     * @param token
     * @param callNumber
     * @return
     * @throws IOException
     */
    public Result end(String enterpriseId, String token, String callNumber)
            throws IOException {
        String surl = getPrefixUrl() + callNumber + "/end?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", null, null);
    }
    /**
     * 结束会议并且释放它，如果是临时会议就会清除掉（不可再次使用）***
     *
     * @param enterpriseId
     * @param token
     * @param callNumber
     * @return
     * @throws IOException
     */
    public Result endAndReleaseNumber(String enterpriseId, String token, String callNumber)
            throws IOException {
        String surl = getPrefixUrl() + callNumber + "/endandrelease?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", null, null);
    }




    /**
     * 授权分享页面权限
     *
     * @param enterpriseId
     * @param token
     * @param callNumber
     * @param target
     * @return
     * @throws IOException
     */
    public Result authShare(String enterpriseId, String token, String callNumber, ShareAuthTarget target) throws IOException {
        String surl = getPrefixUrl() + callNumber + "/content/authShare?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(target);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", jsonEntity, null);
    }

    /**
     * 会议锁定（锁定状态下，除非邀请你，要不然不可主动加入）***
     *
     * @param enterpriseId
     * @param token
     * @param callNumber   小鱼号／会议号
     * @return
     * @throws IOException
     */
    public Result meetingLock(String enterpriseId, String token, String callNumber) throws IOException {
        String surl = getPrefixUrl() + callNumber + "/meeting/lock?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", null, null);
    }

    /**
     * 会议解锁（非锁定状态下，可以主动加入会议）***
     *
     * @param enterpriseId
     * @param token
     * @param callNumber
     * @return
     * @throws IOException
     */
    public Result meetingUnlock(String enterpriseId, String token, String callNumber) throws IOException {
        String surl = getPrefixUrl() + callNumber + "/meeting/unlock?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", null, null);
    }

    /**
     * 会议发送弹幕消息 ***
     *
     * @param enterpriseId
     * @param token
     * @param callNumber      小鱼号／会议号
     * @param meetSubtitleReq 弹幕消息信息
     * @return
     * @throws IOException
     */
    public Result sendMessage(String enterpriseId, String token, String callNumber, MeetingSubtitleRequest meetSubtitleReq) throws IOException {
        String surl = getPrefixUrl() + callNumber + "/meeting/sendMsg?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(meetSubtitleReq);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", jsonEntity, null);
    }

    /**
     *
     * @param enterpriseId
     * @param token
     * @param deviceNotification
     * @return
     * @throws IOException
     */
    public Result notifyDevice(String enterpriseId, String token,DeviceNotification deviceNotification) throws IOException {
        String surl = getPrefixUrl() +"notify?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(deviceNotification);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", jsonEntity, null);
    }

    /**
     * 获取某公司当前正在进行的会议(包括会议质量和参会方质量)
     * @param enterpriseId .
     * @param token .
     * @param needQuality .
     * @return .
     * @throws IOException .
     */
    public Result<CurrentMeetingDetail[]> getEnterpriseCurrentMeetingDetail(String enterpriseId, String token, boolean needQuality) throws IOException {
        String surl = getPrefixUrl() +"currentMeeting/detail?enterpriseId=" + enterpriseId + "&needQuality=" + needQuality;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", "", CurrentMeetingDetail[].class);
    }

    /**
     * 获取某公司特定的正在进行的会议(包括会议质量和参会方质量)
     * @param enterpriseId .
     * @param token .
     * @param needQuality .
     * @return .
     * @throws IOException .
     */
    public Result<CurrentMeetingDetail> getEnterpriseCurrentSpecificMeetingDetail(String enterpriseId, String token, String conferenceNumber, boolean needQuality) throws IOException {
        String surl = getPrefixUrl() +"currentMeeting/"+conferenceNumber+"/detail?enterpriseId=" + enterpriseId + "&needQuality=" + needQuality;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", "", CurrentMeetingDetail.class);
    }

    /**
     * 会议中挂断终端
     * @param enterpriseId .
     * @param token .
     * @param nemoNumber .
     * @return .
     * @throws IOException .
     */
    public Result hangUp(String enterpriseId, String token, String nemoNumber) throws IOException {
        String surl = getPrefixUrl() +"nemo/"+nemoNumber+"/hangup?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", "", null);
    }

    /**
     * 开始多画面及广播
     * @return
     */
    public Result startDeviceMultiImage(String enterpriseId, String token,String callNumber,
                                        DeviceMultiImageRequest deviceMultiImageRequest) throws IOException {
        String surl = getPrefixUrl() + callNumber +"/meeting/startDeviceMultiImage?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(deviceMultiImageRequest);
        String signature = signatureSample.computeSignature(jsonEntity, "POST", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "POST", jsonEntity, null);
    }

    /**
     * 停止多画面及广播
     * @return
     */
    public Result stopDeviceMultiImage(String enterpriseId, String token,String callNumber,
                                        DeviceMultiImageRequest deviceMultiImageRequest) throws IOException {
        String surl = getPrefixUrl() + callNumber +"/meeting/stopDeviceMultiImage?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(deviceMultiImageRequest);
        String signature = signatureSample.computeSignature(jsonEntity, "POST", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "POST", jsonEntity, null);
    }

    /**
     * 向终端发送字幕
     * @return
     */
    public Result subtitle(String enterpriseId, String token,String callNumber,
                           MeetingControlSubtitleRequest meetingControlSubtitleRequest) throws IOException {
        String surl = getPrefixUrl() + callNumber +"/meeting/subtitle?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(meetingControlSubtitleRequest);
        String signature = signatureSample.computeSignature(jsonEntity, "POST", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "POST", jsonEntity, null);
    }

    /**
     * 直播中，设置直播内容布局
     *     POST https://cloud.xylink.com/api/rest/external/v1/conferenceControl/{callNumber}/meeting/liveContentLayout?enterpriseId=XXX&signature=XXX
     * @return
     */
    public Result liveContentLayout(String enterpriseId, String token,String callNumber,
                                    LiveLayoutRequest liveLayoutRequest) throws IOException {
        String surl = getPrefixUrl() + callNumber +"/meeting/liveContentLayout?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(liveLayoutRequest);
        String signature = signatureSample.computeSignature(jsonEntity, "POST", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "POST", jsonEntity, null);
    }

    /**
     * 直播中，设置直播人物布局
     *     POST https://cloud.xylink.com/api/rest/external/v1/conferenceControl/{callNumber}/meeting/livePeopleLayout?enterpriseId=XXX&signature=XXX
     * @return
     */
    public Result livePeopleLayout(String enterpriseId, String token,String callNumber,
                                    LiveLayoutRequest liveLayoutRequest) throws IOException {
        String surl = getPrefixUrl() + callNumber +"/meeting/livePeopleLayout?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(liveLayoutRequest);
        String signature = signatureSample.computeSignature(jsonEntity, "POST", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "POST", jsonEntity, null);
    }

    private String getPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrl;
    }

    private String getMeetingInfoPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrlMeetingInfo;
    }
}
