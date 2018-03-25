package pl.polsl.java.project.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import pl.polsl.java.project.exception.WrongDataException;
import pl.polsl.java.project.model.Polynomial;

/**
 * @author Kamil Ismail
 * @version 3.0
 */
/**
 * Testing class for the Polynomial class. Class containing variable that has
 * list representing equasion.
 */
public class PolynomialTest {

    /**
     * Object containig list of coefficients and its powers.
     */
    Polynomial coeffs;

    /**
     * Testing methode. Test adding new objects (Points) to the list.
     */
    @Test
    public void testSetPoints() {
        /*
         * Initialization of the list.
         */
        coeffs = new Polynomial();
        /*
         * Try catch block.
         */
        try {
            /*
             * This one should end good. There's no problem with these
             * variables.
             */
            coeffs.setPoints(0, 1);
            assertEquals("Set coeff as 0.", coeffs.getList().size(), 1, 0);
            /*
             * This one also should end good. There's no problem with these
             * variables.
             */
            coeffs.setPoints(1, 0);
            assertEquals("Set power as 0.", coeffs.getList().size(), 2, 0);
            /*
             * This situation is not so good. However Netbeans equasion 0^0
             * returns as 1, but it is not desirable for this algorithm.
             */
            coeffs.setPoints(0, 0);
            fail("An exception should have been detected - adding 0^0");
        } catch (WrongDataException e) {
        }
    }
}
