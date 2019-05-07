package com.ananwulian.xylinkcloudsdk.model;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: gzm
 * Date: 2018-10-20
 */
public class LiveLayoutRequest {
    private LiveContentLayoutType contentLayout;
    private LivePeopleLayoutType peopleLayoutType;
    private long mainImageId;
    private int mainImageType;

    public LiveLayoutRequest() {
    }

    public LiveContentLayoutType getContentLayout() {
        return contentLayout;
    }

    public void setContentLayout(LiveContentLayoutType contentLayout) {
        this.contentLayout = contentLayout;
    }

    public LivePeopleLayoutType getPeopleLayoutType() {
        return peopleLayoutType;
    }

    public void setPeopleLayoutType(LivePeopleLayoutType peopleLayoutType) {
        this.peopleLayoutType = peopleLayoutType;
    }

    public long getMainImageId() {
        return mainImageId;
    }

    public void setMainImageId(long mainImageId) {
        this.mainImageId = mainImageId;
    }

    public int getMainImageType() {
        return mainImageType;
    }

    public void setMainImageType(int mainImageType) {
        this.mainImageType = mainImageType;
    }

    @Override
    public String toString() {
        return "LiveLayoutRequest{" +
                "contentLayout=" + contentLayout +
                ", peopleLayoutType=" + peopleLayoutType +
                ", mainImageId=" + mainImageId +
                ", mainImageType=" + mainImageType +
                '}';
    }
}
