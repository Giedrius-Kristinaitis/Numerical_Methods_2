package math.plot;

/**
 * A Z surface function
 */
public interface FunctionZ {

    /**
     * Gets function value at (x, y)
     *
     * @param x
     * @param y
     * @return
     */
    double value(double x, double y);
}
