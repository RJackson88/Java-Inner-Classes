package jackson.rick;

import java.io.Closeable;

/**
 * Created by rickjackson on 2/2/17.
 */
interface Connection extends Closeable {
    
    void connect();
    
    String getAddress();
    
    int getPort();
    
    String getProtocol();
    
    void close();
}
