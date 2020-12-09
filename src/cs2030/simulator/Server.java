package cs2030.simulator;

public class Server {
    private final int identifier;
    private final boolean isAvailable;
    private final boolean hasWaitingCustomer;
    private final double nextAvailableTime;
    private final int currentLength;


    public boolean isAvailable() {
        return isAvailable;
    }

    Server(int identifier, boolean isAvailable, boolean hasWaitingCustomer, double nextAvailableTime,int currentLength){
        this.identifier = identifier;
        this.isAvailable = isAvailable;
        this.hasWaitingCustomer = hasWaitingCustomer;
        this.nextAvailableTime = nextAvailableTime;
        this.currentLength = currentLength;

    }
    Server(int identifier, boolean isAvailable, boolean hasWaitingCustomer, double nextAvailableTime){
        this.identifier = identifier;
        this.isAvailable = isAvailable;
        this.hasWaitingCustomer = hasWaitingCustomer;
        this.nextAvailableTime = nextAvailableTime;
        if(hasWaitingCustomer){
        this.currentLength = 1;}
        else{
            this.currentLength = 0;
        }


    }
//    public void setisAvailable(boolean status){
//        this.isAvailable = status;
//    }
//    public void sethasWaitingCustomer(boolean status){
//        this.hasWaitingCustomer = status;
//    }
    public static  Server newServer(int identifier, boolean isAvailable, boolean hasWaitingCustomer, double nextAvailableTime,int currentLength){
        return new Server(identifier,isAvailable, hasWaitingCustomer, nextAvailableTime,currentLength);
    }
    public int getCurrentLength() {
        return currentLength;
    }
    public boolean gethasWaitingCustomer(){return this.hasWaitingCustomer;}
    public double getnextAvailableTime(){return this.nextAvailableTime;}
    public boolean getisAvailable(){return this.isAvailable;}
    public int getidentifier(){return this.identifier;}

    public boolean hasVacancy(int maxLength){
        return this.getCurrentLength()<maxLength ;
    }

    @Override
    public boolean equals(Object server) {
        if (this == server) {
            return true;
        } else if (server instanceof Server) {
            Server otherServer = (Server)server;
            return this.getidentifier() == otherServer.getidentifier();
        } else {
            return false;
        }
    }
    public String toString(){
        if(this.isAvailable){
            return this.identifier + " is available";
        }
        if(!isAvailable && !hasWaitingCustomer){
            return this.identifier + " is busy; available at " + String.format("%.3f",this.nextAvailableTime);
        }
        if(!isAvailable && hasWaitingCustomer){
            return this.identifier + " is busy; waiting customer to be served at " + String.format("%.3f",this.nextAvailableTime);
        }
        else return "error";

    }
}
