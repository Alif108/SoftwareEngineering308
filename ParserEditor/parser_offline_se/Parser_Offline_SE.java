/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser_offline_se;

import Editor.Editor;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class Parser_Offline_SE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter File Name: ");
        
        String s = scanner.nextLine();
        
        Editor e = Editor.getInstance();
        e.setEditor(s);
        e.show();
    }
}
