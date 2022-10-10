package businesslogic;

import gui.SimulationFrame;
import model.Client;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.IntStream;

public class SimulationManager implements Runnable {

    private final int timeLimit; // read from UI
    private final int maxProcessingTime;
    private final int minProcessingTime;
    private final int numberOfQueues;
    private final int numberOfClients;
    private final int maxArrivalTime;
    private final int minArrivalTime;

    private final Scheduler scheduler;
    private ArrayList<Client> generatedClients;

    public SimulationManager(int timeLimit,
                             int maxProcessingTime,
                             int minProcessingTime,
                             int numberOfQueues,
                             int numberOfClients,
                             int maxArrivalTime,
                             int minArrivalTime) {
        this.timeLimit = timeLimit;
        this.maxProcessingTime = maxProcessingTime;
        this.minProcessingTime = minProcessingTime;
        this.numberOfQueues = numberOfQueues;
        this.numberOfClients = numberOfClients;
        this.maxArrivalTime = maxArrivalTime;
        this.minArrivalTime = minArrivalTime;

        generateNRandomClients();
        this.scheduler = new Scheduler(numberOfQueues);
    }

    private void generateNRandomClients(){
        generatedClients = new ArrayList<>();
        IntStream.range(0, numberOfClients).forEach(i -> {
            Random random = new Random();
            this.generatedClients.add(new Client(i + 1, random.nextInt(minArrivalTime, maxArrivalTime) + 1, random.nextInt(minProcessingTime, maxProcessingTime) + 1));
        });
        generatedClients.sort(Comparator.comparing(Client::getArrivalTime)); //sort by arrival time
    }

    public void showWaitingClients(SimulationFrame simulationFrame){
        simulationFrame.addStringToTextArea(">>>>Waiting clients:\n");
        for (Client client : generatedClients) {
            simulationFrame.addStringToTextArea(client.toString()+"\n");
        }
    }

    public void writeToFile(String string){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("logs.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        SimulationFrame simulationFrame = new SimulationFrame();
        int currentTime = 0;
        simulationFrame.addStringToTextArea("SIMULATION STARTED WITH " + numberOfClients+ " CLIENTS and "+ numberOfQueues+" QUEUES.\n\n\n");
        while (currentTime<=timeLimit){
            Iterator<Client> clientIterator = generatedClients.iterator();
            while(clientIterator.hasNext()){
                Client client = clientIterator.next();
                if(client.getArrivalTime()==currentTime){
                    scheduler.dispatchClient(client);
                    clientIterator.remove();
                }
            }
            simulationFrame.addStringToTextArea("\n>>>>>>>>>>>"+currentTime + " SECONDS\n");
            showWaitingClients(simulationFrame);
            scheduler.showClientQueues(simulationFrame);
            currentTime++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        simulationFrame.addStringToTextArea("SIMULATION ENDED.\n\n");
        writeToFile(simulationFrame.getTextArea().getText());
    }
}
