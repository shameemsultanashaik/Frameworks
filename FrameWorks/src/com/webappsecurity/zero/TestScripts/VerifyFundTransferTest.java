package com.webappsecurity.zero.TestScripts;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webappsecurity.zero.TestScripts.Base;
import com.webappsecurity.zero.pages.AccountSummary;
import com.webappsecurity.zero.pages.Login;
import com.webappsecurity.zero.pages.TransferFundsConfirmation;
import com.webappsecurity.zero.pages.TransferFundsVerify;
import com.webappsecurity.zero.pages.Transfunds;

import utils.GenericMethods;

public class VerifyFundTransferTest extends Base {
	@Test
	public void VerifyFundTransferTest() throws IOException {
		Login lp = new Login(driver);
		AccountSummary acc = new AccountSummary(driver);
		Transfunds tf = new Transfunds(driver);
		TransferFundsVerify tfv = new TransferFundsVerify(driver);
		TransferFundsConfirmation tfc = new TransferFundsConfirmation(driver);
		
		String[][] data = GenericMethods.getData("C:\\Users\\shame\\Downloads\\TestNG\\TransverifyFunds.xlsx", "Sheet1");
		for(int i=1;i<data.length; i++) {
			
				lp.applicationLogin(data[i][0], data[i][1]);
				acc.clickTransFunds();
				tf.doFundTranfer(data[i][2], data[i][3]);
				tfv.clickSubmit();
				String actualText = tfc.getconText();
				String expectedText = data[i][4];
				Assert.assertEquals(actualText, expectedText);
				tfc.logOutFromApp();
			}
		
		
		
		
	}
}
		


