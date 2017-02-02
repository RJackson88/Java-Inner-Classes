package jackson.rick;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by rickjackson on 2/2/17.
 */
public class ConnectionManagerTest {
    private ConnectionManager cm;
    private ConnectionManager.ManagedConnection mc;
    
    @Before
    public void setUp() {
        cm = new ConnectionManager();
        mc = cm.new ManagedConnection("", 0, "");
    }
    
    @Test
    public void checkMaxTest() {
        boolean expected = false;
        boolean actual = cm.checkMax();
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
//    @Test
//    public void buildConnectionTest() {
//        ConnectionManager.ManagedConnection expected = cm.new
//                ManagedConnection("", 0, "");
//        ConnectionManager.ManagedConnection actual = cm.buildConnection("",
//                "");
//        assertEquals(String.format("I expected the result to be: %s", expected),
//                expected, actual);
//    }
    
    @Test
    public void connectTest() {
        String expected = "";
        String actual = mc.connect();
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getIPTest() {
        String expected = "";
        String actual = mc.getIP();
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getPortTest() {
        int expected = 0;
        int actual = mc.getPort();
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getProtocol() {
        String expected = "";
        String actual = mc.getProtocol();
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
}
