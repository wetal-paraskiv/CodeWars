package cs106;

public class PostPreIncrement {
    public void run() {
        int a = 5;
        int b = 5;
        System.out.println("a = 5; b = 5;");
        int x = a++;
        int y = ++b;

        System.out.format("\ny = a++; => y = %1$s - postIncrement\n" +
                          "y = ++b; => y = %2$s preIncrement",
                x, y);
    }
}
