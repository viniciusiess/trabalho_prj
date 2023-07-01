package utils;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
    
public class ButtonRenderTable extends AbstractCellEditor implements TableCellRenderer {
	private JButton button;

    public ButtonRenderTable() {
        button = new JButton("Baixar");
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return button;
    }

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}
}