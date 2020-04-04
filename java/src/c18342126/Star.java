package c18342126;

import processing.core.*;

public class Star {
    My_Visual mv;
    float inner_radius;
    float outer_radius;
    int no_points;

    
    //constructor
    public Star(My_Visual mv) {
        this.mv = mv;
        this.outer_radius = mv.height / 2;
        this.inner_radius = this.outer_radius * 0.5f;
        this.no_points = 5;
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
        mv.background(0);
        mv.fill(255);
        // mv.stroke(0);

        mv.translate(mv.width/2, mv.height/2);
        
        
        

        this.star(this.no_points, this.inner_radius, this.outer_radius);

        
    }
}