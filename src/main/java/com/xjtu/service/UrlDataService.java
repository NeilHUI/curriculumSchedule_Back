package com.xjtu.service;

/**
 * Created by llh.xjtu on 17-4-26.
 * 访问网络获取数据
 */
public interface UrlDataService {

    void getClassSelImage(String param);


    /**
     * 获取cookie
     */
    void getCookie();


    /**
     * 获得验证码
     *
     * @param index
     */
    void getImage(int index);


    /**
     * 通过教室查询
     *
     * @param Sel_XNXQ
     * @param rad_gs
     * @param txt_yzm  验证码
     * @param Sel_XQ
     * @param Sel_JXL
     * @param Sel_ROOM
     * @return
     */
    String getKBFBRoomSel(String Sel_XNXQ, String rad_gs, String txt_yzm, String Sel_XQ, String Sel_JXL, String Sel_ROOM);

    /**
     * 通过班级查询
     *
     * @param Sel_XNXQ
     * @param txtxzbj
     * @param Sel_XZBJ
     * @param type
     * @param txt_yzm
     * @return
     */
    String getKBFBClassSel(String Sel_XNXQ, String txtxzbj, String Sel_XZBJ, String type, String txt_yzm);


    /**
     * 通过老师查询
     *
     * @param Sel_XNXQ
     * @param Sel_JS
     * @param type
     * @param txt_yzm
     * @return
     */
    String getTeacherKBFB(String Sel_XNXQ, String Sel_JS, String type, String txt_yzm);


    /**
     * 通过课程查询
     *
     * @param Sel_XNXQ
     * @param Sel_KC
     * @param gs
     * @param txt_yzm
     * @return
     */
    String getKBFBLessonSel(String Sel_XNXQ, String Sel_KC, String gs, String txt_yzm);


    /**
     * 获取课程
     *
     * @param w  defalut w=150
     * @param id
     * @return
     */
    String getListJXL(String w, String id);


    /**
     * @param w  defalut w=150
     * @param id
     * @return
     */
    String getListROOM(String w, String id);


    /**
     * 行政班级课表
     *
     * @param xnxq
     * @param xzbj
     * @return
     */
    String getListXZBJClassName(String xnxq, String xzbj);

    /**
     * @param flag //defalut flag=1
     * @param xnxq
     * @param xzbj
     * @return
     */
    String getListXZBJTerm(String flag, String xnxq, String xzbj);


    /**
     * 教师课表
     *
     * @param xnxq
     * @param s
     * @return
     */
    String getTeacherList(String xnxq, String s);

    /**
     * 课程课表
     *
     * @param xnxq
     * @param kc
     * @return
     */
    String getXNXQKC(String xnxq, String kc);

    /**
     * 获得sessionID
     * @return
     */
    String getSessionId();


}
