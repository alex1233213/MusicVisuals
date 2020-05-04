package c18342126;

import processing.core.*;
import java.util.ArrayList;

public class Circles {
    My_Visual mv;
    PVector location;
    ArrayList<Circles> circles;
    // float angle = 0;

    
    //constructor
    public Circles(My_Visual mv) {
        this.mv = mv; 
        // this.diam = mv.random(5, 10);
        location = new PVector(0 ,0);
        circles = new ArrayList <Circles> ();
    }



    public void setup() {
        mv.setFrameSize(64);
    }



    public void createAudioCircle(float radius) {
        float x, y;
        float offset;
        
        mv.beginShape();
        for(int i = 0; i < mv.getAudioBuffer().size(); ++i) {
            float angle = PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, PApplet.TWO_PI);
            x = radius * PApplet.cos(angle);
            y = radius * PApplet.sin(angle);
            offset = PApplet.map(mv.getAudioBuffer().get(i),
                                 -1, 1, -radius * 0.2f, radius * 0.2f);

            mv.vertex(x + offset, y + offset);
            
        }
        mv.endShape(PApplet.CLOSE);
    }




    

    public void render() {
        mv.noFill();
        mv.strokeWeight(4f);
        Circles c = new Circles(mv);
        circles.add(c);
        mv.noFill();

        
        // mv.stroke(255);
        
        mv.pushMatrix();
        
        mv.translate(mv.width / 2, mv.height / 2);
        
        for(int i= 0 ; i < mv.getBands().length; ++i) {
            mv.stroke(PApplet.map(i, 0, mv.getBands().length, 0, 255), 255, 255);
            createAudioCircle(mv.getSmoothedBands()[i] * 5);
        }
        
        mv.popMatrix();


    }
}


