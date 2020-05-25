package homework4;

public class Main {

    private final Object mon = new Object();
    private static volatile char ch = 'A';

    public static void main(String[] args) {
        Main m = new Main();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m.writeA();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                m.writeB();
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                m.writeC();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

    public void writeA () {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (ch != 'A') {
                        mon.wait();
                    }
                    System.out.print("A");
                    ch = 'B';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeB () {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (ch != 'B') {
                        mon.wait();
                    }
                    System.out.print("B");
                    ch = 'C';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeC () {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (ch != 'C') {
                        mon.wait();
                    }
                    System.out.print("C");
                    ch = 'A';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
