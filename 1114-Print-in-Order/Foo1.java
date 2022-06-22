import java.util.concurrent.Semaphore;

class Foo1 {
  Semaphore run2;
  Semaphore run3;

  public Foo1() {
    run2 = new Semaphore(0);
    run3 = new Semaphore(0);
  }

  public void first(Runnable printFirst) throws InterruptedException {
    printFirst.run();

    run2.release();
  }

  public void second(Runnable printSecond) throws InterruptedException {
    run2.acquire();

    printSecond.run();

    run3.release();
  }

  public void third(Runnable printThird) throws InterruptedException {
    run3.acquire();

    printThird.run();
  }
}
