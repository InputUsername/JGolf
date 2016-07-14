package com.inputusername.jgolf.types;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Koen on 3-7-2016.
 */
public class GSBlock extends GSString implements GSObject {
    public GSBlock(String string) {
        super(string);
    }

    @Override
    public String toString() {
        return "{" + super.toString() + "}";
    }
}
