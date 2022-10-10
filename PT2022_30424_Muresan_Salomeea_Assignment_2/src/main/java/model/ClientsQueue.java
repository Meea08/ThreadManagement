package model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientsQueue implements Runnable {
    private final int ID;
    private BlockingQueue<Client> clientBlockingQueue;
    private AtomicInteger waitingTime;

    public ClientsQueue(int ID) {
        this.ID = ID;
        this.clientBlockingQueue = new LinkedBlockingQueue<>();
        this.waitingTime = new AtomicInteger(0);
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

        try {
            while(true) {
                if (this.clientBlockingQueue.size() > 0) {
                    Client clientBeingServed = clientBlockingQueue.element();
                    while (clientBeingServed.getServiceTime() > 0) {
                        Thread.sleep(1000); // 1 sec
                        clientBeingServed.setServiceTime(clientBeingServed.getServiceTime() - 1);
                    }
                    clientBlockingQueue.take();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getID() {
        return ID;
    }

    public int getWaitingTime() {
        return waitingTime.get();
    }

    public void addClientToQueue(Client client){
        try {
            clientBlockingQueue.put(client);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.waitingTime.addAndGet(client.getServiceTime());
    }

    public BlockingQueue<Client> getClientBlockingQueue() {
        return clientBlockingQueue;
    }
}
