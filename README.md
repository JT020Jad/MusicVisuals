# Music Visualiser Project
Name: Mohammad Touihri

Student Number: C19319183


# Description of the assignment
Initially, a statement was given, "Something beuatiful to enjoy while listening to music", and the assignment had to be based upon that.
My mind immediately jumped to *Lofi Hip-Hop*. This is very substantial to me personally, as it was the exact same music that I used to study for my Leaving Certificate exam and to this day remains my go to for relaxation. It was truly, in my opinion, something that you could listen to and just chill. 
What makes lofi more appealing is the fact that it is very very simplistic in nature and consists of the same low-fidelity beat being repeated, causing a sense of tranquility. 

My assignment involved three lofi tracks each with their own unique GIF and visualiser. The idea of using a GIF was the first idea that I had and the one
I decided to stick with as the repetitive nature of a GIF compliments the repetitive beat. Another reason I chose to utilise a GIF was because I was fairly certain that the idea in of itself was a unique one and that no one else had done the same thing. By using a GIF I was able to portray calmness and relaxation in the best possible way, and the visualisers were given colours that compliment the scene(s). 

This can be seen in the three scenes I have chosen:
1. Asleep On the Train
2. A Dark Stormy Night
3. Night Time in the Big City 

and their respective tracks:
1. [Kudasaibeats - Technicolor](https://www.youtube.com/watch?v=EaE4QKv9lGk)
2. [WYS - Close My Eyes](https://www.youtube.com/watch?v=ICkW1_r9f80&t=29s)
3. [Sagun - I'll Keep You Safe](https://www.youtube.com/watch?v=7ly7Mhle-4M)


# Instructions
1. Fork and clone this repository to your local machine
2. Open the source repository in your IDE of choice
3. Run the program
4. Follow the on-screen instructions to navigate the program
- Pressing '1' will play/pause track 1
- Pressing '2' will play/pause track 2
- Pressing '3' will play/pause track 3
- Pressing 'spacebar' will reset all the songs (rewinds them to the beginning)


# How it works
Instantiating the array of images. This is how the GIF was created. I firstly found a GIF I liked , and then I split it up into its individual frames using [this](https://ezgif.com/split) tool and inserted them into an array

```Java
PImage [] sleepOnTrain = new PImage [27];
    PImage [] nightVibes = new PImage [54];
    PImage [] nightCity = new PImage [24];
```

The images were looped indefinitely using a for loop to produce the GIF
```Java
	for(int i = 0 ; i < 24 ; i ++)
    {
        nightCity[i] = loadImage("nightCity" + i + ".gif");
    } // End for
```

This line ensured that all the individual frames were accounted for and that no frames were dropped/excluded when being rendered in
``` Java
	image(nightCity[frameCount%24], 100, 50);
```

The first GIF and track visualiser consisted of drawing circles and shifting them along the X and Y axis at an equal interval
```Java
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
``

The visualiser for the second GIF and track was in a different class and the method was called from the Menu Class
``` Java
	public void render()
    {
        mv.colorMode(PApplet.HSB);
        for(int i = 0; i < mv.getAudioBuffer().size(); i++)
        {
            mv.stroke(PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 21), 255, 125);

            mv.line(0, cy, i, cy + cy * mv.getAudioBuffer().get(i));
        }
    } // End render()
```

To allow for three different tracks to be played, I initialised three different AudioPlayer instances and their respective constructors
```Java
AudioPlayer ap;
AudioPlayer ap1;
AudioPlayer ap2;


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
```

The key presses play/pause the requested song and pause everything else. Key = 0 is used to reset the key press input to a neutral state, ensuring there are no input conflicts
```Java
if (key == '1')
        {
            getAudioPlayer1().pause();
            getAudioPlayer2().pause();

            if(getAudioPlayer().isPlaying())
            {
                getAudioPlayer().pause();
            } // End if

            else
            {
                getAudioPlayer().play();
                //smooth();
                for(int i = 0 ; i < 26 ; i ++)
                {
                    sleepOnTrain[i] = loadImage("sleepOnTrainFrame" + i + ".gif");    
                } // End for
            } // End else


            // Reset the key press to a neutral state
            key = '0';
        } // End if
```


# What I am most proud of in the assignment



# What I would have done differently
gif and visualiser in different classes
regiser key press then pass value to a switch case statement




# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings


So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

