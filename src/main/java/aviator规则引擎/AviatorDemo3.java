package aviator规则引擎;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorLong;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanxindong
 * @date 2020/8/9 12:50
 */
public class AviatorDemo3 {

    static String name;

    public static void main(String[] args) {

        // a和b是字段名，来源于数据库.
        String expression = "a<b";

        String expression2 = "${taxperiod} < ${b}";
        name = expression;
        Expression compile = AviatorEvaluator.compile(expression2);
        //将java中的对象构建为Map.
        Map<String, Object> map = getStringObjectMap();

        compile.execute(map);
        // System.out.println(execute);
    }

    private static Map<String, Object> getStringObjectMap() {
        Map<String, Object> map = new HashMap<>(4);
        map.put("a", 10);
        map.put("b", 11);
        map.put("test", "6666");
        return map;
    }

    /**
     * 自定义函数
     */
    static class getValue extends AbstractFunction {
        @Override
        public AviatorObject call(Map<String, Object> env, AviatorObject arg) {

            //arg和对应的map中的value对应
            BigDecimal value1 = (BigDecimal) FunctionUtils.getNumberValue(arg, env);

            return AviatorLong.valueOf(value1);
        }

        @Override
        public String getName() {
            return name;
        }
    }

    /**
     * 自定义时间函数当前时间前1个月/1天/小时
     */



}
