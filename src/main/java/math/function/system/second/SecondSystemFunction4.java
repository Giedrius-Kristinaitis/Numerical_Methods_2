package math.function.system.second;

import math.Function;

/**
 * Function
 */
public class SecondSystemFunction4 implements Function {

    /**
     * Gets function value with the specified variables
     *
     * @param vars variables
     * @return
     */
    public double getValue(double... vars) {
        return vars[0] - 3 * vars[1] + 4 * vars[2] - vars[3] - 3;
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
                return 1;
            case 1:
                return -3;
            case 2:
                return 4;
            case 3:
                return -1;
            default:
                return 0;
        }
    }
}
