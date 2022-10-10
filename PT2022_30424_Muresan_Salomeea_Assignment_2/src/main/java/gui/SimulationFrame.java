package gui;

import javax.swing.*;
import java.awt.*;

public class SimulationFrame extends JFrame{
    private JTextArea textArea;
    private JFrame frame;

    public SimulationFrame(){
        frame = new JFrame();
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        prepareSimulationFrame();
    }
    public void prepareSimulationFrame(){
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setAutoscrolls(true);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        frame.add(scrollPane);
    }
    public void addStringToTextArea(String string){
        textArea.append(string);
    }

    public javax.swing.JTextArea getTextArea() {
        return textArea;
    }
}
