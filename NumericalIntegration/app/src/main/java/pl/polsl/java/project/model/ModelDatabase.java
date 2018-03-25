package pl.polsl.java.project.model;

/**
 * @author Kamil Ismail
 * @version 6.0
 */

import pl.polsl.java.project.exception.WrongDataException;

/**
 * ModelDatabase contains all model objects. Sets up polynomial, points and also
 * starts calculation of integral. Also can check if points parameters are ok
 * and can return result of integral operation.
 */
public class ModelDatabase {

    /**
     * Begining of interval.
     */
    private float startPoint;
    /**
     * End of interval.
     */
    private float endPoint;
    /**
     * Number of points. Algorithm usues it for accuracy.
     */
    private int numberOfPoints;
    /**
     * That string is used for detaining equasion
     */
    private String function;
    /**
     * Obejct of class DetermineCoefficients.
     */
    private DetermineCoefficients theCoefficients;

    /**
     * Variable used for receiving information from the user.
     */
    private float result;
    /**
     * Object of Rectangular methode.
     */
    private final RectangularIntegration theRecInt;
    /**
     * Object of trapezoidal methode.
     */
    private final TrapezoidalIntegration theTrapInt;

    /**
     * Constructor of the class. Initializes variables and creates object of
     * integral methodes.
     */
    public ModelDatabase() {
        this.function = "";
        this.startPoint = 0;
        this.endPoint = 0;
        this.numberOfPoints = 0;
        this.result = 0;
        this.theCoefficients = null;
        this.theRecInt = new RectangularIntegration();
        theTrapInt = new TrapezoidalIntegration();
    }

    /**
     * Methode that sets up polynomial. Checks if polynomial seems to be ok and
     * then starts changing it into the list of points.
     *
     * @param polynomial
     * @throws pl.polsl.java.project.exception.WrongDataException
     */
    public void setFunction(String polynomial) throws WrongDataException, StringIndexOutOfBoundsException,
            NumberFormatException {

        if (polynomial.indexOf("x") == -1) {
            throw new WrongDataException("Hey, there is no x in the function!");
        }

        this.function = polynomial;
        try {
            this.theCoefficients = new DetermineCoefficients(this.function);
        } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
            throw e;
        }
    }

    /**
     * Methode that is used to set up points.
     *
     * @param start
     * @param end
     * @param number
     * @throws WrongDataException
     */
    public void setPoints(int start, int end, int number) throws WrongDataException {
        this.startPoint = start;
        this.endPoint = end;
        this.numberOfPoints = number;
        try {
            checkParameters();
        } catch (WrongDataException e) {
            throw e;
        }
    }

    /**
     * Methode that is used to strat calculation of integral. If something goes
     * wrong, an exception occures.
     *
     * @param choice
     * @throws WrongDataException
     */
    public void startCalculation(int choice) throws WrongDataException, NullPointerException {

        if (choice == 1) {

            try {
                if (theCoefficients != null || theRecInt != null) {
                    theRecInt.calculateIntegral(this.startPoint, this.endPoint, this.numberOfPoints, theCoefficients.getObject());
                    result = theRecInt.getResult();
                }
            } catch (WrongDataException | NullPointerException e) {
                throw e;
            }
        }

        if (choice == 2) {
            try {
                if (theCoefficients != null || theTrapInt != null) {
                    theTrapInt.calculateIntegral(this.startPoint, this.endPoint, this.numberOfPoints, theCoefficients.getObject());
                    result = theTrapInt.getResult();
                }
            } catch (WrongDataException | NullPointerException e) {
                throw e;
            }
        }
    }

    /**
     * Methode that returns result of integral.
     *
     * @return
     */
    public float getResult() {
        return this.result;
    }

    /**
     * Methode that chceks if parameter 'numberOfPoints' is ok.
     *
     * @throws WrongDataException
     */
    private void checkParameters() throws WrongDataException {
        if (this.numberOfPoints < 1) {
            throw new WrongDataException("Number of points is wrong!");
        }
    }
}
