package esopix;

import arc.*;

import static arc.Core.*;

public class UI implements ApplicationListener{

    @Override
    public void init(){

    }

    @Override
    public void update(){
        scene.act();
        scene.draw();
    }
}
