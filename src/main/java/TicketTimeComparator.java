import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        if (Math.abs(o1.getTimeFrom() - o1.getTimeTo()) > Math.abs(o2.getTimeFrom() - o2.getTimeTo())){
            return 1;
        } else if (Math.abs(o1.getTimeFrom() - o1.getTimeTo()) < Math.abs(o2.getTimeFrom() - o2.getTimeTo())) {
            return -1;
        } else {
            return 0;
        }
    }
}
