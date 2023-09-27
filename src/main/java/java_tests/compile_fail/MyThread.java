package java_tests.compile_fail;

class MyThread extends Thread {
   /*
   * If a Runnable object is passed to the Thread constructor, then the run method of the Thread class will invoke
   * the run method of the Runnable object. In this case, however, the run method in the Thread class is overridden
   * by the run method in MyThread class. Therefore, the run() method in MyRunnable is never invoked.
   * Both times, the run() method in MyThread is invoked instead.
   * */
   MyThread() {
   }
   MyThread(Runnable r) {
      super(r);
   }

   public void run() {
      System.out.print("Inside Thread ");
   }
}

class MyRunnable implements Runnable {
   public void run() {
      System.out.print("Inside Runnable");
   }
}

class Test {
   public static void main(String[] args) {
      new MyThread().start();
      new MyThread(new MyRunnable()).start();
      new Thread(new MyRunnable()).start();
   }
}