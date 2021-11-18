/** 
 *  A simple worker class to be used in a java threading demo.
 * 
 *  @author     Henry Campbell
 */

package Threads;

public class Worker extends Thread {
    public void run () {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("getId = " + this.getId() + " name: " + this.getName());
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
