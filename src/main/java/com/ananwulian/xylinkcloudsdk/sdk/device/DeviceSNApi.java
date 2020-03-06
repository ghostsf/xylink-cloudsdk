package com.ananwulian.xylinkcloudsdk.sdk.device;

import com.ananwulian.xylinkcloudsdk.config.SDKConfigMgr;
import com.ananwulian.xylinkcloudsdk.util.HttpUtil;
import com.ananwulian.xylinkcloudsdk.util.Result;
import com.ananwulian.xylinkcloudsdk.util.SignatureSample;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * device sn api
 *
 * @author ghostsf
 * @datetime 2020/3/4 2:16 PM
 * @see
 * @since
 */
public class DeviceSNApi {
    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrl = "/api/rest/external/v1/third/unbind";
    private static final ObjectMapper objectMapper = new ObjectMapper();

//    PUT https://sdk.xylink.com/api/rest/external/v1/third/unbind?enterpriseId=***&deviceSN=***&signature=***

    private String getPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrl;
    }

    /**
     * unbind
     *
     * @param enterpriseId
     * @param token
     * @param deviceSN
     * @return
     * @throws IOException
     */
    public Result unbind(String enterpriseId, String token, String deviceSN) throws IOException {
        String surl = getPrefixUrl() + "?enterpriseId=" + enterpriseId;
        surl += "&deviceSN=" + deviceSN;
        String signature = signatureSample.computeSignature(null, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", null, null);
    }

}

