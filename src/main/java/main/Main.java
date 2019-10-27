package main;

import math.Function;
import math.Matrix;
import math.function.FirstSurface;
import math.function.system.first.FirstSystemFunction1;
import math.function.system.first.FirstSystemFunction2;
import math.function.SecondSurface;
import math.function.system.second.SecondSystemFunction1;
import math.function.system.second.SecondSystemFunction2;
import math.function.system.second.SecondSystemFunction3;
import math.function.system.second.SecondSystemFunction4;
import math.plot.FunctionZ;
import math.plot.SurfacePlot;
import methods.NewtonsEquationSystem;
import methods.QRDecomposition;
import org.jzy3d.colors.Color;

/**
 * Starter class
 */
public class Main {

    /**
     * Entry point of the program
     *
     * @param args
     */
    public static void main(String[] args) {
        QRDecomposition qr = new QRDecomposition();

        Matrix a = new Matrix(4, 4);
        Matrix b = new Matrix(4, 1);

        a.initialize(new double[][] {
                {3, 1, -1, 1},
                {1, -2, 3, 1},
                {2, -9, 5, 2},
                {1, -7, 2, 1}
        });

        b.initialize(new double[][] {
                {27},
                {24},
                {27},
                {3}
        });

        Matrix x = qr.execute(a, b);

        System.out.println("Tiesines lygciu sistemos sprendiniai: ");
        System.out.println(x);

        NewtonsEquationSystem n = new NewtonsEquationSystem();

        n.execute(new Function[] {
                new FirstSystemFunction1(),
                new FirstSystemFunction2(),
        }, new double[] {
                1, 1
        });

        n.execute(new Function[] {
                new FirstSystemFunction1(),
                new FirstSystemFunction2(),
        }, new double[] {
                2, 2
        });

        n.execute(new Function[] {
                new FirstSystemFunction1(),
                new FirstSystemFunction2(),
        }, new double[] {
                3, 3
        });

        n.execute(new Function[] {
                new FirstSystemFunction1(),
                new FirstSystemFunction2(),
        }, new double[] {
                4, 4
        });

        n.execute(new Function[] {
                new SecondSystemFunction1(),
                new SecondSystemFunction2(),
                new SecondSystemFunction3(),
                new SecondSystemFunction4()
        }, new double[] {
                1, 1, 1, 1
        });

        SurfacePlot.plotSurfaces(
                "Z1",
                new FunctionZ[] {
                        new FirstSurface()
                },
                new Color[] {
                        Color.BLACK
                },
                10,
                true,
                Color.RED
        );

        SurfacePlot.plotSurfaces(
                "Z2",
                new FunctionZ[] {
                        new SecondSurface()
                },
                new Color[] {
                        Color.BLACK
                },
                10,
                true,
                Color.YELLOW
        );
    }
}
