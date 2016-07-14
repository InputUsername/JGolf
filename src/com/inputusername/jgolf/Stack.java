package com.inputusername.jgolf;

import com.inputusername.jgolf.types.GSObject;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * Created by Koen on 3-7-2016.
 */
public class Stack extends ArrayDeque<GSObject> {
    public GSObject pop() throws StackEmptyException {
        if (!super.isEmpty()) {
            return super.pop();
        }

        throw new StackEmptyException("Stack underflow");
    }

    public GSObject peek() throws StackEmptyException {
        if (!super.isEmpty()) {
            return super.peek();
        }

        throw new StackEmptyException("Stack underflow");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        Iterator<GSObject> iterator = descendingIterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next().toString());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}