package com.ananwulian.xylinkcloudsdk.sdk.dating;

import com.ananwulian.xylinkcloudsdk.config.SDKConfigMgr;
import com.ananwulian.xylinkcloudsdk.model.ReminderMeeting;
import org.codehaus.jackson.map.ObjectMapper;
import com.ananwulian.xylinkcloudsdk.util.HttpUtil;
import com.ananwulian.xylinkcloudsdk.util.Result;
import com.ananwulian.xylinkcloudsdk.util.SignatureSample;

import java.io.IOException;
import java.util.Map;

/**
 * Created by maolizhi on 12/16/2016.
 */
public class ScheduleMeetingApi {
    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrl = "/api/rest/external/v1/meetingreminders";

    /**
     * schedule a meeting,if success,the date type of Result is "String",the date value is meeting id;if not ,
     * the date type of Result is "RestMessage"
     * @param enterpriseId
     * @param token
     * @param reminderMeeting
     * @return
     * @throws IOException
     */
    public Result remindMeeting(String enterpriseId, String token, ReminderMeeting reminderMeeting, int maxParticipantCount)
            throws IOException {
        String surl = getPrefixUrl()  + "?enterpriseId=" + enterpriseId + "&maxParticipant=" + maxParticipantCount;
        String jsonEntity = new ObjectMapper().writeValueAsString(reminderMeeting);
        String signature = signatureSample.computeSignature(jsonEntity,"POST",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"POST", jsonEntity,Map.class);

    }

    /**
     * schedule a meeting,if success,the date type of Result is "String",the date value is meeting id;if not ,
     * the date type of Result is "RestMessage"
     * @param enterpriseId
     * @param token
     * @param reminderMeeting
     * @return
     * @throws IOException
     */
    public Result remindMeeting(String enterpriseId, String token, ReminderMeeting reminderMeeting)
            throws IOException {
        String surl = getPrefixUrl()  + "?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(reminderMeeting);
        String signature = signatureSample.computeSignature(jsonEntity,"POST",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"POST", jsonEntity, Map.class);

    }

    /**
     * update meeting
     * @param enterpriseId
     * @param token
     * @param meetingId
     * @param reminderMeeting
     * @return
     * @throws IOException
     */
    public Result updateMeeting(String enterpriseId, String token,String meetingId, ReminderMeeting reminderMeeting, int maxParticipantCount)
            throws IOException {
        String surl = getPrefixUrl() + "/" + meetingId + "?enterpriseId=" + enterpriseId + "&maxParticipant=" + maxParticipantCount;
        String jsonEntity = new ObjectMapper().writeValueAsString(reminderMeeting);
        String signature = signatureSample.computeSignature(jsonEntity,"PUT",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"PUT", jsonEntity,null);

    }

    /**
     * update meeting
     * @param enterpriseId
     * @param token
     * @param meetingId
     * @param reminderMeeting
     * @return
     * @throws IOException
     */
    public Result updateMeeting(String enterpriseId, String token,String meetingId, ReminderMeeting reminderMeeting)
            throws IOException {
        String surl = getPrefixUrl() + "/" + meetingId + "?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(reminderMeeting);
        String signature = signatureSample.computeSignature(jsonEntity,"PUT",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"PUT", jsonEntity,null);

    }

    public Result deleteMeeting(String enterpriseId, String token,String meetingId) throws IOException{
        String surl = getPrefixUrl() + "/" + meetingId + "?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("","DELETE",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"DELETE", null,null);


    }

    /**
     * 按照会议ID获取会议提醒
     * @param enterpriseId
     * @param token
     * @param meetingId
     * @return
     * @throws IOException
     */
    public Result<ReminderMeeting> getMeeting(String enterpriseId, String token,String meetingId) throws IOException{
        String surl = getPrefixUrl() + "/" + meetingId + "?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null,ReminderMeeting.class);
    }
    /**
     * get all meetings who's end time is bigger than  the parmater "endTime",
     * if success,the date type of Result is "ReminderMeeting[]",the date value is meeting id;if not ,
     * the date type of Result is "RestMessage"
     * @param enterpriseId
     * @param token
     * @param endTime
     * @return
     * @throws IOException
     */
    public Result<ReminderMeeting[]> getAllMeeting(String enterpriseId, String token, long endTime)
            throws IOException {
        String surl = getPrefixUrl()  + "?enterpriseId=" + enterpriseId + "&endTime="+endTime;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null,ReminderMeeting[].class);
    }

    private String getPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrl;
    }
}
