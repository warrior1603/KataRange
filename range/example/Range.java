package range.example;

public class Range {

	private int end;
	private int start;
	private String input;

	public Range(String input) throws InvalidRangeArgumentException {
		if ((input.startsWith("[") || input.startsWith("(")) && (input.endsWith("]") || input.endsWith(""))) {
			this.input = input;
			setStart(Integer.parseInt(String.valueOf(input.charAt(1))));
			setEnd(Integer.parseInt(String.valueOf(input.charAt(input.length() - 2))));

		} else {
			throw new InvalidRangeArgumentException();
		}
	}

	private void setEnd(int end) {
		this.end = end;
	}

	private void setStart(int start) {
		this.start = start;
	}

	public boolean isInclusiveStart() {
		if (this.input.startsWith("(")) {
			return false;
		}
		return true;
	}

	public boolean isInclusiveEnd() {
		if (this.input.endsWith(")")) {
			return false;
		}
		return true;
	}

	public int getStart() {
		if (!isInclusiveStart()) {
			return this.start + 1;
		}
		return this.start;
	}

	public int getEnd() {
		if (!isInclusiveEnd()) {
			return this.end - 1;
		}
		return this.end;
	}

	public int[] getResult() {
		int numberOfMember = this.getEnd() - this.getStart() + 1;
		int[] result = new int[numberOfMember];
		for(int i=0; i<numberOfMember; i++) {
			result[i] = this.getStart() + i;
		}
		return result;
	}

}
