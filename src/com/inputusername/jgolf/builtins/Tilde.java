package com.inputusername.jgolf.builtins;

import com.inputusername.jgolf.Interpreter;
import com.inputusername.jgolf.Namespace;
import com.inputusername.jgolf.Stack;
import com.inputusername.jgolf.types.*;

import java.util.List;

/**
 * Created by Koen on 19-7-2016.
 */
public class Tilde implements BuiltInFunction {
    /*
    For GSNumbers: bitwise NOT
    For GSStrings/Blocks: eval
    For GSArrays: dump
     */

    @Override
    public void execute(Interpreter interpreter, Stack stack, Namespace variables, StringBuilder output) {
        GSObject object = stack.pop();

        if (object instanceof GSString) {
            String code = ((GSString)object).getCharsAsString();
            interpreter.interpretString(code);
        }
        else if (object instanceof GSArray) {
            List<GSObject> objects = ((GSArray)object).getObjects();
            for (GSObject obj : objects) {
                stack.push(obj);
            }
        }
        else if (object instanceof GSNumber) {
            int value = ((GSNumber)object).getValue();
            stack.push(new GSNumber(~value));
        }
    }
}
