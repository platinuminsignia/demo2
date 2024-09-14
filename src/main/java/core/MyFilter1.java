package core;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String noFilter = filterConfig.getInitParameter("noFilter");
        System.out.println("---- myfilter.init  noFilter="+ noFilter);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        System.out.println("------ MyFilter1.doFilter:"+req.getRequestURI());
        if(req.getRequestURI().startsWith("/public")){
            chain.doFilter(request, response);
        }else{
//            请求对象 在filter和servlet跨越, 该作用域下的request内的数据可以共享
            request.setAttribute("user","anonymous");

//            请求转发: 则 当前servlet不可以设置响应体, 但可以设置响应头
//            request.getRequestDispatcher("/needLogin").forward(request, response);

//            请求包含: 则 当前servlet可以设置响应体
            resp.getWriter().write("xxxxx");
            request.getRequestDispatcher("/needLogin").include(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
