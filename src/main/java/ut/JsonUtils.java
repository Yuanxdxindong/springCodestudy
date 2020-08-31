package ut;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class JsonUtils {

    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    /**
     * JSON字符串转换Map
     * @param json
     * @return
     */
    public static Map writeJsonToMap(String json) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        Map map = null;
        try {
            map = mapper.readValue(json, Map.class);
        } catch (IOException e) {
            logger.error("解析发票文本错误!", e);
        }
        return map;
    }

    /**
     * 判断是否为合法的json串
     * @param jsonInString
     * @return
     */
    public final static boolean isJSONValid(String jsonInString) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(jsonInString);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
