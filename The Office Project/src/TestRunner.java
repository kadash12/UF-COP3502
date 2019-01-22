//Michael Arboleda

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({EmployeeTest.class, AssistantRegionalManagerTest.class, ReceptionistTest.class, SalesAssociateTest.class, RegionalManagerTest.class, SorterTest.class, TaskTest.class, TheOfficeTest.class})

public class TestRunner {
	@AfterClass 
	public static void logout() throws IOException {
		String allErrors = EmployeeTest.error + "\n\n\n"+ AssistantRegionalManagerTest.error + "\n\n\n"+ ReceptionistTest.error + "\n\n\n"+ SalesAssociateTest.error + "\n\n\n"+ RegionalManagerTest.error + "\n\n\n"+ SorterTest.error + "\n\n\n"+ TaskTest.error + "\n\n\n"+ TheOfficeTest.error;
		
		
		System.out.println(allErrors);
		String FILENAME = "Suite_Error_log.txt";
		new File(FILENAME).delete();

		FileWriter fw = new FileWriter(FILENAME, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(allErrors);
		bw.close();
	}
}