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
        this.diam = 5;
        velocity = new PVector(2, 0);
        location = new PVector(mv.random(mv.width), mv.random(mv.height));
        dots = new ArrayList <Dots> ();
    }

    public void moveDots() {
        location.add(velocity);
    }



        
    

    public void render() {
        // mv.colorMode(mv.HSB);
        
        
        Dots dot = new Dots(mv);
        dots.add(dot);
        


        for(int i = 0; i < dots.size(); i++) {
            mv.noStroke();

            if(dots.size() > 20) {
                for(int j = 0; j < dots.size(); j++) {
                    dots.remove(j);
                }
            }
            
            mv.ellipse(dots.get(i).location.x, dots.get(i).location.y, diam, diam);
            dots.get(i).moveDots();

            
            if(dots.get(i).location.x > mv.random((mv.width * 0.9f), mv.width)) {
                
                dots.remove(i);
            }
            
        }
    }
}


