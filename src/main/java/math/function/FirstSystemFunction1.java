package math.function;

import math.Function;

/**
 * Function
 */
public class FirstSystemFunction1 implements Function {

    /**
     * Gets function value with the specified variables
     *
     * @param vars variables
     * @return
     */
    public double getValue(double... vars) {
        return Math.pow(vars[0], 2) + 10 * Math.pow(Math.sin(vars[0]) + Math.cos(vars[1]), 2) - 10;
    }

    /**
     * Gets function derivative value with respect to the variable at the specified
     * index with the given variable values
     *
     * @param vars     variables
     * @param varIndex variable index
     * @return
     */
    public double getDerivativeValue(int varIndex, double... vars) {
        if (varIndex == 0) {
            return 2 * vars[0] + 20 * Math.cos(vars[0]) * (Math.sin(vars[0]) + Math.cos(vars[1]));
        } else {
            return -20 * Math.sin(vars[1]) * (Math.sin(vars[0]) + Math.cos(vars[1]));
        }
    }
}
