package com.learnyeai;

import com.learnyeai.lucene.utils.LuceneManagerUtils;
import com.learnyeai.servicebase.SpringDispatcherServlet;
import com.learnyeai.learnai.consts.PtCons;
import com.learnyeai.learnai.session.SessionListener;
import com.learnyeai.learnai.session.util.SessionManagerUtils;
import com.learnyeai.base.api.util.BaseCons;
import com.learnyeai.core.consts.ConsTools;
import com.learnyeai.core.utils.SpringContextUtils;
import com.learnyeai.common.utils.WeyeCons;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zpz on 2018/4/10.
 */
@Component
public class MySpringDispatcherServlet extends SpringDispatcherServlet {
    @Override
    protected void myIni() {
        ConsTools.addCons(BaseCons.class, PtCons.class, WeyeCons.class);

        // session添加监听器。
        Map<String, SessionListener> bb = SpringContextUtils.getApplicationContext().getBeansOfType(SessionListener.class);
        for(Iterator<SessionListener> it = bb.values().iterator(); it.hasNext();){
            SessionManagerUtils.resigerListener(it.next());
        }
    }
    @Override
    protected void myDoBefore(HttpServletRequest request, HttpServletResponse response) {
        try{
            /*Session session = ThreadContextUtil.getSessionRequired();
            session.setUserId("1");
            session.setAttribute(SessR.CUST_LGN, "thinkgem");*/

        }catch (Exception e){

        }
    }

    @Override
    protected void myDoAfter(HttpServletRequest request, HttpServletResponse response) {
        LuceneManagerUtils.close();
    }
}
