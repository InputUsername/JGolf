package com.inputusername.jgolf.builtins;

import com.inputusername.jgolf.Interpreter;
import com.inputusername.jgolf.Namespace;
import com.inputusername.jgolf.Stack;
import com.inputusername.jgolf.types.GSObject;

/**
 * Created by Koen on 20-7-2016.
 */
public class AtSign implements BuiltInFunction {
    /*
    Stack rotate
     */
    @Override
    public void execute(Interpreter interpreter, Stack stack, Namespace variables, StringBuilder output) {
        GSObject first = stack.pop(), second = stack.pop(), third = stack.pop();
        stack.push(second);
        stack.push(first);
        stack.push(third);
    }
}
