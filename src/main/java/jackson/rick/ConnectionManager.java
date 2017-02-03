package jackson.rick;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.net.InetAddress;

/**
 * Created by rickjackson on 2/2/17.
 */
class ConnectionManager{
    private List<Connection> connectionList;
    private static int MAX_CONNECTIONS;
    private int openConnections;
    
    ConnectionManager() {
        this.connectionList = new ArrayList<>();
        this.MAX_CONNECTIONS = 8;
        this.openConnections = 0;
    }
    
    String buildConnection(String ip, int port, String protocol) {
        if (!checkMax()) {
            return "Error: The maximum number of connections has been reached.";
        } else if (!checkIfOpen(ip)) {
            return "Error: This address is no longer available.";
        } else {
            Connection mc = new ManagedConnection(ip, port, protocol);
            mc.connect();
            return "Connected to " + mc.getAddress() + ":" + mc.getPort() + ""
                    + " via " + mc.getProtocol() + ".";
        }
    }
    
    String buildConnection(String ip, int port) {
        if (!checkMax()) {
            return "Error: The maximum number of connections has been reached.";
        } else if (!checkIfOpen(ip)) {
            return "Error: This address is no longer available.";
        } else {
            Connection mc = new ManagedConnection(ip, port);
            mc.connect();
            return "Connected to " + mc.getAddress() + ":" + mc.getPort() + ""
                    + " via " + mc.getProtocol() + ".";
        }
    }
    
    String buildConnection(String ip, String protocol) {
        if (!checkMax()) {
            return "Error: The maximum number of connections has been reached.";
        } else if (!checkIfOpen(ip)) {
            return "Error: This address is no longer available.";
        } else {
            Connection mc = new ManagedConnection(ip, protocol);
            mc.connect();
            return "Connected to " + mc.getAddress() + ":" + mc.getPort() + ""
                    + " via " + mc.getProtocol() + ".";
        }
    }
    
    Connection getConnectionByAddress(String ip) {
        for (int i = 0; i < connectionList.size(); i++) {
            if (connectionList.get(i).getAddress().equals(ip)) {
                return connectionList.get(i);
            }
        }
        return null;
    }
    
    boolean checkMax() {
        return openConnections < MAX_CONNECTIONS;
    }
    
    boolean checkIfOpen(String ip) {
        return getConnectionByAddress(ip) == null;
    }
    
    private class ManagedConnection implements Connection {
        private String ip;
        private int port;
        private String protocol;
        private boolean status;
        
        ManagedConnection(String ip, int port, String protocol) {
            this.ip = ip;
            this.port = port;
            this.protocol = protocol;
            this.status = true;
            connect();
        }
        
        ManagedConnection(String ip, int port) {
            this.ip = ip;
            this.port = port;
            this.protocol = "HTTP";
            this.status = true;
            connect();
        }
        
        ManagedConnection(String ip, String protocol) {
            this.ip = ip;
            this.port = 80;
            this.protocol = protocol;
            this.status = true;
            connect();
        }
        
        public void connect() {
            connectionList.add(this);
            openConnections++;
        }
        
        public String getAddress() {
            return this.ip;
        }

        public int getPort() {
            return this.port;
        }

        public String getProtocol() {
            return this.protocol;
        }
        
        public boolean getStatus() {
            return this.status;
        }

        public void close() {
            this.status = false;
            openConnections--;
        }
    }
}
