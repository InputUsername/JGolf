package com.inputusername.jgolf;

import com.inputusername.jgolf.types.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Koen on 4-7-2016.
 */
class Util {
    static boolean truthValue(GSObject object) {
        if (object instanceof GSString) {
            // either GSString or GSBlock

            boolean empty = ((GSString)object).getChars().isEmpty();

            return !empty;
        }
        else if (object instanceof GSNumber) {
            return ((GSNumber)object).getValue() == 0;
        }
        else if (object instanceof GSArray) {
            boolean empty = ((GSArray)object).getObjects().isEmpty();

            return !empty;
        }

        return true;
    }

    static boolean sameClass(Object first, Object second) {
        return first.getClass().equals(second.getClass());
    }

    private static int typeRank(GSObject object) {
        if (object instanceof GSBlock) {
            return 3;
        }
        else if (object instanceof GSString) {
            return 2;
        }
        else if (object instanceof GSArray) {
            return 1;
        }
        else if (object instanceof GSNumber) {
            return 0;
        }

        return -1;
    }

    static void coerce(List<GSObject> objects) {
        if (objects.size() < 1) {
            return;
        }

        int highestRank = 0;
        for (GSObject object : objects) {
            int rank = typeRank(object);
            if (rank > highestRank) {
                highestRank = rank;
            }
        }

        //TODO: coerce types
    }


}
