/*

  ==============================
	HazMatMain.java - OOP Team 2 
	* 
	* Patrick Carroll, Aaron Fortner, James Montis
  ==============================
  * 
  
  
*/

import java.util.Date;

public class HazMatMain {

		public static void main(String[] args){
			System.out.println("hey");
			employeeTest();
			inventoryTest();
		}

		//testing for HazMatInventory
		public static void inventoryTest() {
			HazMatInventory test = new HazMatInventory();
			test.addHazMatItemToInventory();
			System.out.println(test.toString());
		}

		//testing for employee class hierarchy
		public static void employeeTest(){
			HazMatEmployee test = new HazMatEmployee("Capt Stubing","Isaac Washinton","9/24/1977",
				"12/7/1979","night","Stewards");
			System.out.println(test.toString());
		}

		//testing for MSDSObject class
		public static void MSDSTest() {
			MSDSObject test = new MSDSObject();
			test.Ask_and_Set_All_Input();
		}
}
