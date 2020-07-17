package com.ananwulian.xylinkcloudsdk.sdk.device;

import com.ananwulian.xylinkcloudsdk.model.DeviceLoginReq;
import com.ananwulian.xylinkcloudsdk.util.HttpUtil;
import com.ananwulian.xylinkcloudsdk.util.Result;
import com.ananwulian.xylinkcloudsdk.util.SignatureSample;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * device sn api
 *
 * @author ghostsf
 * @datetime 2020/3/4 2:16 PM
 * @see
 * @since
 */
public class DeviceLoginApi {
    private static SignatureSample signatureSample = new SignatureSample();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private String getPrefixUrl() {
        return "https://cloud.xylink.com:443/api/rest/v3/en/sdk/box/third/device/login";
    }

    /**
     * login check
     * 模拟请求app sdk xylink login
     * 获取设备当前状态 license是否过期等
     * <p>
     * Header=={Accept-Charset=UTF-8, Accept=application/json, AppID=com.ainemo.sample_xxxx, Accept-Encoding=gzip, Accept-Language=zh-CN, Content-Type=application/json;charset=UTF-8}
     * jsonReq={"category":"手电","deviceModel":"Flashlight","deviceSN":"testlicense","displayName":"测试license","identity":"FFFFFFFF-C7A8-3C72-FFFF-FFFF87CD53AD","packageName":"com.xylink.vessel.third.device"}
     * <p>
     * success:
     * {
     * "securityKey": "454a41a660fe9d206cf5ff46a822f0431735aee2d5b",
     * "deviceSN": "testlicense",
     * "number": "28353068",
     * "id": 223708060,
     * "identity": "FFFFFFFF-C7A8-3C72-FFFF-FFFF87CD53AD",
     * "expTime": 1626492408402,
     * "effectiveDays": 364
     * }
     * <p>
     * fail:
     * {
     * "developerMessage": "",
     * "userMessage": "invalid.parameter",
     * "errorCode": 1001,
     * "moreInfo": "http://www.com.ainemo.com/errors/1001"
     * }
     *
     * @param appId
     * @param sign
     * @param enterpriseId
     * @param deviceLoginReq
     * @return
     * @throws IOException
     */
    public Result simulateLogin(String enterpriseId, String appId, String sign, DeviceLoginReq deviceLoginReq) throws IOException {
        String surl = getPrefixUrl() + "?extId=" + enterpriseId + "&sign=" + sign;
        if (deviceLoginReq == null) {
            return null;
        }
        String jsonEntity = new ObjectMapper().writeValueAsString(deviceLoginReq);
        return HttpUtil.getResponseForSDK(surl, "PUT", appId, jsonEntity, Map.class);
    }

}

