package com.nationalguard.ddf.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nationalguard.ddf.base.BaseTest;
import com.nationalguard.ddf.utility.DataUtil;
import com.nationalguard.ddf.utility.Xls_Reader;

public class ShareButtonLinkTest extends BaseTest {
	
	String testName = "ShareButtonLinkTest";
	Xls_Reader xls;

	@Test(dataProvider = "getData")
	public void shareButtonlink(Hashtable<String, String> data) throws IOException {

		// gives data set
		test.log(Status.INFO, data.toString());

		if (!DataUtil.isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
			test.log(Status.SKIP, "Test skipped since rumode is N");
			throw new SkipException("Test skipped since rumode is N");

		}

		test.log(Status.INFO, "ShareButton Link Test Started");

		// opening chrome browser
		openBrowser(data.get("Browser"));
		// navigate to given url
		navigate("appurl");
		// click on hamburger button
		click("hamburgebutton_xpath");
		// click on what it takes link
		click("whatittakes_xpath");
		// wait for 2 seconds
		wait(2);

		/*****************************
		 * Link Test
		 ***************************************/
		//click("sharebutton_xpath");
		click("sharebutton_xpath");
		//getWebTitleShareLinkText("facebooklink_css");
		//getWebTitleShareLinkText("linkedinlink_css");
		//getWebTitleShareLinkText("twitterlink_css");
		getEmailTitleShareLinkText("emaillink_css");
		
	}

	@DataProvider
	public Object[][] getData() {
		xls = new Xls_Reader(prop.getProperty("xlsPath"));
		return DataUtil.getTestData(xls, testName);
	}

	
	

}
