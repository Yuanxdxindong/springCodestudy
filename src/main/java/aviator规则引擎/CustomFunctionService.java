package aviator规则引擎;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

/**
 * @author yuanxindong
 * @date 2020/9/1  1:02 下午
 */
public class CustomFunctionService {

  /**
   * @Override public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject
   * arg2) { Number left = FunctionUtils.getNumberValue(arg1, env); Number right =
   * FunctionUtils.getNumberValue(arg2, env); return new AviatorDouble(left.doubleValue() +
   * right.doubleValue()); }
   */
  /** 自定义函数 获取某一个时间的欠多少天和后多少天 */
  static class countTimeFunction extends AbstractFunction {
    @Override
    public AviatorDouble call(
        Map<String, Object> env,
        AviatorObject arg1,
        AviatorObject arg2,
        AviatorObject arg3,
        AviatorObject arg4) {

            Object data = FunctionUtils.getJavaObject(arg1, env);
            Object time = FunctionUtils.getJavaObject(arg2, env);
            Object algthori = FunctionUtils.getJavaObject(arg3, env);
            Object times = FunctionUtils.getJavaObject(arg4, env);

            System.out.println(data+""+time+""+algthori+""+times);
            //根据变量值进行计算 想要的结果
            long l = System.currentTimeMillis();
            AviatorDouble aviatorDouble = new AviatorDouble(l);
            return aviatorDouble;
        }

        @Override
        public String getName() {
            return "countTime";
        }
    }
}
