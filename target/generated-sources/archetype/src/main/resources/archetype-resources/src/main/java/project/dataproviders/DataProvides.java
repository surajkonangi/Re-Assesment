#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.project.dataproviders;

import org.testng.annotations.DataProvider;

import ${package}.project.utils.ConstantPaths;



public class DataProvides {

	@DataProvider(name = "name")
	public Object[][] getpagedata(){
		TestDataProvider provideData=new TestDataProvider(ConstantPaths.TESTDATA_FILE,0);
		Object[][] getData=provideData.provideData();
		return getData;
	}
	
	@DataProvider(name = "name")
	public Object[][] getpagesdata(){
		TestDataProvider provideData=new TestDataProvider(ConstantPaths.TESTDATA_FILE,1);
		Object[][] getData=provideData.provideData();
		return getData;
}
}
