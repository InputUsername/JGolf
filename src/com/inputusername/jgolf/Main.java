package com.inputusername.jgolf;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);

        System.out.print("code: ");
        String c = s.nextLine();

        if (args[0].equals("-i")) {
            Interpreter interpreter = new Interpreter();
        }
        else if (args[0].equals("-t")) {
            List<Token> ts = Tokenizer.tokenize(c);

            System.out.println("--- Token list dump ---");

            for (Token t : ts) {
                System.out.println(t.toString());
            }
        }
	}
}
