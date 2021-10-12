package StringUtils.arbitraryconversion;


/*
任意进制转换
* */

public class main {
    public static void main(String[] args) {
        String a= "1110";//2进制的 14
        String b = convert(a,2,16);
        System.out.println(b);
    }

    private static String convert(String a, int frombase, int tobase) {
        char[] chs = new char[100];
        for (int i = 0; i <10; i++) {
            chs[i] = (char) ('0' + i);
        }
        for (int i = 10; i <=36; i++) {
            chs[i] = (char) ('A' + (i-10));
        }
        int num = Integer.parseInt(a,frombase);//利用此工具转换为10进制数
        //System.out.println(num);
        StringBuilder sb = new StringBuilder();
        while (num!=0){
            sb.append(chs[num%tobase]);
            num = num/tobase;
        }
        return sb.reverse().toString();
    }
}
