package com.drcl.traincore.util;

import java.util.HashMap;
import java.util.Map;

import org.springside.modules.utils.web.struts2.Struts2Utils;

public class ParameterUtils
{
    private static String ACTION_INDEX_HEAD = "action_index";

    @SuppressWarnings("unchecked")
    public static String getActionIndex(Class clazz, String name)
    {
        return ACTION_INDEX_HEAD + "_" + clazz.getName() + "_" + name;
    }

    @SuppressWarnings("unchecked")
    public static String getActionIndex(Class clazz)
    {
        return getActionIndex(clazz, "");
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> getParamMap(String actionIndex)
    {
        Map<String, Object> map = (Map<String, Object>) Struts2Utils
                .getSession().getAttribute(actionIndex);
        return map == null ? new HashMap<String, Object>() : map;
    }

    @SuppressWarnings("unchecked")
    public static boolean isEmpty(String actionIndex)
    {
        Map<String, Object> map = (Map<String, Object>) Struts2Utils
                .getSession().getAttribute(actionIndex);
        if (null != map && !map.isEmpty())
        {
            return false;
        }
        return true;
    }

    public static String getParameter(String actionIndex, String proName)
    {
        return getParameter(actionIndex, proName, null);
    }

    public static String getParameter(String actionIndex, String proName,
            String defaultValue)
    {
        Object temp = getParamObj(actionIndex, proName);
        if (null == temp)
        {
            return defaultValue;
        }
        return String.valueOf(temp);

    }

    public static boolean getBooleanParameter(String actionIndex, String proName)
    {
        return getBooleanParameter(actionIndex, proName, false);
    }

    public static boolean getBooleanParameter(String actionIndex,
            String proName, boolean defaultValue)
    {
        try
        {
            return Boolean
                    .valueOf(getParamObj(actionIndex, proName).toString());
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    public static int getIntParameter(String actionIndex, String proName)
    {
        return getIntParameter(actionIndex, proName, 0);
    }

    public static int getIntParameter(String actionIndex, String proName,
            int defaultNum)
    {
        try
        {
            return Integer
                    .valueOf(getParamObj(actionIndex, proName).toString());
        }
        catch (Exception e)
        {
            return defaultNum;
        }
    }

    public static long getLongParameter(String actionIndex, String proName)
    {
        return getLongParameter(actionIndex, proName, 0);
    }

    public static long getLongParameter(String actionIndex, String proName,
            long defaultNum)
    {
        try
        {
            return Long.valueOf(getParamObj(actionIndex, proName).toString());
        }
        catch (Exception e)
        {
            return defaultNum;
        }
    }

    @SuppressWarnings("unchecked")
    public static Object getParamObj(String actionIndex, String proName)
    {
        try
        {
            Map<String, Object> map = (Map<String, Object>) Struts2Utils
                    .getSession().getAttribute(actionIndex);
            return map.get(proName);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public static void setParamObj(String actionIndex,
            Map<String, Object> searchMap)
    {
        Struts2Utils.getSession().setAttribute(actionIndex, searchMap);
    }
}