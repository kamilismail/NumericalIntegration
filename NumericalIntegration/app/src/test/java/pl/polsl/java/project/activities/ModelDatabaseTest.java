package pl.polsl.java.project.test;

import static org.junit.Assert.fail;
import org.junit.Test;
import pl.polsl.java.project.exception.WrongDataException;
import pl.polsl.java.project.model.DetermineCoefficients;
import pl.polsl.java.project.model.ModelDatabase;
import pl.polsl.java.project.model.RectangularIntegration;
import pl.polsl.java.project.model.TrapezoidalIntegration;

/**
 *
 * @author Kamil Ismail
 * @version 3.0
 */
/**
 * Testing class od the ModelDatabase class. Contains all model objects.
 */
public class ModelDatabaseTest {

    /**
     * Object containing all model objects and controlls all model calculations.
     */
    ModelDatabase controller;
    /**
     * Object containing coefficient of polynomial.
     */
    DetermineCoefficients theCoefficients;
    /**
     * Object containing model of Rectangular Integration methode.
     */
    RectangularIntegration theRecInt;
    /**
     * Object containing model of Trapezoidal Integration methode.
     */
    TrapezoidalIntegration theTrapInt;

    /**
     * Testing methode. Tests methode without any 'x' and polynomial without 'x'
     * on some positions.
     */
    @Test
    public void testSetFunction() {
        controller = new ModelDatabase();
        try {
            controller.setFunction("x2+3");
            fail("An exception should have occur - polynomial without 'x' on last position");

            controller.setFunction("");
            fail("An exception should have occur - empty string");

            controller.setFunction("x+5");
            fail("An exception should have occur - 'x' without power");

            controller.setFunction("5");
            fail("An exception should have occur - no 'x' in string");
        } catch (WrongDataException | StringIndexOutOfBoundsException e) {
        }
    }

    /**
     * Testing methode. Tests null objects, if parameters are good and if
     * parameters are wrong there's an exception.
     */
    @Test
    public void testStartCalculation() {
        controller = new ModelDatabase();
        try {
            controller.startCalculation(1);
            fail("An exception should have occur - null pointer of theCoefficient");

            controller.startCalculation(2);
            fail("An exception should have occur - null pointer of theCoefficient");

            controller.startCalculation(3);
            fail("An exception should have occur - wrong choice");

            controller.setFunction("x3+2x0");
            controller.startCalculation(1);
            fail("An exception should have occur - all good");

            controller.setFunction("x");
            controller.startCalculation(1);
            fail("An exception should have occur - wrong polynomial");

        } catch (WrongDataException | NullPointerException e) {
        }
    }
}
