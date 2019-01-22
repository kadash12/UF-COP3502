/**
 * Sort a string arrays of getName() alphabetically.
 * @author Johnny Li and Colby Lathrop 
 */
public class Sorter{

	/**
	 * Sort a string arrays of getName() alphabetically.
	 * @param a A Employee (object) array of employees' information.
	 * @return name A string array of employees' name in alphabetical order.
	 */
	public static Employee[] sort(Employee[] emp){
		//Keep loop running till all name is in alphabetical order.
		boolean test = true;
		//To be compare, if it matches the loop ends and if not it continues.
		int [] testing1 = new int[emp.length];
		int [] testing2 = new int[emp.length];
		for(int j= 0; j<emp.length; j++){
			testing1[j] = 1;
			testing2[j] = 0;
		}
		testing1[emp.length-1]=0;

		//Store list of names.
		while(test){
			for(int i= 0; i<emp.length-1; i++){
				//Sorted in alphabetical order.
				int compare= (emp[i].getName()).compareToIgnoreCase(emp[i+1].getName());	
				//Swap name order.
				if (compare > 0) {  
					Employee alias = emp[i];
					emp[i]=emp[i+1];
					emp[i+1] = alias;
				}  
				//Keep loop running till all name is in alphabetical order.
				else if (compare < 0 ){
					testing1[i] = 0;
				}
				//Ends loop
				test = false;
				for(int k = 0; k<emp.length; k++){
					if (testing1[i] != testing2[i]){
						test = true;
					}
				}
			}
		} 
		return emp;
	}
}