package cn.common.lib.security.service;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

/**
 * 支持自定义转发不同登录成功url，写cookie等操作
 * 生成登录同步登录论坛，同步登录系统系统的等服务端要执行的代码，有loginSuccess.jsp使用，而不是把服务端
 * 执行代码直接写在loginSuccess.jsp中
 * @author hbqian
 *
 */
public class UserSuccessHandler  extends SimpleUrlAuthenticationSuccessHandler{
	protected final Log logger = LogFactory.getLog(this.getClass());

    private RequestCache requestCache = new HttpSessionRequestCache();
    
    private Properties customTargetUrl;

    //@Autowired
    //private UserPhaseManager userPhaseManager;
   // @Autowired
    //private OrderformManager orderformManager;
    

/*    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
    	//参照
    	//org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                
        if(!userDetails.getAuthorities().isEmpty() && !customTargetUrl.isEmpty()){
        	Iterator iterator = customTargetUrl.keySet().iterator();
        	while(iterator.hasNext()){
        		String key = (String) iterator.next();
        		if(key.equals(userDetails.getUsername())){
	        		getRedirectStrategy().sendRedirect(request, response, customTargetUrl.getProperty(key));
	        		return;
        		}
        	}
        }
 

        if (StringUtils.hasText(request.getParameter(getTargetUrlParameter()))) {
            requestCache.removeRequest(request, response);
            super.onAuthenticationSuccess(request, response, authentication);

            return;
        }
    }*/
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
        //TenantDTO tenant = LocalTenantManager.getCurrentTenant(request);
/*        long tenantId = 0;
        if(tenant!=null)
        	tenantId = tenant.getId();*/
    	//System.out.println("jinlai");
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        //System.out.println("saved:"+savedRequest);
        //System.out.println("request:"+request);
        //System.out.println("response:"+response);
        //System.out.println("authentication:"+authentication);
        //Object tourl = request.getSession().getAttribute("curRequestUrl");
        //System.out.println("tourl:"+tourl);
        //UserDTO userDTO = UserUtils.getCurUser();
        //request.getSession().setAttribute("userDTO",userDTO);
        //if(tourl==null||tourl.toString().indexOf("index.action")>0){
        	//long userId = userDTO.getId();
        	//System.out.println("id"+userId);
        	
//        	System.out.println("have"+userPhaseManager.haveTeachPlanThisYear(userId, tenantId));
//        	System.out.println("have"+orderformManager.haveWaitOrder(userId));
//        	if(userPhaseManager.haveTeachPlanThisYear(userId, tenantId)){
//        		/*if(orderformManager.haveWaitOrder(userId)){
//        			response.sendRedirect(RequestUtils.getWebURL(request)+"/user/portal!waitorder.action");
//        		}else{
//        			response.sendRedirect(RequestUtils.getWebURL(request)+"/user/portal.action");
//        		}*/
//        		//response.sendRedirect("/traincore-webapp/user/portal.action");
//        		response.sendRedirect(RequestUtils.getWebURL(request)+"/index.action");
//        	}
        //}
        if (savedRequest == null) {
            super.onAuthenticationSuccess(request, response, authentication);

            return;
        }

        if (isAlwaysUseDefaultTargetUrl() || StringUtils.hasText(request.getParameter(getTargetUrlParameter()))) {
            requestCache.removeRequest(request, response);
            super.onAuthenticationSuccess(request, response, authentication);

            return;
        }

        clearAuthenticationAttributes(request);

        // Use the DefaultSavedRequest URL
        String targetUrl = savedRequest.getRedirectUrl();
        logger.debug("Redirecting to DefaultSavedRequest Url: " + targetUrl);
        //System.out.println("targetUrl"+targetUrl);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }

	public Properties getCustomTargetUrl() {
		return customTargetUrl;
	}

	public void setCustomTargetUrl(Properties customTargetUrl) {
		this.customTargetUrl = customTargetUrl;
	}
}
