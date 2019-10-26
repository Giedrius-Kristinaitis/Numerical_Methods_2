package math;

/**
 * Matrix implementation
 */
public class Matrix {

    // matrix data
    private double[][] data;
    private int rows;
    private int columns;

    /**
     * Class constructor
     *
     * @param rows row count
     * @param columns column count
     */
    public Matrix(int rows, int columns) {
        data = new double[rows][columns];

        this.rows = rows;
        this.columns = columns;
    }

    /**
     * Fills the matrix with data
     *
     * @param data data to fill the matrix with
     */
    public void initialize(double[][] data) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }

    /**
     * Sets the specified element
     *
     * @param value element value
     * @param row row
     * @param column column
     */
    public void setElement(double value, int row, int column) {
        data[row][column] = value;
    }

    /**
     * Gets the specified element
     *
     * @param row row
     * @param column column
     * @return
     */
    public double getElement(int row, int column) {
        return data[row][column];
    }

    /**
     * Gets a column as a matrix
     *
     * @param row row number
     * @return
     */
    public Matrix getColumn(int row) {
        Matrix result = new Matrix(1, columns);

        for (int i = 0; i < columns; i++) {
            result.setElement(data[row][i], 0, i);
        }

        return result;
    }

    /**
     * Gets a row as a matrix
     *
     * @param column column number
     * @return
     */
    public Matrix getRow(int column) {
        Matrix result = new Matrix(rows, 1);

        for (int i = 0; i < rows; i++) {
            result.setElement(data[i][column], i, 0);
        }

        return result;
    }

    /**
     * Sets a column
     *
     * @param row row number
     * @param column column data as a matrix
     */
    public void setColumn(int row, Matrix column) {
        data[row] = column.data[0];
    }

    /**
     * Sets a row
     *
     * @param column column number
     * @param row row data as a matrix
     */
    public void setRow(int column, Matrix row) {
        for (int i = 0; i < row.rows; i++) {
            data[i][column] = row.data[i][0];
        }
    }

    /**
     * Multiplies the matrix by another matrix
     *
     * @param matrix matrix to multiply by
     * @return
     */
    public Matrix multiplyBy(Matrix matrix) {
        if (columns != matrix.rows) {
            throw new IllegalArgumentException("Matrix sizes must be compatible for multiplication");
        }

        Matrix result = new Matrix(rows, matrix.columns);

        for (int i = 0; i < rows; i++) {
            for (int x = 0; x < matrix.columns; x++) {
                double element = 0;

                for (int j = 0; j < columns; j++) {
                    element += data[i][j] * matrix.data[j][x];
                }

                result.setElement(element, i, x);
            }
        }

        return result;
    }

    /**
     * Gets row count
     * @return
     */
    public int getRows() {
        return rows;
    }

    /**
     * Gets column count
     * @return
     */
    public int getColumns() {
        return columns;
    }

    /**
     * Converts the matrix to a string
     * @return
     */
    @Override
    public String toString() {
        StringBuilder matrix = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix.append(data[i][j]);
                matrix.append(' ');
            }

            matrix.append('\n');
        }

        return matrix.toString();
    }
}
