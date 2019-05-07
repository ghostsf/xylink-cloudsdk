package com.ananwulian.xylinkcloudsdk.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by maolizhi on 12/7/2016.
 */
public class Result<T> {

    private static Logger logger = LoggerFactory.getLogger(Result.class);

    private boolean success = true;

    /**
     * errorCode represents error code;default value is 200,OK,NOT ERROE
     */
    private int errorStatus = 200;
    /**
     * When success is true and errorStatus is 200, data represents correct data ,
     * if not,data reoresents error message,the tyoe of data is RestMessage .
     */
    private T data;

    public Result() {
    }

    public Result(boolean success, int errorStatus, T data) {
        this.success = success;

        this.errorStatus = errorStatus;

        this.data = data;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (IOException e) {
            logger.info("convert Result to Json String error!");
            logger.error("convert Result to Json String error!", e);
        }
        return null;
    }


    public boolean isSuccess() {
        return success;
    }

    public int getErrorStatus() {
        return errorStatus;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorStatus(int errorStatus) {
        this.errorStatus = errorStatus;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
