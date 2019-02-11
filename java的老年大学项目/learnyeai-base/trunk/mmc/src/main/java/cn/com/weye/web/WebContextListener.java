package cn.com.weye.web;

import cn.com.weye.cons.PtCons;
import cn.com.weye.cons.WeyeCons;
import cn.com.weye.core.consts.ConsTools;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

public class WebContextListener extends org.springframework.web.context.ContextLoaderListener {
	
	@Override
	public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
		try{

			ConsTools.addCons(PtCons.class);
			ConsTools.addCons(WeyeCons.class);
//			ResourceServerInit.init();
		}catch (Exception e){
			e.printStackTrace();
		}

		if (!SystemService.printKeyLoadMessage()){
			return null;
		}
		return super.initWebApplicationContext(servletContext);
	}
}
