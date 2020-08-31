package aviator规则引擎;

/**
 * @author yuanxindong
 * @date 2020/8/25 15:06
 */
public enum CountTimeRule {

    /**
     *
     */
    DAY(24*60*1000L,"DAY"),

    WEEK(7*24*60*1000L,"WEEK"),

    MONTH(30*24*60*1000L,"MONTH"),

    YEAR(365*24*60*1000L,"DAY");


    private Long  times;
    private String name;

    CountTimeRule(Long times, String name) {
        this.times = times;
        this.name = name;
    }

    public Long getTimes() {
        return times;
    }


    public String getName() {
        return name;
    }
}
