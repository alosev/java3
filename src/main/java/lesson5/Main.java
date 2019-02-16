package lesson5;

import lesson5.models.*;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Начало соревнований!!!");
        Race race = new Race();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Начало подготовки трассы!!!");
        race.addStage(new Road(60), new Tunnel(80), new Road(40), new Road(60), new Tunnel(20), new Road(10));
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Завершение подготовки трассы!!!");

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Начало регистрации участников!!!");
        for (int i = 1; i < 5; i++) {
            race.addCar(new Car("Участник #" + i, 20 + (int) (Math.random() * 10)));
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Завершение регистрации участников!!!");

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Все готовы!!!");

        race.run();
        race.run();
        race.run();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Соревнования завершены!!!");
    }
}
