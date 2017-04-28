package com.xjtu.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by llh.xjtu on 17-4-26.
 * 下拉列表返回类
 */
public class ListResult {

    private String ListName;

    private String ListValue;

    public ListResult() {
    }

    public ListResult(String listName, String listValue) {
        ListName = listName;
        ListValue = listValue;
    }

    public String getListName() {
        return ListName;
    }

    public void setListName(String listName) {
        ListName = listName;
    }

    public String getListValue() {
        return ListValue;
    }

    public void setListValue(String listValue) {
        ListValue = listValue;
    }

}
