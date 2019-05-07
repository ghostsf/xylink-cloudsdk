package com.ananwulian.xylinkcloudsdk.util;

import com.ananwulian.xylinkcloudsdk.config.SDKConfigMgr;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.security.SignatureException;
import java.util.*;

/**
 * Created by wenya on 16/9/10.
 */
public class SignatureSample {

    private static Logger logger = LoggerFactory.getLogger(SignatureSample.class);

    private String requestUriPrefix="/api/rest/external/v1/";

    protected String computeStringToSign(String requestPath, Map<String, String> reqParams, String reqJsonEntity, String reqMethod) throws Exception{
        String prefix = SDKConfigMgr.getServerHost() + requestUriPrefix;
        //1. request method
        StringBuffer strToSign = new StringBuffer(reqMethod);
        strToSign.append("\n");
        //2. request path
        strToSign.append(requestPath.substring(prefix.length()));
        strToSign.append("\n");
        //3. sorted request param and value
        List<String> params = new ArrayList<String>(reqParams.keySet());
        Collections.sort(params);
        for(String param : params) {
            strToSign.append(param);
            strToSign.append("=");
            strToSign.append(reqParams.get(param));
            strToSign.append("&");
        }
        strToSign.deleteCharAt(strToSign.length()-1);
        strToSign.append("\n");
        //4. request entity
//        byte[] reqEntity = reqJsonEntity.getBytes("utf-8");
        byte[] reqEntity = new byte[0];
        if (StringUtils.isNotBlank(reqJsonEntity)){
            reqEntity = reqJsonEntity.getBytes("utf-8");
        }
        //printArray(reqEntity);
        if(reqEntity.length == 0) {
            byte[] entity = DigestUtils.sha256("");
            strToSign.append(Base64.encodeBase64String(entity));
        } else {
            byte[] data = null;
            if(reqEntity.length <= 100) {
                data = reqEntity;
            } else {
                data = Arrays.copyOf(reqEntity, 100);
            }
            byte[] entity = DigestUtils.sha256(data);
           // printArray(entity);
            strToSign.append(Base64.encodeBase64String(entity));
        }

        String ret = strToSign.toString();
        logger.debug(ret);
        logger.debug("------------------");
        return ret;
    }

    private void printArray(byte[] data) {
        StringBuffer sb = new StringBuffer();
        for(byte d : data) {
            sb.append(d);
            sb.append(",");
        }
        logger.debug(sb.toString());
    }

    private String calculateHMAC(String data, String key) throws SignatureException {
        try {
            SecretKeySpec e = new SecretKeySpec(key.getBytes("UTF8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(e);
            byte[] rawHmac = mac.doFinal(data.getBytes("UTF8"));
            String result = Base64.encodeBase64String(rawHmac);
            return result;
        } catch (Exception var6) {
            throw new SignatureException("Failed to generate HMAC : " + var6.getMessage());
        }
    }

    public String computeSignature(String jsonEntity, String method, String token, String reqPath) {
        try {
            Map<String, String> reqParams = new HashMap<String, String>();
            int idx = reqPath.indexOf("?");
            String[] params = reqPath.substring(idx + 1).split("&");
            for(String param : params) {
                String[] pair = param.split("=");
                if (pair.length == 1){
                    reqParams.put(pair[0], "");
                }else {
                    reqParams.put(pair[0], pair[1]);
                }
            }
            reqPath = reqPath.substring(0, idx);
            String strToSign = computeStringToSign(reqPath, reqParams, jsonEntity, method);
            String mySignature = calculateHMAC(strToSign, token);
            mySignature = mySignature.replace(" ", "+");
            return URLEncoder.encode(mySignature, "utf-8");
        } catch (Exception e) {
            return null;
        }
    }
}
