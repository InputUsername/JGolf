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
        ASSIGN,
        OTHER
    }

    private String tokenString;
    private Type tokenType;

    Token(String tokenString, Type tokenType) {
        this.tokenString = tokenString;
        this.tokenType = tokenType;
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
