package sort.insertSort;
/**
* 直接插入排序
*
* */
public class main {
    public static void main(String[] args) {
        int[] a = {7,8,6,4,9,5,2,3,1};
        sort(a);
        printresult(a);

    }
    static void sort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            //记录当前位置元素
            int tmp = a[i];
            int j = i - 1;
            //查找插入位置
            for (; j >= 0; j--) {
                if (a[j] > tmp) {
                    //向后挪动一位
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            //把当前元素插入位置
            a[j + 1] = tmp;
        }

    }

    static void printresult(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
