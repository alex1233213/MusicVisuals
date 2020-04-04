package c18342126;

import ie.tudublin.*;

public class My_Visual extends Visual {
    Dots dots;
    Star s;

    public void settings() {
        size(1200, 800);
    }

    public void setup() {
        setFrameSize(512);
        startMinim();
        loadAudio("Dissolve.mp3"); 
        

        // dots = new Dots(this);
        s = new Star(this);
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
            // pS.render();
            // dots.render();
            s.render();
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