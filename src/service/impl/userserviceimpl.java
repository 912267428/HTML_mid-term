package service.impl;

import dao.impl.userdaoimpl;
import dao.userdao;
import pojo.user;
import service.userservice;

public class userserviceimpl implements userservice {

    private userdao useerdao=new userdaoimpl();
    public void registuser(user user) {
         useerdao.saveuser(user);
    }

    @Override
    public user loginuser(user user) {
        return useerdao.querybyusernameandpassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean checkuser(String username) {
        if(useerdao.queryuserbyusername(username)==null)
        {
            return false;
        }
        else return true;
    }
}
