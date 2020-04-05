package c18342126;


import processing.core.*;

public class Triangles {
    My_Visual mv;


    public Triangles(My_Visual mv) {
        this.mv = mv;
    }

    



    public void render() {
        mv.colorMode(mv.HSB);
        mv.strokeWeight(4f);
        mv.background(0);
        
        

        for(int i = 0; i < mv.getAudioBuffer().size(); ++i) {
            float rotation = PApplet.TWO_PI / 90 * i;
            float length = mv.getAudioBuffer().get(i) * 1400;
            // float x2 = length * PApplet.cos(rotation);
            // float y2 = length * PApplet.sin(rotation);
            // for(int j = 0; j < mv.width; j+= mv.getAudioBuffer().get(i) * 200) {
                
            // }
            mv.pushMatrix();
            mv.translate(mv.width * 0.5f, mv.height * 0.5f);

            mv.rotate(rotation);
            mv.stroke(i, 255, 255);
            mv.line(0, 0, length * PApplet.cos(rotation),length * PApplet.sin(rotation));
            
            mv.popMatrix();
            // System.out.println(mv.getAudioBuffer().get(i));
        }
        
    }
}