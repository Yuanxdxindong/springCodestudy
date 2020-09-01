package aviator规则引擎;

/**
 * @author yuanxindong
 * @date: 2020/8/25 15:33
 */
public enum VictorLibraryFunction {
  /** 自定义函数库 */
  COUNT_TIME(
      "countTime('time','algorithm','time','timeType')",
      "计算time时间前多少天或者后多少天",
      CountTimeObject.class);
  private String name;
  private String function;
  private Class z;

  VictorLibraryFunction(String name, String function, Class z) {
    this.name = name;
    this.function = function;
  }

  public String getName() {
    return name;
  }

  public String getFunction() {
    return function;
  }

  public Class getZ() {
    return z;
  }

  public static  VictorLibraryFunction fromValue(String function) {
    for (VictorLibraryFunction victorLibraryFunction : VictorLibraryFunction.values()) {
      if (victorLibraryFunction.getFunction().equals(function)) {
        return victorLibraryFunction;
      }
    }
    return null;
  }
}
