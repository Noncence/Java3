package homework6;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[] {2,4,6,8,2,4,1,3};

        int[] array1 = new int[] {1,4,4,1,1};
        //1.
        System.out.println(Arrays.toString(afterLast4(array)));
        //2.
        System.out.println(only1And4(array));
        System.out.println(only1And4(array1));

    }
    /*    1.  Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
     Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
     идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
     иначе в методе необходимо выбросить RuntimeException.
     Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].*/
    public static int[] afterLast4(int[] arr) throws RuntimeException {
        int n = 0;
        String str = Arrays.toString(arr);
        if (str.contains(String.valueOf(4))) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 4) n = i;
            }
            int[] arr1 = new int[arr.length - n - 1];
            System.arraycopy(arr, n + 1, arr1, 0, arr1.length);
            return arr1;
        } else {
            throw new RuntimeException("4 не найдена");
        }
    }
    /*    2.  Написать метод, который проверяет состав массива из чисел 1 и 4.
    Если в нем нет хоть одной четверки или единицы, то метод вернет false;
    Написать набор тестов для этого метода (по 3-4 варианта входных данных).*/

    public static boolean only1And4(int[] arr) {
        boolean i1 = false, i4 = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) i1 = true;
            else if (arr[i] == 4) i4 = true;
            else return false;
        }
        return i1 && i4;
    }

}


