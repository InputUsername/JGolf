package com.inputusername.jgolf;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Koen on 4-7-2016.
 */
class BuiltIns {
    private final static List<String> builtIns = Arrays.asList(
            "~",
            "`",
            "!",
            "@",
            "$",
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
            "base"
    );

    static boolean exists(String builtIn) {
        return builtIns.contains(builtIn);
    }
}