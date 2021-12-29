package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author DELL
 *
 */
public class FileUtility {
/**
 * It is used to read the data from commonData.properties File based on key which you pass as an argument
 * @param key
 * @throws Throwable 
 * @throws Throwable 
 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./docs/Common.properties");
		Properties pobj = new  Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}

}

