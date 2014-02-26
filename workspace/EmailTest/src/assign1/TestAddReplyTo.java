package assign1;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.mocks.MockEmailConcrete;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by myoder on 2/26/14.
 */
public class TestAddReplyTo {

    private MockEmailConcrete email;

    @Before
    public void setup() {
        email = new MockEmailConcrete();
    }

    @Test(expected = NullPointerException.class)
    public void addReplyToNullException() throws EmailException{
        email.addReplyTo(null);
    }

    @Test(expected = EmailException.class)
    public void addReplyToEmailException() throws EmailException{
        email.addReplyTo("");
    }

    @Test
    public void testAddReplyTo () {
        try {
            email.addReplyTo("john@email.com");
        } catch (EmailException e) {
            System.out.println("Error adding reply");
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(){
        email = null;
    }
}
