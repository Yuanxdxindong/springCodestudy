package aviator规则引擎;

import com.alibaba.fastjson.JSON;
import ut.JsonUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author yuanxindong
 * @date: 2020/8/25 15:18
 */
public class TimeFunctionActuator<T> {

    /**
     * 解析函数表达式里面值为Map
     * @param function
     * @param Z
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
   public Map actuatorMap(String function,Class<T> Z) throws IllegalAccessException, InstantiationException {
       int ready = function.indexOf("(") + 1;
       int end = function.indexOf(")");
       String substring = function.substring(ready, end);
       String[] split = substring.split(",");

       Object obj = Z.newInstance();
       Field[] fields = Z.getFields();
       int i = 0;
       if(fields.length ==  split.length){
           for(Field f :fields ){
               f.setAccessible(true);
               f.set(obj, split[i]);
           }
       }

       Object o = JSON.toJSON(obj);
       return JsonUtils.writeJsonToMap(o.toString());
   }


   public String  funactionName(String function){
       int ready = function.indexOf("(") + 1;
       return function.substring(0, ready);

   }
}
