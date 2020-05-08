package c18342126;

import processing.core.*;


public class Star {
    My_Visual mv;
    float inner_radius;
    float outer_radius;

    
    //constructor
    public Star(My_Visual mv) {
        this.mv = mv;

        //default values
        this.outer_radius = mv.height / 10f;
        this.inner_radius = this.outer_radius / 20f;
    }

    
    //method creating a star
    public void star(int points, float inner_rad, float outer_rad) {
        float theta = 0f;
        int no_vertexes = points * 2;
        float thetaRot = PApplet.TWO_PI / no_vertexes;
        float temp_rad = 0;
        float x , y = 0f;

        mv.beginShape();
        for(int i = 0; i < points; ++i) {
            for(int j = 0; j < 2; ++j) {
                temp_rad = inner_rad;

                //first iteration will be outer radius
                if(j % 2 == 0) {
                    temp_rad = outer_rad;
                }


                //store the vertex coordinates
                x = PApplet.cos(theta) * temp_rad;
                y =  PApplet.sin(theta) * temp_rad;
                mv.vertex(x, y);

                //rotate around the center for new vertex
                theta += thetaRot;
            }
        }

        mv.endShape(PApplet.CLOSE);
    }






    public void render() {
        //angle of rotation
        float rotation = (PApplet.PI / PApplet.radians(20));
        int stars = 10;
        float rotations = 20;
        float rotation_ratio = 10 / rotations;
        mv.stroke(0);
        mv.strokeWeight(2.5f);
        

        //create stars in the center
        for(int i = 0; i < stars; i++) {
            float c = PApplet.map(i,0, stars, 0, 255);
            mv.fill(c, 255 , 255);
            
            mv.pushMatrix();
            mv.translate(mv.width/2, mv.height/2);
            mv.rotate(rotation_ratio  * rotation * i);
            this.star(i, this.outer_radius * mv.getSmoothedAmplitude()* 2 * i, 
                      this.inner_radius * mv.getAmplitude() * 2 * i);
            mv.popMatrix();
        }

        
    }
}