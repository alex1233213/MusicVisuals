package c18342126;

import processing.core.*;

public class Dots {
    My_Visual mv;
    float diam;
    PVector location;
    PVector velocity;


    

    public Dots(My_Visual mv) {
        this.mv = mv; 
        this.diam = mv.random(20, 30);
        velocity = new PVector(2, 0);
        location = new PVector(mv.random(mv.width), mv.random(mv.height));
    }

    public void moveDots() {
        location.add(velocity);


        //check 
        if(location.x > mv.random(mv.width * 0.8f, mv.width * 0.9f)) {
            

            if(this.diam == 0) {
                this.diam = 0;
            } else { 
                this.diam -= 5;
            }
        }
    }
        
    

    public void render() {
        mv.noStroke();
        mv.fill(255, 200);
        mv.ellipse(location.x, location.y, diam, diam);
    }
}


