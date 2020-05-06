package c18342126;

import processing.core.PApplet;

public class Spheres {
    My_Visual mv;
    

    public Spheres(My_Visual mv) {
        this.mv = mv;
    }



    public void render() {
        mv.strokeWeight(1f);
        mv.stroke(0);
        
        //for each audio band a sphere will get drawn in centre of screen
        for(int i=0; i < mv.getBands().length ; ++i ) {
            mv.fill(PApplet.map(i, 0, mv.getAmplitude() * 100, 0, 255), 255, 255);
            mv.pushMatrix();
            mv.translate(mv.width / 2, mv.height / 2);
            mv.sphere(mv.getAmplitude()  * 170);
            mv.popMatrix();   
        }
    }
}