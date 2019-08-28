package com.ananwulian.xylinkcloudsdk.sdk.vod;

import com.ananwulian.xylinkcloudsdk.config.SDKConfigMgr;
import com.ananwulian.xylinkcloudsdk.model.VodInfo;
import com.ananwulian.xylinkcloudsdk.util.HttpUtil;
import com.ananwulian.xylinkcloudsdk.util.Result;
import com.ananwulian.xylinkcloudsdk.util.SignatureSample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;


/**
 * Created by maolizhi on 12/18/2016.
 */
public class VodApi {
    private static Logger logger = LoggerFactory.getLogger(VodApi.class);

    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrl = "/api/rest/external/v1/";

    /**
     * get all videos int the day,startTime is greater than 0,startTime is less than endTime,
     * endTime-startTime is less than the millisecond number of one day.
     * @param enterpriseId
     * @param token
     * @param startTime
     * @param endTime
     * @return
     * @throws IOException
     */
    public Result<VodInfo[]> getVods(String enterpriseId, String token,long startTime,long endTime)throws IOException{
        String surl = getPrefixUrl()  + "vods?enterpriseId=" + enterpriseId + "&startTime=" + startTime + "&endTime="
                + endTime;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null,VodInfo[].class);
    }

    /**
     * get the nemo's all videos, if startTime is less than or equal to 0,return the nemo's all videos,ignore endTime;
     * if startTime is greater than 0 ,the endTime must be bigger than the startTime;there is no other limits for
     * startTime and endTime
     * @param enterpriseId
     * @param token
     * @param nemoNumber
     * @param startTime
     * @param endTime
     * @return
     * @throws IOException
     */
    public Result<VodInfo[]> getNemoVods(String enterpriseId, String token,String nemoNumber,long startTime,
                              long endTime)throws IOException{
        String surl = getPrefixUrl()  + "nemo/"+nemoNumber+"/vods?enterpriseId=" + enterpriseId +
                "&startTime="+startTime+"&endTime="+endTime;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null,VodInfo[].class);
    }

    /**
     * get all videos for the meeting room during the time ,the time limits is same as the method of
     * getNemoVods
     * @param enterpriseId
     * @param token
     * @param meetingRoomNumber
     * @param startTime
     * @param endTime
     * @return
     * @throws IOException
     */
    public Result<VodInfo[]> getMeetingRoomVods(String enterpriseId, String token,String meetingRoomNumber,Long startTime,
                              Long endTime)throws IOException{
        String surl = getPrefixUrl()  + "meetingroom/" + meetingRoomNumber + "/vods?enterpriseId=" + enterpriseId;
        if (startTime != null) {
            surl += "&startTime="+startTime;
        }
        if (endTime != null) {
            surl += "&endTime="+endTime;
        }
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null,VodInfo[].class);
    }

    /**
     * get video default thumbnail according to video id,
     * if success,the data type of result is byte[]; if failed ,the data type of result is
     * RestMessage. If success,you can convert the byte[] to image file.
     * @param enterpriseId
     * @param token
     * @param vodId
     * @return
     * @throws IOException
     */
    public Result getVodThumbnail(String enterpriseId, String token,String vodId)throws IOException{
        String surl = getPrefixUrl()  + "vods/"+ vodId+ "/thumbnail?enterpriseId=" + enterpriseId ;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getByteStreamResponse(surl,"GET", null);
    }

    /**
     * convert byte array to image or video
     * @param bytes
     * @param path
     */
    public void convertByteArrayToImageOrVideo(byte[] bytes,String path){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            fos.write(bytes);
        } catch (FileNotFoundException e) {
            logger.error("File Path not found!",e);
        } catch (IOException e) {
            logger.error("Convert byte array to image,IO Errot!",e);
        }

    }

    /**
     * download the video according to video id
     * if success,the data type of result is byte[]; if failed ,the data type of result is
     * RestMessage. If success,you can call  convertByteArrayToImageOrVideo(byte[] bytes,String path)
     * convert the byte[] to video file.
     * @param enterpriseId
     * @param token
     * @param vodId
     * @return
     * @throws IOException
     * @deprecated
     */
    public Result videoDownload(String enterpriseId, String token,String vodId)throws IOException{
        String surl = getPrefixUrl()  + "vods/"+ vodId+ "/download?enterpriseId=" + enterpriseId ;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getByteStreamResponse(surl,"GET", null);
    }

    /**
     * delete the video according to video id
     * @param enterpriseId
     * @param token
     * @param vodId
     * @return
     * @throws IOException
     */
    public  Result deleteVideo(String enterpriseId, String token,String vodId)throws IOException{
        String surl = getPrefixUrl()  + "vods/"+ vodId+ "?enterpriseId=" + enterpriseId ;
        String signature = signatureSample.computeSignature("","DELETE",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"DELETE", null,null);
    }

    /**
     * delete the video according to conference number
     * @param enterpriseId .
     * @param token .
     * @param meetingRoomNumber .
     * @return .
     * @throws IOException .
     */
    public  Result deleteMeetingRoomVods(String enterpriseId, String token, String meetingRoomNumber)throws IOException{
        String surl = getPrefixUrl()  + "meetingroom/" + meetingRoomNumber + "/vods?enterpriseId=" + enterpriseId ;
        String signature = signatureSample.computeSignature("","DELETE",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"DELETE", null,null);
    }

    /**
     * get the download url for the video according to video id
     * @param enterpriseId
     * @param token
     * @param vodId
     * @return
     * @throws IOException
     */
    public Result getDownloadurl(String enterpriseId, String token, String vodId)throws IOException{
        String surl = getPrefixUrl()  + "vods/"+ vodId+ "/getdownloadurl?enterpriseId=" + enterpriseId ;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null, Map.class);
    }

    /**
     * get the download url for the video according to session id
     * @param enterpriseId
     * @param token
     * @param sessionId
     * @return
     * @throws IOException
     */
    public Result getDownloadurlBySessionId(String enterpriseId, String token, String sessionId)throws IOException{
        String surl = getPrefixUrl()  + "vods/session/"+ sessionId+ "/downloadurl?enterpriseId=" + enterpriseId ;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null, Map.class);
    }

    /**
     * 获取视频的播放链接
     * getPlayUrl
     * @param enterpriseId
     * @param token
     * @param vodId
     * @return
     * @throws IOException
     */
    public Result getPlayUrl(String enterpriseId, String token,String vodId)throws IOException{
        String surl = getPrefixUrl()  + "vods/"+ vodId+ "/sharedInfo?enterpriseId=" + enterpriseId ;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null, Map.class);
    }

    private String getPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrl;
    }
}
