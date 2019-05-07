package com.ananwulian.xylinkcloudsdk.sdk.user;

import com.ananwulian.xylinkcloudsdk.config.SDKConfigMgr;
import com.ananwulian.xylinkcloudsdk.model.ExternalLoginRequest;
import com.ananwulian.xylinkcloudsdk.model.UserValidateResponse;
import com.ananwulian.xylinkcloudsdk.util.AES256Util;
import com.ananwulian.xylinkcloudsdk.util.HttpUtil;
import com.ananwulian.xylinkcloudsdk.util.Result;
import com.ananwulian.xylinkcloudsdk.util.SignatureSample;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: gzm
 * Date: 2018-12-08
 */
public class UserValidateApi {
    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrl = "/api/rest/external/v1/user/";

    public UserValidateResponse userValidate(String enterpriseId, String token, ExternalLoginRequest externalLoginRequest) throws IOException {
        String surl = getPrefixUrl() + "validate?enterpriseId="+enterpriseId ;
        if(externalLoginRequest == null || StringUtils.isBlank(externalLoginRequest.getPassword())
                || StringUtils.isBlank(externalLoginRequest.getUserPhone())) {
            return null;
        }
        String jsonEntity = new ObjectMapper().writeValueAsString(externalLoginRequest);
        String signature = signatureSample.computeSignature(jsonEntity,"POST",token,surl);
        surl += "&signature=" + signature;
        try {
            Result<UserValidateResponse> userValidateResponseResult = HttpUtil.getResponse(surl, "POST", jsonEntity, UserValidateResponse.class);
            if(userValidateResponseResult.isSuccess()) {
                return userValidateResponseResult.getData();
            } else {
                throw new RuntimeException(userValidateResponseResult.getErrorStatus() + "");
            }
        } catch (IOException e) {
            throw e;
        }
    }

    private String getPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrl;
    }
}
