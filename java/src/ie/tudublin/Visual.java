package ie.tudublin;

import processing.core.PApplet;
import ddf.minim.*;
import ddf.minim.analysis.FFT;


public abstract class Visual extends PApplet
{
	int frameSize = 512;
	int sampleRate = 44100;

	float[] bands;
	float[] smoothedBands;


	Minim minim;
	AudioInput ai;


	AudioPlayer ap;
	AudioPlayer ap1;
	AudioPlayer ap2;


	AudioBuffer ab;
	FFT fft;

	float amplitude  = 0;
	float smothedAmplitude = 0;
	
	
	float[] lerpedBuffer;
	public void startMinim() 
	{
		minim = new Minim(this);

		colorMode(HSB);
        lerpedBuffer = new float[width];
	}


	public void loadAudio(String filename)
	{
		ap = minim.loadFile(filename, frameSize);
		ab = ap.mix;
	}

	public void loadAudio1(String filename)
	{
		ap1 = minim.loadFile(filename, frameSize);
		ab = ap1.mix;
	}

	public void loadAudio2(String filename)
	{
		ap2 = minim.loadFile(filename, frameSize);
		ab = ap2.mix;
	}


	public Minim getMinim() {
		return minim;
	}


	public AudioBuffer getAudioBuffer() {
		return ab;
	}


	public AudioPlayer getAudioPlayer() 
	{
		return ap;
	}

	public AudioPlayer getAudioPlayer1() 
	{
		return ap1;
	}

	public AudioPlayer getAudioPlayer2()
	{
		return ap2;
	}
}
