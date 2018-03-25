package pl.polsl.java.project.model;

/**
 * @author Kamil Ismail
 * @version 3.0
 */
/**
 * Class containing two variables coefficient and its power.
 */
public class Points {

    /**
     * Variable containing coefficient from equasion.
     */
    private final float coefficient;
    /**
     * Variable containing power of coefficient.
     */
    private final int power;

    /**
     * Constructor of the class. Sets up variables.
     *
     * @param coeff
     * @param pow
     */
    public Points(float coeff, int pow) {
        this.coefficient = coeff;
        this.power = pow;
    }

    /**
     * Methode that returns the coefficient variable.
     *
     * @return
     */
    public float getCoeff() {
        return this.coefficient;
    }

    /**
     * Methode that returns the power variable.
     *
     * @return
     */
    public int getPower() {
        return this.power;
    }
}
