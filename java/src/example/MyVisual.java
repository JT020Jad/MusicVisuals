package example;

import ie.tudublin.*;
import processing.core.PImage;

public class MyVisual extends Visual
{    
    WaveForm wf;
    //AudioBandsVisual abv;

    PImage [] sleepOnTrain = new PImage [27];

    public void settings()
    {
        size(1024, 500);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("kudasaibeats-technicolor.mp3");  
        
        
        smooth();
        sleepOnTrain[0] = loadImage("sleepOnTrainFrame0.gif");
        sleepOnTrain[1] = loadImage("sleepOnTrainFrame1.gif");
        sleepOnTrain[2] = loadImage("sleepOnTrainFrame2.gif");
        sleepOnTrain[3] = loadImage("sleepOnTrainFrame3.gif");
        sleepOnTrain[4] = loadImage("sleepOnTrainFrame4.gif");
        sleepOnTrain[5] = loadImage("sleepOnTrainFrame5.gif");
        sleepOnTrain[6] = loadImage("sleepOnTrainFrame6.gif");
        sleepOnTrain[7] = loadImage("sleepOnTrainFrame7.gif");
        sleepOnTrain[8] = loadImage("sleepOnTrainFrame8.gif");
        sleepOnTrain[9] = loadImage("sleepOnTrainFrame9.gif");
        sleepOnTrain[10] = loadImage("sleepOnTrainFrame10.gif");
        sleepOnTrain[11] = loadImage("sleepOnTrainFrame11.gif");
        sleepOnTrain[12] = loadImage("sleepOnTrainFrame12.gif");
        sleepOnTrain[13] = loadImage("sleepOnTrainFrame13.gif");
        sleepOnTrain[14] = loadImage("sleepOnTrainFrame14.gif");
        sleepOnTrain[15] = loadImage("sleepOnTrainFrame15.gif");
        sleepOnTrain[16] = loadImage("sleepOnTrainFrame16.gif");
        sleepOnTrain[17] = loadImage("sleepOnTrainFrame17.gif");
        sleepOnTrain[18] = loadImage("sleepOnTrainFrame18.gif");
        sleepOnTrain[19] = loadImage("sleepOnTrainFrame19.gif");
        sleepOnTrain[20] = loadImage("sleepOnTrainFrame20.gif");
        sleepOnTrain[21] = loadImage("sleepOnTrainFrame21.gif");
        sleepOnTrain[22] = loadImage("sleepOnTrainFrame22.gif");
        sleepOnTrain[23] = loadImage("sleepOnTrainFrame23.gif");
        sleepOnTrain[24] = loadImage("sleepOnTrainFrame24.gif");
        sleepOnTrain[25] = loadImage("sleepOnTrainFrame25.gif");
        sleepOnTrain[26] = loadImage("sleepOnTrainFrame26.gif");

        // Call this instead to read audio from the microphone
        //startListening(); 
        
        wf = new WaveForm(this);
        //abv = new AudioBandsVisual(this);

        frameRate(15);
    }

    public void keyPressed()
    {
        if (key == '1')
        {
            getAudioPlayer().play();
        }

        if(key == '2')
        {
            getAudioPlayer().pause();
        }
    }

    public void draw()
    {
        background(0);

        image(sleepOnTrain[frameCount%8], 540, 90);

        stroke(255);
        text("Press '1' to PLAY", 50, 50);
        text("Press '2' to PAUSE", 50, 65);

        text("Song: Kudasaibeats - Technicolor", 800, 100);

        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        //calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        //calculateAverageAmplitude();    
        
        
        wf.render();
        //abv.render();
    }
}
