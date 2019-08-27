package lv.ipr.workshop.synth;

import javax.sound.sampled.SourceDataLine;
import javax.swing.border.LineBorder;
import java.awt.*;

class WhiteKey extends Key {

	public WhiteKey(SourceDataLine line, int position, int relativeToBaseNote) {
		super(line, position, relativeToBaseNote);
		setBorder(new LineBorder(Color.BLACK));
		setBackground(Color.WHITE);
		setBounds(position * 20, 10, 20, 100);
	}
}
