package GSH.DataTypes;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExcelReader
{
	public String getExcelData(int rowNo, int cellNo, XSSFSheet sheet) throws IOException
	{
		String value = null;
		value = sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	
	public int getNumberOfRows(XSSFSheet sheet)
	{
		return sheet.getPhysicalNumberOfRows();
	}
}