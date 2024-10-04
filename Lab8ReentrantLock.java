import java.util.concurrent.locks.ReentrantLock;

public class Lab8ReentrantLock {

    private static int counter = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        int n = Integer.parseInt(args[0]);  // Количество инкрементирующих потоков
        int m = Integer.parseInt(args[1]);  // Количество декрементирующих потоков
        int iterations = 100000;  // Количество итераций

        Thread[] incrementThreads = new Thread[n];
        Thread[] decrementThreads = new Thread[m];

        long startTime = System.currentTimeMillis();

        // Создаем инкрементирующие потоки
        for (int i = 0; i < n; i++) {
            incrementThreads[i] = new Thread(() -> {
                for (int j = 0; j < iterations; j++) {
                    lock.lock();
                    try {
                        counter++;
                    } finally {
                        lock.unlock();
                    }
                }
            });
            incrementThreads[i].start();
        }

        // Создаем декрементирующие потоки
        for (int i = 0; i < m; i++) {
            decrementThreads[i] = new Thread(() -> {
                for (int j = 0; j < iterations; j++) {
                    lock.lock();
                    try {
                        counter--;
                    } finally {
                        lock.unlock();
                    }
                }
            });
            decrementThreads[i].start();
        }

        // Ожидаем завершения всех потоков
        for (Thread t : incrementThreads) {
            t.join();
        }
        for (Thread t : decrementThreads) {
            t.join();
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        // Вывод результата в консоль
        System.out.println("Итоговое значение счетчика: " + counter);
        System.out.println("Время выполнения: " + duration + " мс");

        // Принудительный вывод данных
        System.out.flush();
    }
}
