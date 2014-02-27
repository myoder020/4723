package assign1;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.mocks.MockEmailConcrete;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by root on 2/27/14.
 */
public class setFromTest {

    private MockEmailConcrete email;

    private static final String[] VALID_EMAILS =
        {
           "me@home.com",
           "joe.doe@apache.org",
           "someone_here@work-address.com.au"
        };

    @Before
    public void setup() {
        email = new MockEmailConcrete();
    }

    @Test(expected = NullPointerException.class)
    public void setFromNullException() throws Exception{
        email.setFrom(null);
    }

    @Test(expected = EmailException.class)
    public void setFromEmptyEmailException() throws Exception{
        email.setFrom("");
    }

    @Test
    public void setFromTest() throws Exception
    {
        List<InternetAddress> arrExpected = new ArrayList<InternetAddress>();
        arrExpected.add(new InternetAddress("me@home.com", "me@home.com"));
        arrExpected.add(
                new InternetAddress(
                        "joe.doe@apache.org",
                        "joe.doe@apache.org"));
        arrExpected.add(
                new InternetAddress(
                        "someone_here@work-address.com.au",
                        "someone_here@work-address.com.au"));

        for (int i = 0; i < VALID_EMAILS.length; i++)
        {
            // set from
            email.setFrom(VALID_EMAILS[i]);

            // retrieve and verify
            assertEquals(arrExpected.get(i), email.getFromAddress());
        }
    }

    @After
    public void tearDown() {
        email = null;
    }
}
