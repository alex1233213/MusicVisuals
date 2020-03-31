package c18342126;

import processing.core.*;

public class Dots {
    My_Visual mv;
    float radius = 5f;
    PVector location;
    PVector velocity;

    

    public Dots(My_Visual mv) {
        this.mv = mv; 
        location = new PVector( radius, mv.height / 2);
        velocity = new PVector(2, -2);
    }

    public void moveDots() {
        location.add(velocity);
    }
        
    

    public void render() {
        mv.noStroke();
        mv.fill(245);
        
        mv.ellipse(location.x, location.y, radius * 2, radius * 2);
        
    }
}


