package mainDriver;//did not include firefoxbrowswerprofile method calling set and get like chrome

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefoxBrowserProfile extends BrowserProfile {

	@Override
	void setDriverPath() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void setDownloadFilePath() {
		try {
			
			FirefoxProfile profile=new FirefoxProfile();
			
			String downloadProjectPath=System.getProperty("user.dir")+"\\download";

			profile.setPreference("browser.download.dir", downloadProjectPath);
			
			FirefoxOptions option=new FirefoxOptions();
			option.setProfile(profile);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
