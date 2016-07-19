package com.inputusername.jgolf;

import com.inputusername.jgolf.builtins.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Koen on 4-7-2016.
 */
class BuiltIns {
    private final static HashMap<String, BuiltInFunction> builtIns = new HashMap<>();

    static {
        builtIns.put("~", new Tilde());
        builtIns.put("`", new Backtick());
        builtIns.put("!", new ExclamationMark());
        builtIns.put("@", new AtSign());
        builtIns.put("$", new DollarSign());
                "+",
                "-",
                "*",
                "/",
                "%",
                "|",
                "&",
                "^",
                "[",
                "]",
                "\\",
                ";",
                "<",
                ">",
                "=",
                ",",
                ".",
                "?",
                "(",
                ")",
                "and",
                "or",
                "xor",
                "print",
                "p",
                "n",
                "puts",
                "rand",
                "do",
                "while",
                "until",
                "if",
                "abs",
                "zip",
                "base"*/
    }

    static boolean exists(String builtIn) {
        return builtIns.containsKey(builtIn);
    }

    static void execute(String builtIn, Interpreter interpreter, Stack stack, Namespace variables, StringBuilder output) {
        builtIns.get(builtIn).execute(interpreter, stack, variables, output);
    }
}