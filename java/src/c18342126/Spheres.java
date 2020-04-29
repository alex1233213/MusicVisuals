package c18342126;

import processing.core.PApplet;

public class Spheres {
    My_Visual mv;
    float[] radii;

    public Spheres(My_Visual mv) {
        this.mv = mv;
        radii = new float[20];
    }



    public void render() {
        for(int i=0; i < mv.getBands().length ; ++i ) {
            mv.fill(PApplet.map(i, 0, mv.getBands().length, 0, 255), 255, 255);
            mv.pushMatrix();
            mv.translate(mv.width / 2, mv.height / 2);
            this.radii[i] = mv.getAmplitude()  * 150;
            mv.sphere(this.radii[i]);
            mv.popMatrix();   
        }
    }
}