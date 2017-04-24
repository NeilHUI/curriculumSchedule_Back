package com.xjtu.entity;

/**
 * Created by llh.xjtu on 17-4-24.
 * 任选课表类
 */
public class ClassInfoA {

    private String classId; //序号

    private String className; //课程

    private String classCount; //学分

    private String classTeacher; //任课老师

    private String classWeek; //周次

    private String classNum; //上课班号

    private String classPerson; //上课人数

    private String classTime; //时间

    private String classRoom; //上课地点



    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        if(classTeacher.length()==0){
            this.classTeacher="同上";
        }else
            this.classTeacher = classTeacher;
    }

    public String getClassWeek() {
        return classWeek;
    }

    public void setClassWeek(String classWeek) {
        if(classWeek.length()==0){
            this.classWeek="同上";
        }else
            this.classWeek = classWeek;
    }



    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        if(className.length()==0){
            this.className="同上";
        }else
            this.className = className;
    }

    public String getClassCount() {

        return classCount;
    }

    public void setClassCount(String classCount) {
        if (classCount.length()==0){
            this.classCount="同上";
        }else
            this.classCount = classCount;
    }




    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        if(classNum.length()==0){
            this.classNum="同上";
        }else
            this.classNum = classNum;
    }



    public String getClassPerson() {
        return classPerson;
    }

    public void setClassPerson(String classPerson) {
        if(classPerson.length()==0){
            this.classPerson="同上";
        }else
            this.classPerson = classPerson;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        if(classTime.length()==0){
            this.classTime="同上";
        }else
            this.classTime = classTime;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        if(classRoom.length()==0){
            this.classRoom="同上";
        }else
            this.classRoom = classRoom;
    }


    @Override
    public String toString() {
        return "ClassInfoA{" +
                "classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                ", classCount='" + classCount + '\'' +
                ", classTeacher='" + classTeacher + '\'' +
                ", classWeek='" + classWeek + '\'' +
                ", classNum='" + classNum + '\'' +
                ", classPerson='" + classPerson + '\'' +
                ", classTime='" + classTime + '\'' +
                ", classRoom='" + classRoom + '\'' +
                '}';
    }
}
