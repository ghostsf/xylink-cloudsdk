package com.ananwulian.xylinkcloudsdk.model.callback;


public class RosterCallback {

    private String confNumber;
    private CallbackEvent callbackEvent;
    private String handlerUrl;

    public String getConfNumber() {
        return confNumber;
    }

    public void setConfNumber(String confNumber) {
        this.confNumber = confNumber;
    }

    public RosterCallback() {

    }

    public RosterCallback(String confNumber, CallbackEvent event, String handlerUrl) {
        this.confNumber = confNumber;
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
                "confNumber=" + confNumber +
                "callbackEvent=" + callbackEvent +
                ", handlerUrl='" + handlerUrl + '\'' +
                '}';
    }
}
