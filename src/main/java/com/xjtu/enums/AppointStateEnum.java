package com.xjtu.enums;

/**
 * Created by llh.xjtu on 17-4-23.
 * 使用枚举表达常量数据字典
 */
public enum  AppointStateEnum {
    SUCCESS(1, "预约成功"), NO_NUMBER(0, "库存不足"), REPEAT_APPOINT(-1, "重复预约"), INNER_ERROR(-2, "系统异常");

    private int state;

    private String stateInfo;

    AppointStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
    public static AppointStateEnum stateof(int index){
        for (AppointStateEnum stateEnum : values()) {
            return stateEnum;
        }
        return null;
    }
}
