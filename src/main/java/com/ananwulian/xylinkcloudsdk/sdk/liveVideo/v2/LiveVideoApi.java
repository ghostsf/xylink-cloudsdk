package com.ananwulian.xylinkcloudsdk.sdk.liveVideo.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ananwulian.xylinkcloudsdk.config.SDKConfigMgr;
import com.ananwulian.xylinkcloudsdk.model.LV;
import com.ananwulian.xylinkcloudsdk.model.LiveVideo;
import org.codehaus.jackson.map.ObjectMapper;
import com.ananwulian.xylinkcloudsdk.util.HttpUtil;
import com.ananwulian.xylinkcloudsdk.util.Result;
import com.ananwulian.xylinkcloudsdk.util.SignatureSample;

import java.io.IOException;

/**
 * Created by maolizhi on 12/15/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveVideoApi {
    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrl = "/api/rest/external/v1/liveVideo2/enterprise/";

    /**
     * create LiveVideo,if Result Object's success is true,
     * the "data" type of Result is LV;if not, the "data" type of Result is RestMessage
     * @param enterpriseId
     * @param token
     * @param nemoNumber
     * @param liveVideo
     * @return
     * @throws IOException
     */
    public Result<LV> newLiveVideo(String enterpriseId,String token,String nemoNumber,LiveVideo liveVideo) throws IOException{
        String surl = getPrefixUrl() + enterpriseId + "/xiaoyunumber/" + nemoNumber + "/live?enterpriseId="+enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(liveVideo);
        String signature = signatureSample.computeSignature(jsonEntity,"POST",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"POST", jsonEntity, LV.class);
    }

    /**
     * update LiveVideo
     * @param enterpriseId
     * @param token
     * @param nemoNumber
     * @param liveId
     * @param liveVideo
     * @return
     * @throws IOException
     */
    public Result updateLiveVideo(String enterpriseId,String token,String nemoNumber,String liveId,LiveVideo liveVideo)
            throws IOException{
        String surl = getPrefixUrl() + enterpriseId + "/xiaoyunumber/" + nemoNumber + "/live/" +liveId
                + "?enterpriseId="+enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(liveVideo);
        String signature = signatureSample.computeSignature(jsonEntity,"PUT",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"PUT", jsonEntity, null);
    }

    /**
     * delete LiverVideo
     * @param enterpriseId
     * @param token
     * @param nemoNumber
     * @param liveId
     * @return
     * @throws IOException
     */
    public Result deleteLiveVideo(String enterpriseId,String token,String nemoNumber,String liveId)throws IOException{
        String surl = getPrefixUrl() + enterpriseId + "/xiaoyunumber/" + nemoNumber + "/live/" +liveId
                + "?enterpriseId="+enterpriseId;
        System.out.println(surl);
        String signature = signatureSample.computeSignature("","DELETE",token,surl);
        surl += "&signature=" + signature;
        System.out.println(surl);
        return HttpUtil.getResponse(surl,"DELETE", null, null);
    }

    /**
     * get LiveVideo according to nemo number and live id,
     * if Result Object's success is true,the "data" type of Result is LV;if not,
     * the "data" type of Result is RestMessage
     * @param enterpriseId
     * @param token
     * @param nemoNumber
     * @param liveId
     * @return
     * @throws IOException
     */
    public Result<LV> getLiveVideo(String enterpriseId,String token,String nemoNumber,String liveId) throws IOException{
        String surl = getPrefixUrl() + enterpriseId + "/xiaoyunumber/" + nemoNumber + "/live/" +liveId
                + "?enterpriseId="+enterpriseId;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        System.out.println(surl);
        return HttpUtil.getResponse(surl,"GET", null, LV.class);
    }

    /**
     * get video list for one LiveVideo,if Result Object's success is true,
     * the "data" type of Result is String[];if not, the "data" type of Result is RestMessage
     * @param enterpriseId
     * @param token
     * @param nemoNumber
     * @param liveId
     * @return
     * @throws IOException
     */
    public Result<String[]> getVideos(String enterpriseId,String token,String nemoNumber,String liveId) throws IOException{
        String surl = getPrefixUrl() + enterpriseId + "/xiaoyunumber/" + nemoNumber + "/live/" +liveId + "/videos"
                + "?enterpriseId="+enterpriseId;
        System.out.println(surl);
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        System.out.println(surl);
        return HttpUtil.getResponse(surl,"GET", null, String[].class);
    }

    private String getPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrl;
    }

    public static void main(String[] args) throws Exception {
        LiveVideoApi liveVideoApi = new LiveVideoApi();
        LiveVideo liveVideo = new LiveVideo();
        liveVideo.setConfNo("913581819843");
        liveVideo.setAutoPublishRecording(true);
        liveVideo.setEndTime(System.currentTimeMillis() + 100 * 1000 * 1000);
        liveVideo.setStartTime(System.currentTimeMillis());
        liveVideo.setNemoNumber("291854");
        liveVideo.setTitle("aaaa");
        Result<LV> lvResult = liveVideoApi.newLiveVideo("3807773d9c7d3b70351a1dcb92c08e9558eeb6d9", "72bcc56c87169cac623acb8d5c28dd1053cd0d9cc96dc57cab3ee5cb6a88774c",
                "291854", liveVideo);
        System.out.println(lvResult.getData());

    }
}
