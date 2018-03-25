package pl.polsl.java.project.model;

import pl.polsl.java.project.exception.WrongDataException;
import pl.polsl.java.project.interfaces.FunctionInterface;
import pl.polsl.java.project.interfaces.IntegrationInterface;

/**
 * @author Kamil Ismail
 * @version 6.0
 */

/**
 * Class that calculates integral with Rectangular methode.
 */
public class RectangularIntegration implements IntegrationInterface {

    /**
     * Variable containing result of integral.
     */
    private float result;

    /**
     * Constructor that makes variable result = 0.
     */
    public RectangularIntegration() {
        this.result = 0;
    }

    /**
     * Methode gets start of the interval, end point, and accuracy. Calculates
     * the integral. If sth goes wrong an exception can occur.
     *
     * @param startPoint
     * @param endPoint
     * @param numberOfPoints
     * @param coeffs
     * @throws pl.polsl.java.project.exception.WrongDataException
     */
    public void calculateIntegral(float startPoint, float endPoint, int numberOfPoints, Polynomial coeffs) throws WrongDataException {

        this.result = 0;
        float dx;
        if (numberOfPoints < 1) {
            throw new WrongDataException("Number of points is incorrect!");
        }
        if (startPoint > endPoint) {
            throw new WrongDataException("Interval is incorrect!");
        }
        if (coeffs == null) {
            throw new WrongDataException("List of coefficients has not been created!");
        }
        if (coeffs.getList().isEmpty()) {
            throw new WrongDataException("List of coefficient is empty!");
        }
        dx = (endPoint - startPoint) / numberOfPoints;
        try {
            for (int i = 1; i <= numberOfPoints; i++) {
                result += substituteFunction(startPoint + i * dx, coeffs);
            }
        } catch (WrongDataException e) {
            throw e;
        }
        result *= dx;
    }

    /**
     * Methode that gets new 'x' and fits it to the old 'x' in equasion. Returns
     * the result of operation. It's implemented from the Integration Interfacea
     * and if sth goes wrong an exception occurs.
     *
     * @param x
     * @param coeffs
     * @return
     * @throws pl.polsl.java.project.exception.WrongDataException
     */
    @Override
    public float substituteFunction(float x, FunctionInterface coeffs) throws WrongDataException {
        float outcome = 0;
        if (coeffs == null) {
            throw new WrongDataException("List of coefficients has not been created!");
        }
        if (!coeffs.areCoeffsDefined()) {
            throw new WrongDataException("List of coefficient is empty!");
        }
        try {
            outcome = coeffs.valueOfX(x);
        } catch (WrongDataException e) {
            throw e;
        }
        return outcome;
    }

    /**
     * Methode that returns the result of calculated integral.
     *
     * @return
     */
    public float getResult() {
        return this.result;
    }
}