package cs2030.simulator;
import java.util.Comparator;


public class TimeComparator implements Comparator<Event> {

    public int compare(Event e1, Event e2)  {
        if (e1.getTime() < e2.getTime()) {
            return -1;
        } else if (e1.getTime() > e2.getTime()) {
            return 1;
        } else {
            if(e1.getCustomer().getid() < e2.getCustomer().getid())
        {
            return e1.getCustomer().getid()-e2.getCustomer().getid();
        } else if(e1.getCustomer().getid() > e2.getCustomer().getid()){
            return e1.getCustomer().getid()-e2.getCustomer().getid();
        }else{
                return e1.toString().compareTo(e2.toString());
            }

    }
}}