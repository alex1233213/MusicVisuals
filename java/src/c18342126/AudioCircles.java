package c18342126;

import processing.core.*;

public class AudioCircles {
    My_Visual mv;
    PVector location;
    

    
    //constructor
    public AudioCircles(My_Visual mv) {
        this.mv = mv; 
    }



    public void setup() {
        mv.setFrameSize(64);
    }



    public void createAudioCircle(float radius) {
        float x, y;
        
        mv.beginShape();
        for(int i = 0; i < mv.getAudioBuffer().size(); ++i) {
            float angle = PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, PApplet.TWO_PI);
            float offset = PApplet.map(mv.getAudioBuffer().get(i),
                                 -1, 1, -radius * 0.15f, radius * 0.15f);
            
            x = radius * PApplet.cos(angle);
            y = radius *  PApplet.sin(angle);

            mv.vertex(x + offset, y + offset);
            
        }
        mv.endShape(PApplet.CLOSE);
    }




    

    public void render() {
        mv.noFill();
        mv.strokeWeight(4f);
        mv.noFill();

        
        mv.pushMatrix();
        
        mv.translate(mv.width / 2, mv.height / 2);
        
        for(int i= 0 ; i < mv.getBands().length; ++i) {
            mv.stroke(PApplet.map(i, 0, mv.getBands().length, 0, 255), 255, 255);
            createAudioCircle(mv.getSmoothedBands()[i] * 10);
        }
        
        mv.popMatrix();


    }
}


