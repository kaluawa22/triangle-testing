/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software.design.assignment.pkg1;

import java.util.*;
import java.lang.Math;

/**
 *
 * @author kaluawa
 */
public class SoftwareDesignAssignment1 {
    
    
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        Scanner scnr2 = new Scanner(System.in);
        double side1, side2, side3;
        double x1, x2, x3, y1, y2, y3;
        double distanceOne;
        double distanceTwo;
        double distanceThree;
        
        System.out.print("Enter The Lenght of Side 1: ");
        side1 = scnr.nextDouble();
        System.out.print("Enter The Lenght of Side 2: ");
        side2 = scnr.nextDouble();
        System.out.print("Enter The Lenght of Side 3: ");
        side3 = scnr.nextDouble();
        System.out.print("Enter The X1 Coordinate: ");
        x1 = scnr2.nextDouble();
        System.out.print("Enter The Y1 Coordinate: ");
        y1 = scnr2.nextDouble();
        System.out.print("Enter The X2 Coordinate: ");
        x2 = scnr2.nextDouble();
        System.out.print("Enter The Y2 Coordinate: ");
        y2 = scnr2.nextDouble();
        System.out.print("Enter The X3 Coordinate: ");
        x3 = scnr2.nextDouble();
        System.out.print("Enter The Y3 Coordinate: ");
        y3 = scnr2.nextDouble();
        Triangle triangle = new Triangle(side1, side2, side3);
        //Point point = new Point(x1,x2,y1,);
        //distanceOne = point.DistanceTo(x1,x2,y1,y2);
        //distanceTwo = point.secondDistanceTo(x2,x3,y2,y3);
        //distanceThree = point.thirdDistanceTo(x3,x1,y3,y1);
        double fixedPArea = triangle.getArea(side1, side2, side3);
        //double fixedCordArea = triangle.getArea(distanceOne,distanceTwo,distanceThree);
        System.out.println("The Type of Triangle is : "+triangle.determineType());
        System.out.println("The Area of this Triangle using the Length of the sides is : " + triangle.squareRoot(fixedPArea));
        //System.out.println("The Area of this Triangle based on those coordinates is: " + triangle.squareRoot(fixedCordArea));
        //System.out.println("This is distance 1: "+ distanceOne);
        //System.out.println("This is distance 1: "+ y1);
        //System.out.println("This is distance 1: "+ x2);
    }
    
    public static class Triangle {
        private double side1;
        private double side2;
        private double side3;
        
        Triangle() {
            side1 = side2 = side3 = 0.1;
        }
        Triangle(double s1, double s2, double s3) {
            side1 = s1;
            side2 = s2;
            side3 = s3;
        }
        Triangle(double s) {
            side1 = side2 = side3 = s;
        }
        
        public double getSide1() {
            return side1;
        }

        public double getSide2() {
            return side2;
        }

        public double getSide3() {
            return side3;
        }

        public void setSide1(double side1) {
            this.side1 = side1;
        }


        public void setSide2(double side2) {
            this.side2 = side2;
        }

        public void setSide3(double side3) {
            this.side3 = side3;
        }

        public String toString() {
            return "side 1: " + side1 + ", side 2: " + side2 + ", side3: " + side3;
        }

        public String determineType() {
            String result = "";
            if (side1 == side2 && side2 == side3)
                result += "Equilateral";
                    else if (side1 == side2 || side2 == side3 || side3 == side1)
                    result += "Isosceles";
            else
                result += "Scalene";
            if(isRightAngle())
                result += " and Right";
            return result;
        }
        public boolean isRightAngle() {
            if (side1 > side2 && side1 > side3) {
                if (side1 * side1 == (side2 * side2) + (side3 * side3))
                    return true;
            } 
            else if (side2 > side1 && side2 > side3) {
                if (side2 * side2 == (side1 * side1) + (side3 * side3))
                    return true;
            } else {
                if (side3 * side3 == (side1 * side1) + (side2 * side2))
                    return true;
                }
            return false;
        }
        
        public double getArea(double side1,double side2,double side3) {
            double sidePerimeter = ((side1 + side2 + side3)/2);
            double insideSqrt = (sidePerimeter * (sidePerimeter - side1) * (sidePerimeter - side2) * (sidePerimeter - side3));
            double Area = insideSqrt;
            return Area;
            
        }
        
        public static double squareRoot(double Area) {
        double squareRoot = 0;
        double startValue = 0;
        double endValue = Area;
        double precision = 0.00001;
 
        if (Area < 0) {
            squareRoot = -1;
        } else if (Area == 0 || Area == 1) {
            squareRoot = Area;
        } else {
 
            // we will use binary search to narrow down.
            while (endValue - startValue > precision) {
                double midValue = (startValue + endValue) / 2;
                squareRoot = midValue * midValue;
 
                if (squareRoot == Area) {
                    return squareRoot;
                } else if (squareRoot > Area) {
                    endValue = midValue;
                } else {
                    startValue = midValue;
                }
            }
 
            // if a match is not found
            squareRoot = (startValue + endValue) / 2;
 
        }
        return squareRoot;
        
        }
    }
    public static class Point{
        private int x1;
        private int x2;
        private int y1;
        private int y2;
        
        
        public int Point(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = y2;
            this.y2 = y2;
            
        }
        
        public double getX1(){
            return x1;
        }

        public double getY1() {
            return y1;
        }
        public double getX2() {
            return x2;
        }

        public double getY2() {
            return y2;
        }
        /*public double getX3() {
            return x3;
        }

        public double getY3() {
            return y3;
        }    
        */

        public void setX1(int x1) {
            this.x1 = x1;
        }

        public void setY1(int y1) {
            this.y1 = y1;
        }
        public void setX2(int x2) {
            this.x2 = x2;
        }

        public void setY2(int y2) {
            this.y2 = y2;
        }
        /*public void setX3(double x3) {
            this.x3 = x3;
        }

        public void setY3(double y3) {
            this.y3 = y3;
        }
         */



        public double DistanceTo(double x1, double x2, double y1, double y2) {
            double dx1 = this.x2 - this.x1;
            double dy1 = this.y2 - this.y1;
            double fullDistance1 = Math.sqrt(dx1*dx1 + dy1*dy1);
            return fullDistance1;
        }
        /*public double secondDistanceTo(double x3, double x2, double y3, double y2) {
            double dx2 = this.x3 - this.x2;
            double dy2 = this.y3 - this.y2;
            double fullDistance2 = Math.sqrt(dx2*dx2 + dy2*dy2);
            return fullDistance2;
        }
        public double thirdDistanceTo(double x3, double x1, double y3, double y1) {
            double dx3 = this.x3 - this.x1;
            double dy3 = this.y3 - this.y1;
            double fullDistance3 = Math.sqrt(dx3*dx3 + dy3*dy3);
            return fullDistance3;
        } */
        
    }
}
        
        
        
    /* return a string representation of this point
        public String toString() {
            return "(" + x + ", " + y + ")";
        } */

        
    
    
    
    
    

    
    
 
    

