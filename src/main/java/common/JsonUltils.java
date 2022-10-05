package common;

import java.io.File;
import java.nio.file.Files;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUltils {
		public String readJsonFile(String filePath) {
			File file = new File(filePath);
			String jsonBody="";
			try {
				FileReader reader = new FileReader(file);
				JSONParser parser = new JSONParser();
				JSONObject responseBodyJsonObj;
				
				responseBodyJsonObj = (JSONObject) parser.parse(reader);
				jsonBody= responseBodyJsonObj.toJSONString();
			} catch ( IOException | ParseException e) {
				System.out.println("file not found");
				e.printStackTrace();
			}
			return jsonBody;		
		}
		public void copyFile(File srcFile, File destFile) throws IOException{
			Files.copy(srcFile.toPath(), destFile.toPath());
			
		}
		public String getValueByKey(String responseBody, String key) {
			String value="";
			return value;
		}
}
