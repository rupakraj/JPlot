/*------------------------------------------
FILE 		: TablePanel.java
AUTHOR		: Rupak Raj Ghimire
DESCRIPTION	: It is the Panel, used to display the table 
				Extended form
					- JPanel
					- IDataObserver
DATE		: 
NOTE		: Developed for the APT assignment
------------------------------------------
*/

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class TablePanel extends JPanel implements IDataObserver {

	private JTable table;
	private DefaultTableModel tableModel;
	private Data data; 

	public TablePanel(){
		//this. setLayout( new BoxLayout());
		Data data = new Data();
		//init the table with cols
		initTable();

		//show the table in Scroll Panel
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}

	private void initTable(){
		tableModel = new  DefaultTableModel( new Object[] { "X", "Y"},0); 
		table = new JTable(tableModel){
			 public boolean isCellEditable(int arg0, int arg1) {         
            	return false;
        	}
		}; 
	}

	public void dataUpdated(Data data){
		this.data = data;
		this.bindData();
	}

	//binding of data to the table
	public void bindData(){
		//reset the table 
		//fill data in the table 
		tableModel.setRowCount(0);
		for (int i = 0; i < data.count(); i++) {
			tableModel.addRow( new Object[] {data.get(i).x, data.get(i).y } );
		} 
	}
}