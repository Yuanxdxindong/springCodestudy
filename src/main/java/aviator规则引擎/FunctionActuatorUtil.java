package aviator规则引擎;

import com.alibaba.fastjson.JSON;
import ut.JsonUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author yuanxindong
 * @date: 2020/8/25 15:18
 */
public class FunctionActuatorUtil<T> {

  private static final String SYMBOL_A = "(";
  private static final String SYMBOL_B = ")";
  private static final String SYMBOL_C = ",";

  /**
   * 解析函数表达式里面值为Map
   *
   * @param function -> 前端过来的函数
   * @param Z -> 自定义函数的类
   * @return
   * @throws IllegalAccessException
   * @throws InstantiationException
   */
  public static Map actuatorMap(String function, Class Z)
      throws IllegalAccessException, InstantiationException {
    int ready = function.indexOf(SYMBOL_A) + 1;
    int end = function.indexOf(SYMBOL_B);
    String substring = function.substring(ready, end);
    String[] split = substring.split(SYMBOL_C);

    Object obj = Z.newInstance();
    Field[] fields = Z.getFields();
    int i = 0;
    if (fields.length == split.length) {
      for (Field f : fields) {
        f.setAccessible(true);
        f.set(obj, split[i]);
      }
    }

    Object o = JSON.toJSON(obj);
    return JsonUtils.writeJsonToMap(o.toString());
  }

  /**
   * 主要用于匹配函数库
   *
   * @param function
   * @return
   */
  public static String getFunctionName(String function) {
    int ready = function.indexOf(SYMBOL_A) + 1;
    return function.substring(0, ready);
  }

  /**
   * 判断是否属于公共函数
   *
   * @param function -> 前端拼接函数类型
   * @return FunctionTypeEnum
   */
  public static FunctionTypeEnum getFunctionType(String function) {
    return (function.contains(SYMBOL_A) && function.contains(SYMBOL_B))
        ? FunctionTypeEnum.CUSTOMIZE
        : FunctionTypeEnum.CUSTOMIZE;
  }

  public static Boolean isCommonFunction(String function) {
    return (function.contains(SYMBOL_A) && function.contains(SYMBOL_B)) ? false : true;
  }
}
