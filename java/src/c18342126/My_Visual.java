package c18342126;

import ie.tudublin.*;

public class My_Visual extends Visual {
    Star star;
    Triangles triangles;
    Spheres spheres;
    Circles circles;

    public void settings() {
        size(1200, 800, P3D);
    }

    public void setup() {
        setFrameSize(512);
        startMinim();
        loadAudio("LANDR-Voices-High-Balanced.wav"); 
        colorMode(HSB);
        

        star = new Star(this);
        triangles = new Triangles(this);
        spheres  = new Spheres(this);        
        circles = new Circles(this);
    }


    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
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
            
            
            star.render();
            spheres.render();
            circles.render();
            triangles.render();
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