package lv.ipr.workshop.synth;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.*;
import java.awt.*;

class Synth {

	static final int SAMPLE_RATE = 44100;

	private SourceDataLine line;

	Synth() {

		try {
			final AudioFormat af = new AudioFormat(SAMPLE_RATE, 8, 1, true, true);
			line = AudioSystem.getSourceDataLine(af);
			line.open(af, SAMPLE_RATE);
			line.start();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	void createAndShowGUI() {


		JPanel contentPane = new JPanel(null);

		contentPane.add(new BlackKey(line, 0, -8));  //C#
		contentPane.add(new BlackKey(line, 1, -6));  //D#
		contentPane.add(new BlackKey(line, 3, -3));  //F#
		contentPane.add(new BlackKey(line, 4, -1));  //G#
		contentPane.add(new BlackKey(line, 5, 1));   //A#
		contentPane.add(new BlackKey(line, 7, 4));   //C#
		contentPane.add(new BlackKey(line, 8, 6));   //D#
		contentPane.add(new BlackKey(line, 10, 9));  //F#
		contentPane.add(new BlackKey(line, 11, 11)); //G#
		contentPane.add(new BlackKey(line, 12, 13)); //A#

		contentPane.add(new WhiteKey(line, 0, -9));  //C
		contentPane.add(new WhiteKey(line, 1, -7));  //D
		contentPane.add(new WhiteKey(line, 2, -5));  //E
		contentPane.add(new WhiteKey(line, 3, -4));  //F
		contentPane.add(new WhiteKey(line, 4, -2));  //G
		contentPane.add(new WhiteKey(line, 5, 0));   //A
		contentPane.add(new WhiteKey(line, 6, 2));   //B
		contentPane.add(new WhiteKey(line, 7, 3));   //C
		contentPane.add(new WhiteKey(line, 8, 5));   //D
		contentPane.add(new WhiteKey(line, 9, 7));   //E
		contentPane.add(new WhiteKey(line, 10, 8));  //F
		contentPane.add(new WhiteKey(line, 11, 10)); //G
		contentPane.add(new WhiteKey(line, 12, 12)); //A
		contentPane.add(new WhiteKey(line, 13, 14)); //B
		contentPane.add(new WhiteKey(line, 14, 15)); //C

		JFrame frame = new JFrame("Piano");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(contentPane);
		frame.setPreferredSize(new Dimension(316, 160));
		frame.pack();
		frame.setVisible(true);
	}

}

