package assign1;

import org.apache.commons.mail.EmailConstants;
import java.util.Properties;
import org.apache.commons.mail.mocks.MockEmailConcrete;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.mail.Session;

import static org.junit.Assert.assertEquals;

    /**
     * Created by myoder on 2/26/14.
     */
public class getMailSessionTest {

    private MockEmailConcrete email;

    @Before
    public void setup() {
        email = new MockEmailConcrete();
    }


    @Test
    public void testGetSetSession() throws Exception
    {

        Properties properties = new Properties(System.getProperties());
        properties.setProperty(EmailConstants.MAIL_TRANSPORT_PROTOCOL, EmailConstants.SMTP);

        properties.setProperty(
             EmailConstants.MAIL_PORT,
             String.valueOf(21));
        properties.setProperty(EmailConstants.MAIL_HOST, "localhost");
        properties.setProperty(EmailConstants.MAIL_DEBUG, String.valueOf(false));

        Session mySession = Session.getInstance(properties, null);

        email.setMailSession(mySession);
        assertEquals(mySession, email.getMailSession());

    }

    @After
    public void tearDown() {
        email = null;
    }
}
