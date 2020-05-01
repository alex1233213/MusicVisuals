package c18342126;

import ie.tudublin.*;

public class My_Visual extends Visual {
    Dots dots;
    Star s;
    Triangles t;
    Spheres spheres;

    public void settings() {
        size(1200, 800, P3D);
    }

    public void setup() {
        setFrameSize(512);
        startMinim();
        loadAudio("LANDR-Voices-High-Balanced.wav"); 
        colorMode(HSB);
        background(0);

        dots = new Dots(this);
        s = new Star(this);
        t = new Triangles(this);
        spheres  = new Spheres(this);        

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
        

        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
            calculateFrequencyBands();
            calculateAverageAmplitude(); 
            // t.render();
            // dots.render();
            s.render();
            spheres.render();
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