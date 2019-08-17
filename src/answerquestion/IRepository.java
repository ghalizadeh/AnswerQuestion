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
public interface IRepository {
    void AddEntry(String Question,Entry entry); 
    Entry getEntry(String Question);
    boolean hasEntry(String Question);
}
