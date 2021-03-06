package com.learnyeai;

import com.learnyeai.learnai.consts.PtCons;
import com.learnyeai.learnai.consts.SessR;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.session.Session;
import com.learnyeai.learnai.session.SessionListener;
import com.learnyeai.learnai.session.util.SessionManagerUtils;
import com.learnyeai.core.consts.ConsTools;
import com.learnyeai.core.utils.SpringContextUtils;
import com.learnyeai.servicebase.SpringDispatcherServlet;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zpz on 2018/4/10.
 */
@Component
public class MySpringDispatcherServlet extends SpringDispatcherServlet {
    @Override
    protected void myIni() {

        // session添加监听器。
        Map<String, SessionListener> bb = SpringContextUtils.getApplicationContext().getBeansOfType(SessionListener.class);
        for(Iterator<SessionListener> it = bb.values().iterator(); it.hasNext();){
            SessionManagerUtils.resigerListener(it.next());
        }
    }

    @Override
    protected void myDoBefore(HttpServletRequest request, HttpServletResponse response) {
        try{
            Session session = ThreadContextUtil.getSessionRequired();
            session.setUserId("1");
            session.setAttribute(SessR.CUST_LGN, "thinkgem");
            Map<String,Object> map=new HashMap<>();
            map.put("mchtId","1");
            map.put("mchtSchmId","1");
            session.setAttribute("userInfo",map);
            
        }catch (Exception e){

        }
    }
}
