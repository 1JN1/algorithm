package day_62;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2024/11/29
 * @description 日志速率限制器
 **/
public class Problem02 {

    @Test
    public void test() {

        Logger logger = new Logger();

        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(2, "bar"));
        System.out.println(logger.shouldPrintMessage(3, "foo"));
        System.out.println(logger.shouldPrintMessage(8, "bar"));
        System.out.println(logger.shouldPrintMessage(10, "foo"));
        System.out.println(logger.shouldPrintMessage(11, "foo"));

    }

    class Logger {

        private Map<String, Integer> infos;

        public Logger() {
            infos = new HashMap<>();
        }


        public boolean shouldPrintMessage(int timestamp, String message) {

            if (!infos.containsKey(message)) {
                infos.put(message, timestamp);
                return true;
            }

            Integer preTimeStamp = infos.get(message);


            return (timestamp - preTimeStamp) >= 10;
        }
    }

}
