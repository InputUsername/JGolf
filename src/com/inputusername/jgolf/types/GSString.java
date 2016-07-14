package com.inputusername.jgolf.types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Koen on 3-7-2016.
 */
public class GSString implements GSObject {
    private List<Character> chars;

    public GSString(String string) {
        int length = string.length();
        chars = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            chars.add(string.charAt(i));
        }
    }

    GSString(List<Character> chars) {
        this.chars = chars;
    }

    public List<Character> getChars() {
        return chars;
    }

    public String getCharsAsString() {
        StringBuilder sb = new StringBuilder(chars.size());

        for (char ch : chars) {
            sb.append(ch);
        }

        return sb.toString();
    }

    @Override
    public Integer compare(GSObject other) {
        if (other instanceof GSBlock) {
            return compare((GSString)other);
        }
        else if (other instanceof GSString) {
            String thisCharsString = getCharsAsString(),
                    otherCharsAsString = ((GSString)other).getCharsAsString();

            return thisCharsString.compareTo(otherCharsAsString);
        }
        else if (other instanceof GSArray) {
            GSString string = ((GSArray)other).toGSString();

            return compare(string);
        }
        else {
            //TODO: compare GSString to other other things
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(chars.size());

        for (char ch : chars) {
            sb.append(ch);
        }

        return sb.toString();
    }

    public GSArray toGSArray() {
        List<GSObject> arrayObjects = new ArrayList<>(chars.size());

        for (char c : chars) {
            arrayObjects.add(new GSNumber((int)c));
        }

        return new GSArray(arrayObjects);
    }
}
