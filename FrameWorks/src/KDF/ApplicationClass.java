package KDF;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class ApplicationClass {
	@Test
	public void verifyInvalidLogin() throws IOException {
		String[][] data = GenericMethods.getData("C:\\Users\\shame\\Downloads\\TransverifyFunds.xlsx", "Sheet2");
		Methods mtd = new Methods();
		
		for(int i= 1;i<data.length;i++) {
			switch(data[i][3]) {
			case "OpenBrowser":
			mtd.openBrowser();
			break;
		    case "maxBrowser":
		    	mtd.maximizedBrowserWindow();
		    	break;
		    case "impwait":
		    	mtd.implementImlicitWait();
		    	break;
		    case "navigateToApp":
		    	mtd.navigateToApplication(data[i][6]);
		        break;
		    case "enterInTextBox":
		    	System.out.println(data[i][5] + ":" + data[i][6]);
		    	
		    	mtd.enterInTextBox(data[i][5],data[i][6]);
		    	break;
		    case "click Button":
		    	mtd.clickButton(data[i][4],data[i][5]);
		    	break;
		    case "verify msg":
		    	String actaulMsg =  mtd.getMessage(data[i][4],data[i][5]);
		    	String expectedMsg = data[i][6];
		    	Assert.assertEquals(actaulMsg, expectedMsg);
		    	
		    	mtd.closeApplication();
		    	
			}
		}
	}

}
