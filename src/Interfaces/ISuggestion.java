/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.Suggestion;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ISuggestion <S> {
    
    
            public void ajouterSuggestion(S s);
    public void supprimerSuggestion(S s);
    public void updateSuggestion(S s , int id);
    public void updateSuggestionAnswer(S s , int id);
    public List<S> displaySuggestion();
    
}
