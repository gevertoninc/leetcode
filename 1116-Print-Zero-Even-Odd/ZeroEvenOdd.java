import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
  int number;

  Semaphore semaphoreEven;

  Semaphore semaphoreOdd;

  Semaphore semaphoreZero;

  public ZeroEvenOdd(int number) {
    this.number = number;

    semaphoreEven = new Semaphore(0);
    semaphoreOdd = new Semaphore(0);
    semaphoreZero = new Semaphore(1);
  }

  public void zero(IntConsumer printNumber) throws InterruptedException {
    boolean printOdd = true;

    for (int i = 0; i < number; i++) {
      semaphoreZero.acquire();
      printNumber.accept(0);

      if (printOdd) {
        semaphoreOdd.release();
      } else {
        semaphoreEven.release();
      }

      printOdd = !printOdd;
    }
  }

  public void even(IntConsumer printNumber) throws InterruptedException {
    int even = 2;

    for (int i = 0; i < number / 2; i++) {
      semaphoreEven.acquire();
      printNumber.accept(even);
      even += 2;
      semaphoreZero.release();
    }
  }

  public void odd(IntConsumer printNumber) throws InterruptedException {
    int odd = 1;

    for (int i = 0; i < Math.ceil((double) number / 2); i++) {
      semaphoreOdd.acquire();
      printNumber.accept(odd);
      odd += 2;
      semaphoreZero.release();
    }
  }
}
