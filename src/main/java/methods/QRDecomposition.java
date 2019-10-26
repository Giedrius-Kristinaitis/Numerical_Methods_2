package methods;

import math.Matrix;

/**
 * QR decomposition algorithm to solve a system of linear equations
 */
public class QRDecomposition {

    /**
     * Executes QR decomposition for a system of linear equations represented as two matrices:
     * a - coefficients
     * b - expected results
     *
     * Only works for correct dimension matrices nxn and nx1
     *
     * @return x matrix
     */
    public Matrix execute(Matrix a, Matrix b) {
        Matrix qt = getQt(a);
        Matrix r = qt.multiplyBy(a);

        return getXMatrix(r, qt, b);
    }

    /**
     * Finds the x matrix:
     *
     * R * x = Qt * b
     *
     * @param r R matrix
     * @param qt Qt matrix
     * @param b b matrix
     * @return
     */
    private Matrix getXMatrix(Matrix r, Matrix qt, Matrix b) {
        b = qt.multiplyBy(b);

        Matrix x = new Matrix(r.getColumns(), 1);

        x.setElement(r.getElement(r.getRows() - 1, r.getColumns() - 1), x.getRows() - 1, 0);

        for (int i = r.getRows() - 2; i >= 0; i--) {
            double leftSide = 0;

            for (int j = i + 1; j <= r.getColumns() - 1; j++) {
                leftSide += r.getElement(i, j) * x.getElement(j, 0);
            }

            double rightSide = b.getElement(i, 0) - leftSide;
            double value = rightSide / r.getElement(i, i);

            x.setElement(value, i, 0);
        }

        return x;
    }

    /**
     * Gets Qt matrix
     *
     * @param a A matrix
     * @return
     */
    private Matrix getQt(Matrix a) {
        Matrix[] qParts = new Matrix[a.getColumns()];

        qParts[0] = a.getColumn(0);

        for (int i = 1; i < a.getColumns(); i++) {
            Matrix column = a.getColumn(i);
            Matrix qi = column;

            /**
             * Q[i] = A[i] - (ProjQ[i-1]A[i])Q[i-1]
             */
            for (int j = 0; j < i; j++) {
                qi = qi.subtract(qParts[j].multiplyBy(Matrix.toVector(column).scalarMultiply(Matrix.toVector(qParts[j])) / Matrix.toVector(qParts[j]).scalarMultiply(Matrix.toVector(qParts[j]))));
            }

            qParts[i] = qi;
        }

        return buildQtFromParts(qParts);
    }

    /**
     * Builds the Q matrix from it's parts
     *
     * @param parts parts to build from
     * @return
     */
    private Matrix buildQtFromParts(Matrix[] parts) {
        Matrix q = new Matrix(parts[0].getRows(), parts.length);

        for (int i = 0; i < parts.length; i++) {
            q.setRow(i, parts[i].divideBy(Matrix.toVector(parts[i]).norm()));
        }

        return q;
    }
}
