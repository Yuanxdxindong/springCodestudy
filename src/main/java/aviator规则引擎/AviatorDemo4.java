package aviator规则引擎;

import com.alipay.sofa.rpc.common.utils.JSONUtils;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import ut.JsonUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author yuanxindong
 * @date 2020/8/9 14:28
 */
public class AviatorDemo4 {

    private static volatile Set<String> authRuleConfigs = new HashSet<>(100);

    public static void main(String[] args) {
        // 需要校验的数据
        Map dateSource = getDateSource();

        // 添加规则表达 允许的字段名 此处的规则都是先给前端一个字典，通过字典筛选框进行配置。
        addAuthRuleConfig("dateTime1 < dateTime2");
        addAuthRuleConfig("string1 == string2");
        addAuthRuleConfig("bigInt1 == bigInt2");
        addAuthRuleConfig("bigInt1 == bigInt2 && dateTime1 > dateTime2");
        addAuthRuleConfig("string1 == string2 || dateTime1 > dateTime2");
        addAuthRuleConfig("string1 == string2 && dateTime1 > dateTime2");

        //存储在数据库中的真正配置


        addAuthRuleConfig("dateTime1>"+VictorLibraryFunction.COUNT_TIME.getFunction());

        addAuthRuleConfig("");
        // addAuthRuleConfig("date<getDate())");

        //获取规则
        Set<String> strings = authRuleConfigs;
        Iterator<String> iterator = strings.iterator();

        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
            Object execute = AviatorEvaluator.execute(next,dateSource);
            System.out.println(execute);

        }



    }

    private static Map getDateSource() {
        TestObject test = new TestObject();
        test.setBigDecimal1(new BigDecimal("1"));
        test.setBigDecimal2(new BigDecimal("2"));
        test.setBigInt(12L);
        test.setBigInt2(13L);
        test.setDateTime1(new Date());
        test.setDateTime2(new Date());
        String s = JSONUtils.toJSONString(test);
        Map data = JsonUtils.writeJsonToMap(s);
        return data;
    }

    /**
     * 自定义函数
     * 获取某一个时间的欠多少天和后多少天
     */
    static class countTimeFunction extends AbstractFunction {
        // @Override
        // public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3) {
        //
        // }

        @Override
        public String getName() {
            return "countTime";
        }
    }




    static void addAuthRuleConfig(String authRule) {

        authRuleConfigs.add(authRule);

    }

}
