package factory;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;


/**
 * @author SurajS
 *
 */

public class DataProviderFactory {
	
	public static ConfigDataProvider getConfig()
	{
		ConfigDataProvider config=new ConfigDataProvider();
		return config;
	}
	
	public static ExcelDataProvider excel()
	{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel;
	}
	
	public static FunctionFactory fact()
	{
		FunctionFactory fact=new FunctionFactory();
		return fact;
	}
	

}
