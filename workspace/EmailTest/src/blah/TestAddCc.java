package blah;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.mocks.MockEmailConcrete;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by myoder on 2/26/14.
 */
public class TestAddCc {
    private static final String[] VALID_EMAILS =
            {
                    "me@home.com",
                    "joe.doe@apache.org",
                    "someone_here@work-address.com.au"
            };

    /** mock for testing */
    private MockEmailConcrete email;


    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        email = new MockEmailConcrete();
    }

    @Test
    public void testAddCc() {

        //add email addresses to arraylist
        List<InternetAddress> arrExpected = new ArrayList<InternetAddress>();
        try {
            arrExpected.add(new InternetAddress("me@home.com"));
        } catch (AddressException e) {
            System.out.println("Couldn't add email to arraylist");
            e.printStackTrace();
        }
        try {
            arrExpected.add(new InternetAddress("joe.doe@apache.org"));
        } catch (AddressException e) {
            System.out.println("Couldn't add email to arraylist");
            e.printStackTrace();
        }
        try {
            arrExpected.add(new InternetAddress("someone_here@work-address.com.au"));
        } catch (AddressException e) {
            System.out.println("Couldn't add email to arraylist");
            e.printStackTrace();
        }


        // add a valid cc
        try {
            for(InternetAddress temp : arrExpected)
                email.addCc(temp.toString());
        } catch (EmailException e) {
            System.out.println("Couldn't add emails to CC list");
            e.printStackTrace();
        }

        // retrieve and verify
        assertEquals("Test should pass", arrExpected.size(), email.getCcAddresses().size());
        assertEquals("Test should pass", arrExpected.toString(),
                email.getCcAddresses().toString());
    }


    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        email = null;
    }
}
