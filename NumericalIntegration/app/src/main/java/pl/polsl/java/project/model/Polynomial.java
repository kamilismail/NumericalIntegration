package pl.polsl.java.project.model;

import java.util.LinkedList;

import pl.polsl.java.project.exception.WrongDataException;
import pl.polsl.java.project.interfaces.FunctionInterface;

import static java.lang.Math.pow;

/**
 * @author Kamil Ismail
 * @version 6.0
 */

/**
 * Class containing list of coefficient and its power. it represent the
 * equasion. Also class has methodes that creates Points object and adds it to
 * the list.
 */
public class Polynomial implements FunctionInterface {

    /**
     * Variable containig Points objects.
     */
    private final LinkedList<Points> listOfPoints;

    /**
     * Constructor of the class. Creates new list.
     */
    public Polynomial() {
        this.listOfPoints = new LinkedList<>();
    }

    /**
     * Methode implemented from the Function Interface. Create new object Points
     * from the received variables and adds it to the list. If the coefficient
     * and its power are 0, then exception occur.
     *
     * @param power
     * @param coeff
     * @throws WrongDataException
     */
    @Override
    public void setPoints(int power, float coeff) throws WrongDataException {
        if (power == 0 && coeff == 0) {
            throw new WrongDataException("0 power 0 cannot be done!");
        }
        this.listOfPoints.add(new Points(coeff, power));
    }

    /**
     * Methode that returns the list.
     *
     * @return
     */
    public LinkedList<Points> getList() {
        return this.listOfPoints;
    }

    /**
     * Methode that powers recieved variable. Returns the result of operation.
     *
     * @param x
     * @param i
     * @return
     */
    @Override
    public float powerCoeff(float x, int i) {
        x = (float) pow(x, i);
        return x;
    }

    /**
     * Methode that calculates value of x in the function and sums up all
     * variables.
     *
     * @param x
     * @return
     * @throws WrongDataException
     */
    @Override
    public float valueOfX(float x) throws WrongDataException {
        float outcome = 0;
        for (Points i : this.listOfPoints) {
            if (i.getPower() == 0 && x == 0) {
                throw new WrongDataException("The equsion 0 power 0 cannot be done!");
            } else {
                outcome += i.getCoeff() * powerCoeff(x, i.getPower());
            }
        }
        return outcome;
    }

    /**
     * Methode that returns boolean value of presence of elements in the listOfPoints.
     * If list is empty methode returns false - there's no coefficient, otherwise true.
     *
     * @return
     */
    @Override
    public boolean areCoeffsDefined() {
        if (this.listOfPoints.isEmpty())
            return false;
        else
            return true;
    }

}
