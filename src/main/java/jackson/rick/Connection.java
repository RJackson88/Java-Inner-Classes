package jackson.rick;

import java.io.Closeable;

/**
 * Created by rickjackson on 2/2/17.
 */
interface Connection extends Closeable {
    
    String connect();
    
    String getIP();
    
    int getPort();
    
    String getProtocol();
}
