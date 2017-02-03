package jackson.rick;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by rickjackson on 2/2/17.
 */
public class ConnectionManagerTest {
    private ConnectionManager cm;
    private String conn;

    @Before
    public void setUp() {
        cm = new ConnectionManager();
        conn = cm.buildConnection("127.0.1.1", 8000, "HTTP");
    }

    @Test
    public void buildConnectionTest() {
        String expected = "Connected to 127.0.0.1:8000 via HTTP.";
        String actual = cm.buildConnection("127.0.0.1", 8000, "HTTP");
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void getConnectionByAddressTest() {
        Connection expected = null;
        Connection actual = cm.getConnectionByAddress("127.0.0.1");
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void checkMaxTest() {
        boolean expected = true;
        boolean actual = cm.checkMax();
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
    
    @Test
    public void checkIfOpenTest() {
        boolean expected = true;
        boolean actual = cm.checkIfOpen("127.0.0.1");
        assertEquals(String.format("I expected the result to be: %s", expected),
                expected, actual);
    }
}
