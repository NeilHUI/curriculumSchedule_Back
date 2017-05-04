package com.xjtu.enums;

/**
 * Created by llh.xjtu on 17-4-25.
 * 课程列表常量类型
 */
public enum ListInfoStateEnum {

    COURSE_TYPE(1, "课程信息列表"), TEACHER_TYPE(2, "教师信息列表"),CLASS_TYPE(3, "教室信息列表"),OPTIONAL_TYPE(4, "任选课表信息列表");

    private int state;

    private String stateInfo;

    ListInfoStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ListInfoStateEnum stateof(int index){
        for (ListInfoStateEnum stateEnum : values()) {
            return stateEnum;
        }
        return null;
    }
}
