package math.plot;

import org.jzy3d.chart.AWTChart;
import org.jzy3d.chart.Chart;
import org.jzy3d.chart.controllers.mouse.camera.AWTCameraMouseController;
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
 * Utility class to plot 3D surfaces
 */
public class SurfacePlot {

    /**
     * Plots a 3D surface
     *
     * @param title chart title
     * @param function surface function
     * @param bounds plot bounds
     */
    public static void plotSurface(String title, final FunctionZ function, float bounds) {
        // Define a function to plot
        Mapper mapper = new Mapper() {
            public double f(double x, double y) {
                return function.value(x, y);
            }
        };

        // Define range and precision for the function to plot
        Range range = new Range(-bounds, bounds);
        int steps = 100;

        // Create a surface drawing that function
        Shape surface = Builder.buildOrthonormal(new OrthonormalGrid(range, steps), mapper);
        surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), -10000D, 10000D));
        surface.setFaceDisplayed(true);
        surface.setWireframeDisplayed(true);
        surface.setWireframeColor(Color.BLACK);

        // Create a chart and add the surface
        Chart chart = new AWTChart(Quality.Advanced);
        chart.add(surface);
        chart.addController(new AWTCameraMouseController());
        chart.open(title, 512, 512);
    }
}
