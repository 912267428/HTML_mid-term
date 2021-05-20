package test;

import dao.impl.userdaoimpl;
import dao.userdao;
import org.junit.Test;
import pojo.user;

import static org.junit.Assert.*;

public class userdaoTest {
private userdao userdao=new userdaoimpl();
    @Test
    public void queryuserbyusername() {
        if(userdao.queryuserbyusername("admin")!=null)
        {
            System.out.println("ok");
        }
//        user us1=new user();
//        us1=userdao.queryuserbyusername("admin");
//        System.out.println(us1.toString());
    }

    @Test
    public void saveuser() {
        int i=userdao.saveuser(new user(null,"ou","123456","1344573611@qq.com"));
        System.out.println(i);
    }

    @Test
    public void querybyusernameandpassword() {

    }
}