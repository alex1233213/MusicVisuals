package c18342126;

import processing.core.*;
import java.util.ArrayList;

public class Circles {
    My_Visual mv;
    float diam;
    PVector location;
    PVector velocity;
    ArrayList<Circles> circles;


    
    //constructor
    public Circles(My_Visual mv) {
        this.mv = mv; 
        // this.diam = mv.random(5, 10);
        velocity = new PVector(5f, 0);
        location = new PVector(0 ,0);
        circles = new ArrayList <Circles> ();
    }



    public void setup() {
        mv.setFrameSize(512);
    }



    public void moveCircles() {
        this.location.add(velocity);
    }




    

    public void render() {
        for(int i = 0; i < mv.getBands().length; i++) {
            Circles c = new Circles(mv);
            circles.add(c);
            
            mv.noFill();
            mv.strokeWeight(3.5f);
            mv.stroke(PApplet.map(i, 0, mv.getBands().length, 0 , 255), 255,255);

            mv.pushMatrix();
            mv.translate(mv.width / 2, mv.height / 2);

            
            float rad = mv.getSmoothedBands()[i] * 10;

            mv.circle(circles.get(i).location.x, 
                    circles.get(i).location.y, rad);
            
            
            mv.popMatrix();
            // circles.get(i).moveCircles();
        }


    }
}


