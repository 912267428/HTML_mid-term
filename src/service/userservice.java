package service;

import pojo.user;

public interface userservice {
    public void registuser(user user);
    public user loginuser(user user);
    public boolean checkuser(String username);

}
