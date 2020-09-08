public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);

		in.readInt();
		return in.readDouble();
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);

        int size = in.readInt();
        in.readDouble();
        
        Planet[] planets = new Planet[size];
        for (int i = 0; i < size; i++) {
            planets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
        }
        return planets;
    }

    private static int readSize(String filename) {
        In in = new In(filename);

        return in.readInt();
    }

    private static void drawPlanets(Planet[] planets) {
        for (Planet p: planets) {
            p.draw();
        }
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        int size = readSize(filename);
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");

        drawPlanets(planets);

        StdDraw.enableDoubleBuffering();
        double time;
        for (time = 0; time < T; time += dt) {
            double[] xForces = new double[size];
            double[] yForces = new double[size];

            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            drawPlanets(planets);
			StdDraw.show();
            StdDraw.pause(10);
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
}
