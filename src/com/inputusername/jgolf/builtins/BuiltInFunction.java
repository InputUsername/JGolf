package com.inputusername.jgolf.builtins;

import com.inputusername.jgolf.Namespace;
import com.inputusername.jgolf.Stack;

/**
 * Created by Koen on 6-7-2016.
 */
interface BuiltInFunction {
    void execute(Stack stack, Namespace namespace, StringBuilder output);
}
