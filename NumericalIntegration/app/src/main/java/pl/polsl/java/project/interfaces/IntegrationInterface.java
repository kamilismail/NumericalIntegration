package pl.polsl.java.project.interfaces;

import pl.polsl.java.project.exception.WrongDataException;

/**
 * @author Kamil Ismail
 * @version 6.0
 */

/**
 * Interface that contains methode that is needed to calculate integral. Is
 * implmented by Rectangular and Trapezoidal integration classes.
 */
public interface IntegrationInterface {

    /**
     * Methode that is necessary to calculate the integral. Receives new 'x'
     * that will be changed with the old 'x' from the equasion. Gets also
     * FunctionInterface object assigned to Polynomial that contains the List of Points - coefficient and its
     * power. Returns the result of operation. If sth goes wrong an exception can occur.
     *
     * @param x
     * @param object
     * @return
     * @throws WrongDataException
     */
    public float substituteFunction(float x, FunctionInterface object) throws WrongDataException;
}
