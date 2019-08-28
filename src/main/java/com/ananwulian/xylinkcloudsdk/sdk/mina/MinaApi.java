package com.ananwulian.xylinkcloudsdk.sdk.mina;

import com.ananwulian.xylinkcloudsdk.config.SDKConfigMgr;
import com.ananwulian.xylinkcloudsdk.util.HttpUtil;
import com.ananwulian.xylinkcloudsdk.util.Result;
import com.ananwulian.xylinkcloudsdk.util.SignatureSample;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * 微信小程序接口
 */
public class MinaApi {
    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrl = "/api/rest/external/v1/miniprogram/token";

    public Result getToken(String enterpriseId, String token,Map map) throws IOException {
        String surl = getPrefixUrl() + "?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(map);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", jsonEntity, Map.class);
    }

    private String getPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrl;
    }
}
