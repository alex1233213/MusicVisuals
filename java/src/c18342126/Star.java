package c18342126;

import processing.core.*;


public class Star {
    My_Visual mv;
    float inner_radius;
    float outer_radius;
    // int no_points;

    
    //constructor
    public Star(My_Visual mv) {
        this.mv = mv;
        this.outer_radius = mv.height / 10f;
        this.inner_radius = this.outer_radius / 20f;
        // this.no_points = 5;
    }

    
    //process of  creating the star
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

                if(j % 2 == 0) {
                    temp_rad = outer_rad;
                }


                x = PApplet.cos(theta) * temp_rad;
                y =  PApplet.sin(theta) * temp_rad;
                mv.vertex(x, y);
                theta += thetaRot;
            }
        }

        mv.endShape(PApplet.CLOSE);
    }






    public void render() {
        // mv.colorMode(PApplet.HSB);

        
        float rotation = (PApplet.PI / 180);
        float shadeRatio = 255 / 100;
        int stars = 10;
        float rotations = 5;
        float inner_ratio = this.inner_radius / rotations;
        float outer_ratio = this.outer_radius / rotations;
        float rotation_ratio = 70 / rotations;

        
        for(int i = 0; i < stars; i++) {
            float c = PApplet.map(i,0, mv.getAmplitude() * 100, 0, 255);
            mv.stroke(shadeRatio);
            // mv.fill(PApplet.map(i,0, mv.getAudioBuffer().get(i) * 10, 0, 255), 255, 255);
            mv.fill(c, 255 , 255);
            
            mv.pushMatrix();
            mv.translate(mv.width/2, mv.height/2);
            mv.rotate(rotation_ratio * i * rotation);
            // mv.rotateZ(PApplet.PI/8);
            this.star(5, this.outer_radius * mv.getSmoothedAmplitude() * 20 - outer_ratio * i, 
                      this.inner_radius * mv.getAmplitude() * 10 - inner_ratio * i);
            
            // this.outer_radius += mv.getAmplitude() / 2;
            // this.inner_radius += mv.getAmplitude() / 6;
            

            mv.popMatrix();
        }

        
    }
}