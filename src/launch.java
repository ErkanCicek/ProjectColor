import functionality.ZoomOnMouse;

import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class launch {
	public static void main(String[] args) {
		int width = Toolkit.getDefaultToolkit().getScreenSize().width/6;
		AtomicInteger height = new AtomicInteger(width);
		ZoomOnMouse zoomOnMouse = new ZoomOnMouse(width, height.get());
		zoomOnMouse.setBounds(0,0,width, height.get());

		Frame mainFrame = new Frame(); // frame that will contain everything
		mainFrame.add(zoomOnMouse);


	}
}
