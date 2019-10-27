package math.function;

import math.plot.FunctionZ;

/**
 * Surface function
 */
public class FirstSurface implements FunctionZ {

    /**
     * Gets function value at (x, y)
     *
     * @param x
     * @param y
     * @return
     */
    public double value(double x, double y) {
        return Math.pow(x, 2) + 10 * Math.pow(Math.sin(x) + Math.cos(y), 2) - 10;
    }
}
