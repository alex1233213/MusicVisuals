package c18342126;


import processing.core.*;




public class AudioCircles {
    My_Visual mv;
    

    
    //constructor
    public AudioCircles(My_Visual mv) {
        this.mv = mv; 
    }



    


    public void createAudioCircle(float radius) {
        float x, y;
        

        //create lines for each audio value in the buffer
        for(int i = 0; i < mv.getAudioBuffer().size(); ++i) {
            
            mv.stroke(PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 255), 255, 255);

            //rotate lines around the centre
            float angle = PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, PApplet.TWO_PI);


            //distance from the radius
            float offset = PApplet.map(mv.getAudioBuffer().get(i),
                                 -0.5f, 0.5f, -radius * 0.05f, radius * 0.05f);
            
            //x and y coordinates from which lines will be drawn
            x = ((radius - radius *0.1f) + offset) * PApplet.cos(angle);
            y = ((radius - radius *0.1f) + offset) *  PApplet.sin(angle);

            mv.line(x, y, x + offset, y + offset);
        }
    }




    

    public void render() {
        mv.noFill();
        mv.strokeWeight(3f);
        mv.noFill();

        
        //create audio circles for audio bands
        mv.pushMatrix();
        mv.translate(mv.width / 2, mv.height / 2);
        for(int i= 0 ; i < mv.getBands().length; ++i) {
            createAudioCircle(mv.getSmoothedBands()[i] * 10);
        }
        mv.popMatrix();
    }
}