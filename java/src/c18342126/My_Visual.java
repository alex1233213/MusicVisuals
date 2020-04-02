package c18342126;

import java.util.ArrayList;

import ie.tudublin.*;

public class My_Visual extends Visual {
    ArrayList<Dots> dots = new ArrayList <Dots> ();

    public void settings() {
        size(1200, 800);
    }

    public void setup() {
        setFrameSize(512);
        startMinim();
        loadAudio("Plakala.mp3"); 
        
        
        
        
        
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
        background(196, 0, 240);

        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
               
        for(int i = 0; i < 20; i++) {
            Dots dot = new Dots(this);
            dots.add(dot);


            if(dots.size() > 300) {

                for(int j = 0; j < dots.size() - 1; j++) {
                    dots.remove(j);
                }
                
            }
        }
        
    
        
        

     

        
        for(Dots d : dots) {
            d.render();
            d.moveDots();
        }

        
        

    }

    //method to close Minim audio classes when done with them
    public void stop() {
        
        getAudioPlayer().close();
        getMinim().stop();
        super.stop();
    }
}