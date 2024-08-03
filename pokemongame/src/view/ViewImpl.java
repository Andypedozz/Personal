package view;

import interfaces.View;
import interfaces.ViewObserver;

public class ViewImpl implements View{
	private MyFrame frame;
	
	public ViewImpl(ViewObserver observer) {
		this.frame = new MyFrame(observer);
	}
	
	@Override
	public MyFrame getFrame() {
		return this.frame;
	}

}
