package math.function;

import math.plot.FunctionZ;

/**
 * Surface function
 */
public class SecondSurface implements FunctionZ {

    /**
     * Gets function value at (x, y)
     *
     * @param x
     * @param y
     * @return
     */
    public double value(double x, double y) {
        return Math.pow(y - 3, 2) + x - 8;
    }
}
