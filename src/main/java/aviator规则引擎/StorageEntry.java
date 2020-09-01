package aviator规则引擎;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanxindong
 * @date 2020/9/1 12:06 上午
 */
@Data
@ToString
public class StorageEntry {
  private FunctionTypeEnum type;
  /** 前端给过来的string */
  private String functionName;
  /** 真正执行的Function */
  private String function;
  /** 自定义函数的每个对应的值 */
  private Map<String, Object> values;
  /**
   * @param functionName 前端拼接函数
   * @param
   * @return
   */
  public static StorageEntry commonStorageEntry(String functionName) {
    StorageEntry storageEntry = new StorageEntry();
    storageEntry.setValues(new HashMap<>(2));
    storageEntry.setFunction(functionName);
    storageEntry.setType(FunctionTypeEnum.COMMON);
    storageEntry.setFunctionName(functionName);
    return storageEntry;
  }

  public static StorageEntry customerStorageEntry(
      String functionName, VictorLibraryFunction victorLibraryFunction)
      throws InstantiationException, IllegalAccessException {

    StorageEntry storageEntry = new StorageEntry();

    // 获取函数的value
    storageEntry.setValues(
        FunctionActuatorUtil.actuatorMap(functionName, victorLibraryFunction.getZ()));
    storageEntry.setFunction(victorLibraryFunction.getFunction());
    storageEntry.setType(FunctionTypeEnum.COMMON);
    storageEntry.setFunctionName(functionName);
    return storageEntry;
  }

}
