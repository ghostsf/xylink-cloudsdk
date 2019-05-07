package com.ananwulian.xylinkcloudsdk.sdk.callback;

import com.ananwulian.xylinkcloudsdk.config.SDKConfigMgr;
import com.ananwulian.xylinkcloudsdk.model.VodInfo;
import com.ananwulian.xylinkcloudsdk.model.callback.CallbackEvent;
import com.ananwulian.xylinkcloudsdk.model.callback.ExternalCallback;
import com.ananwulian.xylinkcloudsdk.model.callback.RosterCallback;
import com.ananwulian.xylinkcloudsdk.util.HttpUtil;
import com.ananwulian.xylinkcloudsdk.util.Result;
import com.ananwulian.xylinkcloudsdk.util.SignatureSample;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * create by xinzhizhixuan on 2018-12-20
 */
public class CallBacksApi {
    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrl = "/api/rest/external/v1/";

    /**
     * 获取注册的所有的基础事件
     * @param enterpriseId .
     * @param token .
     * @return .
     * @throws IOException .
     */
    public Result<ExternalCallback[]> getExternalCallbacks(String enterpriseId, String token) throws IOException {
        String surl = getPrefixUrl() + "callbacks?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", "", ExternalCallback[].class);
    }

    /**
     * 注册基础事件
     * @param enterpriseId .
     * @param token .
     * @param externalCallback .
     * @return .
     * @throws IOException .
     */
    public Result regExternalCallback(String enterpriseId, String token, ExternalCallback externalCallback) throws IOException {
        String surl = getPrefixUrl() + "callbacks?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(externalCallback);
        String signature = signatureSample.computeSignature(jsonEntity, "POST", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "POST", jsonEntity, null);
    }

    /**
     * 更新已经注册的基础事件
     * @param enterpriseId .
     * @param token .
     * @param externalCallback .
     * @return .
     * @throws IOException .
     */
    public Result updateExternalCallback(String enterpriseId, String token, ExternalCallback externalCallback) throws IOException {
        String surl = getPrefixUrl() + "callbacks/" + externalCallback.getCallbackEvent().name()+"?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(externalCallback);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", jsonEntity, null);
    }

    /**
     * 移除注册的基础事件
     * @param enterpriseId .
     * @param token .
     * @param callbackEvent .
     * @return .
     * @throws IOException .
     */
    public Result removeExternalCallback(String enterpriseId, String token, CallbackEvent callbackEvent) throws IOException {
        String surl = getPrefixUrl() + "callbacks/" + callbackEvent.name() + "?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "DELETE", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "DELETE", "", null);
    }

    /**
     * 获取已经注册的所有Roster事件
     * @param enterpriseId .
     * @param token .
     * @return .
     * @throws IOException .
     */
    public Result<RosterCallback[]> getRosterCallbacks(String enterpriseId, String token) throws IOException {
        String surl = getPrefixUrl() + "callbacks/roster?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", "", RosterCallback[].class);
    }

    /**
     * 注册或更新Roster事件
     * @param enterpriseId .
     * @param token .
     * @param confNumber 会议号 .
     * @param rosterCallback .
     * @return .
     * @throws IOException .
     */
    public Result regRosterCallback(String enterpriseId, String token, String confNumber, RosterCallback rosterCallback) throws IOException {
        String surl = getPrefixUrl() + "callbacks/roster/" + confNumber + "?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(rosterCallback);
        String signature = signatureSample.computeSignature(jsonEntity, "POST", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "POST", jsonEntity, CallbackEvent[].class);
    }

    /**
     * 移除住处的roster事件
     * @param enterpriseId .
     * @param token .
     * @param confNumber 会议号.
     * @return .
     * @throws IOException .
     */
    public Result removeRosterCallback(String enterpriseId, String token, String confNumber) throws IOException {
        String surl = getPrefixUrl() + "callbacks/roster/" + confNumber + "?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "DELETE", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "DELETE", "", CallbackEvent[].class);
    }

    private String getPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrl;
    }
}
