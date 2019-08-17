/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answerquestion;

import java.util.HashMap;

/**
 *
 * @author Gh.Alizadeh
 */
public class QuestionRepository implements IRepository {

    private final HashMap<String, Entry> Entries = new HashMap<String, Entry>();

    public void AddEntry(String Question, Entry entry) {
        Entries.put(Question, entry);
    }

    public Entry getEntry(String Question) {
        return Entries.getOrDefault(Question, null);
    }

    public boolean hasEntry(String Question) {
        return Entries.containsKey(Question);
    }
}
