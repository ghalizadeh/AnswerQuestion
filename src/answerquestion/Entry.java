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
     
     public String getQuestion()
    {
        return question;  
    }
      
    public void setQuestion(String QuestionValue)
    {
        //if(QuestionValue.length()<=255)
          question= QuestionValue;
//        else
//             throw new IllegalArgumentException("Question must be maximum 255 characters");
    } 
    
    public String[] getAnswers()
    {
        return answers;
    }
    

    public void setAnswers(String[] AnswersValue)
    {
//        for(String answer:AnswersValue)
//           if(answer.length()>255)
//               throw new IllegalArgumentException("Each answer must be maximum 255 characters");
        answers= AnswersValue;
    }
}
