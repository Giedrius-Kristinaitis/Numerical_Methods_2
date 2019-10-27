package math.function.system.second;

import math.Function;

/**
 * Function
 */
public class SecondSystemFunction1 implements Function {

    /**
     * Gets function value with the specified variables
     *
     * @param vars variables
     * @return
     */
    public double getValue(double... vars) {
        return 5 * vars[0] + vars[1] + vars[2] + 4 * vars[3] + 5;
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
                return 5;
            case 1:
                return 1;
            case 2:
                return 1;
            case 3:
                return 4;
            default:
                return 0;
        }
    }
}
