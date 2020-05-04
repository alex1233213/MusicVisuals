package c18342126;


import processing.core.*;

public class Triangles {
    My_Visual mv;
    float angle;

    public Triangles(My_Visual mv) {
        this.mv = mv;
        angle = 0;
    }

    
    public void createTriangle(float dist) {
        int points = 3;
        float theta = 0;
        float thetaRot = PApplet.TWO_PI/ points;
        float x, y;  
        
        mv.beginShape();
        
        for(int i = 0; i < points; ++i) {
            x = PApplet.cos(theta) * dist;
            y = PApplet.sin(theta) * dist;
            

            mv.vertex(x, y);
            theta += thetaRot;
        }
        mv.endShape(PApplet.CLOSE);
        
    }


    
    public void render() {
        mv.noFill();
        
        mv.strokeWeight(3.5f);

        

        

        mv.pushMatrix();
        mv.translate(mv.width / 2, mv.height /2);
        
        for(int i = 0 ; i < mv.getBands().length ; ++i) {
            mv.stroke(PApplet.map(i, 0, mv.getBands().length, 0 , 255),255, 255);
            mv.rotate(PApplet.radians(angle));
            createTriangle(mv.getSmoothedBands()[i]);
            angle += 0.05;
        }
        mv.popMatrix();
        
    }
}