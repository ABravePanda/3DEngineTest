package com.tompkins_development.game;

import com.tompkins_development.engine.*;
import com.tompkins_development.engine.entity.*;
import com.tompkins_development.engine.lighting.PointLight;
import com.tompkins_development.engine.lighting.SpotLight;
import com.tompkins_development.engine.rendering.*;
import com.tompkins_development.engine.scene.*;
import imgui.*;
import imgui.flag.ImGuiCond;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.tinylog.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;

public class Main implements IAppLogic {

    private static final float MOUSE_SENSITIVITY = 0.1f;
    private static final float MOVEMENT_SPEED = 0.005f;
    private static final int NUM_CHUNKS = 4;

    private float rotation;

    private Entity[][] terrainEntities;


    public static void main(String[] args) {
        Main main = new Main();
        Window.WindowOptions options = new Window.WindowOptions();
        options.fps = 3000;
        Engine gameEng = new Engine("chapter-10", options, main);
        gameEng.start();
    }

    @Override
    public void cleanup() {
        // Nothing to be done yet
    }


    @Override
    public void init(Window window, Scene scene, Render render) {
//        String quadModelId = "quad-model";
//        Model quadModel = ModelLoader.loadModel("quad-model", "F:\\Engines\\3DEngineTest\\src\\main\\resources\\models\\quad\\quad.obj",
//                scene.getTextureCache());
//        scene.addModel(quadModel);

        Model block = ModelLoader.loadModel("block", "F:\\Engines\\3DEngineTest\\src\\main\\resources\\models\\cube\\cube.obj", scene.getTextureCache());
        scene.addModel(block);
        Entity entity = new Entity("block-entity", block.getId());
        scene.addEntity(entity);

        SceneLights sceneLights = new SceneLights();
        sceneLights.getAmbientLight().setIntensity(0.2f);
        scene.setSceneLights(sceneLights);

        LightControls lightControls = new LightControls(scene);
        scene.setGuiInstance(lightControls);

//        SkyBox skyBox = new SkyBox("F:\\Engines\\3DEngineTest\\src\\main\\resources\\models\\skybox\\skybox.obj", scene.getTextureCache());
//        skyBox.getSkyBoxEntity().setScale(50);
//        scene.setSkyBox(skyBox);

        scene.getCamera().moveUp(0.1f);
    }

    @Override
    public void input(Window window, Scene scene, long diffTimeMillis, boolean inputConsumed) {
        if (inputConsumed) {
            return;
        }
        float move = diffTimeMillis * MOVEMENT_SPEED;
        Camera camera = scene.getCamera();
        if (window.isKeyPressed(GLFW_KEY_W)) {
            camera.moveForward(move);
        } else if (window.isKeyPressed(GLFW_KEY_S)) {
            camera.moveBackwards(move);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            camera.moveLeft(move);
        } else if (window.isKeyPressed(GLFW_KEY_D)) {
            camera.moveRight(move);
        }
        if (window.isKeyPressed(GLFW_KEY_SPACE)) {
            camera.moveUp(move);
        } else if (window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
            camera.moveDown(move);
        }

        MouseInput mouseInput = window.getMouseInput();
        if (mouseInput.isRightButtonPressed()) {
            Vector2f displVec = mouseInput.getDisplVec();
            camera.addRotation((float) Math.toRadians(-displVec.x * MOUSE_SENSITIVITY),
                    (float) Math.toRadians(-displVec.y * MOUSE_SENSITIVITY));
        }

    }

    @Override
    public void update(Window window, Scene scene, long diffTimeMillis) {
        //
    }

}
