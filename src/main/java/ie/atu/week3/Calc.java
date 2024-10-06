package ie.atu.week3;

import java.util.Scanner;

public class Calc {
    public static void main(String[] args){
        double FirstNumber, SecondNumber, result;
        boolean VaildOperation = true;
        String operation;

        Scanner Input = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        FirstNumber = Input.nextDouble();

        System.out.println("Enter the second number: ");
        SecondNumber = Input.nextDouble();

        System.out.println("Please enter an operation: (Add, Sub, Mul, Dev, Pow)");
        operation = Input.next();

        result = switch (operation){
            case "Add": yield add(FirstNumber, SecondNumber);

            case "Sub": yield sub(FirstNumber, SecondNumber);

            case "Mul": yield mul(FirstNumber, SecondNumber);

            case "Div":{
                if (SecondNumber == 0){
                    VaildOperation = false;
                    yield 0;
                }
                yield div(FirstNumber, SecondNumber);
            }

            case "Pow": yield pow(SecondNumber, FirstNumber);

            default:{
                VaildOperation = false;
                yield 0;
            }
        };

        if (VaildOperation){
            System.out.println("The result is: " + result);
        } else {
            System.out.println("Invalid Operation");
        }


    }

    public static double add(double a, double b){
        return a + b;
    }

    public static double sub(double a, double b){
        return a - b;
    }

    public static double mul(double a, double b){
        return a * b;
    }

    public static double div(double a, double b){
        return a / b;
    }

    public static double pow(double a, double b) {
        return Math.pow(a, b);
    }
}
