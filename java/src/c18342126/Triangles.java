package c18342126;


import processing.core.*;

public class Triangles {
    My_Visual mv;
    float distance;

    public Triangles(My_Visual mv) {
        this.mv = mv;
        
    }

    


    public void create_triangles(float distance) {

    }





    public void render() {
        float angle = PApplet.PI / 20;
        // float dist = 200;
        mv.fill(0);
        // mv.stroke(255);
       
        float increment = 0.3f;
        float shadeRatio = 255 / 100;

        for(int i = 0; i < mv.getBands().length; ++i) {
            mv.stroke(PApplet.map(i, 0, mv.getAudioBuffer().get(i) * 500, 0, 255), 255, 255);
            System.out.println(mv.getSmoothedAmplitude());
            // float dist = mv.getAudioBuffer().get(i) * mv.getAmplitude() * 1000;
            
            // float c = PApplet.map(i,0, mv.getAmplitude() * 1000, 0, 255);
            // mv.stroke(shadeRatio);
            // mv.fill(c, 255 , 255);
            System.out.println(mv.getAudioBuffer().get(i));
            float xOffset = mv.getAmplitude();
            float dist = mv.noise(xOffset) * mv.width / 2;

            mv.pushMatrix();
            mv.beginShape();
            mv.translate(mv.width / 2, mv.height / 2);
            mv.vertex(0, 0);
            mv.vertex(dist * PApplet.sin(angle), dist * PApplet.cos(angle) );
            mv.vertex(dist * PApplet.sin(-angle) / 4 , dist * PApplet.cos(-angle) / 4);
            // mv.vertex(dist * PApplet.sin(-angle) * 2 , dist * PApplet.cos(-angle) * 2);
            mv.rotate(angle * i * mv.getSmoothedAmplitude() * 100);
            mv.endShape();
            mv.popMatrix();
            
            xOffset += increment;
        }
    }
}