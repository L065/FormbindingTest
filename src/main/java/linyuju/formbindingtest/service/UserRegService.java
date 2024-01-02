package linyuju.formbindingtest.service;

import linyuju.formbindingtest.DAO_Repository.UserRegDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegService
{
    @Autowired
    UserRegDao userRegDao;

    //取下方的公用方法來使用


    //檢查帳號是否存在判斷式
    //獨立寫成一個公用方法，使確認帳號是否存在的功能可以分享，如改密碼也需要檢查是否有此帳號
    public boolean testUserExist(String uname)
    {
        long count = userRegDao.testUserExist(uname);
        if (count > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
