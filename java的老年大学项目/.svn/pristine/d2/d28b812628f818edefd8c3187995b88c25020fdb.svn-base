package com.learnyeai.core.consts;

import java.util.*;

/**
 * 枚举类型工具类
 * TYPE 枚举类型
 * CODE 自定义枚举标识
 * LABEL 标识中文说明
 * VALUE 字典值
 * Created by sunlei on 2017/2/8 0008.
 */
public class ConsTools {
    /**
     * 所有枚举容器
     */
    private static Map<String, Map<String, ICons>> consMap = new HashMap<String, Map<String, ICons>>();
    private List<Class> csList = new ArrayList<Class>();

    public static void addCons(Class... cses){
        for (Class cs : cses)
            load(cs);
    }

    /**
     * 获取枚举MAP
     * 枚举MAP空检查，如为空则重新获取
     *
     * @return
     */
    static public Map<String, Map<String, ICons>> getConsMap() {
//        if (null == consMap || consMap.size() == 0)
//            load();
        return consMap;
    }

    /**
     * 将枚举类型转化为MAP，每个const注册进来 zzzzzzzzzzzzzz还未实现20171107
     */
    static private void load(Class cs) {
//            Class[] s1 =DtCons.class.getClasses();
//            Class[] s2 = PtCons.class.getClasses();
//            Class[] ss = new Class[s1.length+s2.length];
//            System.arraycopy(s1,0,ss,0,s1.length);
//            System.arraycopy(s2,0,ss,s1.length,s2.length);
//            Class[] ss =PtCons.class.getClasses();
        Class[] ss = cs.getClasses();

        for (Class<?> cl : ss) {
            try {
                if (cl.isEnum()) {
                    Map<String, ICons> item = new HashMap<String, ICons>();
                    ICons[] module = (ICons[]) cl.getEnumConstants();
                    if (module != null) {
                        for (ICons m : module) {
                            item.put(m.getVal(), m);
                        }
                    }
                    String type = cl.getSimpleName();
                    consMap.put(type, item);
                }
            } catch (Exception e) {
//            LOGGER.error("Module->load失败，原因：" + e.getMessage());
                e.printStackTrace();
            }
        }

    }

    // 根据枚举类型，获取list
    public static List<Map> getListByType(String type) {
        Map<String, ICons> map = getConsMap().get(type);
        List list = new ArrayList();
        if (null == map) {
            return list;
        }
        for (Iterator<Map.Entry<String, ICons>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map p = new HashMap();
            Map.Entry<String, ICons> o = it.next();
            p.put(o.getKey(), o.getValue().getLabel());
            list.add(p);
        }
        return list;
    }
    public static   <T>  T getCons(Class<T> cs, String val){
        if(!getConsMap().containsKey(cs.getSimpleName()))
            return null;
        Map<String, ICons> valus = getConsMap().get(cs.getSimpleName());
        if(valus.containsKey(val))
            return (T)valus.get(val);
        return null;
    }

    /**
     * 检查val是否是指定常量
     * @param cons
     * @param val
     * @return
     */
    public static boolean validateConsVal(ICons cons, String val){
        ICons vCons = getCons(cons.getClass(), val);
        return cons == vCons;
    }

    //判断值是否在常量定义数组中
    public static boolean validateIn(String type,String value){
        boolean result = false;
        Map<String, ICons> map = getConsMap().get(type);
        for(Iterator<Map.Entry<String, ICons>> it=map.entrySet().iterator(); it.hasNext();){
            Map.Entry<String, ICons> o = it.next();
            if(value.equals(o.getKey())){
                result = true;
                return result;
            }
        }
        return result;
    }


    /**
     * 通过枚举类型和对应的值获取枚举对应值的中文说明
     * 如没有则返回空字符串
     *
     * @param type
     * @param value
     * @return
     */
    public static String getLabelByValue(String type, String value) {
        return getLabelByValue(type, value, "");
    }

    /**
     * 通过枚举类型和对应的值获取枚举对应值的中文说明
     * 如没有则返回默认参数 def
     *
     * @param type
     * @param value
     * @return
     */
    public static String getLabelByValue(String type, String value, String def) {
        if(!getConsMap().containsKey(type))
            return def;
        Map<String, ICons> map = getConsMap().get(type);
        if(!map.containsKey(value))
            return def;
        String label = map.get(value).getLabel();
        return label;
    }

}
