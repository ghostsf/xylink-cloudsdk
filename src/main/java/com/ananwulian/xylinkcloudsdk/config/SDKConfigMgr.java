package com.ananwulian.xylinkcloudsdk.config;

import com.ananwulian.xylinkcloudsdk.util.SslUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wenya on 17/9/11.
 */
public class SDKConfigMgr {

    private static final String CONFIG_FILE = "/com/ananwulian/xylinkcloudsdk/config/config.json";

    private static String DEFAULT_SERVER_HOST = "https://sdk.xylink.com";

    private static String DEFAULT_WS_SERVER_HOST = "wss://sdk.xylink.com";

    private static SDKConfig sdkConfig;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        sdkConfig = loadConfigs();
        if(sdkConfig == null) {
            sdkConfig = new SDKConfig();
            sdkConfig.setServerHost(DEFAULT_SERVER_HOST);
            sdkConfig.setWsServerHost(DEFAULT_WS_SERVER_HOST);
        }
    }

    public static String getServerHost() {
        return sdkConfig.getServerHost();
    }

    public static String getWsServerHost() {
        return sdkConfig.getWsServerHost();
    }

    public static void setServerHost(String host) {
        if(host == null || host.trim().isEmpty()) {
            throw new IllegalArgumentException("host cannot be empty.");
        }
        if(!DEFAULT_SERVER_HOST.equals(host.toLowerCase().trim())) {
            try {
                SslUtils.ignoreSsl();
            } catch (Exception e) {
                throw new IllegalArgumentException("Failed to ignore ssl cert.", e);
            }
        }
        sdkConfig.setServerHost(host);
    }

    private static SDKConfig loadConfigs() {
        try {
            InputStream inputStream = SDKConfigMgr.class.getResourceAsStream(CONFIG_FILE);
            if(inputStream == null){
                return null;
            }
            SDKConfig sdkConfig = objectMapper.readValue(inputStream, SDKConfig.class);
            return sdkConfig;
        } catch (IOException e) {
            return new SDKConfig();
        }
    }
}
