package main;

import math.Matrix;
import org.jzy3d.chart.AWTChart;
import org.jzy3d.chart.Chart;
import org.jzy3d.colors.Color;
import org.jzy3d.colors.ColorMapper;
import org.jzy3d.colors.colormaps.ColorMapRainbow;
import org.jzy3d.maths.Range;
import org.jzy3d.plot3d.builder.Builder;
import org.jzy3d.plot3d.builder.Mapper;
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid;
import org.jzy3d.plot3d.primitives.Shape;
import org.jzy3d.plot3d.rendering.canvas.Quality;

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
        /**
         // Define a function to plot
         Mapper mapper = new Mapper() {
         public double f(double x, double y) {
         return 10 * Math.sin(x / 10) * Math.cos(y / 20);
         }
         };

         // Define range and precision for the function to plot
         Range range = new Range(-150, 150);
         int steps = 100;

         // Create a surface drawing that function
         Shape surface = Builder.buildOrthonormal(new OrthonormalGrid(range, steps), mapper);
         surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), -10D, 10D));
         surface.setFaceDisplayed(true);
         surface.setWireframeDisplayed(true);
         surface.setWireframeColor(Color.BLACK);

         // Create a chart and add the surface
         Chart chart = new AWTChart(Quality.Advanced);
         chart.add(surface);
         chart.open("Jzy3d Demo", 600, 600);*/

        Matrix a = new Matrix(2, 3);
        Matrix b = new Matrix(3, 2);

        a.initialize(new double[][] {
                {1, 2, 3},
                {4, 5, 6}
        });

        b.initialize(new double[][] {
                {7, 8},
                {9, 10},
                {11, 12}
        });

        Matrix c = a.multiplyBy(b);

        System.out.println(c.toString());
    }
}
