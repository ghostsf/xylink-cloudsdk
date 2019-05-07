package com.ananwulian.xylinkcloudsdk.model.callback;

import com.ananwulian.xylinkcloudsdk.model.callback.CallbackEvent;

/**
 * Created by wenya on 16/4/9.
 */
public class ExternalCallback {

    private CallbackEvent callbackEvent;
    private String handlerUrl;

    public ExternalCallback() {

    }

    public ExternalCallback(CallbackEvent event, String handlerUrl) {
        this.callbackEvent = event;
        this.handlerUrl = handlerUrl;
    }

    public CallbackEvent getCallbackEvent() {
        return callbackEvent;
    }

    public void setCallbackEvent(CallbackEvent callbackEvent) {
        this.callbackEvent = callbackEvent;
    }

    public String getHandlerUrl() {
        return handlerUrl;
    }

    public void setHandlerUrl(String handlerUrl) {
        this.handlerUrl = handlerUrl;
    }

    @Override
    public String toString() {
        return "ExternalCallback{" +
                "callbackEvent=" + callbackEvent +
                ", handlerUrl='" + handlerUrl + '\'' +
                '}';
    }
}
