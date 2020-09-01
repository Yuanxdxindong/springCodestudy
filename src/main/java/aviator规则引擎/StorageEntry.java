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

  public static StorageEntry commonStorageEntry(
      FunctionTypeEnum type, String functionName) {
    StorageEntry storageEntry = new StorageEntry();
    storageEntry.setValues(new HashMap<>(2));
    storageEntry.setFunction(functionName);
    storageEntry.setType(type);
    storageEntry.setFunctionName(functionName);
    return storageEntry;
  }

    public static StorageEntry customerStorageEntry(
            FunctionTypeEnum type, String functionName, String function) {
        StorageEntry storageEntry = new StorageEntry();
        storageEntry.setValues(new HashMap<>(2));
        storageEntry.setFunction(functionName);
        storageEntry.setType(type);
        storageEntry.setFunctionName(functionName);
        return storageEntry;
    }

  private FunctionTypeEnum type;
  /** 前端给过来的string */
  private String functionName;
  /** 真正执行的Function */
  private String function;
  /** 自定义函数的每个对应的值 */
  private Map<String, Object> values;
}
