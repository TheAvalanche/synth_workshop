package lv.ipr.workshop.midi;

import javax.sound.midi.MidiChannel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Key extends JPanel implements MouseListener {
	final MidiChannel channel;

	final int position;
	final int relativeToBaseNote;

	final Color defaultColor;
	final Color pressColor;

	public Key(MidiChannel channel, int position, int relativeToBaseNote, Color defaultColor, Color pressColor) {
		this.channel = channel;
		this.position = position;
		this.relativeToBaseNote = relativeToBaseNote;
		this.defaultColor = defaultColor;
		this.pressColor = pressColor;
		setBackground(defaultColor);
		addMouseListener(this);
	}

	private int getNote() {
		return 69 + relativeToBaseNote;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		channel.noteOn(this.getNote(), 127);
		setBackground(pressColor);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		channel.noteOff(this.getNote());
		setBackground(defaultColor);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
			channel.noteOn(this.getNote(), 127);
			setBackground(pressColor);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		channel.noteOff(this.getNote());
		setBackground(defaultColor);
	}
}
