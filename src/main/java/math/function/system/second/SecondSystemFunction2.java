package math.function.system.second;

import math.Function;

/**
 * Function
 */
public class SecondSystemFunction2 implements Function {

    /**
     * Gets function value with the specified variables
     *
     * @param vars variables
     * @return
     */
    public double getValue(double... vars) {
        return -Math.pow(vars[0], 2) + Math.pow(vars[2], 2) + 5;
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
        switch (varIndex) {
            case 0:
                return -2 * vars[0];
            case 2:
                return 2 * vars[2];
            case 1:
            case 3:
            default:
                return 0;
        }
    }
}
