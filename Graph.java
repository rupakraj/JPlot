/*------------------------------------------
FILE 		: Graph.java
AUTHOR		: Rupak Raj Ghimire
DESCRIPTION	: It is the main program calls the UI.show().
DATE		: 
NOTE		: Developed for the APT assignment
------------------------------------------
*/ 

public class Graph   {

	public static void main(String[] args) { 
		createAndShowGUI();
	}
	public static void createAndShowGUI(){
		UI ui =  new UI();
		ui.show();
	}
}