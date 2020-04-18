package c18342126;

import ie.tudublin.*;

public class My_Visual extends Visual {
    Dots dots;
    Star s;
    Triangles t;

    public void settings() {
        size(1200, 800);
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
            t.render();
            // dots.render();
            // s.render();
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }

        
        
        // dots.render();
        
    }

    //method to close Minim audio classes when done with them
    public void stop() {
        
        getAudioPlayer().close();
        getMinim().stop();
        super.stop();
    }
}