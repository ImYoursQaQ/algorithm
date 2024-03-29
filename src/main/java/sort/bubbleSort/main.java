package sort.bubbleSort;

/*
 * 冒泡排序
 *
 * */
public class main {
    public static void main(String[] args) {
        int[] a = {7, 8, 6, 4, 9, 5, 2, 3, 1};
        sort(a);
        printresult(a);

    }

    static void sort(int[] a) {
        int i, j;
        //外层循环代表：当前冒泡出得最大位置
        for (i = a.length - 1; i > 0; i--) {
            boolean flag = false;
            //内层循坏到待排序末尾
            for (j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    static void printresult(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
