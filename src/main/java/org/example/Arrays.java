package org.example;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.System.out;

public class Arrays {


        //1.3
        //Создать массив, в котором содержатся строки с временами года.
        // При помощи конструкции switch-case сделать вывод в консоль месяцев, соответствующих времени года.
        // Выбор времени года реализовать через псевдорандом Math.
        public static void main(String[] args) {


            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add("Зима");
            arrayList.add("Лето");
            arrayList.add("Осень");
            arrayList.add("Весна");
            int seasonNumber = new Random().nextInt(arrayList.size());
            switch (seasonNumber) {
                case 0:
                    out.println("Декабрь, Январь, Февраль");
                    break;
                case 1:
                    out.println("Март, Апрель, Май");
                    break;
                case 2:
                    out.println("Июнь, Июль, Август");
                    break;
                case 3:
                    out.println("Сентябрь, Октябрь, Ноябрь");
                    break;
                default:
                    out.println("Error!");
            }


            //task1
            //Создать массив Array из 10 элементов, заполнить массив случайными числами используя псевдорандом из Math.
            int[] array1 = new int[10];
            //int[] array2 = new int[10];
            ArrayList<Integer> array2 = new ArrayList<>();
            for (int i = 0; i < array1.length; i++) {
                array1[i] = (int) (Math.random() * 100);
                if (array1[i] % 2 == 0 && array1[i] != 0) { //расчёт нахождения чётных чисел в массиве
                    array2.add(array1[i]);
                }
                System.out.print(array1[i] + "  ");
            }  ////Найти наименьшее и наибольшее число в массиве
            int min = array1[0];
            int max = array1[0];
            for (int i = 1; i < array1.length; i++) {
                if (array1[i] > max)
                    max = array1[i];
                else if (array1[i] < min)
                    min = array1[i];
            }
            System.out.println(" Наибольшее число в массиве : " + max);
            System.out.println("Наименьшее число в массиве " + min);
            //Найти суммы чисел массива
            int sum = 0;
            for (int i : array1) {
                sum += i;
            }

            System.out.println("Сумма чисел массива : " + sum);
            //Вывести содержимое массива с четными числами в консоль
            System.out.println("Чётные числа в масссиве" + array2);
        }
    }

