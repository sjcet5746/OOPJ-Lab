class DisplayThread extends Thread {
    private String message;
    private int interval;

    public DisplayThread(String message, int interval) {
        this.message = message;
        this.interval = interval;
    }

    public void run() {
        while (true) {
            System.out.println(message);
            try {
                Thread.sleep(interval * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main6 {
    public static void main(String[] args) {
        DisplayThread thread1 = new DisplayThread("Good Morning", 1);
        DisplayThread thread2 = new DisplayThread("Hello", 2);
        DisplayThread thread3 = new DisplayThread("Welcome", 3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
