package cs106;

import java.util.Scanner;

public class AddConsoleInputInt {
    Scanner scan = new Scanner(System.in);

    private static final int SENTINEL = 0;
    public double total;

    public void run() {
        while (true) {
            try {
                System.out.println("Enter a number: ");
                double val = scan.nextDouble();
                if (val == SENTINEL) break;
                total += val;
            } catch (Exception e) {
                System.out.println("Enter 0 to stop or provide a valid number: ");
                scan.nextLine(); // advances scanner to next line in case of exception
            }
        }
        System.out.format("The sum is: %.2f%n", total);
        scan.close();
    }
}
