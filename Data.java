/*------------------------------------------
FILE 		: TablePanel.java
AUTHOR		: Rupak Raj Ghimire
DESCRIPTION	: It is the Panel, used to display the table 
				Has
					- List of Point List<Point> : stores the points to plot
					- List of Observers  ArrayList<IDataObserver> : stores the observers
								to whom need to notify on change of the data
DATE		: 
NOTE		: Developed for the APT assignment
------------------------------------------
*/

import java.awt.Point;
import java.util.*;

public class Data {

	//list of data to plot in graph
	public List<Point>  dataList = new ArrayList<Point>();

	//list of the observers
	private ArrayList<IDataObserver> observers = new ArrayList<IDataObserver>();

	public void addData(Integer x, Integer y){ 
		this.dataList.add(new Point( x, y) );
		this.notifyChange();
	}
	
	//reset data to blank
	public void clearData(){
		this.dataList = new ArrayList<>();
		this.notifyChange();
	}
	public void removeObserver( IDataObserver observer)
	{
		observers.remove(observer);
	}

	public void addObserver( IDataObserver observer)
	{
		observers.add(observer);
	}

	//get the no of items in the colelction
	public  int count(){
		return this.dataList.size();
	}

	//get the Point object of ith position
	public Point get(int i){
		return dataList.get(i);
	}

	public double getMinScore() {
		 
		return 0;
	}

	//get the maximun value of y axis - set to static
	public double getMaxScore() {
		 
		return 500;
	}
	//get the maximun value of x axis - set to static
	public double getMaxX(){
		return 500;
	}

	//notify all the observers
	public void notifyChange(){
		for(int i = 0; i<observers.size(); i++){
			observers.get(i).dataUpdated(this);
		}
	}
}