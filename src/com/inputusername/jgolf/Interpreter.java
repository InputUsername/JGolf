package com.inputusername.jgolf;

import com.inputusername.jgolf.types.*;

import java.util.List;

/**
 * Created by Koen on 4-7-2016.
 */
public class Interpreter {
    private Stack stack;
    private Namespace variables;
    private StringBuilder output;

    public Interpreter(Stack stack, Namespace variables, StringBuilder output) {
        this.stack = stack;
        this.variables = variables;
        this.output = output;
    }

    private void interpretString(String code) throws RuntimeException {
        List<Token> tokens = Tokenizer.tokenize(code);
        int tokenCount = tokens.size();

        for (int i = 0; i < tokenCount; i++) {
            Token token = tokens.get(i);
            String tokenString = token.getTokenString();
            Token.Type tokenType = token.getTokenType();

            if (tokenType == Token.Type.COMMENT) {
                continue;
            }

            if (tokenString.equals(":")) {
                if (i != tokenCount - 1) {
                    Token nextToken = tokens.get(i + 1);
                    Token.Type nextTokenType = nextToken.getTokenType();

                    switch (nextTokenType) {
                        case BLOCK:
                        case STRING:
                        case COMMENT:
                        case OTHER:
                            throw new AssignmentException("Cannot assign to " + nextTokenType.toString());
                    }

                    variables.put(nextToken.getTokenString(), stack.peek());
                }
                else {
                    throw new AssignmentException("End of code reached before assignment was completed");
                }

                ++i;
                continue;
            }

            if (variables.containsKey(tokenString)) {
                GSObject object = variables.get(tokenString);

                if (object instanceof GSBlock) {
                    String blockCode = ((GSBlock)object).getCharsAsString();
                    interpretString(blockCode);

                    continue;
                }
                else if (object instanceof GSNumber || object instanceof GSString
                        || object instanceof GSArray) {
                    stack.push(object);

                    continue;
                }
            }

            switch (tokenType) {
                case NUMBER:
                    int number = Integer.parseInt(tokenString);
                    stack.push(new GSNumber(number));
                    break;
                case STRING:
                    String string = tokenString.substring(1, tokenString.length() - 1);
                    stack.push(new GSString(string));
                    break;
                case BLOCK:
                    String block = tokenString.substring(1, tokenString.length() - 1);
                    stack.push(new GSBlock(block));
                    break;
                case WORD:
                case OTHER:
                    if (BuiltIns.exists(tokenString)) {
                        output.append("[builtin called: " + tokenString + "]");
                        //TODO: built-in functions
                    }
                    break;
            }
        }
    }

    public void interpret(String code) {
        try {
            interpretString(code);

            output.append(stack.toString());
        }
        catch (RuntimeException e) {
            output.append(e.getMessage());
        }
    }
}
