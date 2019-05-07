package com.ananwulian.xylinkcloudsdk.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: gzm
 * Date: 2018-10-09
 */
public class MlayoutDetailRequest {

    /**
     * layout : [0.75,0.125,0.25,0.25]
     * pollingInterval : 0
     * sequence : 1
     */

    private List<MlayoutDetailItemsRequest> items;


    public List<MlayoutDetailItemsRequest> getItems() {
        return items;
    }

    public void setItems(List<MlayoutDetailItemsRequest> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "MlayoutDetailRequest{" +
                ", items=" + items +
                '}';
    }
}
