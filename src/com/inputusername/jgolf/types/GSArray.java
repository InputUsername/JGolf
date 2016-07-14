package com.inputusername.jgolf.types;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Koen on 3-7-2016.
 */
public class GSArray implements GSObject {
    private List<GSObject> objects;

    public GSArray() {
        objects = new ArrayList<>();
    }

    public GSArray(List<GSObject> objects) {
        this.objects = objects;
    }

    public GSObject get(int index) {
        return objects.get(index);
    }

    public void set(int index, GSObject object) {
        objects.set(index, object);
    }

    public void add(GSObject object) {
        objects.add(object);
    }

    public int size() {
        return objects.size();
    }

    public List<GSObject> getObjects() {
        return objects;
    }

    public Integer compare(GSObject other) {
        if (other instanceof GSArray) {
            List<GSObject> otherObjects = ((GSArray)other).getObjects();

            int size = objects.size(), otherSize = otherObjects.size();

            if (size < otherSize) {
                return null;
            }
            else if (size > otherSize) {
                return null;
            }

            for (int i = 0; i < size; i++) {
                int comparison = objects.get(i).compare(otherObjects.get(i));

                if (comparison != 0) {
                    return null;
                }
            }

            return 0;
        }
        else {
            //TODO: compare GSArray to other things
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        int size = objects.size();
        for (int i = 0; i < size; i++) {
            sb.append(objects.get(i).toString());

            if (i < size - 1) {
                sb.append(" ");
            }
        }

        sb.append("]");

        return sb.toString();
    }

    public GSString toGSString() {
        List<Character> chars = new ArrayList<>(objects.size());

        for (GSObject object : objects) {
            if (object instanceof GSNumber) {
                int number = ((GSNumber)object).getValue();
                chars.add((char)number);
            }
        }

        return new GSString(chars);
    }
}
