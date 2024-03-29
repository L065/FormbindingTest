package linyuju.formbindingtest.DAO_Repository;

import linyuju.formbindingtest.model.userModel.UserRegModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository    //repository 專門資料庫的存取、處理，倉儲物件
public class UserRegDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveUserData(UserRegModel userregform)  //進行存檔 Insert into 資料表userregform
    {
        String sql01 = "insert into userregform(uname,email,mobile,address) values (?,?,?,?)";
        return jdbcTemplate.update(sql01, userregform.getUname(), userregform.getEmail(), userregform.getMobile(), userregform.getAddress()); //update新增(sql語法物件,資料表.Model方法)
    }

    //檢查帳號是否存在
    public long testUserExist(String uname)
    {
        String sql02 = "select count(*) from userregform where uname=?";
        // select count(*) 回傳一慮使用 long 型別
        return jdbcTemplate.queryForObject(sql02,Long.class, uname);
    }
}
