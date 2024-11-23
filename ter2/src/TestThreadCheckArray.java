import java.util.ArrayList;
import java.util.Scanner;

public class TestThreadCheckArray {
    public static void main(String[] args) {
        SharedData sd;
        String winT;
        long endTh;
        long startT;
        long startTh;
		try (Scanner input = new Scanner(System.in)) {
        	startT = System.currentTimeMillis();
            Thread thread1, thread2;
            System.out.println("Enter array size");

            // Read array size from user
            int arraySize = input.nextInt();
            ArrayList<Integer> array = new ArrayList<>(arraySize);
            System.out.println("Enter numbers for array");

            // Read array elements from user
            for (int index = 0; index < arraySize; index++)
                array.add(input.nextInt());

            System.out.println("Enter number");
            // Read the number to be searched
            int num = input.nextInt();

            // Initialize shared data object
            sd = new SharedData(new ArrayList<>(array), num);
            startTh= System.currentTimeMillis();
            // Create threads for searching the number
            thread1 = new Thread(new ThreadCheckArray(sd), "thread1");
            thread2 = new Thread(new ThreadCheckArray(sd), "thread2");
            

            // Start both threads
            thread1.start();
            thread2.start();
            try {
                // Wait for both threads to complete
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            endTh = System.currentTimeMillis();

            // Determine which thread found the match
            if (sd.getFlag()) {
                winT = thread1.isAlive() ? "thread2" : "thread1";
            } else {
                System.out.println("Sorry");
                return;
            }

            // Print solution details
            System.out.println("Solution for b : " + sd.getB() + ",n = " + sd.getArray().size());
            System.out.print("I:    ");
            for (int index = 0; index < sd.getArray().size(); index++)
                System.out.print(index + "    ");
            System.out.println();
            System.out.print("A:    ");
            for (int index : sd.getArray()) {
                System.out.print(index);
                int counter = 5;
                while (true) {
                    index = index / 10;
                    counter--;
                    if (index == 0)
                        break;
                }
                for (int i = 0; i < counter; i++)
                    System.out.print(" ");
            }
        }

        // Print the result array indicating which indices matched
        System.out.println();
        System.out.print("C:    ");
        for (boolean index : sd.getWinArray()) {
            if (index)
                System.out.print("1    ");
            else
                System.out.print("0    ");
        }
        long endT = System.currentTimeMillis();

        // Print execution times and the winning thread
        System.out.println("\nWinning:" + winT);
        System.out.println("Time " + (endTh- startTh) );
        System.out.println("\nTotal time: "+(endT - startT));
       
    }
}