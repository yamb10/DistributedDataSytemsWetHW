public class RoutingTableEntry implements TableEntry
{
    private int distance;
    private int nextName;

    public RoutingTableEntry(int dist, int name)
    {
        this.distance = dist;
        this.nextName = name;
    }
     @Override
    public String toString()
     {
         StringBuilder out = new StringBuilder();
         out.append(distance);
         out.append(";");
         out.append(nextName);
         return out.toString();
     }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getNextName() {
        return nextName;
    }

    public void setNextName(int nextName) {
        this.nextName = nextName;
    }
}


