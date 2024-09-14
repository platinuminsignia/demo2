package core;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

public class NeedLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map parameterMap = req.getParameterMap();
        parameterMap.forEach((k,v)->{
            System.out.println(String.format("key=%s, val=%s", k, v));
        });

        Enumeration names = req.getParameterNames();
        while(names.hasMoreElements()){
            String o = (String)names.nextElement();
            System.out.println(o+"="+req.getParameter(o));
        }

        JSONObject jsn = new JSONObject();
        jsn.put("code",-1);
        jsn.put("msg", "need login");
        jsn.put("user", req.getAttribute("user"));
        resp.getWriter().write(jsn.toJSONString());

//        resp.sendRedirect("");
    }
}
