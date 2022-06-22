import java.util.concurrent.Semaphore;

class FooBar {
  private int number;

  Semaphore semaphore1 = new Semaphore(0);
  Semaphore semaphore2 = new Semaphore(1);

  public FooBar(int number) {
    this.number = number;
  }

  public void foo(Runnable printFoo) throws InterruptedException {
    for (int i = 0; i < number; i++) {
      semaphore2.acquire();

      printFoo.run();

      semaphore1.release();
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {
    for (int i = 0; i < number; i++) {
      semaphore1.acquire();

      printBar.run();

      semaphore2.release();
    }
  }
}
