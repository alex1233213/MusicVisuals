package c18342126;

import processing.core.PApplet;
import processing.core.PVector;

public class Cubes {
    My_Visual mv;
    PVector locations[];
    float angle = 0.1f;
    int no_cubes = 30;
    

    //Constructor initialises locations of cubes
    public Cubes(My_Visual mv) {
        this.mv = mv;
        locations = new PVector[no_cubes];
        
        //initialise the locations of cubes
        for(int i = 0; i < no_cubes; ++i) {
            float angle = PApplet.map(i, 0, no_cubes, 0, PApplet.TWO_PI);
            float gap = PApplet.map(i , 0, no_cubes , 400, mv.height / 2);
            float x = PApplet.cos(angle) * gap;
            float y = PApplet.sin(angle) * gap;
            
            locations[i] = new PVector(x, y, 120);
        }
    }


    
    public void render() {
        mv.lights();
        mv.stroke(0);

        //create cubes at location vectors and rotate them
        for(int i = 0 ; i < no_cubes; ++i) {
            mv.fill(PApplet.map(i, 0, no_cubes, 0, 255), 255, 255);
            float length = PApplet.map(i, 0, no_cubes, 30, mv.getAmplitude() * 100);
            mv.pushMatrix();
            mv.translate(mv.width / 2 + this.locations[i].x, 
                            mv.height / 2 + this.locations[i].y,
                            this.locations[i].z);

            mv.rotateY(angle);
            mv.rotateZ(angle); 
            mv.rotateX(angle);
            mv.box(length);
            angle += 0.001;

            //rotate cubes around the center based on amplitude
            this.locations[i].rotate(PApplet.radians(-mv.getAmplitude() * 5));
            mv.popMatrix();
        }
        


        
    }
}