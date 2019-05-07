package com.ananwulian.xylinkcloudsdk.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ananwulian.xylinkcloudsdk.config.SDKConfigMgr;
import com.ananwulian.xylinkcloudsdk.model.BuffetUserDto;
import com.ananwulian.xylinkcloudsdk.util.HttpUtil;
import com.ananwulian.xylinkcloudsdk.util.Result;
import com.ananwulian.xylinkcloudsdk.util.SignatureSample;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by changxiangyang on 2017/10/31.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuffetUserApi {
    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrl = "/api/rest/external/v1/buffet/";

    /**
     * batch addition User Info
     * @param buffetUserDtos UserList
     * @param enterpriseId
     * @param token
     * @return
     * @throws IOException
     */
    public Result<Set> batchAdd(List<BuffetUserDto> buffetUserDtos, String enterpriseId, String token) throws IOException {
        String surl = getPrefixUrl() + "batch/users?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(buffetUserDtos);
        String signature = signatureSample.computeSignature(jsonEntity, "POST", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "POST", jsonEntity, Set.class);
    }

    /**
     * add user
     * @param buffetUserDtos
     * @param enterpriseId
     * @param token
     * @return
     * @throws IOException
     */
    public Result<Map> add(BuffetUserDto buffetUserDtos, String enterpriseId, String token) throws IOException {
        String surl = getPrefixUrl() + "user?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(buffetUserDtos);
        String signature = signatureSample.computeSignature(jsonEntity, "POST", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "POST", jsonEntity, Map.class);
    }

    /**
     * get user info
     * @param enterpriseId
     * @param token
     * @return
     * @throws IOException
     */
    public Result<List> get(String enterpriseId, String token) throws IOException {
        String surl = getPrefixUrl() + "user?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", null, List.class);
    }

    /**
     * update user info
     * @param buffetUserDtos
     * @param enterpriseId
     * @param token
     * @return
     * @throws IOException
     */
    public Result update(BuffetUserDto buffetUserDtos, String enterpriseId, String token) throws IOException {
        String surl = getPrefixUrl() + "user?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(buffetUserDtos);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
         return HttpUtil.getResponse(surl, "PUT", jsonEntity, null);

    }

    /**
     * delete user
     * @param enterpriseId
     * @param token
     * @return
     * @throws IOException
     */
    public Result delete( String enterpriseId,String countryCode, String phone, String token) throws IOException {
        String surl = getPrefixUrl() + "user?countryCode=" + countryCode + "&phone=" + phone + "&enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "DELETE", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "DELETE", null, null);
    }

    private String getPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrl;
    }
}
