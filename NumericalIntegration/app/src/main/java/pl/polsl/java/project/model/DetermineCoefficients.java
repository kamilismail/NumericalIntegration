package pl.polsl.java.project.model;

import pl.polsl.java.project.exception.WrongDataException;

/**
 * @author Kamil Ismail
 * @version 6.0
 */

/**
 * Class that transfers the equasion from string to table of floats.
 */
public class DetermineCoefficients {

    /**
     * Object containing list of coefficients and its powers.
     */
    private Polynomial coeffs;

    /**
     * Methode gets function parameter. This is equasion (string). Firstly the
     * algorithm replaces all '+' and '-' with added space before them. Now they
     * are like tokens. This is helpful for separate the coefficients of 'x' and
     * the place in table - that is the setCoeff of 'x'.
     *
     * @param function
     * @throws WrongDataException
     */
    public DetermineCoefficients(String function) throws WrongDataException, StringIndexOutOfBoundsException,
            NumberFormatException {
        int indexTab, indexSpace, indexX, coeffInt, tabSize = 0;
        String substring, coeff;
        function = function.replaceAll("\\+", " +");
        function = function.replaceAll("\\-", " -");

        while (function.length() > 0) {

            indexSpace = function.indexOf(" ");
            if (indexSpace != -1) {
                substring = function.substring(0, indexSpace);
                function = function.substring(indexSpace + 1, function.length());
            } else {
                substring = function;
                function = "";
            }

            indexX = substring.indexOf("x");

            try {
                coeff = substring.substring(0, indexX);
            } catch (StringIndexOutOfBoundsException e) {
                throw e;
            }

            try {
                if (coeff.equalsIgnoreCase("")) {
                    coeffInt = 1;
                } else {
                    coeffInt = Integer.parseInt(coeff);
                }
                if (indexX + 1 == substring.length()) {
                    throw new WrongDataException("Function is incorrect!");
                }

                indexTab = Integer.parseInt(substring.substring(indexX + 1, substring.length()));

                if (tabSize == 0) {
                    coeffs = new Polynomial();
                    tabSize = indexTab;
                }
            } catch (NumberFormatException e) {
                throw e;
            }
            try {
                coeffs.setPoints(indexTab, coeffInt);
            } catch (WrongDataException e) {
                throw e;
            }
        }
    }

    /**
     * Methode that returns the coefficients table for the algorithm that
     * calculate the integral.
     *
     * @return
     */
    public Polynomial getObject() {
        return this.coeffs;
    }
}
