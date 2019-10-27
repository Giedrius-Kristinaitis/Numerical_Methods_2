package math.plot;

import org.jzy3d.chart.AWTChart;
import org.jzy3d.chart.Chart;
import org.jzy3d.chart.controllers.mouse.camera.AWTCameraMouseController;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.Range;
import org.jzy3d.plot3d.builder.Builder;
import org.jzy3d.plot3d.builder.Mapper;
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid;
import org.jzy3d.plot3d.primitives.Shape;
import org.jzy3d.plot3d.rendering.canvas.Quality;

/**
 * Utility class to plot 3D surfaces
 */
public class SurfacePlot {

    /**
     * Plots 3D surfaces
     *
     * @param title
     * @param functions
     * @param colors
     * @param bounds
     * @param displayZeroSurface
     * @param zeroSurfaceColor
     */
    public static void plotSurfaces(String title, final FunctionZ[] functions, Color[] colors, float bounds, boolean displayZeroSurface, Color zeroSurfaceColor) {
        // Define range and precision for the function to plot
        Range range = new Range(-bounds, bounds);

        // Create a chart and add the surfaces
        Chart chart = new AWTChart(Quality.Advanced);

        // add all surfaces
        for (int i = 0; i < functions.length; i++) {
            createSurface(chart, functions[i], range, colors[i]);
        }

        // add z = 0 surface
        if (displayZeroSurface) {
            createSurface(chart, new FunctionZ() {
                public double value(double x, double y) {
                    return 0;
                }
            }, range, zeroSurfaceColor);
        }

        chart.addController(new AWTCameraMouseController());
        chart.open(title, 512, 512);
    }

    /**
     * Creates and adds a 3D surface
     *
     * @param chart
     * @param function
     * @param range
     * @param color
     */
    private static void createSurface(Chart chart, final FunctionZ function, Range range, Color color) {
        Mapper mapper = new Mapper() {
            @Override
            public double f(double v, double v1) {
                return function.value(v, v1);
            }
        };

        Shape surface = Builder.buildOrthonormal(new OrthonormalGrid(range, 100), mapper);
        surface.setFaceDisplayed(false);
        surface.setWireframeDisplayed(true);
        surface.setWireframeColor(color);

        chart.add(surface);
    }
}
