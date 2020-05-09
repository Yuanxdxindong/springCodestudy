package 动态代理;

/**
 * @Author:yuanxindong
 * @Date:2020/5/90:57
 */
public class UserServiceImpl implements UserService{

    public void select() {
        System.out.println("查询 selectById");
    }

    public void update() {
        System.out.println("更新 update");
    }
}
