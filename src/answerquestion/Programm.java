/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answerquestion;

import java.util.Scanner;


/**
 *
 * @author Gh.Alizadeh
 */
public class Programm {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        IRepository Repository = new QuestionRepository();
        QuestionController Controller = new QuestionController(Repository);
        while (true) {
            System.out.println(">> Ask a question or Define a question");
            String input = sc.nextLine().trim();
            if (input.indexOf("?") == -1) {
                System.out.println("Incorrect Format");
                continue;
            }
            String[] SplitedInput = input.split("\\?", 0);
            if (SplitedInput.length == 1) {
                String _Question = SplitedInput[0];
                System.out.println(Controller.AnswerQuestion(_Question));
            } else if (SplitedInput.length == 2) {
                System.out.println(Controller.DefineQuestion(input));
            } else {
                System.out.println("Incorrect Format");
            }
        }
    }

}
