package web;

import dao.impl.userdaoimpl;
import dao.userdao;
import pojo.user;
import service.impl.userserviceimpl;
import service.userservice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class logservlet extends HttpServlet {


    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userservice userservice=new userserviceimpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user user = userservice.loginuser(new user(null, username, password, null));
        if(user!=null)
        {
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
            System.out.println("登陆成功");

        }
        else {
            System.out.println("用户v不存在");
            request.setAttribute("mssg","用户名或者密码错误");
            request.setAttribute("user",username);
        }

        request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
