package de.twissow.chess.board;

public enum File {
	FILE_A(0,"a"),
	FILE_B(1,"b"),
	FILE_C(2,"c"),
	FILE_D(3,"d"),
	FILE_E(4,"e"),
	FILE_F(5,"f"),
	FILE_G(6,"g"),
	FILE_H(7,"h");

	private int index;

	private String value;

	@Override
	public String toString() {
		return value;
	}



	public int getIndex() {
		return index;
	}

	public static File getByIndex(int index) {
		for (File file : File.values()) {
			if (file.getIndex() == index) {
				return file;
			}
		}
		return null;
	}


	private File(int index, String value) {
		this.index = index;
		this.value = value;
	}

}
