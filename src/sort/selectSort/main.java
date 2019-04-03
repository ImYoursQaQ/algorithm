package sort.selectSort;

/*
 * 简单选择排序
 *
 * */
public class main {
    public static void main(String[] args) {
        int[] a = {7, 8, 6, 4, 9, 5, 2, 3, 1};
        sort(a);
        printresult(a);

    }

    static void sort(int[] a) {
        int i, j, temp;
        for ( i = 0; i < a.length-1; i++) {

            temp = i;//记录坐标
            for ( j = i+1; j < a.length; j++) {
               if (a[j]<a[temp]){
                   temp = j;
               }
            }
            if (a[i]>a[temp]){
                swap(a,i,temp);
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
