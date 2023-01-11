package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ArraysTask2 { ////task2
    //Создать список ArrayList(динамический массив), заполнить строками, вводимыми пользователем через консоль (до 10 штук).
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 10 строк : ");
        for (int i = 0; i < 10; i++) {
            arrayList.add(scanner.nextLine());
        }
        System.out.println(arrayList);
        // Вывести в консоль строку, содержащую заглавную букву
        for (String word : arrayList) {
            if (Character.isUpperCase(word.charAt(0))) {
                System.out.println("Заглавная буква в слове " + word);
            }
        }
        //Найти наименьшую и наибольшую по длине строку в списке
        String smallest = arrayList.get(0);
        String greatest = arrayList.get(0);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).length() < smallest.length()) {
                smallest = arrayList.get(i);
            }
            if (arrayList.get(i).length() > greatest.length()) {
                greatest = arrayList.get(i);
            }
        }
        System.out.println("Наименьшая по длине строка в списке : " + smallest );
        System.out.println("Наибольшая по длине строка в списке : " + greatest);
        arrayList.remove(smallest);//Удалить из списка наименьшую и наибольшую строки
        arrayList.remove(greatest);
        //Вывести содержимое списка в консоль++
        System.out.println(arrayList);
    }


}