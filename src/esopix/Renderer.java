package esopix;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;

public class Renderer implements ApplicationListener{
    @Override
    public void update(){
        Core.camera.update();

        Draw.proj(Core.camera);

        Draw.color(Color.black);
        Draw.rect();
        draw();
    }

    public void draw(){

    }
}
