package lv.ipr.workshop.midi;

import javax.sound.midi.MidiChannel;
import java.awt.*;

class BlackKey extends Key {

	public BlackKey(MidiChannel channel, int position, int relativeToBaseNote) {
		super(channel, position, relativeToBaseNote, Color.BLACK, Color.GRAY);
		setBounds(position * 20 + 15, 10, 10, 70);
	}
}
