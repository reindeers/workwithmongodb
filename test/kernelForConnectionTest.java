import com.mongodb.DBObject;
import junit.framework.TestCase;
import junit.framework.Assert;
import org.junit.Test;

public class kernelForConnectionTest extends TestCase {
@Test
    public void testConnectToDB() throws Exception {
        kernelForConnection newDB = new kernelForConnection();
        Assert.assertEquals(newDB.connectToDB(), (Boolean)true);
    }

@Test
    public void testSetToDB() throws Exception {
        kernelForConnection newDB = new kernelForConnection();
        newDB.connectToDB();
        Assert.assertEquals(newDB.setToDB("testData"), (Boolean)true);
    }


@Test
    public void testGetFirstFromDB() throws Exception {
        kernelForConnection newDB = new kernelForConnection();
        newDB.connectToDB();
        Assert.assertEquals(newDB.getFirstFromDB("name: test"), (Boolean)true);
    }


 @Test
    public void testGetFromDB() throws Exception {
        kernelForConnection newDB = new kernelForConnection();
        newDB.connectToDB();
        Assert.assertEquals(newDB.getFromDB("name: test"), (Boolean)true);
    }

 @Test
    public void testRemoveFromDB() throws Exception {
        kernelForConnection newDB = new kernelForConnection();
        newDB.connectToDB();
        newDB.getFirstFromDB("name: test2");
        Assert.assertEquals(newDB.removeFromDB("name: test2"), (Boolean)true);
    }
}
