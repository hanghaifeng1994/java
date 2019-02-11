package cn.com.weye.ares.web;

import cn.com.weye.core.utils.ParamCover;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zpz on 2016/2/15.
 */
public class MyDispacherServlet extends DispatcherServlet {
    @Override
    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("paramCover", new ParamCover(request));
        super.doDispatch(request, response);
    }
}
