package common;

import java.util.List;
import java.util.Map;

public class CucumberUtils {
	public static String getValueByTableKey(List<Map<String, String>> tableName, String columnName) {
		String result="";
		for(Map<String, String> tableMap: tableName) {
			  result = tableMap.get(columnName);
		  }return result;
	} 
}
