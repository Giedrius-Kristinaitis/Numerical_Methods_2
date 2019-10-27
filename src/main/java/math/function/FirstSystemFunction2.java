package math.function;

import math.Function;

/**
 * Function
 */
public class FirstSystemFunction2 implements Function {

    /**
     * Gets function value with the specified variables
     *
     * @param vars variables
     * @return
     */
    public double getValue(double... vars) {
        return Math.pow(vars[1] - 3, 2) + vars[0] - 8;
    }

    /**
     * Gets function derivative value with respect to the variable at the specified
     * index with the given variable values
     *
     * @param varIndex variable index
     * @param vars     variables
     * @return
     */
    public double getDerivativeValue(int varIndex, double... vars) {
        if (varIndex == 0) {
            return 1;
        } else {
            return 2 * vars[1] - 6;
        }
    }
}
