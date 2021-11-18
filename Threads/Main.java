/** 
 *  A simple demo of threading in java. This was made just so i've got a basic
 *  reference point to go from moving forward towards a multi client server.
 * 
 *  @author     Henry Campbell
 */

package Threads;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        /* Example of having an input and output thread */
        Scanner scanner = new Scanner(System.in);

        try {
            String message = "";
            Worker worker = new Worker();
            
            worker.start();

            // There is a race condition on the console output, but for this
            // simple example that's not really a concern
            while (!message.equals("quit")) {
                message = scanner.nextLine();
                System.out.println(message);
            }
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
        } finally {
            scanner.close();
        }

        /* Example of having multiple worker threads */
        // try {
        //     for (int i = 0; i < 5; i++) {
        //         Worker worker = new Worker();
        //         worker.start();
        //     }
        // } catch (Exception e) {
        //     System.out.println("Something went wrong!");
        //     System.out.println(e.toString());
        // }
    }
}
