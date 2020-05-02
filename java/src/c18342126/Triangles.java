package c18342126;


import processing.core.*;

public class Triangles {
    My_Visual mv;
    

    public Triangles(My_Visual mv) {
        this.mv = mv;
        
    }

    



    public void render() {
        
        mv.pushMatrix();
        // mv.translate(mv.width / 2, mv.height / 2);
        
        mv.beginShape();
        for(int i = 0; i < mv.getBands().length ; ++i) {
            mv.vertex(mv.width / 2, mv.height * 0.1f);
            mv.vertex(mv.width / 3, mv.height * 0.9f);
            mv.vertex(mv.width * 0.9f, mv.height * 0.9f);
        }
        mv.endShape();

        mv.popMatrix();
    }
}