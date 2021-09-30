package mainDriver;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowserProfile extends BrowserProfile{
	
	public ChromeBrowserProfile()
	{
		
		setDriverPath();
		setDownloadFilePath();
	}

	void setDriverPath() {
		String path=System.getProperty("user.dir")+"//driver//chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", path);
		
	}

	void setDownloadFilePath() {
		
		try {
			Map<String, Object> map=new HashMap<String, Object>();
			
			String downloadProjectPath=System.getProperty("user.dir")+"\\download";
			map.put("download.default_directory", downloadProjectPath);
			
			ChromeOptions option=new ChromeOptions();
			
			option.setExperimentalOption("map", map);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
