package ie.tudublin;

import processing.core.*;

// This is an example of a visual that renders the waveform
public class Visualisers
{
    Menu mv;
    float cy = 0;

    public Visualisers(Menu mv)
    {
        this.mv = mv;
        cy = this.mv.height;
    }


    public void render()
    {
        mv.colorMode(PApplet.HSB);
        for(int i = 0; i < mv.getAudioBuffer().size(); i++)
        {
            mv.stroke(PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 21), 255, 125);

            mv.line(0, cy, i, cy + cy * mv.getAudioBuffer().get(i));
        }
    } // End render()
}