package prot;

import java.io.*;
import java.util.Random;


public class Solution {
    public static String[] products = {"onions", "eggs", "tomatoes", "walnuts", "parsley", "garlic", "peppers", "cucumber",
            "cabbage", "mushrooms", "beetroot", "potatoes", "lettuce", "corn", "white wine", "olives", "oranges", "radish",
            "bananas", "pineapple rings", "grapefruit", "canned peas", "carrots", "rice", "ham", "melon", "peaches", "apples",
            "boiled chicken", "cheese", "cooked beef", "tuna fish"};

    public static String[] dressing = {"olive oil", "mustard", "vinegar", "salt", "pepper", "lemon juice", "mayonnaise", "sugar",
            "cognac", "lemon", "ketchup", "yogurt", "double cream", "sour cream", "honey", "soy sauce"};

    public static String[] actions = {"slice", "add", "wash and drain", "peel", "cut", "fry", "mix with",
    "sprinkle with", "decorate with", "cut into cubes", "cut", "shred", "season with", "place"};



    public static void main(String[] args) {
        int am_of_ing = rand(2,5);
        int am_of_dre = rand(2,5);

        String[] ingr = ing(am_of_ing, products);
        String[] dres = ing(am_of_dre, dressing);
        String[] act = ing(am_of_ing, actions);

        for (int i = 0; i < am_of_ing; i++) {
            System.out.println(act[i] + " " + ingr[i]);
        }
        System.out.println("\n***\n");
        for (int i = 0; i < am_of_dre; i++) {
            System.out.println(dres[i]);
        }
    }

    public static String[] ing (int amount, String[] prod) {
        String[] ingredients = new String[amount];
        tas(prod);
        for (int i = 0; i < amount; i++) {
            ingredients[i] = prod[i];
        }
        return ingredients;
    }

    public static void tas (String[] arr) {
        int max = arr.length;
        for (int i = 0; i < max; i++) {
            int m = new Random().nextInt(max - i) + i;
            String temp = arr[i];
            arr[i] = arr[m];
            arr[m] = temp;

        }
    }

    public static int rand(int min, int max) {
        return (int) (Math.random() * (max-1)) + min;
    }
}
