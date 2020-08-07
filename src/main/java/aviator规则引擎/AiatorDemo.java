package aviator规则引擎;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorLong;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanxindong
 * @date: 2020/8/4 16:05
 */
public class AiatorDemo extends AbstractFunction {
    public static void main(String[] args) {
        //注册函数
        AviatorEvaluator.addFunction(new AiatorDemo());

        String expression = "my_sum(a,b,c)";

        Map<String, Object> params = new HashMap<>();
        params.put("a", 1);
        params.put("b", 2);
        params.put("c", 3);

        long result = (long) AviatorEvaluator.execute(expression, params);

        System.out.printf("result : " + result);
    }

    @Override
    public String getName() {
        return "my_sum";
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject a, AviatorObject b, AviatorObject c) {
        Number numA = FunctionUtils.getNumberValue(a, env);
        Number numB = FunctionUtils.getNumberValue(b, env);
        Number numC = FunctionUtils.getNumberValue(c, env);

        long result = numA.longValue() + numB.longValue() + numC.longValue();
        return new AviatorLong(result);
    }
}
