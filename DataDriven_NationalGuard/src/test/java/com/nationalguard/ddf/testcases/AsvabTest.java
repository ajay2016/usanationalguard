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

public class AsvabTest extends BaseTest {

	String testName = "AsvabTest";
	Xls_Reader xls;

	@Test(dataProvider = "getData")
	public void fitnessCalculator(Hashtable<String, String> data) throws IOException {

		// gives data set
		test.log(Status.INFO, data.toString());

		if (!DataUtil.isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
			test.log(Status.SKIP, "Test skipped since rumode is N");
			throw new SkipException("Test skipped since rumode is N");

		}

		test.log(Status.INFO, "Asvab Practice Test Started");

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
		// click on ASVAB
		click("practiceasvab_xpath");
		// click on Start Test
		click("starttest_name");

		// click on choice and click continue button
		click("question1_xpath");
		click("nextbutton_xpath");

		click("question2_xpath");
		click("nextbutton_xpath");

		click("question3_xpath");
		click("nextbutton_xpath");

		click("question4_xpath");
		click("nextbutton_xpath");

		click("question5_xpath");
		click("nextbutton_xpath");

		click("question6_xpath");
		click("nextbutton_xpath");

		click("question7_xpath");
		click("nextbutton_xpath");

		click("question8_xpath");
		click("nextbutton_xpath");

		click("question9_xpath");
		click("nextbutton_xpath");

		click("question10_xpath");
		click("nextbutton_xpath");

		click("question11_xpath");
		click("nextbutton_xpath");

		click("question12_xpath");
		click("nextbutton_xpath");

		test.log(Status.INFO, "result is displayed");
		// verify score is present
		String scoretext = verifyTextPresent("scoretext_xpath");
		System.out.println("Your score result is displayed  " + scoretext);

		/*****************************
		 * Link Test
		 ***************************************/

		

	}

	@DataProvider
	public Object[][] getData() {
		xls = new Xls_Reader(prop.getProperty("xlsPath"));
		return DataUtil.getTestData(xls, testName);
	}

}
