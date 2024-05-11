package interfaces;

import view.MyFrame;
import view.SelectMoveView;
import view.SwitchView;

public interface View {
	MyFrame getFrame();
	SwitchView getSwitchView();
	SelectMoveView getSelectMoveView();
}
