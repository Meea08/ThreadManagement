package gui;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame{
    private JFrame frame;
    private JTextField numberOfClientsText;
    private JTextField numberOfQueuesText;
    private JTextField minArrivalTimeText;
    private JTextField maxArrivalTimeText;
    private JTextField minServiceTimeText;
    private JTextField maxServiceTimeText;
    private JTextField simulationTimeText;

    gui.Controller controller = new Controller(this);

    public View(String name) {
        frame = new JFrame(name);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850,220);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        this.prepareGui();
    }


    public void prepareGui() {
        JLabel numberOfClientsLabel = new JLabel("Number of clients: ");
        JLabel numberOfQueuesLabel = new JLabel("Number of queues:");
        JLabel minArrivalTimeLabel = new JLabel("Min. arrival time:");
        JLabel maxArrivalTimeLabel = new JLabel("Max. arrival time:");
        JLabel minServiceTimeLabel = new JLabel("Min. service time:");
        JLabel maxServiceTimeLabel = new JLabel("Max. service time:");
        JLabel simulationTimeLabel = new JLabel("Simulation time:");
        JLabel emptyLabel = new JLabel("");

        numberOfClientsText = new JTextField();
        numberOfQueuesText = new JTextField();
        minArrivalTimeText = new JTextField();
        maxArrivalTimeText = new JTextField();
        minServiceTimeText = new JTextField();
        maxServiceTimeText = new JTextField();
        simulationTimeText = new JTextField();

        JButton startButton = new JButton("Start simulation");
        JButton helpButton = new JButton("Help");

        // Add UI element to frame
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(numberOfClientsLabel)
                        .addComponent(numberOfQueuesLabel)
                        .addComponent(minArrivalTimeLabel)
                        .addComponent(minServiceTimeLabel)
                        .addComponent(simulationTimeLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(numberOfClientsText)
                        .addComponent(numberOfQueuesText)
                        .addComponent(minArrivalTimeText)
                        .addComponent(minServiceTimeText)
                        .addComponent(simulationTimeText))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(emptyLabel)
                        .addComponent(emptyLabel)
                        .addComponent(maxArrivalTimeLabel)
                        .addComponent(maxServiceTimeLabel)
                        .addComponent(startButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(emptyLabel)
                        .addComponent(emptyLabel)
                        .addComponent(maxArrivalTimeText)
                        .addComponent(maxServiceTimeText)
                        .addComponent(helpButton)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(numberOfClientsLabel)
                        .addComponent(numberOfClientsText)
                        .addComponent(emptyLabel)
                        .addComponent(emptyLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(numberOfQueuesLabel)
                        .addComponent(numberOfQueuesText)
                        .addComponent(emptyLabel)
                        .addComponent(emptyLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(minArrivalTimeLabel)
                        .addComponent(minArrivalTimeText)
                        .addComponent(maxArrivalTimeLabel)
                        .addComponent(maxArrivalTimeText))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(minServiceTimeLabel)
                        .addComponent(minServiceTimeText)
                        .addComponent(maxServiceTimeLabel)
                        .addComponent(maxServiceTimeText))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(simulationTimeLabel)
                        .addComponent(simulationTimeText)
                        .addComponent(startButton)
                        .addComponent(helpButton)));
        frame.getContentPane().setLayout(layout);

        startButton.setActionCommand("START");
        helpButton.setActionCommand("HELP");

        startButton.addActionListener(this.controller);
        helpButton.addActionListener(this.controller);
        helpButton.setBackground(Color.pink);
    }
    public JTextField getNumberOfClientsText(){
        return numberOfClientsText;
    }
    public JTextField getNumberOfQueuesText(){
        return numberOfQueuesText;
    }
    public JTextField getMinArrivalTimeText(){
        return minArrivalTimeText;
    }
    public JTextField getMaxArrivalTimeText(){
        return maxArrivalTimeText;
    }
    public JTextField getMinServiceTimeText(){
        return minServiceTimeText;
    }
    public JTextField getMaxServiceTimeText(){
        return maxServiceTimeText;
    }
    public JTextField getSimulationTimeText(){
        return simulationTimeText;
    }
}