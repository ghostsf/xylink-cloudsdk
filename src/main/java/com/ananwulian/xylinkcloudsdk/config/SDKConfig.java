package com.ananwulian.xylinkcloudsdk.config;

/**
 * Created by wenya on 17/9/11.
 */
public class SDKConfig {

    private String serverHost;

    private String wsServerHost;

    public String getWsServerHost() {
        return wsServerHost;
    }

    public void setWsServerHost(String wsServerHost) {
        this.wsServerHost = wsServerHost;
    }

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }
}
