/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answerquestion;

import java.util.Hashtable;

/**
 *
 * @author Gh.Alizadeh
 */
public class QuestionEntry extends Entry {

    @Override
    public void setQuestion(String QuestionValue) {
        if (QuestionValue.length() <= 255) {
            super.setQuestion(QuestionValue);
        } else {
            throw new IllegalArgumentException("Question must be maximum 255 characters");
        }
    }

    @Override
    public void setAnswers(String[] AnswersValue) {
        for (String answer : AnswersValue) {
            if (answer.length() > 255) {
                throw new IllegalArgumentException("Each answer must be maximum 255 characters");
            }
        }
        super.setAnswers(AnswersValue);
    }

}
