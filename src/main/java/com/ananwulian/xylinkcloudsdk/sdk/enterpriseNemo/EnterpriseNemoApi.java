package com.ananwulian.xylinkcloudsdk.sdk.enterpriseNemo;

import com.ananwulian.xylinkcloudsdk.config.SDKConfigMgr;
import com.ananwulian.xylinkcloudsdk.model.NemoDto;
import com.ananwulian.xylinkcloudsdk.model.PageableNemoDto;
import com.ananwulian.xylinkcloudsdk.util.HttpUtil;
import com.ananwulian.xylinkcloudsdk.util.Result;
import com.ananwulian.xylinkcloudsdk.util.SignatureSample;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;

/**
 * created by maolizhi at 03/14/2017
 * get Enterprise Nemos
 */
public class EnterpriseNemoApi {
    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrl = "/api/rest/external/v1/buffet/nemos";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * get enterprise all nemos(only nemo) acording to enterpriseId.
     *
     * @param enterpriseId
     * @param token
     * @return
     * @throws IOException
     */
    public Result<NemoDto[]> getEnterpriseNemos(String enterpriseId, String token) throws IOException {

        String surl = SDKConfigMgr.getServerHost() + prefixUrl + "?enterprise_id=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", null, NemoDto[].class);

    }

    /**
     * get enterprise pageable nemos(only nemo) acording to enterpriseId.
     *
     * @param enterpriseId
     * @param token
     * @return
     * @throws IOException
     */
    public Result<PageableNemoDto> getPageableEnterpriseNemos(String enterpriseId, String token, int page, int pageSize) throws IOException {
        String surl = SDKConfigMgr.getServerHost() + prefixUrl + "/page?enterpriseId=" + enterpriseId + "&pageIndex=" + page + "&pageSize=" + pageSize;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", null, PageableNemoDto.class);

    }

    /**
     * 修改小鱼终端名称
     *
     * @param enterpriseId
     * @param token
     * @param nemoNumber
     * @param displayName
     * @return
     * @throws IOException
     */
    public Result updateEnterpriseNemosName(String enterpriseId, String token, String nemoNumber, String displayName) throws IOException {
        String surl = SDKConfigMgr.getServerHost() + prefixUrl + "?enterpriseId=" + enterpriseId + "&nemoNumber=" + nemoNumber + "&displayName=" + displayName;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", null, null);
    }
}
