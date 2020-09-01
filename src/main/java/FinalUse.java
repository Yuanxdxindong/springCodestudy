import lombok.Data;
import lombok.ToString;

/**
 * @author yuanxindong
 */
@ToString
@Data
public class FinalUse {
    private final String name = "yaunxindong";
    private final String gender= "N";
    static final FinalUse finalUse =  new FinalUse();

    public static void main(String[] args) {
        System.out.println("修改前" +finalUse.toString());
//        finalUse.setGender("dog");
        System.out.println("修改后"+finalUse.toString());

    }
}
