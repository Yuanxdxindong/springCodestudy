package 动态代理.CGLib;

/**
 * @Author:yuanxindong
 * @Date:2020/5/91:25
 */
public class UserDao {
    public void select() {
        System.out.println("UserDao 查询 selectById");
    }

    public void update() {
        System.out.println("UserDao 更新 update");
    }
}

