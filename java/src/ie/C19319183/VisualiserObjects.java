package ie.C19319183;

import processing.core.PApplet;
import ddf.minim.*;


public abstract class VisualiserObjects extends PApplet
{
	int frameSize = 512;
	int sampleRate = 44100;

	
    float[] lerpedBuffer;
    float halfHeight = height / 2;
	float halfWidth = width / 2;

	float lerpedAverage = 0;
    float average = 0;
    float sum = 0;
	


	Minim minim;
	AudioInput ai;


	AudioPlayer ap;
	AudioPlayer ap1;
	AudioPlayer ap2;


	AudioBuffer ab;


	// Decided not to utilise these
	/*
		float amplitude  = 0;
		float smothedAmplitude = 0;
	*/


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


	// Decide not to utilise these
	/*
		public void calculateAverageAmplitude()
		{
			float total = 0;
			for(int i = 0 ; i < ab.size() ; i ++)
			{
				total += abs(ab.get(i));
			}
			amplitude = total / ab.size();
			smothedAmplitude = PApplet.lerp(smothedAmplitude, amplitude, 0.1f);
		}

		public float getSmoothedAmplitude() 
		{
			return smothedAmplitude;
		}
	*/
}
