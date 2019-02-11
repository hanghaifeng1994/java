package cn.com.weye.modules.cfg.web;

import cn.com.weye.modules.cfg.entity.CfgFunction;

import java.util.List;

/**
 * Created by zpz on 2018/1/29.
 */
public class CfgFunctionUtils {
    public static void sortList(List<CfgFunction> list, List<CfgFunction> sourcelist, String parentId, boolean cascade){
        for (int i=0; i<sourcelist.size(); i++){
            CfgFunction e = sourcelist.get(i);
            if (e.getParentId()!=null
                    && e.getParentId().equals(parentId)){
                list.add(e);
                if (cascade){
                    // 判断是否还有子节点, 有则继续获取子节点
                    for (int j=0; j<sourcelist.size(); j++){
                        CfgFunction child = sourcelist.get(j);
                        if (child.getParentId()!=null
                                && child.getParentId().equals(e.getFuncId())){
                            sortList(list, sourcelist, e.getFuncId(), true);
                            break;
                        }
                    }
                }
            }
        }
    }
    public static String getRootId(){
        return "1";
    }
}
