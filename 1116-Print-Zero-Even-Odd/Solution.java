import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    int n;

    Semaphore semaphoreEven, semaphoreOdd, semaphoreZero;

    public ZeroEvenOdd(int n) {
        this.n = n;

        semaphoreEven = new Semaphore(0);
        semaphoreOdd = new Semaphore(0);
        semaphoreZero = new Semaphore(1);
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        boolean printOdd = true;

        for (int i = 0; i < n; i++) {
            semaphoreZero.acquire();
            printNumber.accept(0);

            if (printOdd)
                semaphoreOdd.release();
            else
                semaphoreEven.release();

            printOdd = !printOdd;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int even = 2;

        for (int i = 0; i < n / 2; i++) {
            semaphoreEven.acquire();
            printNumber.accept(even);
            even += 2;
            semaphoreZero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int odd = 1;

        for (int i = 0; i < Math.ceil(n / 2); i++) {
            semaphoreOdd.acquire();
            printNumber.accept(odd);
            odd += 2;
            semaphoreZero.release();
        }
    }
}
