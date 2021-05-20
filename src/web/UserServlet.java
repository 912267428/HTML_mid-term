package web;

import pojo.user;
import service.impl.userserviceimpl;
import service.userservice;
import utils.Webutils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userservice userservice=new userserviceimpl();
        System.out.println(request.getParameter("11"));
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        user us1=Webutils.copytobean(request.getParameterMap(),new user());
        System.out.println(us1.toString());
        user user = userservice.loginuser(us1);
        HttpSession session = request.getSession();
        if(user!=null)
        {

            session.setAttribute("user",user);

            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
            System.out.println("登陆成功");

        }
        else {
            System.out.println("用户v不存在");
            request.setAttribute("mssg","用户名或者密码错误");
            request.setAttribute("user",us1.getUsername());
        }

        request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
    }
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userservice userservice=new userserviceimpl();
//        String username= request.getParameter("username");
//        String password= request.getParameter("password");
//        String email= request.getParameter("email");

          String code= request.getParameter("code");
          String token= (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
          request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
          user us1=  Webutils.copytobean(request.getParameterMap(),new user());
        if(token!=null&&token.equalsIgnoreCase(code))
        {
            if(userservice.checkuser(us1.getUsername()))
            {
                System.out.println("用户名存在");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            }
            else {
                userservice.registuser(us1);
            }
            request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
        }
        else {
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            System.out.println("验证码错误");
        }
    }
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath());
    }
}
