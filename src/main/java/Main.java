import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int quantityPersons = getQuantityPersons();

        ArrayList<Good> goodList = getGoodList();

        Calculator calculator = new Calculator();
        float sum = calculator.getSum(goodList);
        float sumForPerson = calculator.getSumForPerson(quantityPersons, sum);
        String goodListString = getGoodListString(goodList);

        System.out.println(goodListString);
        System.out.println("Количество человек: " + quantityPersons);
        System.out.println("Cумма: " + sum + " руб.");
        System.out.println("Сумма на человека: " + sumForPerson + " руб.");


    }

    public static int getQuantityPersons() {
        Scanner scanner = new Scanner(System.in);

        int quantityPersons;

        while(true) {
            System.out.println("На сколько человек разделить счет?");

            if (scanner.hasNextInt()) {
                quantityPersons = scanner.nextInt();
                if(quantityPersons <= 0) {
                    System.out.println("Некорректное значение.");
                } else if (quantityPersons == 1) {
                    System.out.println("Нечего делить!");
                } else {
                    break;
                }
            } else {
                System.out.println("Введите число.");
                scanner.next();
            }
        }
        return quantityPersons;
    }
    public static ArrayList<Good> getGoodList() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Good> goodList = new ArrayList<>();
        int position = 0;
        while(true) {
            if(position == 0) {
                System.out.println("Введите наименование товара.");
            } else {
                System.out.println("Введите наименование товара или команду Завершить.");
            }

            String goodName = scanner.next();
            if(goodName.equalsIgnoreCase("Завершить")){
                break;
            } else {
                System.out.println("Введите стоимость товара.");
                while(scanner.hasNext()){
                    if(scanner.hasNextFloat()){
                        float goodPrice = scanner.nextFloat();
                        if(goodPrice <= 0){
                            System.out.println("Стоимость товара не может быть отрицательной или равна нулю.");
                        } else {
                            Good good = new Good(goodName, goodPrice);
                            goodList.add(good);
                            System.out.println("Товар " + goodName + " успешно добавлен.");
                            position++;
                            break;
                        }
                    } else {
                        System.out.println("Стоимость - целое число или число с запятой.");
                        scanner.next();
                    }
                }
            }
        }

        float sum = 0;
        Iterator iterator = goodList.iterator();

        while(iterator.hasNext()){
           Good good = (Good) iterator.next();
           sum = sum + good.price;
        }
        return goodList;
    }

    public static String getGoodListString(ArrayList<Good> goodL) {
        ArrayList<Good> goodList = goodL;
        String goodListString = new String("");
        Iterator iterator = goodList.iterator();

        while(iterator.hasNext()){
            Good good = (Good) iterator.next();
            goodListString = goodListString + "\n" +good.name;
        }

        goodListString = "Добавленные товары:" + goodListString;
        return goodListString;
    }

    public static class Calculator {
        ArrayList<Good> goodList = new ArrayList<>();

        float sum = 0;
        int quantityPersons;

        float getSum(ArrayList<Good> goodList) {

            this.goodList = goodList;
            Iterator iterator = goodList.iterator();

            while(iterator.hasNext()){
                Good good = (Good) iterator.next();
                sum = sum + good.price;
            }
            return sum;
        }

        float getSumForPerson(int quantityPersons, float sum) {
            this.sum = sum;
            this.quantityPersons = quantityPersons;
            float sumForPerson = sum / quantityPersons;
            return sumForPerson;
        }

       /*

            System.out.println(String.format("Каждый должен заплатить " + f%.2f + " р.", sumForPerson));
*/

    }


    public static class Good {
        String name;
        float price;
        Good(String name, float price){
            this.name = name;
            this.price = price;
        }
    }

    public static class Formater {

    }


}

