/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca2.algorithms;

import java.io.File;
import java.util.*;

/**
 *
 * @author sarna
 */
public class CA2ALGORITHMS {

    static Scanner input = new Scanner(System.in);
    static List<employee> list = new ArrayList<>();
    static treenode root;
    
    public static void main(String[] args) {
     
        System.out.print("Enter CSV filename: ");
        loadFile(input.nextLine());

        while (true) {
            System.out.println("\n============== MENU ==============");
            System.out.println("1. Sort Employees");
            System.out.println("2. Search Employee");
            System.out.println("3. Add Record");
            System.out.println("4. Create Binary Tree (20 employees)");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int c = Integer.parseInt(input.nextLine());
            menuoption option = menuoption.fromCode(c);

            if (option == null) {
                System.out.println("Invalid");
                continue;
            }

            switch (option) {
                case SORT -> sort();
                case SEARCH -> search();
                case ADD_RECORD -> addRecord();
                case CREATE_TREE -> createTree();
                case EXIT -> { System.out.println("Goodbye"); return; }
            }
        }   
    }
    
    static void loadFile(String file) {
        try {
            Scanner sc = new Scanner(new File(file));
            
            sc.nextLine();
            
            while (sc.hasNextLine()) {
                String[] a = sc.nextLine().split(",");
                
                String name = a[0] + " " + a[1];
                String dept = a[5];
                String type = a[6].length()>0 ? a[6] : (a[7].length()>0 ? a[7] : "staff");
                
                list.add(new employee(name, type , dept));              
            }
            System.out.println("Loaded: " + list.size());
        } catch ( Exeption e) {
            System.out.println("Ërror loading file.");
        }
    }
    
}
