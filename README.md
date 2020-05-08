# Music Visualiser Project

Name: Alexandru Bulgari

Student Number: C18342126


# Description of the assignment
The assignment is a visual representation of sound , consisting of geometric
2D and 3D shapes, which respond to music that is playing. 


# How it works
The code used in the assignment uses polymorphism and inheritance to create the 
visuals.

All visuals are created in the package c18342126.
All the visuals are rendered the My_Visual class.
The visuals are responsive to sound. For sound analysis, 
the minim library was used to obtain the values from the sound 
such as amplitude, frequency bands and data values from the 
audio buffer. Visuals are displayed based on those values.

For each visual , a separate class is created.
Below is an example of visual constructors being called in the setup() method

``` Java
		star = new Star(this);
        triangles = new Triangles(this);
        spheres  = new Spheres(this);        
        audio_circles = new AudioCircles(this);
        cubes = new Cubes(this);
```
These constructors create the visuals which are drawn in the draw() method.


## Controls

In order to toggle on or off the visuals, input from the keyboard is read.
For each visual there is a different button. 
The keyPressed() method is used to detect the event that any of the 
buttons from 1 to 5 are pressed to toggle the visuals. 

``` Java
public void keyPressed()
    {
        //for each visual there is a button assigned 1-5
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        } else if(key == '1') {
            if(s == 0) {
                s = 1;
            } else {
                s = 0;
            }
        } else if(key == '2') {
            if(t == 0) {
                t = 1;
            } else {
                t = 0;
            }
        } else if(key == '3') {
            if(sph == 0) {
                sph = 1;
            } else {
                sph = 0;
            }
        } else if(key == '4') {
            if(aC == 0) {
                aC = 1;
            } else {
                aC = 0;
            }
        } else if(key == '5') {
            if(c == 0) {
                c = 1;
            } else {
                c = 0;
            }
        }
    }
```




## How to run
There are 5 visuals which I created :
- Star, toggled with 1.
- Triangles, toggled with 2.
- Spheres, toggled with 3.
- Audio Circles, toggled with 4.
- Cubes, toggled with 5.

In order to start playing the music, the space key is pressed.





# What I am most proud of in the assignment
From this assignment , I have gained a lot of experience in processing
programming.

I am proud of the new things I have learned and experience gained which includes : 
- Using vectors to implement motion of objects.
- In more depth understanding of sound waves and using the data from sound.
- Creating custom shapes using beginShape(), endShape() and vertex() methods.
- Using cos(), sin() and vertex() to create vertices around a point(rotating).
- Managing classes using inheritance and polymorphism.
- Creating visuals which were not covered in class.


## The video below shows the output of the program
[Link to video](https://youtu.be/h-jel802NNY)



