package Excel;

import java.io.IOException;


public class Test {
	
	public static void main(String[] args) throws IOException {
		ExcelUtils.setCellStringValue(1, 2, "Azen");
		ExcelUtils.setCellStringValue(2, 0, "Afen");
		ExcelUtils.setCellStringValue(0, 0, "Afen");
		ExcelUtils.setCellStringValue(1, 3, "Azen");
	}
}
