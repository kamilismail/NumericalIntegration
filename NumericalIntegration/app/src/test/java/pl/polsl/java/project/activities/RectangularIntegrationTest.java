package pl.polsl.java.project.test;

import pl.polsl.java.project.model.RectangularIntegration;
import org.junit.*;
import static org.junit.Assert.*;
import pl.polsl.java.project.exception.WrongDataException;
import pl.polsl.java.project.model.Polynomial;

/**
 * @author Kamil Ismail
 * @version 3.0
 */
/**
 * Testing class for methodes in RectangularIntegration class. Contains some
 * variables and 2 testing methodes.
 */
public class RectangularIntegrationTest {

    /**
     * Object constaing methodes that calculate an integral.
     */
    RectangularIntegration theRectInt;
    /**
     * Object containing list of objects Points hat contains coefficient and
     * powers variables.
     */
    Polynomial coeffs;

    /**
     * Testing methode. Tests CaculateIntegral methode.
     */
    @Test
    public void testCalculateIntegral() {
        /*
         * Initialization of variable.
         */
        theRectInt = new RectangularIntegration();
        /*
         * Try-catch block.
         */
        try {
            /*
             * In this situaltion an exception should occur, cause the
             * Polynomial object has not been created.
             */
            theRectInt.calculateIntegral(0, 2, 1, coeffs);
            fail("An exception should have been detected - Polynomial doesn't exist");
        } catch (WrongDataException e) {
        }
        /*
         * Initalization of variable.
         */
        coeffs = new Polynomial();
        try {
            /*
             * This one also should thow an exception, because, list in the
             * object is empty.
             */
            theRectInt.calculateIntegral(0, 2, 1, coeffs);
            fail("An exception should have been detected - List of coefficients is empty.");
        } catch (WrongDataException e) {
        }
        try {
            /*
             * Here, the list of obejcts is empty and the number of points is
             * smaller then 1.
             *
             */
            theRectInt.calculateIntegral(0, 2, 0, coeffs);
            fail("An exception should have been detected - List of coefficients is empty & number of points < 1.");
        } catch (WrongDataException e) {
        }
        /*
         * Adding the object to the list.
         */
        try {
            coeffs.setPoints(2, 5);
        } catch (WrongDataException e) {
        }
        try {
            /*
             * In this situation number of points is less then 1, so an
             * exception should occur.
             */
            theRectInt.calculateIntegral(10, 2, 0, coeffs);
            fail("An exception should have been detected - number of points < 1");
        } catch (WrongDataException e) {
        }
        try {
            /*
             * Here is normal situation, but checking negative values.
             */
            theRectInt.calculateIntegral(-2, -1, 3, coeffs);
            assertEquals("Set correct parameters.", coeffs.getList().size(), 1, 0);
        } catch (WrongDataException e) {
        }
    }

    /**
     * Next testing methode. It tests the SubstituteFunction.
     */
    @Test
    public void testSubstituteFunction() {
        /*
         * Initialization of variable.
         */
        theRectInt = new RectangularIntegration();
        /*
         * Testing if provading null object can result with some problems.
         */
        try {
            theRectInt.substituteFunction(1, coeffs);
            fail("An exception should have been detected - Object is null.");
        } catch (WrongDataException e) {
        }
        /*
         * Initialization of variable.
         */
        coeffs = new Polynomial();
        /*
         * List in variable coeffs is empty. There are no object within it.
         */
        try {
            theRectInt.substituteFunction(1, coeffs);
            fail("An exception should have been detected - List of coefficients is empty.");
        } catch (WrongDataException e) {
        }
        /*
         * Creating and adding object to the list.
         */
        try {
            coeffs.setPoints(2, 5);
        } catch (WrongDataException e) {
        }
        /*
         * This situation has to end without any problems. Ther are normal
         * parameters.
         */
        try {
            theRectInt.substituteFunction(1, coeffs);
            assertEquals("Set correct parameters.", coeffs.getList().size(), 1, 0);
        } catch (WrongDataException e) {
        }
        /*
         * Creating and adding object to the list with power = 0.
         */
        try {
            coeffs.setPoints(0, 2);
        } catch (WrongDataException e) {
        }
        try {
            /*
             * Before that the object with power = 0 has been created and the
             * methode uses it to make pow(0,0). The equasion in Netbeans
             * returns 1, but it is not desirable in this algorithm.
             */
            theRectInt.substituteFunction(0, coeffs);
            fail("An exception should have been detected - 0^0 cannot be done.");
        } catch (WrongDataException e) {
        }

    }
}
