package com.ananwulian.xylinkcloudsdk.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: gzm
 * Date: 2018-10-09
 */
public class MlayoutResquest {


    /**
     * auto : false
     * mode : 4x2
     */

    private String mode;
    private List<MlayoutDetailRequest> detail;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<MlayoutDetailRequest> getDetail() {
        return detail;
    }

    public void setDetail(List<MlayoutDetailRequest> detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "MlayoutResquest{" +
                ", mode='" + mode + '\'' +
                ", detail=" + detail +
                '}';
    }
}
