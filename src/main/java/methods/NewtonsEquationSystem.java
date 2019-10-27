package methods;

import math.Function;
import math.Matrix;

/**
 * Solves a system of non-linear equations using Newton's method
 */
public class NewtonsEquationSystem {

    // calculation precision
    private static final double PRECISION = 0.00001D;

    /**
     * Solves a system of equations
     */
    public void execute(Function[] functions, double[] initialValues) {
        final QRDecomposition qr = new QRDecomposition();
        double precision = Double.MAX_VALUE;
        double[] values = initialValues;
        int functionCount = functions.length;
        int iterationCount = 0;
        Matrix answer = new Matrix(functionCount, 1);

        while (precision > PRECISION) {
            // create and fill last value matrix with data
            Matrix valueMatrix = getValueMatrix(functionCount, values);

            // create and fill jacobian matrix
            Matrix jacobianMatrix = getJacobianMatrix(functionCount, functions, values);

            // create and fill function values matrix
            Matrix functionValuesMatrix = getFunctionValuesMatrix(functionCount, functions, values);

            // find delta x matrix
            Matrix deltaX = qr.execute(jacobianMatrix, functionValuesMatrix);

            // create and fill new value matrix
            Matrix newValuesMatrix = valueMatrix.add(deltaX);

            // get new values
            double[] newValues = getMatrixValues(newValuesMatrix);

            // calculate precision
            precision = calculatePrecision(values, newValues);

            // set old values
            values = newValues;

            // initialize potential answer
            answer = newValuesMatrix;

            // increase iterations
            iterationCount++;
        }

        System.out.println("********* Niutono metodas ***********");
        printResults(answer, iterationCount, initialValues, precision);
        System.out.println("*************************************");
    }

    /**
     * Prints method results
     *
     * @param answer
     * @param iterationCount
     * @param initialValues
     * @param precision
     */
    private void printResults(Matrix answer, int iterationCount, double[] initialValues, double precision) {
        System.out.println("Atsakymas: ");
        System.out.println(answer);
        System.out.println("Iteraciju skaicius: " + iterationCount);
        System.out.println("Pradinis artinys: ");

        for (int i = 0; i < initialValues.length; i++) {
            System.out.println(initialValues[i]);
        }

        System.out.println("Tikslumas: " + precision);
    }

    /**
     * Calculates value precision
     *
     * @param oldValues
     * @param newValues
     * @return
     */
    private double calculatePrecision(double[] oldValues, double[] newValues) {
        double precision = Double.MIN_VALUE;

        for (int i = 0; i < oldValues.length; i++) {
            double diff = Math.abs(oldValues[i] - newValues[i]);

            if (diff > precision) {
                precision = diff;
            }
        }

        return precision;
    }

    /**
     * Gets matrix values
     *
     * @param matrix
     * @return
     */
    private double[] getMatrixValues(Matrix matrix) {
        double[] values = new double[matrix.getRows()];

        for (int i = 0; i < matrix.getRows(); i++) {
            values[i] = matrix.getElement(i, 0);
        }

        return values;
    }

    /**
     * Gets variable value matrix
     *
     * @param functionCount
     * @param values
     * @return
     */
    private Matrix getValueMatrix(int functionCount, double[] values) {
        Matrix valueMatrix = new Matrix(functionCount, 1);

        double[][] valueMatrixData = new double[functionCount][1];

        for (int i = 0; i < functionCount; i++) {
            valueMatrixData[i][0] = values[i];
        }

        valueMatrix.initialize(valueMatrixData);

        return valueMatrix;
    }

    /**
     * Gets the Jacobian matrix
     *
     * @param functionCount
     * @param functions
     * @param values
     * @return
     */
    private Matrix getJacobianMatrix(int functionCount, Function[] functions, double[] values) {
        Matrix jacobianMatrix = new Matrix(functionCount, functionCount);

        double[][] jacobianMatrixData = new double[functionCount][functionCount];

        for (int i = 0; i < functionCount; i++) {
            for (int j = 0; j < functionCount; j++) {
                jacobianMatrixData[i][j] = functions[i].getDerivativeValue(j, values);
            }
        }

        jacobianMatrix.initialize(jacobianMatrixData);

        return jacobianMatrix;
    }

    /**
     * Gets function values' matrix
     *
     * @param functionCount
     * @param functions
     * @param values
     * @return
     */
    private Matrix getFunctionValuesMatrix(int functionCount, Function[] functions, double[] values) {
        Matrix functionValuesMatrix = new Matrix(functionCount, 1);

        double[][] functionValuesMatrixData = new double[functionCount][1];

        for (int i = 0; i < functionCount; i++) {
            functionValuesMatrixData[i][0] = -functions[i].getValue(values);
        }

        functionValuesMatrix.initialize(functionValuesMatrixData);

        return functionValuesMatrix;
    }
}
