/**
 * @author yuanxindong
 * @date: 2020/7/29 13:17
 */
public class demo extends demoDad {
    @Override
    public String getName(){
        return  "son";
    }

    public static void main(String[] args) {
        demo demo = new demo();
        System.out.println(demo.getName());
        demoDad demoDad = new demo();
        System.out.println(demoDad.getName());
    }
}
