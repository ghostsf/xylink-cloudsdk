package com.ananwulian.xylinkcloudsdk.model;

/**
 * Created by maolizhi on 12/15/16.
 */
public class LV extends LiveVideoWithStreamingUrls{
    private static final String VIEW_URL_TEMPLATE="http://www.ainemo.com/live/v/{liveId}";

    private String liveId;
    private String status;
    private String viewUrl;

    public String getLiveId() {
        return liveId;
    }

    public void setLiveId(String liveId)
    {
        this.liveId = liveId;

        viewUrl = VIEW_URL_TEMPLATE.replace("{liveId}",liveId);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getViewUrl() {
        return viewUrl;
    }

    @Override
    public String toString() {
        return "LV{" +
                "liveId='" + liveId + '\'' +
                ", status='" + status + '\'' +
                ", viewUrl='" + viewUrl + '\'' +
                '}';
    }
}
