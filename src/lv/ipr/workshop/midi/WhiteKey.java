package lv.ipr.workshop.midi;

import javax.sound.midi.MidiChannel;
import javax.swing.border.LineBorder;
import java.awt.*;

class WhiteKey extends Key {

	public WhiteKey(MidiChannel channel, int position, int relativeToBaseNote) {
		super(channel, position, relativeToBaseNote, Color.WHITE, Color.GRAY);
		setBorder(new LineBorder(Color.BLACK));
		setBounds(position * 20, 10, 20, 100);
	}
}
