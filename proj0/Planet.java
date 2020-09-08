import java.lang.Math;

public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static double G = 6.67 * Math.pow(10, -11);

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    private double dx(Planet p) {
        return p.xxPos - this.xxPos;
    }

    private double dy(Planet p) {
        return p.yyPos - this.yyPos;
    }

    public double calcDistance(Planet p) {
        return Math.sqrt(Math.pow(dx(p), 2) + Math.pow(dy(p), 2));
    }

    public double calcForceExertedBy(Planet p) {
        return G * this.mass * p.mass / Math.pow(calcDistance(p), 2);
    }

    public double calcForceExertedByX(Planet p) {
        return calcForceExertedBy(p) * dx(p) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return calcForceExertedBy(p) * dy(p) / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] ps) {
        double sum = 0;
        for (Planet p: ps) {
            if (!this.equals(p)) {
                sum += calcForceExertedByX(p);
            }
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] ps) {
        double sum = 0;
        for (Planet p: ps) {
            if (!this.equals(p)) {
                sum += calcForceExertedByY(p);
            }
        }
        return sum;
    }

    public void update(double dt, double fX, double fY) {
        double ax = fX / this.mass;
        double ay = fY / this.mass;

        this.xxVel = this.xxVel + dt * ax;
        this.yyVel = this.yyVel + dt * ay;

        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}
