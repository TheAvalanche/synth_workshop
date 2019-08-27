package lv.ipr.workshop.midi;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

class Synth {

	static final int SAMPLE_RATE = 44100;

	MidiChannel channel;

	Synth() {

		try {
			Synthesizer synth = MidiSystem.getSynthesizer();
			synth.open();
			synth.loadAllInstruments(synth.getDefaultSoundbank());
			channel = synth.getChannels()[0];
			channel.programChange(1);

		} catch (MidiUnavailableException ex) {
			ex.printStackTrace();
		}
	}

	void createAndShowGUI() {


		JPanel contentPane = new JPanel(null) {
			@Override
			public boolean isOptimizedDrawingEnabled() {
				return false;
			}
		};

		contentPane.add(new BlackKey(channel, 0, -8));  //C#
		contentPane.add(new BlackKey(channel, 1, -6));  //D#
		contentPane.add(new BlackKey(channel, 3, -3));  //F#
		contentPane.add(new BlackKey(channel, 4, -1));  //G#
		contentPane.add(new BlackKey(channel, 5, 1));   //A#
		contentPane.add(new BlackKey(channel, 7, 4));   //C#
		contentPane.add(new BlackKey(channel, 8, 6));   //D#
		contentPane.add(new BlackKey(channel, 10, 9));  //F#
		contentPane.add(new BlackKey(channel, 11, 11)); //G#
		contentPane.add(new BlackKey(channel, 12, 13)); //A#

		contentPane.add(new WhiteKey(channel, 0, -9));  //C
		contentPane.add(new WhiteKey(channel, 1, -7));  //D
		contentPane.add(new WhiteKey(channel, 2, -5));  //E
		contentPane.add(new WhiteKey(channel, 3, -4));  //F
		contentPane.add(new WhiteKey(channel, 4, -2));  //G
		contentPane.add(new WhiteKey(channel, 5, 0));   //A
		contentPane.add(new WhiteKey(channel, 6, 2));   //B
		contentPane.add(new WhiteKey(channel, 7, 3));   //C
		contentPane.add(new WhiteKey(channel, 8, 5));   //D
		contentPane.add(new WhiteKey(channel, 9, 7));   //E
		contentPane.add(new WhiteKey(channel, 10, 8));  //F
		contentPane.add(new WhiteKey(channel, 11, 10)); //G
		contentPane.add(new WhiteKey(channel, 12, 12)); //A
		contentPane.add(new WhiteKey(channel, 13, 14)); //B
		contentPane.add(new WhiteKey(channel, 14, 15)); //C

		JFrame frame = new JFrame("Piano");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(contentPane);
		frame.setPreferredSize(new Dimension(316, 160));
		frame.pack();
		frame.setVisible(true);
	}

}

