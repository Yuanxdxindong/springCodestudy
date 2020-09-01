package aviator规则引擎;

import com.alipay.sofa.rpc.common.utils.JSONUtils;
import com.googlecode.aviator.AviatorEvaluator;
import ut.JsonUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author yuanxindong
 * @date 2020/8/9 14:28
 */
public class AviatorDemo4 {

  private static volatile Set<String> authRuleConfigs = new HashSet<>(100);
  private static volatile List<StorageEntry> storageEntryList = new ArrayList<>();

  public static void main(String[] args) throws IllegalAccessException, InstantiationException {
    String functionName = "";
    // 添加规则表达 允许的字段名 此处的规则都是先给前端一个字典，通过字典筛选框进行配置。
    addAuthRuleConfig("dateTime1 < dateTime2");
    addAuthRuleConfig("string1 == string2");
    addAuthRuleConfig("bigInt1 == bigInt2");
    addAuthRuleConfig("bigInt1 == bigInt2 && dateTime1 > dateTime2");
    addAuthRuleConfig("string1 == string2 || dateTime1 > dateTime2");
    addAuthRuleConfig("string1 == string2 && dateTime1 > dateTime2");
    addAuthRuleConfig("dateTime1 > countTime(now,before,100,day)");

    // 获取规则
    Set<String> strings = authRuleConfigs;
    Iterator<String> iterator = strings.iterator();

    while (iterator.hasNext()) {
      addRule(functionName, iterator.next());
    }
    // 将前端给过来的表达式

    // 需要校验的数据
    Map dateSource = getDateSource();

    // 读取配置的函数
    List<StorageEntry> storageEntryList = AviatorDemo4.storageEntryList;

    // 注册自定义函数表达式
    AviatorEvaluator.addFunction(new CustomFunctionService.countTimeFunction());

    // 遍历进行执行表达式校验这条数据是否符合规范
    for (StorageEntry storageEntry : storageEntryList) {
      dateSource.putAll(storageEntry.getValues());
      Object execute = AviatorEvaluator.execute(storageEntry.getFunctionName(), dateSource);
      System.out.println(execute);
    }
  }

  /**
   * 前段传过来的函数进行解析存储
   *
   * @param functionName 函数名
   * @param function 函数表达式
   * @throws InstantiationException
   * @throws IllegalAccessException
   */
  private static void addRule(String functionName, String function)
      throws InstantiationException, IllegalAccessException {
    // 判断是那一种表达式
    if (FunctionActuatorUtil.isCommonFunction(function)) {

      StorageEntry storageEntry = StorageEntry.commonStorageEntry(functionName);
      storageEntryList.add(storageEntry);
    } else {

      String s = FunctionActuatorUtil.getFunctionName(function);
      VictorLibraryFunction victorLibraryFunction = VictorLibraryFunction.fromValue(s);
      // 匹配函数库自定义的函数
      StorageEntry storageEntry =
          StorageEntry.customerStorageEntry(functionName, victorLibraryFunction);
      storageEntryList.add(storageEntry);
    }
  }

  /**
   * 数据源
   *
   * @return Map
   */
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

  static void addAuthRuleConfig(String authRule) {
    authRuleConfigs.add(authRule);
  }
}
