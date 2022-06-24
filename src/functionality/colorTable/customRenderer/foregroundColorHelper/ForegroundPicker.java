package functionality.colorTable.customRenderer.foregroundColorHelper;

import java.awt.*;

public class ForegroundPicker {
	public static Color foregroundPickerAlg(Color color){
		double luma = ((0.299 * color.getRed()) + (0.587 * color.getGreen()) + (0.114 * color.getBlue())) / 255;
		return luma > 0.5 ? Color.black : Color.white;
	}
}
