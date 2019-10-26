package math;

/**
 * Vector implementation
 */
public class Vector {

    // data
    private double[] data;

    /**
     * Class constructor
     * @param data
     */
    public Vector(double[] data) {
        this.data = data;
    }

    /**
     * Performs scalar multiplication between this and the given vector
     *
     * @param vector vector to multiply by
     * @return
     */
    public double scalarMultiply(Vector vector) {
        if (data.length != vector.data.length) {
            throw new IllegalArgumentException("Vector lengths must match in order to multiply");
        }

        double result = 0;

        for (int i = 0; i < data.length; i++) {
            result += data[i] * vector.data[i];
        }

        return result;
    }

    /**
     * Converts the vector to a string
     * @return
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (double element: data) {
            result.append(element);
            result.append(' ');
        }

        return result.toString();
    }
}
