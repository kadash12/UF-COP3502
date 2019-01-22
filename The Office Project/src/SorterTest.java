//Michael Arboleda
import static org.junit.Assert.*;

import org.junit.Test;

public class SorterTest {
	public static String error = "SorterTest\n";
	
	@Test
	public void sortTest(){ 
		error += ("sortTest() \t Sorter sort\n");
		
		Task t1 = new Task("T1", 1);
		Task t2 = new Task("T2", 2);
		Task[] ansTasks = {t1, t2};
		String[] items = {"100x white paper","Sabre Printer" ,"Sabre Copier"};
		RegionalManager r = new RegionalManager(-1, "Michael Scott", null, -1, null, -1);
		SalesAssociate sa = new SalesAssociate(3, "James Duncan Halpert", ansTasks, 5, items, r);
		AssistantRegionalManager arm = new AssistantRegionalManager(2, "Dwight Kurt Schrute III", ansTasks, r, 5);
		Receptionist pam = new Receptionist(4, "Pamela Morgan Beesly", ansTasks, arm, 5);
		Employee[] e = {arm, sa, r};
		RegionalManager rm = new RegionalManager(1, "Michael Scott", ansTasks, 10, e, 8);
		
		Employee[] ee = {rm, arm, sa, pam};
			
		Employee[] students = Sorter.sort(ee);
		
		boolean same = true;
		
		if(!(students[0] instanceof AssistantRegionalManager)){
			error += ("index 0 should be a AssistantRegionalManager\n");
			same = false;
		}
		if(!(students[1] instanceof SalesAssociate)){
			error += ("index 1 should be a SalesAssociate\n");
			same = false;
		}
		
		if(!(students[2] instanceof RegionalManager)){
			error += ("index 2 should be a RegionalManager\n");
			same = false;
		}
		
		if(!(students[3] instanceof Receptionist)){
			error += ("index 3 should be a Receptionist\n");
			same = false;
		}
		error += ("\n");
		
		assert(same);
	}
}