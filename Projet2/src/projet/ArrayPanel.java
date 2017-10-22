package projet;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ArrayPanel extends JPanel {
	 
	private static final long serialVersionUID = 1L;
 
	private static final Insets INSETS_VER = new Insets(10, 0, 10, 0);
	private static final Insets INSETS_HOR= new Insets(0, 10, 0, 10);
	private static final Insets INSETS= new Insets(1, 1, 0, 0);
 
	private int rowCount;
	private int columnCount;
 
	private Color lineColor;
	private boolean grid;
 
	public ArrayPanel() {
		super(new GridBagLayout());
		lineColor=Color.WHITE;
	}
 
	public void setLineColor(Color color) {
		if ( color==null ) {
			color=Color.WHITE;
		}
		this.lineColor=color;
		repaint();
	}
 
	@Override
	public void setForeground(Color fg) {
		super.setForeground(fg);
		for(int row=0; row<rowCount; row++) {
			JLabel jlabel =  (JLabel)getComponent(0, row+1);
			jlabel.setForeground(fg);
		}
		for(int column=0; column<columnCount; column++) {
			JLabel jlabel =  (JLabel)getComponent(column+1,0);
			jlabel.setForeground(fg);
		}
	}
 
	@Override
	public void setFont(Font font) {
		super.setFont(font);
		for(int row=0; row<rowCount; row++) {
			JLabel jlabel =  (JLabel)getComponent(0, row+1);
			jlabel.setFont(font);
		}
		for(int column=0; column<columnCount; column++) {
			JLabel jlabel =  (JLabel)getComponent(column+1,0);
			jlabel.setFont(font);
		}
	}
 
	public void setGridVisible(boolean grid) {
		this.grid=grid;
		repaint();
	}
 
	public boolean isGridVisible() {
		return grid;
	}
 
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(lineColor);
		if ( columnCount>0 ) {
			int headerWidth=0;
			if (!grid && rowCount>0) {
				JLabel jlabel =  (JLabel)getComponent(0,1);
				headerWidth=jlabel.getWidth();
			}
			for(int i=0; i<=rowCount; i++) {
				Component component = getComponent(1,i);
				if( component==null) continue;
				if ( grid || i==0 ) {
					if ( i==0 ) g.drawLine(0, component.getY(), getWidth(), component.getY());
					g.drawLine(0, component.getY()+component.getHeight(), getWidth(), component.getY()+component.getHeight());
				}
				else {
					if ( i==0 ) g.drawLine(0, component.getY(), headerWidth, component.getY());
					g.drawLine(0, component.getY()+component.getHeight(), headerWidth, component.getY()+component.getHeight());
				}
			}
		}
		if ( rowCount>0 ) {
			int headerHeight=0;
			if (!grid && columnCount>0) {
				JLabel jlabel =  (JLabel)getComponent(1,0);
				headerHeight=jlabel.getHeight();
			}
			for(int i=0; i<=columnCount; i++) {
				Component component = getComponent(i, 1);
				if( component==null) continue;
				if ( grid || i==0 ) {
					if ( i==0 ) g.drawLine(component.getX(), 0, component.getX(), getHeight());
					g.drawLine(component.getX()+component.getWidth(), 0, component.getX()+component.getWidth(), getHeight());
				}
				else {
					if ( i==0 ) g.drawLine(component.getX(), 0, component.getX(), headerHeight);
					g.drawLine(component.getX()+component.getWidth(), 0, component.getX()+component.getWidth(), headerHeight);
				}
			}
		}
	}
 
	public void addRow(String label) {
		if ( label==null ) {
			label="";
		}
		int newRow = ++rowCount;
		createRow(label, newRow);
	}
 
	protected JLabel createRow(String label, int newRow) {
		JLabel jlabel = createJLabel(label);
		jlabel.setUI(new VerticalLabelUI(false));
		add(jlabel, new GridBagConstraints(0, newRow, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, INSETS_VER, 0, 0));
		fillRow(newRow);
		revalidate();
		repaint();
		return jlabel;
	}
 
	public void addRow(String label, int row) {
		if ( row<0 || row>rowCount ) {
			throw new IndexOutOfBoundsException();
		}
		else if ( row==rowCount ) {
			addRow(label);
		}
		else {
			if ( label==null ) {
				label="";
			}
 
			GridBagLayout layout = (GridBagLayout) getLayout();
			for(int i=columnCount; i>=0; i--) {
				for(int j=rowCount; j>=row; j--) {
					Component component = getComponent(i,j);
					GridBagConstraints gbc = layout.getConstraints(component);
					gbc.gridy++;
					layout.setConstraints(component, gbc);
				}
			}
			rowCount++;
			createRow(label, row);
		}
	}
 
	protected JLabel createJLabel(String label) {
		JLabel jlabel = new JLabel(label, JLabel.CENTER);
		jlabel.setForeground(getForeground());
		jlabel.setFont(getFont());
		return jlabel;
	}
 
	private void fillRow(int newRow) {
		for(int i=1; i<=columnCount; i++) {
			add( new JPanel(), new GridBagConstraints(i, newRow, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, INSETS, 0, 0));
		}
	}
 
	public void addColumn(String label) {
		if ( label==null ) {
			label="";
		}
		int newColumn = ++columnCount;
		createColumn(label, newColumn);
	}
 
	protected JLabel createColumn(String label, int newColumn) {
		JLabel jlabel = createJLabel(label);
		add(jlabel, new GridBagConstraints(newColumn, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, INSETS_HOR, 0, 0));
		fillColumn(newColumn);
		revalidate();
		repaint();
		return jlabel;
	}
 
	private void fillColumn(int newColumn) {
		for(int i=1; i<=rowCount; i++) {
			add( new JPanel(), new GridBagConstraints(newColumn, i, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, INSETS, 0, 0));
		}
	}
 
 
	public void addColumn(String label, int column) {
		if ( column<0 || column>columnCount ) {
			throw new IndexOutOfBoundsException();
		}
		else if ( column==columnCount ) {
			addColumn(label);
		}
		else {
			if ( label==null ) {
				label="";
			}
 
			GridBagLayout layout = (GridBagLayout) getLayout();
			for(int i=rowCount; i>=0; i--) {
				for(int j=columnCount; j>=column; j--) {
					Component component = getComponent(j,i);
					GridBagConstraints gbc = layout.getConstraints(component);
					gbc.gridx++;
					layout.setConstraints(component, gbc);
				}
			}
			columnCount++;
			createColumn(label, column);
		}
	}
 
	public void swapRow(int row1, int row2) {
		if ( row1<0 || row1>=rowCount || row2<0 || row2>=rowCount ) throw new IndexOutOfBoundsException();
		if ( row1==row2 ) return;
		if ( row1<row2 ) {
			swapRow(row2, row1);
			return;
		}
		GridBagLayout layout = (GridBagLayout) getLayout();
		for(int i=columnCount; i>=0; i--) {
			Component component1 = getComponent(i,row1+1);
			GridBagConstraints gbc1 = layout.getConstraints(component1);
			gbc1.gridy=row2+1;
			layout.setConstraints(component1, gbc1);
			Component component2 = getComponent(i,row2+1);
			GridBagConstraints gbc2 = layout.getConstraints(component2);
			gbc2.gridy=row1+1;
			layout.setConstraints(component2, gbc2);
		}
		revalidate();
		repaint();
	}
 
	public void swapColumn(int column1, int column2) {
		if ( column1<0 || column1>=columnCount || column2<0 || column2>=columnCount ) throw new IndexOutOfBoundsException();
		if ( column1==column2 ) return;
		if ( column1<column2) {
			swapColumn(column2, column1);
			return;
		}
		GridBagLayout layout = (GridBagLayout) getLayout();
		for(int i=rowCount; i>=0; i--) {
			Component component1 = getComponent(column1+1,i);
			GridBagConstraints gbc1 = layout.getConstraints(component1);
			gbc1.gridx=column2+1;
			layout.setConstraints(component1, gbc1);
			Component component2 = getComponent(column2+1,i);
			GridBagConstraints gbc2 = layout.getConstraints(component2);
			gbc2.gridx=column1+1;
			layout.setConstraints(component2, gbc2);
		}
		revalidate();
		repaint();
	}
 
	public void setRowLabel(String label, int row) {
		if ( row<0 || row>=rowCount ) throw new IndexOutOfBoundsException();
		if ( label==null ) {
			label="";
		}
		JLabel jlabel =  (JLabel)getComponent(0, row+1);
		jlabel.setText(label);
		revalidate();
		repaint();
	}
 
	public void setColumnLabel(String label, int column) {
		if ( column<0 || column>=columnCount ) throw new IndexOutOfBoundsException();
		if ( label==null ) {
			label="";
		}
		JLabel jlabel =  (JLabel)getComponent(column+1, 0);
		jlabel.setText(label);
		revalidate();
		repaint();
	}
 
	public void removeRow(int row) {
		if ( row<0 || row>=rowCount ) throw new IndexOutOfBoundsException();
		for(int i=columnCount; i>=0; i--) {
			Component component = getComponent(i,row+1);
			remove(component);
		}
		GridBagLayout layout = (GridBagLayout) getLayout();
		for(int i=columnCount; i>=0; i--) {
			for(int j=row+2; j<=rowCount; j++) {
				Component component = getComponent(i,j);
				GridBagConstraints gbc = layout.getConstraints(component);
				gbc.gridy--;
				layout.setConstraints(component, gbc);
			}
		}
		rowCount--;
		revalidate();
		repaint();
	}
 
	public void removeColumn(int column) {
		if ( column<0 || column>=columnCount ) throw new IndexOutOfBoundsException();
		for(int i=rowCount; i>=0; i--) {
			Component component = getComponent(column+1, i);
			remove(component);
		}
		GridBagLayout layout = (GridBagLayout) getLayout();
		for(int i=rowCount; i>=0; i--) {
			for(int j=column+2; j<=columnCount; j++) {
				Component component = getComponent(j,i);
				GridBagConstraints gbc = layout.getConstraints(component);
				gbc.gridx--;
				layout.setConstraints(component, gbc);
			}
		}
		columnCount--;
		revalidate();
		repaint();
	}
 
	public int getRowCount() {
		return rowCount;
	}
 
	public int getColumnCount() {
		return columnCount;
	}
 
	public void setPanel(JPanel jpanel, int row, int column) {
		if ( row<0 || row>=rowCount || column<0 || column>=columnCount ) throw new IndexOutOfBoundsException();
		removeComponentAt(column+1, row+1);
		add(jpanel, new GridBagConstraints(column+1, row+1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, INSETS, 0, 0));
		revalidate();
		repaint();
	}
 
	private void removeComponentAt(int column, int row) {
		Component component = getComponent(row, column);
		if ( component!=null ) {
			remove(component);
		}
	}
 
	private Component getComponent(int column, int row) {
		for(Component component : getComponents()) {
			GridBagConstraints gbc = ((GridBagLayout)getLayout()).getConstraints(component);
			if ( gbc.gridx==column && gbc.gridy==row ) {
				return component;
			}
		}
		return null;
	}
 
}
