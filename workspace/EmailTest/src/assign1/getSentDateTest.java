package assign1;

import org.apache.commons.mail.mocks.MockEmailConcrete;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by root on 2/27/14.
 */
public class getSentDateTest {

    private MockEmailConcrete email;

    @Before
    public void setup() {
        email = new MockEmailConcrete();
    }

    @Test
    public void testGetSetSentDate()
    {
        // with input date

        Date dtTest = Calendar.getInstance().getTime();
        email.setSentDate(dtTest);
        assertEquals(dtTest, email.getSentDate());

        // with null input (this is a fudge :D)
        email.setSentDate(null);

        Date sentDate = email.getSentDate();

        // Date objects are millisecond specific. If you have a slow processor,
        // time passes between the generation of dtTest and the new Date() in
        // getSentDate() and this test fails. Make sure that the difference
        // is less than a second...
        assertTrue(Math.abs(sentDate.getTime() - dtTest.getTime()) < 1000);
    }

    @After
    public void tearDown() {
        email = null;
    }

}
