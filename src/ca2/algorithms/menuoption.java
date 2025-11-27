/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2.algorithms;

/**
 *
 * @author sarna
 */
public enum menuoption {
    
    SORT(1, "Sort employees list"),
    SEARCH(2, "Search employee by name"),
    ADD_RECORD(3, "Add new employee"),
    CREATE_TREE(4, "Build employee hierarchy"),
    EXIT(5, "Exit program");

    public final int code;
    public final String text;
    
    menuoption(int code, String text) {
        this.code = code;
        this.text = text;
}
    public static menuoption fromCode(int code) {
        for (menuoption m : values()) {
            if (m.code == code) {
                
            }
        }
        return null;
    }
}
