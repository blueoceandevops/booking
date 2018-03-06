package me.rainking.booking.util;

import java.util.Random;

/**
 * @author Rain
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     * synchronized
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900) + 100;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
