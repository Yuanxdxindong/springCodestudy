package aviator规则引擎;

/**
 * @author yuanxindong
 * @date 2020/9/1  12:07 上午
 */
public enum FunctionTypeEnum {
    /**
     *
     */
    COMMON("常规类型",1),
    /**
     *
     */
    CUSTOMIZE("自定义类型",2);

    private String description;
    private Integer value;

    FunctionTypeEnum(String description, Integer value) {
        this.description = description;
        this.value = value;
    }
}
