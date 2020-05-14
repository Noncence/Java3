
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4, 5};
        String[] array2 = {"a", "b", "c", "d", "e"};
    //1
        change(array1, 2,4);
        change(array2, 3,1);
    //2
        transform(array1);
        transform(array2);

        System.out.println("Получение списка: " + transform(array1).getClass());
        System.out.println("Получение списка: " + transform(array2).getClass());
    //3
        Box<Apple> boxA1 = new Box<>();
        Box<Apple> boxA2 = new Box<>();
        Box<Orange> boxO1 = new Box<>();
        Box<Orange> boxO2 = new Box<>();

        boxA1.addFruit(new Apple(), 8);
        boxA2.addFruit(new Apple(), 5);
        System.out.println("Weight boxA1: " + boxA1.getWeight());
        System.out.println("Weight boxA2: " + boxA2.getWeight());

        boxO1.addFruit(new Orange(), 3);
        boxO2.addFruit(new Orange(), 9);
        System.out.println("Weight boxO1: " + boxO1.getWeight());
        System.out.println("Weight boxO2: " + boxO2.getWeight());

        System.out.println("Весовое сравнение : " + boxA1.compare(boxA2));
        boxA2.intersperse(boxA1);

        System.out.println("Вес boxA1 после пересыпки: " + boxA1.getWeight() + ", boxA2 = " + boxA2.getWeight());


    }
    //1 - замена элементов
    public static void change (Object[] array, int n1, int n2){
        if (n1 > array.length - 1 || n2 > array.length - 1) {
            System.out.println("Один из элементов за пределами массива");
        } else {
            Object temp = array[n1];
            array[n1] = array[n2];
            array[n2] = temp;
            System.out.println(Arrays.toString(array));
        }
    }
    //2 - преобразование в ArrayList
    public static <T> ArrayList<T> transform(T[] array){
        return  new ArrayList<T>(Arrays.asList(array));
    }
}