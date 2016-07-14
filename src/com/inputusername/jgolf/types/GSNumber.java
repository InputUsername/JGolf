package com.inputusername.jgolf.types;

public class GSNumber implements GSObject {
	private int value;

	public GSNumber(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Integer compare(GSObject other) {
		if (other instanceof GSNumber) {
			int otherValue = ((GSNumber)other).getValue();

            if (value < otherValue) {
                return -1;
            }
            else if (value == otherValue) {
                return 0;
            }
            else {
                return 1;
            }
		}
        else {
            //TODO: compare GSNumber to other things
            return null;
        }
	}

	public String toString() {
		return Integer.toString(value);
	}
}
