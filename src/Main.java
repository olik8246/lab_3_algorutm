import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[1000000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((int) (Math.random() * 1000001));
        }
        System.out.println(Arrays.toString(arr));
        long c = System.currentTimeMillis();
        int[] sortArr = sort(arr);
        System.out.println(Arrays.toString(sortArr));
        long m = System.currentTimeMillis();
        long b=m-c;
        System.out.println("Time: " + b);
    }

    public static int[] sort(int[] arr) {
        if (arr.length < 2)
            return arr;
        int m = arr.length / 2;
        int[] arr1 = Arrays.copyOfRange(arr, 0, m);
        int[] arr2 = Arrays.copyOfRange(arr, m, arr.length);
        return merge(sort(arr1), sort(arr2));

    }

    public static int[] merge(int[] arr1, int arr2[]) {
        int n = arr1.length + arr2.length;
        int[] arr = new int[n];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < n; i++) {
            if (i1 == arr1.length) {
                arr[i] = arr2[i2++];
            } else if (i2 == arr2.length) {
                arr[i] = arr1[i1++];

            } else {
                if (arr1[i1] > arr2[i2]) {

                    arr[i] = arr1[i1++];
                } else {
                    arr[i] = arr2[i2++];
                }
            }
        }
        return arr;

        }


    }
