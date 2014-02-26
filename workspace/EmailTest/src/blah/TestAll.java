/**
 * 
 */
package blah;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
       TestAddBcc.class,
       TestAddCc.class,
       TestAddHeader.class,
       TestAddReplyTo.class
})

/**
 * @author myoder
 *
 */
public class TestAll {

}
