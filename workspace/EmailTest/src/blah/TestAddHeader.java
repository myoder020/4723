package blah;

/**
 * Created by myoder on 2/26/14.
 */

import org.apache.commons.mail.mocks.MockEmailConcrete;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAddHeader {

    private String name = "John";

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
    public void initTest() {
        //Test the initialization of a new mock email
        assertEquals("Test initialization of new mock email", 0, email.getHeaders().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullValueException() {
        //Test that exception is thrown for null values
        email.addHeader(name, null);
        email.addHeader(null, name);
        email.addHeader(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyValueException() {
        //Test that exception is thrown for empty strings
        email.addHeader(name, "");
        email.addHeader("", name);
        email.addHeader("", "");
    }

    @Test
    public void testAddHeader() {
        //Test adding a header to an email
        email.addHeader(name, "Test");
        assertEquals("Test should pass", 1, email.getHeaders().size());
    }

    @After
    public void tearDown() throws Exception {
        email = null;
    }
}
