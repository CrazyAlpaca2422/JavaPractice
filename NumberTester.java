/*  SWENG 586 - Coding Challenge 5
 *   By Lauren Hutchison
 *   6/10/2018
 */
package com.company;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class CodeChallenge5 {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to the Prime, Perfect Square and Perfect Number Tester\n" +
                "\n" +
                "Enter the name of the output file: ");
        String fileName = input.nextLine();

        System.out.print("Enter a start number: ");
        String in = input.nextLine();
        int startNum = Integer.parseInt(in);
        System.out.print("Enter a stop number: ");
        String in2 = input.nextLine();
        int endNum = Integer.parseInt(in2);
        System.out.print("\n" + "\n");


        //creating file
        PrintWriter file = new PrintWriter(fileName);

        //get the factors
        for(int i = startNum; i <= endNum; i++){
            ArrayList<Integer> finalFactors =factors(i);

            System.out.print("The number " + i + " is: ");
            file.print("The number " + i + " is: ");
            if(prime(finalFactors, i)){
                file.println("Prime");
                System.out.print("Prime" + "\n");
            }
            else if(PerfectSquare(i)){
                file.println("Perfect Square");
                System.out.print("Perfect Square" + "\n");
            }
            else if (perfect(finalFactors, i)){
                file.println("Perfect");
                System.out.print("Perfect" + "\n");
            }
            else if (!perfect(finalFactors, i) && deficient(finalFactors, i)){
                file.println("Imperfect Deficient");
                System.out.print("Imperfect Deficient" + "\n");
            }
            else if (!perfect(finalFactors, i) && abundant(finalFactors, i)){
                file.println("Imperfect Abundant");
                System.out.print("Imperfect Abundant" + "\n");
            }else{
                System.out.print("Oh no, error :(");
            }

        }
        file.close();

        System.out.println();

        System.out.print("Enter the name of the input file to search: ");
        String searchFile = input.nextLine();

        System.out.print("Enter the string to search: ");
        String searchString = input.nextLine();

        System.out.println();

        BufferedReader reader = new BufferedReader(new FileReader(searchFile));
        ArrayList<String> fileLines = new ArrayList<String>();
        String row = reader.readLine();

        while (row != null){
            fileLines.add(row);
            //System.out.println(row);
            row=reader.readLine();
        }
        reader.close();

        int position = 0;
        while(position < fileLines.size()){
            //System.out.println(position);
            String line = fileLines.get(position);
            if(line.contains(searchString)){
                System.out.println(line);
            }
            position++;
        }


    }

    //Generates the factors for the number
    public static ArrayList<Integer> factors(int x){
        //this will hold the factors
        ArrayList<Integer> numFactors = new ArrayList<Integer>();

        for(int i = 1; i < x; i++){
            if (x % i == 0) {
                numFactors.add(i);
            }
        }
        return numFactors;
    }

    //is the number perfect?
    public static Boolean perfect(ArrayList<Integer> nums, int mainNum){

        int total = 0;
        Boolean perfect = false;

        for (int i = 0; i < nums.size(); i++) {
            total += nums.get(i);
        }

        if(total == mainNum) {
            perfect = true;
        }

        return perfect;
    }

    //is the number prime
    public static Boolean prime(ArrayList<Integer> nums, int mainNum){
        int total = 0;
        Boolean prime = true;

        for (int i = 1; i < nums.size(); i++) {
            if (mainNum % 1 == 0) {
                prime = false;
            }
        }

        return prime;
    }

    //is the number deficient?
    public static Boolean deficient(ArrayList<Integer> nums, int mainNum){

        int total = 0;
        Boolean deficient = false;

        for (int i = 0; i < nums.size(); i++) {
            total += nums.get(i);
        }

        if(mainNum > total) {
            deficient = true;
        }

        return deficient;
    }

    //is the number abundant?
    public static Boolean abundant(ArrayList<Integer> nums, int mainNum){

        int total = 0;
        Boolean abundant = false;

        for (int i = 0; i < nums.size(); i++) {
            total += nums.get(i);
        }

        if(mainNum < total) {
            abundant = true;
        }

        return abundant;
    }

    //is the number a perfect square?
    public static Boolean PerfectSquare(int mainNum){

        Boolean Ps = false;

        double square = (int)Math.sqrt(mainNum);

        if((square*square) == mainNum){
            Ps = true;
        }

        return Ps;
    }
}
