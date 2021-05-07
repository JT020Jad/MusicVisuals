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
		

		fft = new FFT(frameSize, sampleRate);

		bands = new float[(int) log2(frameSize)];
  		smoothedBands = new float[bands.length];

		colorMode(HSB);
        lerpedBuffer = new float[width];
	}


	float log2(float f) 
	{
		return log(f) / log(2.0f);
	}


	protected void calculateFFT() throws VisualException
	{
		fft.window(FFT.HAMMING);
		if (ab != null)
		{
			fft.forward(ab);
		}
		else
		{
			throw new VisualException("You must call startListening() or loadAudio() before calling fft");
		}
	}

	
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


	protected void calculateFrequencyBands() {
		for (int i = 0; i < bands.length; i++) {
			int start = (int) pow(2, i) - 1;
			int w = (int) pow(2, i);
			int end = start + w;
			float average = 0;
			for (int j = start; j < end; j++) {
				average += fft.getBand(j) * (j + 1);
			}
			average /= (float) w;
			bands[i] = average * 5.0f;
			smoothedBands[i] = lerp(smoothedBands[i], bands[i], 0.05f);
		}
	}


	public void startListening()
	{
		ai = minim.getLineIn(Minim.MONO, frameSize, 44100, 16);
		ab = ai.left;
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


	public int getFrameSize() {
		return frameSize;
	}

	public void setFrameSize(int frameSize) {
		this.frameSize = frameSize;
	}

	public int getSampleRate() {
		return sampleRate;
	}

	public void setSampleRate(int sampleRate) {
		this.sampleRate = sampleRate;
	}

	public float[] getBands() {
		return bands;
	}

	public float[] getSmoothedBands() {
		return smoothedBands;
	}

	public Minim getMinim() {
		return minim;
	}

	public AudioInput getAudioInput() {
		return ai;
	}


	public AudioBuffer getAudioBuffer() {
		return ab;
	}

	public float getAmplitude() {
		return amplitude;
	}

	public float getSmoothedAmplitude() {
		return smothedAmplitude;
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


	public FFT getFFT() {
		return fft;
	}
}
