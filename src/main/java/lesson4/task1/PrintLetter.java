package lesson4.task1;

public class PrintLetter {
    public static Object lock = new Object();
    private String letter = "A";

    public static void main(String[] args) {
        PrintLetter printLetter = new PrintLetter();

        Thread t1 = new Thread(() -> printLetter.PrintA());
        t1.start();

        Thread t2 = new Thread(() -> printLetter.PrintB());
        t2.start();

        Thread t3 = new Thread(() -> printLetter.PrintC());
        t3.start();

    }

    public void PrintA(){
        synchronized (lock){
            try {
                for (int i = 0; i < 5; i++){
                    while (!letter.equals("A")){
                        lock.wait();
                    }
                    System.out.println("A");
                    letter = "B";
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void PrintB(){
        synchronized (lock){
            try {
                for (int i = 0; i < 5; i++){
                    while (!letter.equals("B")){
                        lock.wait();
                    }
                    System.out.println("B");
                    letter = "C";
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void PrintC(){
        synchronized (lock){
            try {
                for (int i = 0; i < 5; i++){
                    while (!letter.equals("C")){
                        lock.wait();
                    }
                    System.out.println("C");
                    letter = "A";
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
