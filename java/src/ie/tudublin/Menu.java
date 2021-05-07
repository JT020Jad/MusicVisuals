package ie.tudublin;

import java.util.*;
import processing.core.PImage;

public class Menu extends Visual
{    
    WaveForm wf;

    PImage [] sleepOnTrain = new PImage [27];
    PImage [] nightVibes = new PImage [54];
    PImage [] nightCity = new PImage [24];
    
	float[] lerpedBuffer;


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
        loadAudio("kudasaibeats - technicolor.mp3"); 
        loadAudio1("WYS - Close My Eyes.mp3"); 
        loadAudio2("Sagun - I'll Keep You Safe.mp3"); 
        

        wf = new WaveForm(this);
        colorMode(HSB);
        lerpedBuffer = new float[width];

        frameRate(21);
    }


    public void keyPressed()
    {
        if (key == '1')
        {
            getAudioPlayer1().pause();
            getAudioPlayer2().pause();

            if(getAudioPlayer().isPlaying())
            {
                getAudioPlayer().pause();
            }

            else
            {
                getAudioPlayer().play();
                smooth();
                for(int i = 0 ; i < 26 ; i ++)
                {
                    sleepOnTrain[i] = loadImage("sleepOnTrainFrame" + i + ".gif");    
                }
            }


            // Reset the key press to a neutral state
            key = '0';
        }


        if(key == '2')
        {
            getAudioPlayer().pause();
            getAudioPlayer2().pause();

            if(getAudioPlayer1().isPlaying())
            {
                getAudioPlayer1().pause();
            }
            
            else
            {
                getAudioPlayer1().play();
                smooth();
                for(int i = 0 ; i < 54 ; i ++)
                {
                    nightVibes[i] = loadImage("frame_" + i + "_delay-0.1s" + ".gif");
                }
            }


            // Reset the key press to a neutral state
            key = '0';
        }


        if(key == '3')
        {
            getAudioPlayer().pause();
            getAudioPlayer1().pause();

            if(getAudioPlayer2().isPlaying())
            {
                getAudioPlayer2().pause();
            }
            
            else
            {
                getAudioPlayer2().play();
                smooth();
                for(int i = 0 ; i < 24 ; i ++)
                {
                    nightCity[i] = loadImage("nightCity" + i + ".gif");
                }
            }


            // Reset the key press to a neutral state
            key = '0';
        } 


        if(key == ' ')
        {
            getAudioPlayer().rewind();
            getAudioPlayer1().rewind();
            getAudioPlayer2().rewind();

            text("All songs have been reset", width / 2, height / 2);


            // Reset the key press to a neutral state
            key = '0';
        }
    }



    float lerpedAverage = 0;

    public void draw()
    {
        background(0);
        stroke(255);
        float average = 0;
        float sum = 0;
        

        // Calculate the average of the buffer
        for (int i = 0; i < ab.size(); i ++)
        {
            sum += abs(ab.get(i));
        }
        average = sum / ab.size();

        // Move lerpedAverage 10% closer to average every frame
        lerpedAverage = lerp(lerpedAverage, average, 0.1f);



        text("Press '1' to play and pause Track1", 50, 50);
        text("Press '2' to play and pause Track2", 50, 65);
        text("Press '2' to play and pause Track3", 50, 80);
        text("Press 'Spacebar' to reset the songs", 50, 95);

        
        // Track 1
        if(getAudioPlayer().isPlaying() )
        {
            // Clears the canvas
            background(255);
            background(0);
            

            image(sleepOnTrain[frameCount%26], 0, 0);
            ab = ap.mix;
            

            stroke(255);
            text("Press '1' to play and pause Track1", 50, 50);
            text("Press '2' to play and pause Track2", 50, 65);

            text("Song: Kudasaibeats - Technicolor", 800, 50);


            // Circles 1 - 3 are on the right side of the screen
            // Circle 1
            float a = map(average, 0, 1, 0, 255);
            stroke(a, 255, 255);        
            strokeWeight(2);
            noFill();
            ellipse(900, 410, 50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));  

            // Circle 2
            float b = map(average, 0, 1, 0, 255);
            stroke(b, 255, 255);        
            strokeWeight(2);
            noFill();
            ellipse(915, 425, 50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));

            // Circle 3
            float c = map(average, 0, 1, 0, 255);
            stroke(c, 255, 255);        
            strokeWeight(2);
            noFill();
            ellipse(930, 440, 50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));


            // Circles 4 - 6 are on the left side of the screen
            // Circle 4
            float d = map(average, 0, 1, 0, 255);
            stroke(d, 255, 255);        
            strokeWeight(2);
            noFill();
            ellipse(100, 440, 50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));  

            // Circle 5
            float e = map(average, 0, 1, 0, 255);
            stroke(e, 255, 255);        
            strokeWeight(2);
            noFill();
            ellipse(115, 425, 50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));

            // Circle 6
            float f = map(average, 0, 1, 0, 255);
            stroke(f, 255, 255);        
            strokeWeight(2);
            noFill();
            ellipse(130, 410, 50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
        }



        // Track 2
        else if(getAudioPlayer1().isPlaying())
        {
            // Clears the canvas
            background(255);
            background(0);


            image(nightVibes[frameCount%54], 0, 0);
            ab = ap1.mix;
            
            stroke(255);
            text("Press '1' to play and pause Track1", 50, 50);
            text("Press '2' to play and pause Track2", 50, 65);

            text("Song: WYS - Close My Eyes", 800, 50);


            wf.render();
            //wf.flippedRender();
        }



        // Track 3
        else if(getAudioPlayer2().isPlaying())
        {
            // Clears the canvas
            background(255);
            background(0);


            image(nightCity[frameCount%24], 100, 50);
            ab = ap2.mix;
            
            stroke(255);
            text("Press '1' to play and pause Track1", 120, 85);
            text("Press '2' to play and pause Track2", 120, 100);
            text("Press '3' to play and pause Track3", 120, 115);

            text("Song: Sagun - I'll Keep You Safe", 700, 85);
        }
    }
}
