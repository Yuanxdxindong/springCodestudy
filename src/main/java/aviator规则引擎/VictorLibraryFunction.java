package aviator规则引擎;

/**
 * @author yuanxindong
 * @date: 2020/8/25 15:33
 */
public enum VictorLibraryFunction {
    /**
     * 自定义函数库
     */
    COUNT_TIME("countTime('time','algorithm','time','timeType')","计算time时间前多少天或者后多少天");
    private  String name;
    private  String function;
    VictorLibraryFunction(String name, String function) {
        this.name = name;
        this.function = function;
    }

    public String getName() {
        return name;
    }

    public String getFunction() {
        return function;
    }}
