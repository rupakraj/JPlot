/*------------------------------------------
FILE 		: GraphPanel.java
AUTHOR		: Rupak Raj Ghimire
DESCRIPTION	: It is the Panel, used to display the graph
				Extended form
					- JPanel
					- IDataObserver
DATE		: 
NOTE		: Developed for the APT assignment
------------------------------------------
*/

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.geom.*;

//Display of the Graph
public class GraphPanel extends JPanel implements IDataObserver {

	//data to show
		Data data;

	//Parameters to draw the Graph
		int width = 500;
		int height = 500;
		int padding = 25;
		int labelPadding = 25;
		
		Color lineColor = new Color(44, 102, 230, 180);
    	Color pointColor = new Color(100, 100, 100, 180);
    	Color gridColor = new Color(200, 200, 200, 200);
    	Stroke GraphStroke = new BasicStroke(2f);
    	int numberYDivisions = 10;
    	int numberXDivisions = 10;
		int pointWidth = 10;
	
	public GraphPanel(){ 

		Data data = new Data();
		//this.setBackground(Color.RED);
		//setPreferredSize(new Dimension(150,75) );

	}

	public void dataUpdated(Data data){
		this.data = data;
		//this.clear();
		this.repaint();
	
	}

	//repain the graph
	protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
		//public void paint(Graphics g){

		//convert Graphics g into the 2g to set color and stroke of the line
		Graphics2D g2 =(Graphics2D)g;
		g2.setStroke(new BasicStroke(2));

		boolean isFirstLoop= true;
		//Integer x1=0, y1=0;
		if (data ==  null) {
			return ;
		}

		double xScale = ((double) getWidth() - (2 * padding) - labelPadding) / (data.getMaxX() - 1);
		double yScale = ((double) getHeight() - 2 * padding - labelPadding) / (data.getMaxScore() - data.getMinScore());

		prepareGraph(g2); 
		 
        g2.drawLine(padding + labelPadding, getHeight() - padding - labelPadding, padding + labelPadding, padding);
        g2.drawLine(padding + labelPadding, getHeight() - padding - labelPadding, getWidth() - padding, getHeight() - padding - labelPadding);

        Stroke oldStroke = g2.getStroke();
        g2.setColor(lineColor);
        g2.setStroke(GraphStroke);
        
        //draw line
        for (int i = 0; i < data.count() - 1; i++) {
            int x1 = (int) (data.get(i).x * xScale + padding + labelPadding);
            int y1 = (int) (( data.getMaxScore() - data.get(i).y ) * yScale + padding);
            int x2 = (int) (data.get(i + 1).x * xScale + padding + labelPadding);
            int y2 = (int) (( data.getMaxScore() - data.get(i + 1).y ) * yScale + padding);
            g2.drawLine(x1, y1, x2, y2);
        }

        //draw point
        g2.setStroke(oldStroke);
        g2.setColor(pointColor);

        for (int i = 0; i < data.count(); i++) {
        	
        	int x1 = (int) (data.get(i).x * xScale + padding + labelPadding);
            int y1 = (int) (( data.getMaxScore() - data.get(i).y ) * yScale + padding);
            

            x1 = x1 - pointWidth / 2;
            y1 = y1 - pointWidth / 2;
            int ovalW = pointWidth;
            int ovalH = pointWidth;
            g2.fillOval(x1, y1, ovalW, ovalH);
        }

	}

	private void prepareGraph( Graphics2D g2){
		//background draw
		g2.setColor(Color.WHITE);
        g2.fillRect(padding + labelPadding, padding, getWidth() - (2 * padding) - labelPadding, getHeight() - 2 * padding - labelPadding);
        g2.setColor(Color.BLACK);

 		// create hatch marks and grid lines for y axis.
        for (int i = 0; i < numberYDivisions + 1; i++) {
            int x0 = padding + labelPadding;
            int x1 = pointWidth + padding + labelPadding;
            int y0 = getHeight() - ((i * (getHeight() - padding * 2 - labelPadding)) / numberYDivisions + padding + labelPadding);
            int y1 = y0;

            g2.setColor(gridColor);
            g2.drawLine(padding + labelPadding + 1 + pointWidth, y0, getWidth() - padding, y1);
            g2.setColor(Color.BLACK);
            String yLabel = ((int) ((data.getMinScore() + (data.getMaxScore() - data.getMinScore()) * ((i * 1.0) / numberYDivisions)) * 100)) / 100.0 + "";
            FontMetrics metrics = g2.getFontMetrics();
            int labelWidth = metrics.stringWidth(yLabel);
            g2.drawString(yLabel, x0 - labelWidth - 5, y0 + (metrics.getHeight() / 2) - 3);
         
            g2.drawLine(x0, y0, x1, y1);
        }

		// and for x axis
        for (int i = 0; i <= data.getMaxX(); i++) { 
                int x0 = (int) ( i * (getWidth() - padding * 2 - labelPadding) / (data.getMaxX() - 1) + padding + labelPadding);
                int x1 = x0;
                int y0 = getHeight() - padding - labelPadding;
                int y1 = y0 - pointWidth;
                if ((i % ((int) ((data.getMaxX() / 10.0)) )) == 0) {
                    g2.setColor(gridColor);
                    g2.drawLine(x0, getHeight() - padding - labelPadding - 1 - pointWidth, x1, padding);
                    g2.setColor(Color.BLACK);
                    String xLabel = i + "";
                    FontMetrics metrics = g2.getFontMetrics();
                    int labelWidth = metrics.stringWidth(xLabel);
                    g2.drawString(xLabel, x0 - labelWidth / 2, y0 + metrics.getHeight() + 3);
                    g2.drawLine(x0, y0, x1, y1); 
                }
                
        }
	}
}