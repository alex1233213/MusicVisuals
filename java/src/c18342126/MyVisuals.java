package c18342126;

import ie.tudublin.*;

public class MyVisuals extends Visual {
    
    public void settings() {
        size(1200, 800);
    }

    public void draw() {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("Illusionize.mp3");   

        //create objects
        // wf = new WaveForm(this);
        // abv = new AudioBandsVisual(this);
    }
}