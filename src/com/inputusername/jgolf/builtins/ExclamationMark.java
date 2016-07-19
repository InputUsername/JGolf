package com.inputusername.jgolf.builtins;

import com.inputusername.jgolf.Interpreter;
import com.inputusername.jgolf.Namespace;
import com.inputusername.jgolf.Stack;
import com.inputusername.jgolf.Util;
import com.inputusername.jgolf.types.GSNumber;
import com.inputusername.jgolf.types.GSObject;

/**
 * Created by Koen on 19-7-2016.
 */
public class ExclamationMark implements BuiltInFunction {
    /*
    Logical NOT: 0, [], "" and {} yield 1; anything else yield 0
     */
    @Override
    public void execute(Interpreter interpreter, Stack stack, Namespace variables, StringBuilder output) {
        boolean result = !Util.truthValue(stack.pop());
        stack.push(new GSNumber(result ? 1 : 0));
    }
}
