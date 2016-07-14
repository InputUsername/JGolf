package com.inputusername.jgolf;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Koen on 3-7-2016.
 */

//TODO: fix nested blocks
//TODO: support escaped strings

class Tokenizer {
    // [a-zA-Z_][a-zA-Z_]*|-?[0-9]+|\\{[^\\}]*\\}|'(?:\\.|[^'])*'?|\"(?:\\.|[^\"])*\"?|#[^\n\r]*|.
    private final static String REGEX = "[a-zA-Z_][a-zA-Z_]*|-?[0-9]+|\\{[^\\}]*\\}|'(?:\\.|[^'])*'?|\"(?:\\.|[^\"])*\"?|#[^\n\r]*|.";
    private final static Pattern pattern = Pattern.compile(REGEX);

    static List<Token> tokenize(String code) {
        List<Token> tokens = new ArrayList<>();

        Matcher matcher = pattern.matcher(code);

        while (matcher.find()) {
            Token token = new Token(matcher.group());
            tokens.add(token);
        }

        return tokens;
    }
}
