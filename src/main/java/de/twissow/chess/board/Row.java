package de.twissow.chess.board;

public enum Row {
  ROW_1(7, "1"), ROW_2(6, "2"), ROW_3(5, "3"), ROW_4(4, "4"), ROW_5(3, "5"), ROW_6(2, "6"), ROW_7(1, "7"), ROW_8(0, "8");

  private int index;

  private String value;

  public int getIndex() {
	return index;
  }

  public static Row getByIndex(int index) {
	for (Row row : Row.values()) {
	  if (row.getIndex() == index) {
		return row;
	  }
	}
	return null;
  }

  private Row(int index, String value) {
	this.index = index;
	this.value = value;
  }

  @Override
  public String toString() {
	return value;
  }

}
