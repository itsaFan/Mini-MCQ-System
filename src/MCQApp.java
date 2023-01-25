import structure.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MCQApp {

    public static void main(String[] args) {

        try {
            System.out.println("\n***************************");
            System.out.println("Welcome to the MCQ Beta");
            System.out.println("***************************\n");

            System.out.print("Enter your Name : ");
            Scanner sc = new Scanner(System.in);
            Learner learner = new Learner(sc.nextLine());

            System.out.println("\nWelcome " + learner.getName() + " :) " );

            FileConfig csvQuestionSet = new FileConfig("src/storequestion", "csv");

            File[] files = csvQuestionSet.getQuestionFile();
            csvQuestionSet.displayAllFiles();

            System.out.println("Choose Question Set that You Want");
            System.out.print("Set Question No : ");
            int selectFile = sc.nextInt();

            String filePath = files[selectFile-1].getAbsolutePath();

            System.out.println();
            System.out.println("You select : " + filePath);
            System.out.println();

            Scanner fr = new Scanner(new FileReader(filePath));
            while (fr.hasNextLine()) {
                String line = fr.nextLine();

                Mcq item = new Mcq(line.split(","));

                System.out.print(Mcq.getCount() + ". ");
                item.displayMCQ();

                System.out.print("\nEnter your answer : ");
                int learnerAnswer = sc.nextInt();
                if(item.evaluate(learnerAnswer)) {
                    learner.addLearnerScore();
                }
            }
            sc.close();
            fr.close();

            //grading
            learner.gradingPhase(Mcq.getCount());

            //result
            System.out.println("Quiz complete!\n" + learner.getName() + ", you answered " + learner.getScore()
            + " Questions Right, " + (Mcq.getCount() - learner.getScore()) + " Questions Wrong for a Total of " + Mcq.getCount() + " Questions.");
            System.out.println("You scored " + (int)learner.getGrade() + "%.");

        } catch (IOException e) {
            e.printStackTrace();
        }




    }

}
