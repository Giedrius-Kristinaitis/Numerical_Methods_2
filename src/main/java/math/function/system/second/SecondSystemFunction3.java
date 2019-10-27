package math.function.system.second;

import math.Function;

/**
 * Function
 */
public class SecondSystemFunction3 implements Function {

    /**
     * Gets function value with the specified variables
     *
     * @param vars variables
     * @return
     */
    public double getValue(double... vars) {
        return 4 * Math.pow(vars[2], 3) - Math.pow(vars[3], 2) - 3 * vars[1] * vars[3] - 28;
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
            case 1:
                return -3 * vars[3];
            case 2:
                return 12 * Math.pow(vars[2], 2);
            case 3:
                return -2 * vars[3] - 3 * vars[1];
            case 0:
            default:
                return 0;
        }
    }
}
