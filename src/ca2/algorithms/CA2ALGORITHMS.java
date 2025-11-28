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
    // load csv
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
        } catch (Exception e) {
            System.out.println("Ërror loading file.");
        }
    }
    
    // mergesort
    static void sort() {
        mergeSort(0, list.size()-1);
        System.out.println("SOrted showing first20");
        for(int i=0;i<Math.min(20,list.size());i++)
            System.out.println(list.get(i).name);
    }
    
    static void mergeSort(int L,int R){
        if(L>=R) return;
        int mid=(L+R)/2;
        mergeSort(L,mid); mergeSort(mid+1,R);
        merge(L,mid,R);
    }
    
    static void merge(int L,int M,int R){
        List<employee> temp=new ArrayList<>();
        int i=L,j=M+1;

        while(i<=M && j<=R){
            if(list.get(i).name.compareToIgnoreCase(list.get(j).name)<=0)
                temp.add(list.get(i++));
            else temp.add(list.get(j++));
        }
        while(i<=M) temp.add(list.get(i++));
        while(j<=R) temp.add(list.get(j++));

        for(int k=L;k<=R;k++) list.set(k,temp.get(k-L));
    }
    
    // binary search
    static void search(){
        sort(); // make sure sorted
        System.out.print("Enter name: ");
        String t=input.nextLine();

        int L=0,R=list.size()-1;
        while(L<=R){
            int mid=(L+R)/2;
            int cmp=list.get(mid).name.compareToIgnoreCase(t);
            if(cmp==0){
                System.out.println("FOUND → "+list.get(mid));
                return;
            }
            if(cmp<0) L=mid+1;
            else R=mid-1;
        }
        System.out.println("Not found.");
    }
    
    //adding record
    static void addRecord(){
        System.out.print("Name: "); String name=input.nextLine();
        System.out.print("Manager Type: "); String type=input.nextLine();
        System.out.print("Department: "); String dept=input.nextLine();

        list.add(new employee(name,type,dept));
        System.out.println("Added.");
    }
    
    // binary tree
     static void createTree(){
        if(list.size()<20){
            System.out.println("Need 20 employees.");
            return;
        }

        root=null;
        for(int i=0;i<20;i++) insert(list.get(i));

        System.out.println("\nTree Level Order:");
        levelOrder();

        System.out.println("Height = "+height(root));
        System.out.println("Nodes = "+count(root));
    }
     
      static void insert(employee e){
        if(root==null){ root=new treenode(e); return;}
        Queue<treenode>q=new LinkedList<>(); q.add(root);

        while(!q.isEmpty()){
            treenode n=q.remove();
            if(n.left==null){ n.left=new treenode(e); return;}
            if(n.right==null){ n.right=new treenode(e); return;}
            q.add(n.left); q.add(n.right);
        }
    }
      
      static void levelOrder(){
          Queue<treenode>q=new LinkedList<>(); q.add(root);
          while(!q.isEmpty()){
              treenode n=q.remove();
              System.out.println(n.data);
              if(n.left!=null)q.add(n.left);
              if(n.right!=null)q.add(n.right);
          }
      }
      
      static int height(treenode n){
          return n==null?0:1+Math.max(height(n.left),height(n.right));
      }
      
      static int count(treenode n){
          return n==null?0:1+count(n.left)+count(n.right);
      }
}
