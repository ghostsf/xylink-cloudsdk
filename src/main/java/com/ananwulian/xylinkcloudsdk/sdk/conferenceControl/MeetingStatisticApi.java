package com.ananwulian.xylinkcloudsdk.sdk.conferenceControl;

import com.ananwulian.xylinkcloudsdk.config.SDKConfigMgr;
import com.ananwulian.xylinkcloudsdk.model.ListData;
import com.ananwulian.xylinkcloudsdk.model.statis.SdkMeetingExportDto;
import com.ananwulian.xylinkcloudsdk.model.statis.SdkParticipantExportDto;
import com.ananwulian.xylinkcloudsdk.util.HttpUtil;
import com.ananwulian.xylinkcloudsdk.util.Result;
import com.ananwulian.xylinkcloudsdk.util.SignatureSample;

import java.io.IOException;
import java.util.List;

/**
 * Created by xinzhixuan on 2018-12-20.
 */
public class MeetingStatisticApi {

    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrl = "/api/rest/external/v1/meeting/statistic/";

    /**
     *  按会议时间导出会议详情
     *
     * @param enterpriseId .
     * @param token .
     * @param timeBegin 开始时间
     * @param timeEnd 结束时间
     * @return .
     * @throws IOException .
     */
    public Result<ListData<SdkMeetingExportDto>> getByTime(String enterpriseId, String token, long timeBegin, long timeEnd) throws IOException {
        String surl = getPrefixUrl() + "enterprise?enterpriseId=" + enterpriseId + "&timeBegin=" + timeBegin + "&timeEnd=" + timeEnd;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", "", ListData.class);
    }


    /**
     * 按参会者导出会议详情
     *
     * @param enterpriseId .
     * @param token .
     * @param timeBegin 开始时间
     * @param timeEnd 结束时间
     * @return .
     * @throws IOException .
     */
    public Result<ListData<SdkParticipantExportDto>> getByParticipant(String enterpriseId, String token, long timeBegin, long timeEnd) throws IOException {
        String surl = getPrefixUrl() + "participant?enterpriseId=" + enterpriseId + "&timeBegin=" + timeBegin + "&timeEnd=" + timeEnd;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", "", ListData.class);

    }

    private String getPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrl;
    }

}
