package lv.ipr.workshop.synth;

import javax.sound.sampled.SourceDataLine;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

abstract class Key extends JPanel implements MouseListener {
	final SourceDataLine line;
	final int position;
	final int relativeToBaseNote;

	public Key(SourceDataLine line, int position, int relativeToBaseNote) {
		this.line = line;
		this.position = position;
		this.relativeToBaseNote = relativeToBaseNote;
		addMouseListener(this);
	}

	private double getFrequency() {
		return 440 * Math.pow(1.05946309, relativeToBaseNote);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		byte[] toneBuffer = createMonoSinWaveBuffer(this.getFrequency(), 500);
		line.write(toneBuffer, 0, toneBuffer.length);
	}

	private byte[] createMonoSinWaveBuffer(double freq, int ms) {
		int samples = (ms * Synth.SAMPLE_RATE) / 1000;
		byte[] output = new byte[samples];

		double period = (double) Synth.SAMPLE_RATE / freq;
		for (int i = 0; i < output.length; i++) {
			double angle = 2.0 * Math.PI * i / period;
			output[i] = (byte) (Math.sin(angle) * 127f);
		}

		return output;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
