package lesson1;

import lesson1.model.Apple;
import lesson1.model.Orange;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        run();
        System.out.println("====================================================");
        runBox();
    }

    private static void run() {
        Sample<Integer> sampleInt = new Sample<Integer>();
        Sample<String> sampleString = new Sample<String>();

        Integer[] objInt = {1,2,3,4};
        String[] objString = {"dfff", "dadas", "wrre", "lkklqq"};

        // перестановка
        Integer[] retInt = sampleInt.swapArrayElements(objInt);
        String[] retString = sampleString.swapArrayElements(objString);

        // преобразование в ArrayList
        ArrayList<Integer> listInt = sampleInt.convertToList(retInt);
        ArrayList<String> listString = sampleString.convertToList(retString);

        System.out.println(listInt);
        System.out.println(listString);
    }

    private static void runBox(){
        // инициализируем коробки
        Box<Apple> boxAppleOne = new Box<Apple>("Яблоки", new Apple(), new Apple(), new Apple(), new Apple(), new Apple(), new Apple());
        Box<Apple> boxAppleTwo = new Box<Apple>("Яблоки", new Apple(), new Apple(), new Apple());
        Box<Orange> boxOrange = new Box<Orange>("Апельсины", new Orange(), new Orange(), new Orange(), new Orange(), new Orange(), new Orange());

        // выводим информацию
        printBox(boxAppleOne, boxAppleTwo, boxOrange);

        // сравниваем
        System.out.println(boxAppleOne.compare(boxAppleTwo));
        System.out.println(boxAppleOne.compare(boxOrange));

        // пересыпаем
        boxAppleOne.outBox(boxAppleTwo);
        //boxAppleTwo.outBox(boxOrange); // Ошибка

        printBox(boxAppleOne, boxAppleTwo, boxOrange);

        System.out.println(boxAppleTwo.compare(boxOrange));

        // добавляем фрукты
        boxAppleOne.add(new Apple());
        boxAppleOne.add(new Apple());
        //boxAppleOne.add(new Orange()); //Ошибка

        printBox(boxAppleOne, boxAppleTwo, boxOrange);
    }

    private static void printBox(Box... boxes){
        for (Box box: boxes) {
            System.out.println(String.format("Коробка: {%s}, Вес: {%f}", box.getName(), box.getWeight()) );
        }
    }

}


