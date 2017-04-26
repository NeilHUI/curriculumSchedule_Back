package com.xjtu.service.impl;

import com.xjtu.entity.ClassInfoA;
import com.xjtu.entity.ClassInfoByCourse;
import com.xjtu.entity.ClassInfoC;
import com.xjtu.service.HtmlParseJsonService;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Created by llh.xjtu on 17-4-26.
 * 移植原项目，简单分离
 */
@Service
public class HtmlParseJsonServiceImpl implements HtmlParseJsonService{
    @Override
    public JSONObject getClassInfo1(String fileName) {
        //        File file = new File(fileName);
        Document dInfo = Jsoup.parse(fileName);
        Elements eInfo = dInfo.select("table").select("tr");
        ArrayList<ClassInfoC> list = new ArrayList<ClassInfoC>();
        for (int i = 5; i < eInfo.size(); i++) {
            Elements eInfo1 = eInfo.get(i).select("td");
            if (eInfo1.text().toString().equals("注1：")) {
                break;
            }
            if (eInfo1.size() == 9) {
                for (int j = 2; j < eInfo1.size(); j++) {
                    if (eInfo1.get(j).text().length() != 0) {
                        ClassInfoC classInfo1 = new ClassInfoC();
                        classInfo1.setWeek(String.valueOf(j - 1));
                        classInfo1.setLesson(String.valueOf(i - 4));
                        classInfo1.setInfo(eInfo1.get(j).text());
                        list.add(classInfo1);
                    }
                }
            } else {
                for (int j = 1; j < eInfo1.size(); j++) {
                    if (eInfo1.get(j).text().length() != 0) {
                        ClassInfoC classInfo1 = new ClassInfoC();
                        classInfo1.setWeek(String.valueOf(j));
                        classInfo1.setLesson(String.valueOf(i - 4));
                        classInfo1.setInfo(eInfo1.get(j).text());
                        list.add(classInfo1);
                    }
                }
            }
        }
        Collections.sort(list);
        /*Iterator<ClassInfo1> it=list.iterator();
        while (it.hasNext()){
            ClassInfo1 classInfo1=new ClassInfo1();
            classInfo1=it.next();
            System.out.println(classInfo1.getInfo()+"----课程："+classInfo1.getLesson()+"----星期："+classInfo1.getWeek());
        }*/

        //获取部门，教师，性别，职称
        String infoTitle;
        if (eInfo.size() >= 3) {
            infoTitle = eInfo.get(3).select("td").text();
        } else {
            infoTitle = eInfo.get(0).select("td").text();
        }

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(infoTitle, list);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //System.out.println(jsonObject.toString());
        return jsonObject;
    }

    @Override
    public List<ClassInfoByCourse> getClassInfo2(String fileName) {
        //        File file = new File(fileName);
//        Document dInfo = Jsoup.parse(file, "UTF-8");


        Document dInfo = Jsoup.parse(fileName);
        Elements eInfo = dInfo.select("table").select("tr");
        ArrayList<ClassInfoByCourse> list = new ArrayList<ClassInfoByCourse>();
        for (int i = 5; i < eInfo.size(); i++) {
            Elements eInfo1 = eInfo.get(i).select("td");
            if (eInfo1.text().toString().equals("注1：")) {
                break;
            }
            if (eInfo1.size() == 9) {
                for (int j = 2; j < eInfo1.size(); j++) {
                    if (eInfo1.get(j).text().length() != 0) {
                        ClassInfoByCourse classInfo1 = new ClassInfoByCourse();
                        classInfo1.setWeek(String.valueOf(j - 1));
                        classInfo1.setLesson(String.valueOf(i - 4));
                        classInfo1.setInfo(eInfo1.get(j).text());
                        list.add(classInfo1);
                    }
                }
            } else {
                for (int j = 1; j < eInfo1.size(); j++) {
                    if (eInfo1.get(j).text().length() != 0) {
                        ClassInfoByCourse classInfo1 = new ClassInfoByCourse();
                        classInfo1.setWeek(String.valueOf(j));
                        classInfo1.setLesson(String.valueOf(i - 4));
                        classInfo1.setInfo(eInfo1.get(j).text());
                        list.add(classInfo1);
                    }
                }
            }
        }
        Collections.sort(list);
        /*Iterator<ClassInfo1> it=list.iterator();
        while (it.hasNext()){
            ClassInfo1 classInfo1=new ClassInfo1();
            classInfo1=it.next();
            System.out.println(classInfo1.getInfo()+"----课程："+classInfo1.getLesson()+"----星期："+classInfo1.getWeek());
        }*/

        /*//获取部门，教师，性别，职称
        String infoTitle = "";
        try {
            infoTitle = eInfo.get(3).select("td").text();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(infoTitle, list);
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        //System.out.println(jsonObject.toString());
        return list;
    }

    @Override
    public JSONObject getClassInfo3(String fileName) {
        //        File file = new File(fileName);
//        Document dInfo = Jsoup.parse(file, "UTF-8");
        Document dInfo = Jsoup.parse(fileName);
        Elements eInfo = dInfo.select("table").select("tr");
        ArrayList<ClassInfoC> list = new ArrayList<ClassInfoC>();
        for (int i = 5; i < eInfo.size(); i++) {
            Elements eInfo1 = eInfo.get(i).select("td");
            if (eInfo1.text().toString().equals("注1：")) {
                break;
            }
            if (eInfo1.size() == 9) {
                for (int j = 2; j < eInfo1.size(); j++) {
                    if (eInfo1.get(j).text().length() != 0) {
                        ClassInfoC classInfo1 = new ClassInfoC();
                        classInfo1.setWeek(String.valueOf(j - 1));
                        classInfo1.setLesson(String.valueOf(i - 4));
                        classInfo1.setInfo(eInfo1.get(j).text());
                        list.add(classInfo1);
                    }
                }
            } else {
                for (int j = 1; j < eInfo1.size(); j++) {
                    if (eInfo1.get(j).text().length() != 0) {
                        ClassInfoC classInfo1 = new ClassInfoC();
                        classInfo1.setWeek(String.valueOf(j));
                        classInfo1.setLesson(String.valueOf(i - 4));
                        classInfo1.setInfo(eInfo1.get(j).text());
                        list.add(classInfo1);
                    }
                }
            }
        }
        Collections.sort(list);
        /*Iterator<ClassInfo1> it=list.iterator();
        while (it.hasNext()){
            ClassInfo1 classInfo1=new ClassInfo1();
            classInfo1=it.next();
            System.out.println(classInfo1.getInfo()+"----课程："+classInfo1.getLesson()+"----星期："+classInfo1.getWeek());
        }*/

        //获取部门，教师，性别，职称
        String infoTitle = "";
        try {
            infoTitle = eInfo.get(3).select("td").text();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(infoTitle, list);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //System.out.println(jsonObject.toString());
        return jsonObject;
    }

    @Override
    public JSONObject getClassInfo4(String fileName) {
        //        File file = new File(fileName);
//        Document dInfo = Jsoup.parse(file, "UTF-8");
        Document dInfo = Jsoup.parse(fileName);
        Elements eInfo = dInfo.select("table").select("tr");
        ArrayList<ClassInfoA> list = new ArrayList<ClassInfoA>();
        for (int i = 5; i < eInfo.size(); i++) {
            Elements eInfo1 = eInfo.get(i).select("td");
            ClassInfoA classInfo = new ClassInfoA();
            classInfo.setClassId(eInfo1.get(0).text());
            classInfo.setClassName(eInfo1.get(1).text());
            classInfo.setClassCount(eInfo1.get(2).text());
            classInfo.setClassTeacher(eInfo1.get(3).text());
            classInfo.setClassNum(eInfo1.get(4).text());
            classInfo.setClassPerson(eInfo1.get(5).text());
            classInfo.setClassWeek(eInfo1.get(6).text());
            classInfo.setClassTime(eInfo1.get(7).text());
            classInfo.setClassRoom(eInfo1.get(8).text());
            list.add(classInfo);
        }

        /*Iterator<ClassInfo1> it=list.iterator();
        while (it.hasNext()){
            ClassInfo1 classInfo1=new ClassInfo1();
            classInfo1=it.next();
            System.out.println(classInfo1.getInfo()+"----课程："+classInfo1.getLesson()+"----星期："+classInfo1.getWeek());
        }*/

        //获取部门，教师，性别，职称
        String infoTitle = "";
        try {
            infoTitle = eInfo.get(3).select("td").text();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(infoTitle, list);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //System.out.println(jsonObject.toString());
        return jsonObject;
    }

    @Override
    public Map<String, String> optiontoList(String html) {
        Document dname = Jsoup.parse(html);
        Elements script = dname.select("script");
        Document dname1 = Jsoup.parse(script.toString());
        String data = dname1.data();
        Document dname2 = Jsoup.parse(data);
        //System.out.println(dname2.toString());
        Elements script1 = dname2.getElementsByTag("option");
        Map<String, String> map = new HashMap<String, String>();
        //将信息存入map中
        for (Element el : script1) {
            map.put(el.attr("value"), el.text());
        }
        return map;
    }
}
