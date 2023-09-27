package java_tests.compile_fail;

class MyThread1 extends Thread {
   /*
   * When the start() method is attempted a second time on a single Thread object, the method will throw an IllegalThreadStateException
   * Even if the thread has finished running, it is still illegal to call start() again.
   * */
   public static void main(String[] args) {
      MyThread1 t = new MyThread1();
      t.start();
      System.out.print("one. ");
      t.start();
      System.out.print("two. ");
   }

   public void run() {
      System.out.print("Thread ");
   }
}
