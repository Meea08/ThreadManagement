package businesslogic;

import gui.SimulationFrame;
import model.Client;
import model.ClientsQueue;

import java.util.ArrayList;

public class Scheduler {
    private ArrayList<ClientsQueue> clientsQueueList = new ArrayList<>();

    public Scheduler(int maxNoQueues){
        for(int i=0;i<maxNoQueues;i++){
            ClientsQueue clientsQueue = new ClientsQueue(i+1);
            clientsQueueList.add(clientsQueue);
            Thread thread = new Thread(clientsQueue);
            thread.start();
        }
    }

    public ClientsQueue findMinimum(){
        ClientsQueue clientsQueue = clientsQueueList.get(0);
        int mini = clientsQueue.getWaitingTime();
        for (ClientsQueue queue : clientsQueueList) {
            if (queue.getWaitingTime() < mini) {
                mini = queue.getWaitingTime();
                clientsQueue = queue;
            }
        }
        return clientsQueue;
    }

    public void dispatchClient(Client client){
        ClientsQueue clientsQueue = this.findMinimum();
        clientsQueue.addClientToQueue(client);
    }

    public void showClientQueues(SimulationFrame simulationFrame){
        for (ClientsQueue clientsQueue : clientsQueueList) {
            if (clientsQueue.getClientBlockingQueue().size() == 0) {
                simulationFrame.addStringToTextArea(">>>>Queue " + clientsQueue.getID() + " is empty\n");
            } else {
                simulationFrame.addStringToTextArea(">>>>Queue " + clientsQueue.getID() + " has clients:\n");
                Client[] clients = clientsQueue.getClientBlockingQueue().toArray(new Client[0]);
                for (Client client : clients) {
                    simulationFrame.addStringToTextArea(client+"\n");
                }
            }
        }
    }
}
