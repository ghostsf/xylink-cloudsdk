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
        String signature = signatureSample.computeSignature("","DELETE",token,surl);
        surl += "&signature=" + signature;
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
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null, String[].class);
    }

    private String getPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrl;
    }

}
