package com.ananwulian.xylinkcloudsdk.sdk.liveVideo.v3;

import com.ananwulian.xylinkcloudsdk.config.SDKConfigMgr;
import com.ananwulian.xylinkcloudsdk.model.*;
import com.ananwulian.xylinkcloudsdk.util.HttpUtil;
import com.ananwulian.xylinkcloudsdk.util.Result;
import com.ananwulian.xylinkcloudsdk.util.SignatureSample;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * created by maolizhi at 03/14/2017
 * modify by ghostsf at 2020-08-26 10:06:49
 */
public class LiveVideoApi {
    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrl = "/api/rest/external/v1/liveVideo3/enterprise/";

    /**
     * create LiveVideo,if Result Object's success is true,
     * the "data" type of Result is LV;if not, the "data" type of Result is RestMessage
     *
     * @param enterpriseId
     * @param token
     * @param confNo
     * @param liveVideo
     * @return
     * @throws IOException
     */
    @Deprecated
    public Result<LV> newLiveVideo(String enterpriseId, String token, String confNo, LiveVideo liveVideo) throws IOException {
        String surl = getPrefixUrl() + enterpriseId + "/conf/" + confNo + "/live?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(liveVideo);
        String signature = signatureSample.computeSignature(jsonEntity, "POST", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "POST", jsonEntity, LV.class);
    }

    /**
     * shcedule a live for conference
     * <p>
     * 说明：必须要在开会前预约
     * 默认接口请求频率限制：20次/秒
     *
     * @param enterpriseId
     * @param token
     * @param confNo
     * @param confPwd
     * @param liveVideo
     * @return
     * @throws IOException
     */
    public Result<LiveVideoForConference> scheduleLive(String enterpriseId, String token, String confNo, String confPwd, LiveVideo liveVideo) throws IOException {
        String surl = getPrefixUrl() + enterpriseId + "/conf/" + confNo + "/live?enterpriseId=" + enterpriseId + "&confPwd=" + confPwd;
        String jsonEntity = new ObjectMapper().writeValueAsString(liveVideo);
        String signature = signatureSample.computeSignature(jsonEntity, "POST", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "POST", jsonEntity, LiveVideoForConference.class);
    }

    /**
     * update live
     * <p>
     * 修改一条未开始的直播。由于实现上的约束，暂时不支持修改直播时间。
     * <p>
     * 默认接口请求频率限制：20次/秒
     *
     * @param enterpriseId
     * @param token
     * @param confNo
     * @param confPwd      , it is can be empty
     * @param liveId
     * @param liveVideo
     * @return
     * @throws IOException
     */
    @Deprecated
    public Result updateLive(String enterpriseId, String token, String confNo, String confPwd, String liveId, LiveVideo liveVideo)
            throws IOException {
        String surl = getPrefixUrl() + enterpriseId + "/conf/" + confNo + "/live/" + liveId
                + "?enterpriseId=" + enterpriseId + "&confPwd=" + confPwd;
        String jsonEntity = new ObjectMapper().writeValueAsString(liveVideo);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", jsonEntity, null);
    }

    /**
     * delete live
     * <p>
     * 删除一条存在的直播。会删除和这个直播相关的所有信息。
     * <p>
     * 默认接口请求频率限制：20次/秒
     *
     * @param enterpriseId
     * @param token
     * @param confNo
     * @param confPwd
     * @param liveId
     * @return
     * @throws IOException
     */
    public Result deleteLive(String enterpriseId, String token, String confNo, String confPwd, String liveId) throws IOException {
        String surl = getPrefixUrl() + enterpriseId + "/conf/" + confNo + "/live/" + liveId
                + "?enterpriseId=" + enterpriseId + "&confPwd=" + confPwd;
        String signature = signatureSample.computeSignature("", "DELETE", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "DELETE", null, null);
    }

    /**
     * get the live
     * 默认接口请求频率限制：20次/秒
     *
     * @param enterpriseId
     * @param token
     * @param confNo
     * @param confPwd
     * @param liveId
     * @return
     * @throws IOException
     */
    public Result<LiveVideoForConference> getLive(String enterpriseId, String token, String confNo, String confPwd, String liveId) throws IOException {
        String surl = getPrefixUrl() + enterpriseId + "/conf/" + confNo + "/live/" + liveId
                + "?enterpriseId=" + enterpriseId + "&confPwd=" + confPwd;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", null, LiveVideoForConference.class);
    }

    /**
     * get video list for the live
     * <p>
     * 预约直播或修改直播时autoRecording和autoPublishRecording必须都为true，才有视频列表。视频信息包括开始时间、结束时间、时长信息。
     * 默认接口请求频率限制：20次/秒
     *
     * @param enterpriseId
     * @param token
     * @param confNo
     * @param confPwd
     * @param liveId
     * @return
     * @throws IOException
     */
    public Result<Video[]> getLiveVideoList(String enterpriseId, String token, String confNo, String confPwd, String liveId) throws IOException {
        String surl = getPrefixUrl() + enterpriseId + "/conf/" + confNo + "/live/" + liveId + "/videoswithduration"
                + "?enterpriseId=" + enterpriseId + "&confPwd=" + confPwd;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", null, Video[].class);
    }

    /**
     * start/end the live
     * 默认接口请求频率限制：20次/秒
     *
     * @param enterpriseId
     * @param token
     * @param confNo
     * @param confPwd
     * @param liveId
     * @param status
     * @return
     * @throws IOException
     */
    public Result controlLive(String enterpriseId, String token, String confNo, String confPwd, String liveId, Status status) throws IOException {
        String surl = getPrefixUrl() + enterpriseId + "/conf/" + confNo + "/live/" + liveId + "/status"
                + "?enterpriseId=" + enterpriseId + "&confPwd=" + confPwd;
        String jsonEntity = new ObjectMapper().writeValueAsString(status);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", jsonEntity, null);
    }


    /**
     * 根据直播状态查询直播列表
     * 默认接口请求频率限制：20次/秒
     *
     * @param enterpriseId
     * @param token
     * @return
     * @throws IOException
     */
    public Result<Pager<LiveVideoForConference>> livePage(String enterpriseId, String token, int liveStatus, int pageIndex, int pageSize) throws IOException {
        String surl = getPrefixUrl() + enterpriseId + "/live/page?enterpriseId=" + enterpriseId + "&liveStatus=" + liveStatus + "&pageIndex=" + pageIndex + "&pageSize=" + pageSize;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", null, Pager.class);
    }


    private String getPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrl;
    }

}
