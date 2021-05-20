package utils;

import org.apache.commons.beanutils.BeanUtils;
import pojo.user;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Webutils {
    public static <T> T copytobean(Map value, T bean) {

        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    public static int parseint(String strint,int defaultvalue)
    {
         try {
             return Integer.parseInt(strint);
         }
         catch (Exception e)
         {
//e.printStackTrace();
         }
return defaultvalue;

    }
    }

