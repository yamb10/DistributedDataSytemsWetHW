public class RoutingTableEntryForSelf implements TableEntry
{
    private int distance;
    private String next;

    public RoutingTableEntryForSelf()
    {
        distance = 0;
        next = "None";
    }

    public String toString() {return "0;None";}

    public int getDistance() {
        return distance;
    }

    public String getNext() {
        return next;
    }
}
