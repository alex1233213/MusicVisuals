package c18342126;


import processing.core.*;

public class Triangles {
    My_Visual mv;


    public Triangles(My_Visual mv) {
        this.mv = mv;

    }

    



    public void render() {
        float angle = PApplet.PI / 20;
        // float dist = 200;
        mv.fill(0);
        // mv.stroke(255);


        for(int i = 0; i < mv.getAudioBuffer().size(); ++i) {
            mv.stroke(PApplet.map(i, 0, mv.getAudioBuffer().get(i) * 500, 0, 255), 255, 255);
            System.out.println(mv.getSmoothedAmplitude());
            float dist = mv.getAudioBuffer().get(i) * mv.getAmplitude() * 1000;

            mv.pushMatrix();
            mv.beginShape();
            mv.translate(mv.width / 2, mv.height / 2);
            mv.vertex(0, 0);
            mv.vertex(dist * PApplet.sin(angle), dist * PApplet.cos(angle));
            mv.vertex(dist * PApplet.sin(-angle), dist * PApplet.cos(-angle));
            mv.rotate(angle * i * mv.getSmoothedAmplitude() * 100);
            mv.endShape(mv.CLOSE);
            mv.popMatrix();
            
        }
    }
}