package com.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point {
    public static final Point ORIGIN = new Point(0,0);

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private double x;
    private double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Point(double x){
        this(x,0);
    }

    public Point(Point p) {
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y){
        this.y=y;
    }

    public void setXY(double x, double y){
        this.x=x;
        this.y=y;
    }

    public void printXY(){
        System.out.println("Point X " + x + " : " + "Point Y " + y);
    }

    double distanceToOrigin(){
        return distanceTo(new Point(ORIGIN));
    }

    double distanceTo(Point p){
        double dx=p.x-this.x;
        double dy=p.y-this.y;
        return Math.sqrt(dx*dx+dy*dy);
    }
}

class Circle {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    boolean containsPoint(Point p) {
        double distance = center.distanceTo(p);
        return distance<=radius;
    }
}

class PointList {
    List<Point> points = new ArrayList<>();

    int size() {
        return points.size();
    }

    void add(Point point) {
        System.out.println(point.getX() + "  " + point.getY());
        points.add(point);
    }

    Point get(int index) {
        return points.get(index);
    }

    List<Point> getAllPoints(int index) {
        return points;
    }

    List<Point> allPointsInOrOutOfTheCircle(Circle circle, boolean in) {
        List<Point> pointsInTheCircle = new ArrayList<>();
        List<Point> pointsOutTheCircle = new ArrayList<>();
        for (Point pnt: points) {
            if(circle.containsPoint(pnt)) {
                pointsInTheCircle.add(pnt);
            } else {
                pointsOutTheCircle.add(pnt);
            }
        }
        if(in) {
            return pointsInTheCircle;
        } else {
            return pointsOutTheCircle;
        }

    }
 }

public class Main {

    public static void main(String[] args) {
        Point point = new Point(2, 90);
        System.out.println(point.distanceToOrigin());
        Circle circle = new Circle(new Point(0, 100),20);
        if (circle.containsPoint(point)) {
            System.out.println("Contains");
        } else {
            System.out.println("Not contains");
        }

        Scanner scanner = new Scanner(System.in);

        String addNewPoint = "yes";

        PointList pointsList = new PointList();

        while (addNewPoint != "no") {
            System.out.println("Do you want to add new Point? yes/no");
            // statements
            addNewPoint = scanner.nextLine();
            switch (addNewPoint) {
                case "yes":
                    System.out.println("Enter point location X:");
                    double pointX = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter point location Y:");
                    double pointY = scanner.nextInt();
                    scanner.nextLine();

                    Point pointToAdd = new Point(pointX, pointY);
                    pointsList.add(pointToAdd);
                    break;
                case "no":
                    System.out.println("Provide coordinates for center of a circle");
                    System.out.println("Provide Circle X:");
                    double centerX = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Provide Circle Y:");
                    double centerY = scanner.nextInt();
                    scanner.nextLine();
                    Point centerPoint = new Point(centerX, centerY);

                    System.out.println("Provide Radius:");
                    double radius = scanner.nextInt();
                    Circle circlePoint = new Circle(centerPoint, radius);

                    System.out.println("Points that are part of the circle");
                    System.out.println(pointsList.allPointsInOrOutOfTheCircle(circlePoint, true));
                    addNewPoint = "no";
                    break;
                default:
                    System.out.println("thank you. bye!");
            }
        }
    }
}