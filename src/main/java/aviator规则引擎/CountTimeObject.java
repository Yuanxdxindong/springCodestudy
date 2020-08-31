package aviator规则引擎;

import lombok.Data;

import java.util.Date;

/**
 * @author yuanxindong
 * @date: 2020/8/25 15:49
 * countTime('dateTime','algorithm','math','timeType')
 */
@Data
public class CountTimeObject {
    /**
     * 某一时刻时间
     */
    private Date date;

    /**
     * 算法
     */
    private String algorithm;

    /**
     * 数量
     */
    private Integer math;
    /**
     * 单位
     */
    private String timeType;
}
