import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * JVM 参数和使用
 * 1。-XX:+PrintGCDetails：打印gc详细信息
 * 2。-Xloggc:log/gc.log：将gc日志保存到文件中
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Map map = new ConcurrentHashMap<>(7);
        map.put("key","value");
        System.out.println("Hello World!");
        List list = new ArrayList();
//        for(int i=0;i<10000;i++){
//            String str = new String("12348888");
//            list.add(str);
//        }
        System.out.println("最大堆："+Runtime.getRuntime().maxMemory()/1024/1024+"M");
        System.out.println("空闲堆："+Runtime.getRuntime().freeMemory()/1024/1024+"M");
        System.out.println("总的堆："+Runtime.getRuntime().totalMemory()/1024/1024+"M");
        while (true){
            System.in.read();
        }
    }
}
