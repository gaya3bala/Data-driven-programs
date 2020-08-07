package com.excel.utility;

import java.util.ArrayList;

public class TestUtil {
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getdatafromexcel(){
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try {
			reader= new Xls_Reader("G:/java programs/DataDriven/src/com/testsdata/CRMNewcontacts.xlsx");
		}catch(Exception e)
		{ e.printStackTrace();
		}
		
		
		for(int rowNum=2;rowNum<=reader.getRowCount("Contactsdata");rowNum++)
		{
			
			String Title = reader.getCellData("Contactsdata", "title", rowNum);
			String Firstname = reader.getCellData("Contactsdata", "firstname", rowNum);
			String Lastname = reader.getCellData("Contactsdata", "lastname", rowNum);
			String Company = reader.getCellData("Contactsdata", "company", rowNum);
			String Address = reader.getCellData("Contactsdata", "address", rowNum);
			String City = reader.getCellData("Contactsdata", "city", rowNum);
			String State = reader.getCellData("Contactsdata", "state", rowNum);
			String Zipcode = reader.getCellData("Contactsdata", "zipcode", rowNum);
			String Country = reader.getCellData("Contactsdata", "country", rowNum);
			
			
			//object array
			Object ob[] = {Title,Firstname,Lastname,Company,Address,City,State,Zipcode,Country};
			mydata.add(ob); //araylist
			
		}
		
		return mydata;
	}

}
