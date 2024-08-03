package view;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class TransparentTextField extends JTextField {

    public TransparentTextField(int width) {
        super(width);
    }

    public TransparentTextField() {
        super();
        init();
    }

    private void init() {
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder());
    }
}
