package sort.insertSort;
/*
* 直接插入排序
*
* */
public class main {
    public static void main(String[] args) {
        int[] a = {7,8,6,4,9,5,2,3,1};
        sort(a);
        printresult(a);

    }
    static void sort(int[] a){
        int i,j,temp ;
        for (i = 1; i < a.length; i++) {

                temp = a[i];

            for (j = i; j >0 && temp<a[j-1] ; j--) {
                a[j] = a[j-1];
            }
            a[j] = temp;
        }

    }

    static void printresult(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
