import java.io.*;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.net.UnknownHostException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.util.*;

public class Router extends Thread
{
    private int name;
    private int networkSize;
    private String forwardingFilePrefix;
    private String tableFilePrefix;
    private int udpPort;
    private int tcpPort;
    private int diameterUpperBound;

    private ArrayList<NeighbourInfo> neighbourInfos;

    private Hashtable<Integer, TableEntry> routingTable;  // todo - check whether we should save all rounds or only the last one
    /**
     *
     * @param name - int ranging from 1 to network size
     * @param inputFilePrefix
     * @param tableFilePrefix
     * @param forwardingFilePrefix
     */
    public Router(int name, String inputFilePrefix, String tableFilePrefix, String
            forwardingFilePrefix)
    {
        File inputFile = new File(inputFilePrefix + String.valueOf(name) + ".txt");
        Scanner myReader;
        neighbourInfos = new ArrayList<NeighbourInfo>();
        try
        {
            myReader = new Scanner(inputFile);
            udpPort = myReader.nextInt();
            tcpPort = myReader.nextInt();
            networkSize = myReader.nextInt();

            //lines 4-8
            String line = myReader.next();
            while (!line.equals("*"))
            {
//                System.out.println(inputFile.getAbsolutePath());
                int neighbourName = Integer.parseInt(line);
                String neighbourIP = myReader.next();
                int neighUdpPort = myReader.nextInt();
                int neighTcpPort = myReader.nextInt();
                int edgeWeight = myReader.nextInt();

                NeighbourInfo neigh = new NeighbourInfo(neighbourName, neighbourIP, neighUdpPort, neighTcpPort, edgeWeight);
                neighbourInfos.add(neigh);

                line = myReader.next();
            }

            diameterUpperBound = myReader.nextInt();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("error - input file not found");
            e.printStackTrace();
        }
    }
}
