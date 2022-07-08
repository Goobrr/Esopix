package esopix;

import arc.*;
import arc.backend.sdl.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.graphics.g2d.TextureAtlas.*;
import arc.scene.*;
import arc.util.*;

import static arc.Core.*;

public class Launcher extends ApplicationCore{
    public static Renderer renderer;
    public static UI ui;

    public static void main(String[] args){
        try{
            new SdlApplication(new Launcher(), new SdlConfig(){{
                title = "Esopix";
                maximized = true;
                width = 900;
                height = 700;

                vSyncEnabled = true;
            }});
        }catch(Exception e){
            Log.err(e);
        }
    }

    @Override
    public void setup(){
        atlas = new TextureAtlas("assets/sprites/sprites.aatls");
        camera = new Camera();
        batch = new SortedSpriteBatch();
        scene = new Scene();

        camera.resize(Core.graphics.getWidth(), Core.graphics.getHeight());
        camera.position.set(Core.graphics.getWidth() / 2f, Core.graphics.getHeight() / 2f);

        int[] insets = graphics.getSafeInsets();
        scene.marginLeft = insets[0];
        scene.marginRight = insets[1];
        scene.marginTop = insets[2];
        scene.marginBottom = insets[3];

        add(renderer = new Renderer());
        add(ui = new UI());
    }

    @Override
    public void resize(int width, int height){
        camera.resize(width, height);
        camera.position.set(width, height);

        super.resize(width, height);
    }

    @Override
    public void update(){
        Time.update();

        super.update();
    }

    @Override
    public void dispose(){
        batch.dispose();
        atlas.dispose();

        super.dispose();
    }
}
