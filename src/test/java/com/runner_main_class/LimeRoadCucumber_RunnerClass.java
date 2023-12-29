package com.runner_main_class;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber_base_class.LimeRoad_BaseClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\AutomationTraining\\Lime_Road_Cucumber_TestingDemo\\src\\test\\java\\com\\feature_files\\FeatureFile1.feature",
					glue = "com.step_definition_classes",
					monochrome = true,
					dryRun = false,
					//strict = true,
					tags = "@MenTab",
					plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
					)

public class LimeRoadCucumber_RunnerClass extends LimeRoad_BaseClass{
	
	@BeforeClass
	public static void launchBrowser() throws InterruptedException {
		
		launchBrowser("edge");
		
	}	

}
