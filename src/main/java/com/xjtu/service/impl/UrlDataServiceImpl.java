package com.xjtu.service.impl;

import com.xjtu.exception.VerificationException;
import com.xjtu.service.UrlDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * Created by llh.xjtu on 17-4-26.
 * 移植原项目，简单分离
 */
@Service
public class UrlDataServiceImpl implements UrlDataService {

   
    private HttpServletRequest request;

    public String m_head;
    public String m_cokie;



    @Override
    public void getClassSelImage(String param) {
        param = param.substring(param.lastIndexOf("src="));
        System.out.println(">>>>"+param);
        param = param.substring(param.indexOf("='")+2,param.indexOf("'>"));
        System.out.println(">>>>"+param);

        String u = "http://jwxt.cqtbi.edu.cn/ZNPK/"+param;
        String r = "http://jwxt.cqtbi.edu.cn/ZNPK/KBFB_ClassSel_rpt.aspx";
        _GetImage(m_cokie, u, r);
    }

    @Override
    public void getCookie() {

        //m_head = "http://jwgl.lnc.edu.cn";
        m_head = "http://jwxt.cqtbi.edu.cn";
        m_cokie = _GetCookie();
    }

    @Override
    public void getImage(int index) {

        String PostData[] = {"KBFB_LessonSel",	//�γ̿α�
                "TeacherKBFB",		//��ʦ�α�
                "KBFB_ClassSel",	//�����༶�α�
                "KBFB_RoomSel"		//���ҿα�
        };
        Date date = new Date();
        long times = date.getTime();
        String u = m_head+"/sys/ValidateCode.aspx?t="+times;
        String r = m_head+"/ZNPK/"+PostData[index]+".aspx";
        _GetImage(m_cokie, u, r);
    }

    @Override
    public String getKBFBRoomSel(String Sel_XNXQ, String rad_gs, String txt_yzm, String Sel_XQ, String Sel_JXL, String Sel_ROOM) {
        String param = "Sel_XNXQ="+Sel_XNXQ+"&rad_gs="+rad_gs+"&txt_yzm="+txt_yzm+"&Sel_XQ="+Sel_XQ+"&Sel_JXL="+Sel_JXL+"&Sel_ROOM="+Sel_ROOM;
        //System.out.println(param);
        String url = m_head+"/ZNPK/KBFB_RoomSel_rpt.aspx";
        String r = m_head+"/ZNPK/KBFB_RoomSel.aspx";
        return _PostFunction(m_cokie, url, r, param);
    }

    @Override
    public String getKBFBClassSel(String Sel_XNXQ, String txtxzbj, String Sel_XZBJ, String type, String txt_yzm) {
        String param = "Sel_XNXQ="+Sel_XNXQ+"&txtxzbj="+txtxzbj+"&Sel_XZBJ="+Sel_XZBJ+"&type="+type+"&txt_yzm="+txt_yzm;
        //System.out.println(param);
        String url = m_head+"/ZNPK/KBFB_ClassSel_rpt.aspx";
        String r = m_head+"/ZNPK/KBFB_ClassSel.aspx";
        return _PostFunction(m_cokie, url, r, param);
    }

    @Override
    public String getTeacherKBFB(String Sel_XNXQ, String Sel_JS, String type, String txt_yzm) {
        String param = "Sel_XNXQ="+Sel_XNXQ+"&Sel_JS="+Sel_JS+"&type="+type+"&txt_yzm="+txt_yzm;
        //System.out.println(param);
        String url = m_head+"/ZNPK/TeacherKBFB_rpt.aspx";
        String r = m_head+"/ZNPK/TeacherKBFB.aspx";
        return _PostFunction(m_cokie, url, r, param);
    }

    @Override
    public String getKBFBLessonSel(String Sel_XNXQ, String Sel_KC, String gs, String txt_yzm) {
        String param = "Sel_XNXQ="+Sel_XNXQ+"&Sel_KC="+Sel_KC+"&gs="+gs+"&txt_yzm="+txt_yzm;
        //System.out.println(param);
        String url = m_head+"/ZNPK/KBFB_LessonSel_rpt.aspx";
        String r = m_head+"/ZNPK/KBFB_LessonSel.aspx";
        return _PostFunction(m_cokie, url, r, param);
    }

    @Override
    public String getListJXL(String w, String id) {
        String param = "w="+w+"&id="+id;
        String url = m_head+"/ZNPK/Private/List_JXL.aspx?"+param;
        return _GetFunction(m_cokie, url);
    }

    @Override
    public String getListROOM(String w, String id) {
        String param = "w="+w+"&id="+id;
        String url = m_head+"/ZNPK/Private/List_ROOM.aspx?"+param;
        return _GetFunction(m_cokie, url);
    }

    @Override
    public String getListXZBJClassName(String xnxq, String xzbj) {
        Date date = new Date();
        long times = date.getTime();
        String param = "xnxq="+xnxq+"&xzbj="+xzbj+"&t="+times;
        String url = m_head+"/ZNPK/Private/List_XZBJ.aspx?"+param;
        return _GetFunction(m_cokie, url);
    }

    @Override
    public String getListXZBJTerm(String flag, String xnxq, String xzbj) {
        String param = "flag="+flag+"xnxq="+xnxq+"&xzbj="+xzbj;
        String url = m_head+"/ZNPK/Private/List_XZBJ.aspx?"+param;
        return _GetFunction(m_cokie, url);
    }

    @Override
    public String getTeacherList(String xnxq, String s) {
        String param = "xnxq="+xnxq+"&js="+s;
        String url = m_head+"/ZNPK/Private/List_JS.aspx?"+param;
        return _GetFunction(m_cokie, url);
    }

    @Override
    public String getXNXQKC(String xnxq, String kc) {
        String param = "xnxq="+xnxq+"&kc="+kc;
        String url = m_head+"/ZNPK/Private/List_XNXQKC.aspx?"+param;
        return _GetFunction(m_cokie, url);
    }

    @Override
    public String getSessionId() {
        return m_cokie;
    }

    private String _GetFunction(String cok, String u)
    {
        StringBuilder tmp = null;
        try {
            URL url = new URL(u);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Cookie", cok);
            InputStream in = conn.getInputStream();

            InputStreamReader fo = new InputStreamReader(in,"gbk");
            BufferedReader reader = new BufferedReader(fo);
            String context;
            tmp = new StringBuilder();
            while((context =reader.readLine()) != null)
            {
                tmp.append(context);
            }

            in.close();
            fo.close();
            reader.close();
            conn.disconnect();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return String.valueOf(tmp);
    }

    private String _PostFunction(String cok, String u, String r, String param)
    {
        StringBuilder tmp = null;
        try {
            URL url = new URL(u);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            conn.setRequestProperty("Referer", r);
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //conn.setRequestProperty("Host", m_head.substring(7,m_head.length()));
            //conn.setRequestProperty("Origin", m_head);
            conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
            conn.setRequestProperty("Cookie", cok);
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2914.3 Safari/537.36");
            conn.setRequestProperty("Cache-Control", "max-age=0");

            PrintWriter out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            out.close();

            InputStream in = conn.getInputStream();

            InputStreamReader fo = new InputStreamReader(in,"gbk");
            BufferedReader reader = new BufferedReader(fo);
            String context;
            tmp = new StringBuilder();
            while((context =reader.readLine()) != null)
            {
                tmp.append(context);
            }

            in.close();
            fo.close();
            reader.close();
            conn.disconnect();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        String resultString = String.valueOf(tmp);
        if(resultString.substring(35,40).equals("验证码错误")){
            throw new VerificationException("验证码错误");
        }

        return resultString;
    }

    private String _GetCookie()
    {
        String co  = new String();
        try {
            URL url = new URL(m_head);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //InputStream in = conn.getInputStream();
            //in.close();
            co = conn.getHeaderField("Set-Cookie");
            conn.disconnect();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        co = co.substring(0,co.indexOf(";"));
        System.out.println(co);
        return co;
    }

    private void _GetImage(String cok, String u, String r)
    {

        try {
            URL url = new URL(u);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Cookie", cok);
            conn.setRequestProperty("Referer", r);
            InputStream in = conn.getInputStream();
            //Bitmap bitmap = BitmapFactory.decodeStream(in);
            //得到服务器中保存文件的绝对路径



            String filePath = request.getSession().getServletContext().getRealPath("/") + "resources/"
                    + m_cokie+".jpg";
            File file = new File(filePath);



			/*if (!file.exists()) {
				file.createNewFile();
			}*/



            FileOutputStream fo = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int length = 0;
            while ((length = in.read(buf, 0, buf.length)) != -1) {
                fo.write(buf, 0, length);
            }
            fo.close();
            fo.close();
            conn.disconnect();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
