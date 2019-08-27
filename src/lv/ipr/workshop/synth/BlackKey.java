package lv.ipr.workshop.synth;

import javax.sound.sampled.SourceDataLine;
import java.awt.*;

class BlackKey extends Key {

	public BlackKey(SourceDataLine line, int position, int relativeToBaseNote) {
		super(line, position, relativeToBaseNote);
		setBackground(Color.BLACK);
		setBounds(position * 20 + 15, 10, 10, 70);
	}
}
