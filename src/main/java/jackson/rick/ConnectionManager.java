package jackson.rick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rickjackson on 2/2/17.
 */
public class ConnectionManager {
    private List<ManagedConnection> connectionList;
    private static int MAX_CONNECTIONS;
    
    ConnectionManager() {
        this.connectionList = new ArrayList<>();
        this.MAX_CONNECTIONS = 3;
    }
    
    ManagedConnection buildConnection(String ip, String protocol) {
        return null;
    }
    
    ManagedConnection buildConnection(String ip, int port, String protocol) {
        return null;
    }
    
    ManagedConnection buildConnection(String ip, int port) {
        return null;
    }
    
    ManagedConnection getConnectionByProtocol(String protocol) {
        return null;
    }
    
    ManagedConnection getConnectionByIP(String ip) {
        return null;
    }
    
    boolean checkMax() {
        return false;
    }
    
    void removeClosedConnection(ManagedConnection mc) {
        
    }
    
    class ManagedConnection implements Connection {
        private String ip;
        private int port;
        private String protocol;
        
        ManagedConnection(String ip, int port, String protocol) {
            this.ip = ip;
            this.port = port;
            this.protocol = protocol;
        }
        
        public String connect() {
            return "";
        }
        
        public String getIP() {
            return "";
        }
        
        public int getPort() {
            return 0;
        }
        
        public String getProtocol() {
            return "";
        }
        
        public void close() {
            
        }
    }
}
