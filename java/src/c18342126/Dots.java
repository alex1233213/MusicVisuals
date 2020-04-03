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
        location = new PVector(mv.random(mv.width), mv.random(mv.height));
        dots = new ArrayList <Dots> ();
    }



    public void moveDots() {
        location.add(velocity);
    }



        
    

    public void render() {
        mv.noStroke();
        mv.fill(255, 200);

        for(int i = 0; i < mv.getBands().length; i++) {
            
            Dots dot = new Dots(mv);
            dots.add(dot);
            System.out.println(mv.getBands()[i]); 
            


            mv.circle(dots.get(i).location.x, dots.get(i).location.y, mv.getBands()[i] * 0.1f);
            dots.get(i).moveDots();

            
            
            
            
            if(dots.get(i).location.x > mv.random(mv.width * 0.75f, mv.width * 0.9f)) {
                dots.remove(i);
                i--;
            }
        }
    }
}


