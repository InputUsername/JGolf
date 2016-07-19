package com.inputusername.jgolf;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Koen on 3-7-2016.
 */

class Tokenizer {
    static List<Token> tokenize(String code) {
        List<Token> tokens = new ArrayList<>();

        Log.p("starting tokenization");

        int length = code.length();
        for (int i = 0; i < length; i++) {
            char c = code.charAt(i);

            Log.p("char #" + i + ": " + c);

            if (c == '#') {
                // Comments

                int start = i;

                do {
                    i++;
                    if (i == code.length()) {
                        break;
                    }
                } while (code.charAt(i) != '\n');

                Token token = new Token(code.substring(start, i), Token.Type.COMMENT);
                tokens.add(token);

                i--;
            }
            else if (c == '"' || c == '\'') {
                // Strings

                char startChar = c;

                StringBuilder builder = new StringBuilder();

                builder.append(startChar);

                do {
                    i++;
                    if (i == code.length()) {
                        builder.append(startChar);
                        break;
                    }
                    c = code.charAt(i);

                    if (c == '\\') {
                        if (i == code.length() - 1) {
                            builder.append('\\');
                            builder.append(startChar);
                            break;
                        }

                        char escape = code.charAt(i + 1);
                        switch (escape) {
                            case '0': builder.append('\0'); break;
                            case 'b': builder.append('\b'); break;
                            case 't': builder.append('\t'); break;
                            case 'n': builder.append('\n'); break;
                            case 'f': builder.append('\f'); break;
                            case 'r': builder.append('\r'); break;
                            case '\\': builder.append('\\'); break;
                            default: builder.append(escape); break;
                        }
                        i++;
                    }
                    else {
                        builder.append(c);
                    }
                } while (c != startChar);

                Token token = new Token(builder.toString(), Token.Type.STRING);
                tokens.add(token);

                Log.p("string token: " + token.getTokenString());
            }
            else if (c == '{') {
                // Blocks

                StringBuilder builder = new StringBuilder();

                builder.append('{');

                int blockNesting = 1;

                do {
                    i++;
                    if (i == code.length()) {
                        break;
                    }
                    c = code.charAt(i);

                    if (c == '{') {
                        blockNesting++;
                    }
                    else if (c == '}') {
                        blockNesting--;
                    }

                    builder.append(c);
                } while (blockNesting != 0);

                Token token = new Token(builder.toString(), Token.Type.BLOCK);
                tokens.add(token);

                Log.p("block token: " + token.getTokenString());
            }
            else if (c == '-' || Character.isDigit(c)) {
                // Numbers

                boolean negative = (c == '-');
                if (negative) {
                    i++;
                    //TODO: string end check for negative numbers
                }

                int start = i;

                do {
                    i++;
                    if (i == code.length()) {
                        break;
                    }
                } while (Character.isDigit(code.charAt(i)));

                String numberString = code.substring(start, i);
                //TODO: parse number string (including negative sign)

                Token token = new Token(code.substring(start, i), Token.Type.NUMBER);
                tokens.add(token);

                i--;

                Log.p("number token: " + token.getTokenString());
            }
            else if (c == '_' || Character.isAlphabetic(c)) {
                // Words

                int start = i;

                do {
                    i++;
                    if (i == code.length()) {
                        break;
                    }
                    c = code.charAt(i);
                } while (c == '_' || Character.isLetterOrDigit(c));

                Token token = new Token(code.substring(start, i), Token.Type.WORD);
                tokens.add(token);

                i--;

                Log.p("word token: " + token.getTokenString());
            }
            else if (c == ':') {
                Token token = new Token(":", Token.Type.ASSIGN);
                tokens.add(token);
            }
            else {
                // Other

                Log.p("other token: " + c);

                Token token = new Token(Character.toString(c), Token.Type.OTHER);
                tokens.add(token);
            }
        }

        return tokens;
    }
}
