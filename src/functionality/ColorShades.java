package functionality;

import java.awt.*;

/**
 * @author Erkan
 */
public class ColorShades {
	/**
	 *
	 * @param colors color array
	 * @param rounds pass in the array length
	 * @implNote Pass in a color array and get the shades of the colors, from bright to dark.
	 */
	public static void getColorShades(Color[]colors, int rounds){
		if (rounds != 1) {
			Color color = colors[rounds - 1];
			for (int i = 0; i < rounds - 1; i++) {
				color = color.darker();
			}
			colors[rounds - 1] = color;
			rounds = rounds - 1;
			getColorShades(colors, rounds);
		}
	}
}
