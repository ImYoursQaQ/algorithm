package sort.quickSort;

/**
 * 快速排序
 *
 * */
public class main {
    public static void main(String[] args) {
        int[] a = {7, 8, 6, 4, 9, 5, 2, 3, 1};
        int start = 0,end = a.length-1;
        //Arrays.sort(a);//Arrays工具类内置排序
        quickSort(a,start,end);
        printresult(a);

    }

    static void quickSort(int[] a,int low,int high) {
        if (low >= high) {
            return;
        }
        int k = partition(a, low, high);
        quickSort(a, low, k - 1);
        quickSort(a, k + 1, high);
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

    static int partition(int[] a, int low, int high){
        //将当前表中第一个元素作为枢轴元素
        int tmp = a[low];
        while (low < high){
            //从右端找出比枢轴元素小的
            while (low < high && a[high] >= tmp){
                high --;
            }
            a[low] = a[high];
            //从左端找出比枢轴元素大的
            while (low < high && a[low] <= tmp){
                low ++;
            }
            a[high] = a[low];
        }
        //将枢轴元素放在最终位置上
        a[low] = tmp;
        return low;
    }
}
