package model;

public class Client {
    private final int ID; // from 1 to N
    private int arrivalTime;
    private int serviceTime;

    public Client(int id, int arrivalTime, int serviceTime){
        this.ID = id;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     * @apiNote In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * The string output is not necessarily stable over time or across
     * JVM invocations.
     * @implSpec The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     */
    @Override
    public String toString() {
        return "Client "+ this.ID +
                " -- arrival time: " + this.arrivalTime +
                " -- service time: "+this.serviceTime;
    }
    public int getArrivalTime(){
        return arrivalTime;
    }
    public int getServiceTime(){
        return serviceTime;
    }
    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }
}
