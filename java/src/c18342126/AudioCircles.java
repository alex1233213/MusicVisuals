package c18342126;

import java.util.ArrayList;

import processing.core.*;

public class AudioCircles {
    My_Visual mv;
    PVector location;
    

    
    //constructor
    public AudioCircles(My_Visual mv) {
        this.mv = mv; 
    }



    


    public void createAudioCircle(float radius) {
        float x, y;
        int reduceRatio = PApplet.floor(mv.getAudioBuffer().size() / 350);
        ArrayList <Float> reducedBuffer = new ArrayList <Float> ();


        for(int i = 0; i < 350; ++i) {
            reducedBuffer.add(mv.getAudioBuffer().get(i * reduceRatio) );
        }
        
        

        for(int i = 0; i < reducedBuffer.size(); ++i) {
            
            mv.stroke(PApplet.map(i, 0, reducedBuffer.size(), 0, 255), 255, 255);
            float angle = PApplet.map(i, 0, reducedBuffer.size(), 0, PApplet.TWO_PI);
            float offset = PApplet.map(reducedBuffer.get(i),
                                 -0.5f, 0.5f, -radius * 0.05f, radius * 0.05f);
            
            x = ((radius - radius *0.1f) + offset) * PApplet.cos(angle);
            y = ((radius - radius *0.1f) + offset) *  PApplet.sin(angle);

            mv.line(x, y, x + offset, y + offset);
        }
    }




    

    public void render() {
        mv.noFill();
        mv.strokeWeight(1.5f);
        mv.noFill();

        
        mv.pushMatrix();
        
        mv.translate(mv.width / 2, mv.height / 2);
        
        for(int i= 0 ; i < mv.getBands().length; ++i) {
            createAudioCircle(mv.getSmoothedBands()[i] * 10);
        }
        
        mv.popMatrix();


    }
}


