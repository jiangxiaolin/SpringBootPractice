package cn.netrookie;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJ {
    private static final Logger logger = Logger.getLogger(TestJ.class);
    @Test
    public void parseJson(){
        String x = "{\"log_id\":1993282656890988426,\"items\":[{\"score\":0.938807,\"tag\":\"达沃斯\"},{\"score\":0.91365,\"tag\":\"世界经济\"},{\"score\":0.885237,\"tag\":\"经济全球化\"},{\"score\":0.858967,\"tag\":\"习近平\"}]}";
        Map map = (Map)JSON.parse(x);
        logger.info(map);
        Map<String,Double> result = new HashMap<>();
        List list = (List)map.get("items");
        logger.info(list);
        for(int i=0;i<list.size();i++){
            Map xx = (Map)list.get(i);
            logger.info(xx.get("score"));
            logger.info(xx.get("tag"));
            result.put(xx.get("tag").toString(),Double.valueOf(xx.get("score").toString()));
        }
        logger.info(result);
    }
}
