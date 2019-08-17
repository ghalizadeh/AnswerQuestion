/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answerquestion;

/**
 *
 * @author Gh.Alizadeh
 */
public abstract class Entry {

    private String question;
    private String[] answers;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String QuestionValue) {
        question = QuestionValue;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] AnswersValue) {
        answers = AnswersValue;
    }
}
