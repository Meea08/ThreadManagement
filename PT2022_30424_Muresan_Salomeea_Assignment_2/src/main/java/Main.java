import gui.View;
import javax.swing.*;

public class Main implements Runnable{
    public static void main(String[] args){
        JFrame frame = new View("Queue Manager by Salomeea Muresan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }
    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }
}
