package gui;

import businesslogic.SimulationManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class Controller implements Runnable, ActionListener {

    private final View view;

    public Controller(View v){
        this.view = v;
    }

    public static boolean isNumeric(String string){
        int intValue;

        if(string == null || string.equals("")) {
            return false;
        }
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {

        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        int N;
        int Q;
        int minArrivalTime;
        int maxArrivalTime;
        int minServiceTime;
        int maxServiceTime;
        int simulationTime;

        switch (command) {
            case "START" -> {
                boolean ok = true;
                boolean okNumber = true;

                if (view.getNumberOfClientsText().getText().equals("") ||
                        view.getNumberOfQueuesText().getText().equals("") ||
                        view.getMinArrivalTimeText().getText().equals("") ||
                        view.getMaxArrivalTimeText().getText().equals("") ||
                        view.getMinServiceTimeText().getText().equals("") ||
                        view.getMaxServiceTimeText().getText().equals("") ||
                        view.getSimulationTimeText().getText().equals("")) {
                    showMessageDialog(null, """
                            Please make sure to complete all the input fields
                            before starting the simulation.""");
                    ok = false;
                }
                else if (!isNumeric(view.getNumberOfClientsText().getText()) ||
                        !isNumeric(view.getNumberOfQueuesText().getText()) ||
                        !isNumeric(view.getMinArrivalTimeText().getText()) ||
                        !isNumeric(view.getMaxArrivalTimeText().getText()) ||
                        !isNumeric(view.getMinServiceTimeText().getText()) ||
                        !isNumeric(view.getMaxServiceTimeText().getText()) ||
                        !isNumeric(view.getSimulationTimeText().getText())) {
                    showMessageDialog(null, """
                            Please make sure that the values given
                            as inputs are numbers.""");
                    okNumber = false;
                }
                if(ok && okNumber){
                    N = Integer.parseInt(view.getNumberOfClientsText().getText());
                    Q = Integer.parseInt(view.getNumberOfQueuesText().getText());
                    minArrivalTime = Integer.parseInt(view.getMinArrivalTimeText().getText());
                    maxArrivalTime = Integer.parseInt(view.getMaxArrivalTimeText().getText());
                    minServiceTime = Integer.parseInt(view.getMinServiceTimeText().getText());
                    maxServiceTime = Integer.parseInt(view.getMaxServiceTimeText().getText());
                    simulationTime = Integer.parseInt(view.getSimulationTimeText().getText());

                    JFrame frame = new SimulationFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();

                    SimulationManager simulationManager = new SimulationManager(simulationTime,maxServiceTime,minServiceTime,Q,N,maxArrivalTime,minArrivalTime);
                    Thread thread = new Thread(simulationManager);
                    thread.start();
                }
            }
            case "HELP" -> System.out.println("am apasat pe help");
        }

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
