/**
 * 
 */
package assign1;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
       testAddBcc.class,
       testAddCc.class,
       testAddHeader.class,
       testAddReplyTo.class,
       getHostNameTest.class,
       setFromTest.class,
       getSentDateTest.class,
       getMailSessionTest.class
})

/**
 * @author myoder
 *
 */
public class testAll {

}
