/*------------------------------------------
FILE 		: UI.java
AUTHOR		: Rupak Raj Ghimire
DESCRIPTION	: Main UI
DATE		: 
NOTE		: Developed for the APT assignment
------------------------------------------
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI {

	private JFrame frame;
	private JTextField txtX ;
	private JTextField txtY ;
	private JButton btnAdd ;
	private GraphPanel panGraph;
	private TablePanel panTable;
	Data data;

	public UI(){ 
		frame = new JFrame("Assignment: Graph Drawing using Observer Pattern");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		//init the data
		data = new Data();		

		//prepare the UI
		addControls( frame.getContentPane() );

		// Add observers
		data.addObserver(panGraph);
		data.addObserver(panTable);

		data.clearData();

		//pack the size
		frame.pack(); 
	}

	
	//prepare the GUI
	public void addControls(Container pane){

		// Title of the Frame		
		JLabel lblTitle =  new  JLabel(" :: Use of Observer Pattern"+
			" for plotting a graph. ::",JLabel.CENTER);

		lblTitle.setFont( new Font ( lblTitle.getName(), Font.BOLD, 20 ) );
		pane.add( lblTitle, BorderLayout.NORTH); 	

		//prepare panels as a placeholder		
		JPanel panControls = new JPanel();	// Controls

		//populate the graph form GraphPanel Class
		panGraph = new GraphPanel();
		panGraph.setPreferredSize(new Dimension(600,600));
		//panGraph.setBackground(Color.BLUE); 
		pane.add(panGraph, BorderLayout.CENTER);

		//side panel holds the data table and input boxes
		JPanel sidePanel = new JPanel();
		//sidePanel.setPreferredSize(new Dimension(150,400));
		sidePanel.setLayout( new  BorderLayout());

		

		//populate the controls
		panControls.setLayout ( new GridLayout(4,2));
		//panControls.setPreferredSize(new Dimension(75,75));
		txtX = new JTextField(5);
		txtY = new JTextField(5);
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//stem.out.println(Integer.valueOf ( txtX.getText() ));
				try{ 
					if(Integer.valueOf ( txtX.getText() ) >500
						|| Integer.valueOf ( txtY.getText())  >500 ){
						JOptionPane.showMessageDialog(frame, "Program can plot only the data between 0 and 500.");
						 
						return; 
					}
					data.addData(
						Integer.valueOf ( txtX.getText() ),
						Integer.valueOf (txtY.getText() ) 
					); 
				
				}
				catch(NumberFormatException exx){
					JOptionPane.showMessageDialog(frame, "Data should be numeric.");
					 
				} 
				catch(Exception ex){
					JOptionPane.showMessageDialog(frame, "Error: "+ex.getMessage());

				}
				finally{
					txtX.setText("");
					txtY.setText(""); 
					txtX.requestFocus();
				}

			}
		});
		JLabel lblX = new JLabel("X : ");
		panControls.add(lblX);		
		panControls.add(txtX);

		JLabel lblY = new JLabel("Y : ");
		panControls.add(lblY);		
		panControls.add(txtY);

		JLabel lblBtn = new JLabel(" ");
		panControls.add(lblBtn);
		panControls.add(btnAdd);

		JButton btnClear  = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				data.clearData();
			}
		});
		panControls.add(btnClear);

		JButton btnSample  = new JButton("Samples");
		btnSample.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				data.clearData();

				data.addData(12,12);
				data.addData(12,40);
				data.addData(55,100);
				data.addData(200,100);
				data.addData(120,400);

			}
		});
		panControls.add(btnSample);

		//container of the controls (text boxes)
		JPanel panControlContainer = new  JPanel();
		panControlContainer.setLayout(new BorderLayout());
		panControlContainer.add( new JLabel("provide points to plot") , BorderLayout.NORTH);
		panControlContainer.add( panControls, BorderLayout.SOUTH ); 

		//add panTable to side bar
		panTable = new TablePanel(); 
		sidePanel.add( new JLabel("Points being displayed in graph"), BorderLayout.NORTH);
		sidePanel.add( panTable, BorderLayout.CENTER);
		sidePanel.add( panControlContainer, BorderLayout.SOUTH ); 
		 
		//add side bar to the main panel
		pane.add( sidePanel, BorderLayout.WEST);
		JLabel lblAbout = new JLabel("Developer: Rupak Raj Ghimire,"+
			"for assignment for APT Course, "+
			" Kathmandu University, Nepal. "+
			" Supervisior: Sagun Dhakhwa");
		lblAbout.setSize(100, 500);
		pane.add( lblAbout, BorderLayout.SOUTH);
		 txtX.requestFocus();
	}

	//show the form
	public void show(){		
		frame.setVisible(true);
	}
}