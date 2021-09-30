package testDataReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataReader {


	/**
	 * @author MYSHA
	 * Summary: This method is used to read xls and xlsx both extension file
	 * List is interface
	 * @param filename
	 * @param subsheetIndex
	 */
	public List<List<Object>> readxlsAndXlsxFile(String filename,int subsheetIndex)//lists list of object
	{

		List<List<Object>> mainList=new ArrayList<List<Object>>();
		//this object i have created so i can store all the row data of excel and all the row data are separated
		//[[row1dtata],[row2data],[row3data]]  
		try {

			String path=System.getProperty("user.dir")+"\\testdata\\"+filename;

			FileInputStream file=new FileInputStream(path);

			Workbook book=WorkbookFactory.create(file);
			Sheet sheet=book.getSheetAt(subsheetIndex);


			Iterator<Row> rowitr=sheet.iterator();



			while(rowitr.hasNext())
			{

				List<Object> rowlist=new ArrayList<Object>();
				Row rowData=rowitr.next();

				Iterator<Cell> cellitr=rowData.iterator();


				while(cellitr.hasNext())
				{

					Cell cellData=cellitr.next();

					switch (cellData.getCellType()) {
					case STRING:
						rowlist.add(cellData.getStringCellValue());
						break;

					case NUMERIC:

						rowlist.add(cellData.getNumericCellValue());

						break;

					case BOOLEAN:
						rowlist.add(cellData.getBooleanCellValue());

						break;

					case FORMULA:

						rowlist.add(cellData.getCellFormula());
						break;

					case BLANK:
						rowlist.add("");
						break;

					default:
						System.out.println("Please check your Sheet!!");
						break;
					}


				}


				mainList.add(rowlist);





			}





		} catch (Exception e) {
			e.printStackTrace();



		}
		return mainList;


	}

/**
 * Summary:
 * This method is used to set cell value corresponding any row.
 * here are parameters which we need to pass when we will call this method
 * @param excelname ex: abc.xlsx
 * @param sheetname :sheet1
 * @param rownumber : 2
 * @param cellnumber :3
 * @param value  :true/false/user
 */
	public void setExcelCellData(String excelname,String sheetname,int rownumber,int cellnumber,String value)
	{


		try {
			
			
			String filepath=System.getProperty("user.dir")+"//testdata"+excelname;
			
			//by fileinputstream i am checking only my xls file is present in my project or not.
			FileInputStream file=new FileInputStream(filepath);
			
			// this is creating xls structure so that i can view it
			Workbook book=WorkbookFactory.create(file);
			
			//here i am passing the sheetname as parameter and geeting subsheet data view.
			Sheet sheet=book.getSheet(sheetname);
			System.out.println(sheet.getLastRowNum());
			
			//Here i am getting exact cell number corresponding row which i need to update
			Cell cell=sheet.getRow(rownumber).getCell(cellnumber);
			
			//This code is used to update cell value and value is anything which i have passed as a parameter
			
			cell.setCellValue(value);
			file.close();
			
			//this fileoutput stram is used to save the file data and i have pass the full path of excel
			//which i need to save it
			FileOutputStream fileout=new FileOutputStream(new File(filepath));
			
			book.write(fileout);
			book.close();
			fileout.close();
			
			
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}


	}



}
