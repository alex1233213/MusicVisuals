/*
Music Visualiser Assignment
When Program is run , a processing sketch will be created.

When space key is entered, an audio file is played.
When '1' key is entered the star object is rendered.
When '2' key is entered triangles will be rendered.
When '3' key is entered , spheres will be rendered.
When '4' key is entered, audio circles will be rendered.
When '5' key is entered ,cubes will be rendered.

Alexandru Bulgari
C18342126
*/


package c18342126;

import ie.tudublin.*;

public class My_Visual extends Visual {
    //objects to be rendered
    Star star;
    Triangles triangles;
    Spheres spheres;
    AudioCircles audio_circles;
    Cubes cubes;

    //button flags
    int s, t, sph, aC, c = 0;

    public void settings() {
        size(1200, 800, P3D);
    }

    public void setup() {
        setFrameSize(512);
        startMinim();
        loadAudio("LANDR-Voices-High-Balanced.wav"); 
        colorMode(HSB);
        
        //call to constructors of objects
        star = new Star(this);
        triangles = new Triangles(this);
        spheres  = new Spheres(this);        
        audio_circles = new AudioCircles(this);
        cubes = new Cubes(this);
    }


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




    public void draw() {
        background(0);

        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
            calculateFrequencyBands();
            calculateAverageAmplitude(); 
            
            if(s == 1) {
                star.render();
            } 
            
            if(t == 1) {
                triangles.render();
            }

            if(sph == 1) {
                spheres.render();
            }

            if(aC == 1) {
                audio_circles.render();
            }
            
            
            if(c == 1) {
                cubes.render();
            }

        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }

        
    }

    //method to close Minim audio classes when done with them
    public void stop() {
        getAudioPlayer().close();
        getMinim().stop();
        super.stop();
    }
}