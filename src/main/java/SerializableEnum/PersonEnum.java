package SerializableEnum;

/**
 * @Author:yuanxindong
 * @Date:2020/5/101:33
 */
public enum PersonEnum {
    /**
     * 小圆
     */
    YUANXINDONG("yuanxindong",1);

    ;
    private String age;
    private int i;

    @Override
    public String toString() {
        return "PersonEnum{" +
                "age='" + age + '\'' +
                ", i=" + i +
                '}';
    }

    PersonEnum(String yuanxindong, int i) {
        this.age = yuanxindong;
        this.i = i;
    }}
