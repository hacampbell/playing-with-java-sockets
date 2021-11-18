/** 
 *  A simple demo of threading in java. This was made just so i've got a basic
 *  reference point to go from moving forward towards a multi client server.
 * 
 *  @author     Henry Campbell
 */

package Threads; 

public class Main {
    public static void main (String[] args) {
        try {
            for (int i = 0; i < 5; i++) {
                Worker worker = new Worker();
                worker.start();
            }
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            System.out.println(e.toString());
        }
    }
}
