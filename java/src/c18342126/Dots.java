package c18342126;

import processing.core.*;
import java.util.ArrayList;

public class Dots {
    My_Visual mv;
    float diam;
    PVector location;
    PVector velocity;
    ArrayList<Dots> dots;


    

    public Dots(My_Visual mv) {
        this.mv = mv; 
        // this.diam = mv.random(5, 10);
        velocity = new PVector(0.5f, 0);
        location = new PVector(mv.random(mv.width * 0.1f, mv.width * 0.3f),
                                 mv.random(mv.height * 0.25f, mv.height * 0.9f));
        dots = new ArrayList <Dots> ();
    }



    public void moveDots() {
        location.add(velocity);
    }



        
    

    public void render() {
        mv.translate(0, 0);
        mv.fill(255, 200);
        mv.noStroke();

        for(int i = 0; i < 20; i++) {
            
            Dots dot = new Dots(mv);
            dots.add(dot);
            // System.out.println(mv.getBands()[i]); 
            mv.pushMatrix();
            mv.translate(0, 0);
            mv.circle(dots.get(i).location.x, dots.get(i).location.y, mv.getSmoothedAmplitude() * 50f);
            mv.popMatrix();

            

            dots.get(i).moveDots();

            
            
            
            
            if(dots.get(i).location.x > mv.random(mv.width * 0.3f, mv.width * 0.32f)) {
                dots.remove(i);
                i--;
            }   
        }


    }
}


