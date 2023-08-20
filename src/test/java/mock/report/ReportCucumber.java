package mock.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mock.baseclass.BaseClass;
import mock.pages.CareerFormPageKerv;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class ReportCucumber extends BaseClass{
	public static void generateJVMReport(String json) throws FileNotFoundException, IOException {
		File file = new File(getProjectPath()+getPropertyFileValue("jvmPath"));

		Configuration configuration = new Configuration(file, "tc-1-kerv-career");
		configuration.addClassifications("browser", "chrome");
		configuration.addClassifications("browser version", "109");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(json);
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();

	}

}
