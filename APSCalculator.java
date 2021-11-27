package apcalculator;

import java.util.ArrayList;
import java.util.Scanner;

public class APSCalculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfSubjects = 0;

        boolean inputCorrect = false;

        while(!inputCorrect) {
            try {
                System.out.println("How many subjects did you take?");
                numberOfSubjects = Integer.parseInt(scan.nextLine());
                inputCorrect = true;
            } catch (NumberFormatException i) {
                System.out.println("Please enter a number!");
            }
        }

        ArrayList<String> subject = new ArrayList<>(numberOfSubjects);
        ArrayList<Integer> mark = new ArrayList<>(numberOfSubjects);

        int points = 0;
        int sum = 0;
        String mySubjects = "";

        while(true) {

            while(true){

                System.out.println("Enter Subjects/ Enter X to end: ");
                mySubjects = scan.nextLine();

                boolean inputResult = mySubjects.matches("[a-zA-Z]+([\\s][a-zA-Z]+)*");

                if(!inputResult){
                    System.out.println("Please check spelling. Enter Alphabets only!");
                } else {
                    subject.add(mySubjects);
                    break;

                }
            }

            if (mySubjects.equalsIgnoreCase("X")) {
                break;
            }

            boolean correctMarkInput = false;

            while (!correctMarkInput) {
                try {
                    System.out.println("Enter Marks Obtained: ");
                    int myMark = Integer.parseInt(scan.nextLine());
                    correctMarkInput = true;
                    mark.add(myMark);
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number!");
                }
            }

        }

            for (int i = 0; i < subject.size() - 1; i++) {

                if (mark.get(i) >= 80 && mark.get(i) <= 100) {
                    points = 7;
                } else if (mark.get(i) >= 70 && mark.get(i) <= 79) {
                    points = 6;
                } else if (mark.get(i) >= 60 && mark.get(i) <= 69) {
                    points = 5;
                } else if (mark.get(i) >= 50 && mark.get(i) <= 59) {
                    points = 4;
                } else if (mark.get(i) >= 40 && mark.get(i) <= 49) {
                    points = 3;
                } else if (mark.get(i) >= 30 && mark.get(i) <= 39) {
                    points = 2;
                } else if (mark.get(i) >= 0 && mark.get(i) <= 29) {
                    points = 1;
                } else {
                    System.out.println("No marks were entered!");
                }
                sum = sum + points;
            }

            displayInfo(subject,mark,sum,points);
    }

    public static void displayInfo(ArrayList<String> subject,ArrayList<Integer> mark, int sum,int points) {
        System.out.println("****************************");
        System.out.println("APS SCORE RESULTS");
        System.out.println("*****************************");

        for (int i = 0; i < subject.size() - 1; i++) {
            System.out.println("Subject: " + subject.get(i) + " Mark: " + mark.get(i) + " Points: " + points);
        }
        System.out.println();
        System.out.println("Total APS Points: " + sum);
    }

}
