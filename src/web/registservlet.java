package web;

import pojo.user;
import service.impl.userserviceimpl;
import service.userservice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLOutput;

public class registservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userservice userservice=new userserviceimpl();
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        String email= request.getParameter("email");
        String code= request.getParameter("code");
        if("abcd".equalsIgnoreCase(code))
        {
            if(userservice.checkuser(username))
            {
                System.out.println("用户名存在");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            }
            else {
                userservice.registuser(new user(null,username,password,email));
            }
            request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
        }
        else {
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            System.out.println("验证码错误");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
