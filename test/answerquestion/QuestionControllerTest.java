/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answerquestion;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gh.Alizadeh
 */
public class QuestionControllerTest {
    
    public QuestionControllerTest() {
        
    }
    

    IRepository Repository;
    QuestionController instance;
    @Before
    public void setUp() {  
        Repository=new QuestionRepository();
        instance = new QuestionController(Repository);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of DefineQuestion method, of class QuestionController.
     */
    @Test
    public void test1_DefineQuestion() {
        System.out.println("test1_DefineQuestion");
        String input = "What is Peters favorite food? \"Pizza\" \"Spaghetti\" \"Ice cream\"";
        String expResult = "The Question is defined successfully.";
        String result = instance.DefineQuestion(input);
        assertEquals(expResult, result);
    }

    @Test
    public void test2_AnswerDefinedQuestion() {
        System.out.println("test2_AnswerDefinedQuestion");
        String input = "What is Peters favorite food? \"Pizza\" \"Spaghetti\" \"Ice cream\"";
        instance.DefineQuestion(input);
        String Question = "What is Peters favorite food"; 
        String expResult = "Pizza\nSpaghetti\nIce cream\n";
        String result2 = instance.AnswerQuestion(Question);
        assertEquals(expResult, result2);
    }
    
    @Test
    public void test3_AnswerNotDefinedQuestion() {
        System.out.println("test3_AnswerNotDefinedQuestion");
        String Question = "What is Peters favorite food"; 
        String expResult = "the answer to life, universe and everything is 42";
        String result = instance.AnswerQuestion(Question);
        assertEquals(expResult, result);
    }
    
    @Test
    public void test4_DefineBadFormatQuestion() {
        System.out.println("test4_DefineBadFormatQuestion");
        String Question = "What is Peters favorite fooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
                + "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
                + "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooood? "
                + "\"Pizza\" \"Spaghetti\" \"Ice cream\""; 
        String expResult = "Failed to defining the new question:\nQuestion must be maximum 255 characters";
        String result = instance.DefineQuestion(Question);
        assertEquals(expResult, result);   
    }
    
    @Test
    public void test5_DefineBadFormatAnswer() {
        System.out.println("test5_DefineBadFormatAnswer");
        String Question = "What is Peters favorite food? \"Pizza\" \"Spaghetti\" \"Ice creammmmmmmmmm"
                + "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                + "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"
                + "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm\""; 
        String expResult = "Failed to defining the new question:\nEach answer must be maximum 255 characters";
        String result = instance.DefineQuestion(Question);
        assertEquals(expResult, result);   
    }
}
