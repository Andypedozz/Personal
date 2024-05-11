package view;

import interfaces.View;
import interfaces.ViewObserver;

public class ViewImpl implements View{
	private MyFrame frame;
	private SelectMoveView selectMoveView;
	private SwitchView switchView;
	
	public ViewImpl(ViewObserver observer) {
		this.frame = new MyFrame(observer);
	}
	
	@Override
	public MyFrame getFrame() {
		// TODO Auto-generated method stub
		return this.frame;
	}
	
	@Override
	public SelectMoveView getSelectMoveView() {
    	
    	return this.selectMoveView;
    }
	
	@Override
	public SwitchView getSwitchView() {
    	
    	return this.switchView;
    }
}
