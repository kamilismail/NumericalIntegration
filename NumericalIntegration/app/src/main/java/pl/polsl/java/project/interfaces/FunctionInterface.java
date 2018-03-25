package pl.polsl.java.project.interfaces;

import pl.polsl.java.project.exception.WrongDataException;

/**
 * @author Kamil Ismail
 * @version 6.0
 */
/**
 * Interface that is implemented by Polynomial class. Represents adding Points
 * object. That interface is needed to create representation of equasion.
 *
 */
public interface FunctionInterface {

    /**
     * Methode that creates Points object of received variables and adds it to
     * the list of coefficients. If sth goes wrong the exception can occur.
     *
     * @param power
     * @param coeff
     * @throws WrongDataException
     */
    public void setPoints(int power, float coeff) throws WrongDataException;

    /**
     * Methode that calculates power - i of variable x.
     *
     * @param i
     * @param x
     * @return
     */
    public float powerCoeff(float x, int i);

    /**
     * Methode that calculates value of x in the function and sums up all
     * variables.
     *
     * @param x
     * @return
     * @throws WrongDataException
     */
    public float valueOfX(float x) throws WrongDataException;

    /**
     * Methode that returns boolean value if in the list of coefficients are elements.
     * @return
     */
    public boolean areCoeffsDefined();
}
