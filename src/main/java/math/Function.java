package math;

/**
 * A function with many variables
 */
public interface Function {

    /**
     * Gets function value with the specified variables
     *
     * @param vars variables
     * @return
     */
    double getValue(double... vars);

    /**
     * Gets function derivative value with respect to the variable at the specified
     * index with the given variable values
     *
     * @param vars variables
     * @param varIndex variable index
     * @return
     */
    double getDerivativeValue(int varIndex, double... vars);
}
