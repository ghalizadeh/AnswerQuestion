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
public class QuestionController {
   
    private final IRepository _repository;
    
    public QuestionController(IRepository Repository)
    {
        _repository=Repository;
       
    }
    
    /**
     * To define a question with specific answer/answers.
     * @param Input the input string should be like: question? “answer1” “answer2” “answerX” 
     * @return The result of definition that could be successful or failed.
     */
    public String DefineQuestion(String Input)
    {
        try
        {    
             String[] SplitedInput = Input.split("\\?",0);
             String Answer=SplitedInput[1].trim().replace("\" \"", ",").replace("\"", "");
             String[] TrimedAnswers=Answer.split(",");
             //String[] Answers=SplitedInput[1].split("\" \"");  
             //String[] TrimedAnswers=new String[Answers.length];
             //for (int i=0; i<Answers.length; i++) 
             //{ 
             //   TrimedAnswers[i]=Answers[i].replaceAll("\"", "").trim();
             //}
             Entry entry=new QuestionEntry();
             entry.setQuestion(SplitedInput[0]);
             entry.setAnswers(TrimedAnswers);
             _repository.AddEntry(entry.getQuestion(), entry);
            return "The Question is defined successfully.";
        }
        catch(Exception ex)
        {
         return "Failed to defining the new question:\n"+ex.getMessage();
        }
    }
    
    /**
     * To find the answer for specific question   
     * @param Question in format: question?
     * @return the answer/answers would be returned in one or several lines.
     */
    public String AnswerQuestion(String Question)
    {
        StringBuilder AnswerBuilder=new StringBuilder();
        try
        {   
            if(_repository.hasEntry(Question))
            {
                Entry Founded_Question=_repository.getEntry(Question);
                if(Founded_Question!=null)
                {
                  for(String answer:Founded_Question.getAnswers())
                  {
                    AnswerBuilder.append(answer);                
                    AnswerBuilder.append("\n");
                  }
                  AnswerBuilder.deleteCharAt(AnswerBuilder.length()-1);
                }
            }
            else
                AnswerBuilder.append("the answer to life, universe and everything is 42");
        }
        catch(Exception ex)
        {
          AnswerBuilder.append("Failed to answer to the question:\n").append(ex.getMessage());
        }
        finally
        {
            return AnswerBuilder.toString();
        }
    }
    
    
}
