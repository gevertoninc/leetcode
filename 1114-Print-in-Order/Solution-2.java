class Foo {
    Boolean signal = false;

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();

        signal = true;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (signal != true) {
        }

        printSecond.run();

        signal = null;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (signal != null) {
        }

        printThird.run();
    }
}
