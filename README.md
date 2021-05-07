# Music Visualiser Project
Name: Mohammad Touihri

Student Number: C19319183

# Description of the assignment
Initially, a statement was given, "Something beuatiful to enjoy while listening to music", and the assignment had to be based upon that.
My mind immediately jumped to *Lofi Hip-Hop*. This is very substantial to me personally, as it was the exact same music that I used to study for my Leaving Certificate exam and to this day
remains my go to for relaxation. It was truly, in my opinion, something that you could listen to and just chill. 
What makes lofi more appealing is the fact that it is very very simplistic in nature and consists of the same low-fidelity beat being repeated, causing a sense of tranquility. 
My assignment involved three lofi  lofi tracks each with their own unique GIF and visualiser. The idea of using a GIF was the first idea that I had and the one
I decided to stick with as the repetitive nature of a GIF compliments the repetitive beat. Also, by using a GIF I was able to portray calmness and relaxation
in the best possible way, and the visualisers were given colours that compliment the scene(s). 

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
Instantiating the array of images. This is how the GIF was created. I firstly found a GIF I liked , and then I split it up into its individual frames and inserted them into an array

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

