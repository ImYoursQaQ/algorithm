package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    /**
     * 输入：paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"]
     * 输出：[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
     *
     * @param paths
     * @return
     */

    public List<List<String>> findDuplicate(String[] paths) {
        if (paths.length == 0){
            return new ArrayList<>();
        }

        Map<String,List<String>> resMap = new HashMap<>();
        //遍历路径
        for (String path : paths) {
            String[] strs = path.split(" ");
            String tmpPath = strs[0];
            //遍历文件
            for (int i = 1; i < strs.length; i++) {
                String tmpFile = strs[i].substring(0,strs[i].indexOf('('));
                String tmpContent = strs[i].substring(strs[i].indexOf('('));
                if (resMap.containsKey(tmpContent)){
                    resMap.get(tmpContent).add(tmpPath+"/" + tmpFile);
                }else {
                    List<String> tmp = new ArrayList<>();
                    tmp.add(tmpPath+"/" + tmpFile);
                    resMap.put(tmpContent,tmp);
                }
            }

        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> value : resMap.values()) {
            if (value.size() > 1){
                res.add(value);
            }
        }
        return res;
    }




    public static void main(String[] args) {
        String[] path = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        Main main = new Main();
        main.findDuplicate(path);
    }
}
