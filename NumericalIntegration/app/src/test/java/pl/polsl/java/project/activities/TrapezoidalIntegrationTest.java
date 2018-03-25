package pl.polsl.java.project.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import pl.polsl.java.project.exception.WrongDataException;
import pl.polsl.java.project.model.Polynomial;
import pl.polsl.java.project.model.TrapezoidalIntegration;

/**
 * @author Kamil Ismail
 * @version 3.0
 */
/**
 * Testing class for methodes in TrapezoidalIntegration class. Contains some
 * variables and 2 testing methodes.
 */
public class TrapezoidalIntegrationTest {

    /**
     * Object constaing methodes that calculate an integral.
     */
    TrapezoidalIntegration theTrapInt;
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
        theTrapInt = new TrapezoidalIntegration();
        /*
         * Try-catch block.
         */
        try {
            /*
             * In this situaltion an exception should occur, cause the
             * Polynomial object has not been created.
             */
            theTrapInt.calculateIntegral(0, 2, 1, coeffs);
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
            theTrapInt.calculateIntegral(0, 2, 1, coeffs);
            fail("An exception should have been detected - List of coefficients is empty.");
        } catch (WrongDataException e) {
        }
        try {
            /*
             * Here, the list of obejcts is empty and the number of points is
             * smaller then 1.
             *
             */
            theTrapInt.calculateIntegral(0, 2, 0, coeffs);
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
            theTrapInt.calculateIntegral(10, 2, 0, coeffs);
            fail("An exception should have been detected - number of points < 1");
        } catch (WrongDataException e) {
        }
        try {
            /*
             * Here is normal situation, but checking negative values.
             */
            theTrapInt.calculateIntegral(-2, -1, 3, coeffs);
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
        theTrapInt = new TrapezoidalIntegration();
        /*
         * Testing if provading null object can result with some problems.
         */
        try {
            theTrapInt.substituteFunction(1, coeffs);
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
            theTrapInt.substituteFunction(1, coeffs);
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
            theTrapInt.substituteFunction(1, coeffs);
            assertEquals("Set correct parameters.", coeffs.getList().size(), 1, 0);
        } catch (WrongDataException e) {
        }

    }
}
