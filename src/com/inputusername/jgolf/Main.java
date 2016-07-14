package com.inputusername.jgolf;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Stack stack = new Stack();
        Namespace variables = new Namespace();
        StringBuilder output = new StringBuilder();

        Interpreter interpreter = new Interpreter(stack, variables, output);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert GS code> ");

        interpreter.interpret(scanner.nextLine());

        System.out.println(output.toString());
	}
}
