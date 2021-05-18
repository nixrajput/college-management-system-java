package repository;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import models.Branch;

/**
 *
 * @author nixrajput
 */
@SuppressWarnings("serial")
public class ComboBoxRenderer extends BasicComboBoxRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof Branch) {
            Branch branch = (Branch) value;
            setText(branch.getInit());
        }
        return this;
    }

}
