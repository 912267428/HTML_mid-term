package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLOutput;

public abstract class  BaseServlet  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String action=request.getParameter("action");
        try {
            Method method=this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            try {
                method.invoke(this,request,response);
            } catch (IllegalAccessException e) {
                //e.printStackTrace();
            } catch (InvocationTargetException e) {
                //e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            //e.printStackTrace();
        }
        System.out.println("base被调用");
        System.out.println("/**\n" +
                " *                             _ooOoo_\n" +
                " *                            o8888888o\n" +
                " *                            88\" . \"88\n" +
                " *                            (| -_- |)\n" +
                " *                            O\\  =  /O\n" +
                " *                         ____/`---'\\____\n" +
                " *                       .'  \\\\|     |//  `.\n" +
                " *                      /  \\\\|||  :  |||//  \\\n" +
                " *                     /  _||||| -:- |||||-  \\\n" +
                " *                     |   | \\\\\\  -  /// |   |\n" +
                " *                     | \\_|  ''\\---/''  |   |\n" +
                " *                     \\  .-\\__  `-`  ___/-. /\n" +
                " *                   ___`. .'  /--.--\\  `. . __\n" +
                " *                .\"\" '<  `.___\\_<|>_/___.'  >'\"\".\n" +
                " *               | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |\n" +
                " *               \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /\n" +
                " *          ======`-.____`-.___\\_____/___.-`____.-'======\n" +
                " *                             `=---='\n" +
                " *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" +
                " *                     佛祖保佑        永无BUG\n" +
                " *            佛曰:\n" +
                " *                   写字楼里写字间，写字间里程序员；\n" +
                " *                   程序人员写程序，又拿程序换酒钱。\n" +
                " *                   酒醒只在网上坐，酒醉还来网下眠；\n" +
                " *                   酒醉酒醒日复日，网上网下年复年。\n" +
                " *                   但愿老死电脑间，不愿鞠躬老板前；\n" +
                " *                   奔驰宝马贵者趣，公交自行程序员。\n" +
                " *                   别人笑我忒疯癫，我笑自己命太贱；\n" +
                " *                   不见满街漂亮妹，哪个归得程序员？\n" +
                "*/");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
