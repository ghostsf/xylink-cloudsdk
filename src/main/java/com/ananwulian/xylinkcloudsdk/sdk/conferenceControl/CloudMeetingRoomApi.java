package com.ananwulian.xylinkcloudsdk.sdk.conferenceControl;

import com.ananwulian.xylinkcloudsdk.config.SDKConfigMgr;
import com.ananwulian.xylinkcloudsdk.model.*;
import com.ananwulian.xylinkcloudsdk.util.HttpUtil;
import com.ananwulian.xylinkcloudsdk.util.Result;
import com.ananwulian.xylinkcloudsdk.util.SignatureSample;

import java.io.IOException;
import java.net.URLEncoder;

public class CloudMeetingRoomApi {
    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrlMeetingInfo = "/api/rest/external/v1/conference/";



    /**
     * 根据类型查询企业的云会议室列表
     * @param enterpriseId
     * @param token
     * @return
     * @throws IOException
     */
    public Result<Pager<ConferenceMeetingRoom>> getCloudMeetingRooms(String enterpriseId, String token, String type, int page, int size) throws IOException {
        String surl = getMeetingInfoPrefixUrl() + "cloudConference?enterpriseId=" + enterpriseId + "&type=" + type + "&page=" + page + "&size=" + size;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", null, Pager.class);
    }

    private String getMeetingInfoPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrlMeetingInfo;
    }
}
