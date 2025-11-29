/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

public enum menuoption {
    SORT(1, "Sort Employees"),
    SEARCH(2, "Search Employee"),
    ADD_RECORD(3, "Add Record"),
    CREATE_TREE(4, "Create Binary Tree (20 employees)"),
    EXIT(5, "Exit");

    private final int code;
    private final String text;

    menuoption(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public static menuoption fromCode(int code) {
        for (menuoption m : values()) {
            if (m.code == code) {
                return m;
            }
        }
        return null;
    }
}
