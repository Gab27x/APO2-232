public class Main {
    public static void main(String[] args) {

        Main m = new Main();

        // Thread thread = new Thread(Main::print);
        // thread.start();

        // Thread thread2 = new Thread(Main::print);
        // thread2.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Thread: " + i);
            new Thread(Main::print).start();
        }

    }

    public static synchronized void print(){
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}