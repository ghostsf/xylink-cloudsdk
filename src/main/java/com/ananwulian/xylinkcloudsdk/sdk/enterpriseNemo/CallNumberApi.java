package com.ananwulian.xylinkcloudsdk.sdk.enterpriseNemo;

import com.ananwulian.xylinkcloudsdk.config.SDKConfigMgr;
import com.ananwulian.xylinkcloudsdk.model.CallNumberInfo;
import com.ananwulian.xylinkcloudsdk.model.MeetingRoom;
import com.ananwulian.xylinkcloudsdk.util.HttpUtil;
import com.ananwulian.xylinkcloudsdk.util.Result;
import com.ananwulian.xylinkcloudsdk.util.SignatureSample;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by changxiangyang on 2017/9/14.
 */
public class CallNumberApi {
    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrl = "/api/rest/external/{thirdId}/v1/callnumber";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 按照呼叫号获取信息
     * @param enterpriseId
     * @param token
     * @param callNumber
     * @return
     * @throws IOException
     */
    public Result<CallNumberInfo> getCallNumberInfo(String enterpriseId, String token, String callNumber) throws IOException{
        String surl = getPrefixUrl() + "/" + callNumber + "?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(callNumber);
        String signature = signatureSample.computeSignature(jsonEntity, "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", jsonEntity, CallNumberInfo.class);
    }

    public static SignatureSample getSignatureSample() {
        return signatureSample;
    }

    public static void setSignatureSample(SignatureSample signatureSample) {
        CallNumberApi.signatureSample = signatureSample;
    }

    public static String getPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrl;
    }
}
