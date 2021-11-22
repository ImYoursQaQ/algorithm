package designpattern.creat.prototypepattern;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author teohubo
 */
public class DataCenter {

    private Map<String,Score> current = new HashMap<>();


    /**
     * 初始化 当前
     */
    public void init(){
        this.current = mockInit();
    }

    private Map<String, Score> mockInit() {
        Map<String, Score> map = new HashMap<>();
        map.put("math",new Score(19));
        map.put("english",new Score(79));
        map.put("chinese",new Score(100));
        return map;
    }

    public void update(){
        //利用 deepCopy 完成 初始化工作
        String string = JSON.toJSONString(current);
        Map<String, Score> newMap = (Map<String, Score>) JSON.parse(string);
        newMap.put("english",new Score(90));
        current = newMap;

    }

    public Integer getScore(String keyWord){
       return Optional.ofNullable(current.get(keyWord)).map(Score::getNumber).orElse(-1);
    }
}
