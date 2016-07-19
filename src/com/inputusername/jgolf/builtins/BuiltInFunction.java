package com.inputusername.jgolf.builtins;

import com.inputusername.jgolf.Interpreter;
import com.inputusername.jgolf.Namespace;
import com.inputusername.jgolf.Stack;

/**
 * Created by Koen on 6-7-2016.
 */
public interface BuiltInFunction {
    void execute(Interpreter interpreter, Stack stack, Namespace variables, StringBuilder output);
}
