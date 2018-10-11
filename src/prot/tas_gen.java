package prot;

import java.util.Random;

public class tas_gen {
    public static int[] numbers = {1, 2, 3, 4, 5,6 ,7, 8, 9, 10};
    public static void main(String[] args) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        for (int j = 0; j < 10; j++) {
            System.out.println("");
            tas(numbers);
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i] + " ");
            }


        }
    }

    public static void tas (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
           // int m = ((int) (Math.random() * (arr.length - 1)) + i);
            int m = new Random().nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[m];
            arr[m] = temp;

        }
    }
/*
    public static int rand(int min, int max) {
        return (int) (Math.random() * ++max) + min;
    }
    */
}
