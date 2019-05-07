package com.ananwulian.xylinkcloudsdk.sdk.recordingControl;

import com.ananwulian.xylinkcloudsdk.config.SDKConfigMgr;
import com.ananwulian.xylinkcloudsdk.model.*;
import com.ananwulian.xylinkcloudsdk.util.HttpUtil;
import com.ananwulian.xylinkcloudsdk.util.Result;
import com.ananwulian.xylinkcloudsdk.util.SignatureSample;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * created by maolizhi at 03/14/2017
 */
public class RecordingControlApi {
    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrl = "/api/rest/external/v1/meeting/recording/";

    /**
     * start recording
     * @param enterpriseId
     * @param token
     * @param meetingRoomNumber
     * @return
     * @throws IOException
     */
    public Result startRecording(String enterpriseId, String token, String meetingRoomNumber) throws IOException{
        String surl = getPrefixUrl() + meetingRoomNumber + "/start?enterpriseId="+enterpriseId ;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null, null);
    }

    /**
     * stop recording
     * @param enterpriseId
     * @param token
     * @param meetingRoomNumber
     * @return
     * @throws IOException
     */
    public Result<RecordingResponse> stopRecording(String enterpriseId, String token, String meetingRoomNumber) throws IOException{
        String surl = getPrefixUrl() + meetingRoomNumber + "/stop?enterpriseId="+enterpriseId ;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null, RecordingResponse.class);
    }

    /**
     * stop recording with sessionId
     * @param enterpriseId
     * @param token
     * @param meetingRoomNumber
     * @return
     * @throws IOException
     */
    public Result<RecordingStopResponse> stopRecordingWithSessionId(String enterpriseId, String token, String meetingRoomNumber) throws IOException{
        String surl = getPrefixUrl() + meetingRoomNumber + "/stopWithSessionId?enterpriseId="+enterpriseId ;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null, RecordingStopResponse.class);
    }

    /**
     * get bytes which be saved in result's data.
     * @param enterpriseId
     * @param token
     * @param downLoadRestApi,RecordingResponse's property
     * @return
     * @throws IOException
     */
    public Result downLoadRecord(String enterpriseId, String token, String downLoadRestApi) throws IOException{
        String surl = downLoadRestApi + "?enterpriseId="+enterpriseId ;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getByteStreamResponse(surl,"GET", null);
    }

    /**
     * convert byte array to image or video
     * @param bytes
     * @param path, in fact,including path and file's name,for example,"/home/aa/myFile.mp4"
     */
    public  void convertByteArrayToImageOrVideo(byte[] bytes,String path){
        HttpUtil.convertByteArrayToImageOrVideo(bytes,path);
    }

    private String getPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrl;
    }
}
