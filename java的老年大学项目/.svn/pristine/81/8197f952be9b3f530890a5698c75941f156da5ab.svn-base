package com.learnyeai.servicebase;

import com.learnyeai.learnai.consts.AppR;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zpz on 2018/5/2.
 */
@RestController
public class MyErrorController implements ErrorController{
    private static final String ERROR_PATH = "/error";
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Error Attributes in the Application
     */
    @Autowired
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
    /*@RequestMapping(value = ERROR_PATH, produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request) {
        return new ModelAndView("greeting", getErrorAttributes(request, false));
    }*/

    @RequestMapping(value = ERROR_PATH)
    public Object error(HttpServletRequest request){
//        Map<String, Object> body = getErrorAttributes(request, getTraceParameter(request));
        int status = getStatus(request);

        Map rst = new HashMap();
        rst.put(AppR.RTN_CODE, status);
        rst.put(AppR.RTN_MSG, "请求失败");
        return rst;
    }
    private boolean getTraceParameter(HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        if (parameter == null) {
            return false;
        }
        return !"false".equals(parameter.toLowerCase());
    }
    /*private Map<String, Object> getErrorAttributes(HttpServletRequest request,
                                                   boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        Map<String, Object> map = this.errorAttributes.getErrorAttributes(requestAttributes,includeStackTrace);
        String URL = request.getRequestURL().toString();
        map.put("URL", URL);
        logger.debug("AppErrorController.method [error info]: status-" + map.get("status") +", request url-" + URL);
        return map;
    }*/

    private int getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode != null) {
            try {
                return statusCode;
            }
            catch (Exception ex) {
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR.value();
    }
}
