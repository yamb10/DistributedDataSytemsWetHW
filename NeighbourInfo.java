public class NeighbourInfo
{
    private int name;
    private String ip;
    private int udpPort;
    private int tcpPort;
    private int edgeWeight;

    public NeighbourInfo(int name, String ip, int udpPort, int tcpPort, int edgeWeight)
    {
        this.name = name;
        this.ip = ip;
        this.udpPort = udpPort;
        this.tcpPort = tcpPort;
        this.edgeWeight = edgeWeight;
    }
}
