package com.ananwulian.xylinkcloudsdk.model;

public class ListData<T> {

    private T[] data;

    public ListData() {

    }

    public ListData(T[] data) {
        this.data = data;
    }

    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }
}
