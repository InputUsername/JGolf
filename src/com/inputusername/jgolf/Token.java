package com.inputusername.jgolf;

/**
 * Created by Koen on 3-7-2016.
 */
class Token {
    enum Type {
        WORD,
        NUMBER,
        BLOCK,
        STRING,
        COMMENT,
        OTHER
    }

    private String tokenString;
    private Type tokenType;

    private Token(String tokenString, Type tokenType) {
        this.tokenString = tokenString;
        this.tokenType = tokenType;
    }

    Token(String tokenString) {
        this(tokenString, findTokenType(tokenString));
    }

    private static Type findTokenType(String tokenString) {
        if (tokenString.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            return Type.WORD;
        }
        else if (tokenString.matches("-?[0-9]+")) {
            return Type.NUMBER;
        }
        else if (tokenString.startsWith("{") && tokenString.endsWith("}")) {
            return Type.BLOCK;
        }
        else if (tokenString.matches("'(?:\\.|[^'])*'?") || tokenString.matches("\"(?:\\.|[^\"])*\"?")) {
            return Type.STRING;
        }
        else if (tokenString.startsWith("#")) {
            return Type.COMMENT;
        }
        else {
            return Type.OTHER;
        }
    }

    public String getTokenString() {
        return tokenString;
    }

    public Type getTokenType() {
        return tokenType;
    }

    public String toString() {
        return tokenType.toString() + " token: " + tokenString;
    }
}
