package assign1;

import org.apache.commons.mail.mocks.MockEmailConcrete;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by myoder on 2/26/14.
 */
public class getHostNameTest {
    private MockEmailConcrete email;
    protected String hostName;

    @Before
    public void setup(){
        email = new MockEmailConcrete();
        hostName = "TestHost";
        email.setHostName("TestHost");
    }

    @Test
    public void getHostTest() {
        //Tests getHostName() to test whether it gets the correct hostname
        assertEquals(hostName, email.getHostName());
    }

    @After
    public void tearDown() {
        email = null;
    }
}
