//package com.tompkins_development.game;
//
//import com.tompkins_development.engine.Engine;
//import com.tompkins_development.engine.IAppLogic;
//import com.tompkins_development.engine.MouseInput;
//import com.tompkins_development.engine.entity.*;
//import com.tompkins_development.engine.rendering.Render;
//import com.tompkins_development.engine.entity.Entity;
//import com.tompkins_development.engine.scene.ModelLoader;
//import com.tompkins_development.engine.scene.Scene;
//import org.joml.Vector2f;
//
//import java.lang.Math;
//import java.util.*;
//
//import static org.lwjgl.glfw.GLFW.*;
//
//public class MainOLD implements IAppLogic {
//
//    private static final float MOUSE_SENSITIVITY = 0.1f;
//    private static final float MOVEMENT_SPEED = 0.005f;
//    private List<Entity> entityList;
//    private float rotation;
//
//    public static void main(String[] args) {
//        Main main = new Main();
//        Engine gameEng = new Engine("chapter-09", new Window.WindowOptions(), main);
//        gameEng.start();
//    }
//
//    @Override
//    public void cleanup() {
//        // Nothing to be done yet
//    }
//
//    @Override
//    public void init(Window window, Scene scene, Render render) {
//        entityList = new ArrayList<>();
//        Model cubeModel = ModelLoader.loadModel("cube-model", "F:\\Engines\\3DEngineTest\\src\\main\\resources\\models\\cube\\cube.obj", scene.getTextureCache());
//        scene.addModel(cubeModel);
//
//        int size = 10;
//
//        for(int b = 0; b < size; b++) {
//            for (int i = 0; i < size; i++) {
//                for (int j = 0; j < size; j++) {
//                    Entity cubeEntity = new Entity("cube-entity-" + i + "-" + j, cubeModel.getId());
//                    cubeEntity.setPosition(i, 1, b);
//                    entityList.add(cubeEntity);
//                }
//            }
//        }
//
//        for(Entity cubeEntity : entityList)
//            scene.addEntity(cubeEntity);
//
//    }
//
//    @Override
//    public void input(Window window, Scene scene, long diffTimeMillis) {
//        float move = diffTimeMillis * MOVEMENT_SPEED;
//        Camera camera = scene.getCamera();
//        if (window.isKeyPressed(GLFW_KEY_W)) {
//            camera.moveForward(move);
//        } else if (window.isKeyPressed(GLFW_KEY_S)) {
//            camera.moveBackwards(move);
//        }
//        if (window.isKeyPressed(GLFW_KEY_A)) {
//            camera.moveLeft(move);
//        } else if (window.isKeyPressed(GLFW_KEY_D)) {
//            camera.moveRight(move);
//        }
//        if (window.isKeyPressed(GLFW_KEY_SPACE)) {
//            camera.moveUp(move);
//        } else if (window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
//            camera.moveDown(move);
//        }
//
//        MouseInput mouseInput = window.getMouseInput();
//        if (mouseInput.isRightButtonPressed()) {
//            Vector2f displVec = mouseInput.getDisplVec();
//            camera.addRotation((float) Math.toRadians(-displVec.x * MOUSE_SENSITIVITY),
//                    (float) Math.toRadians(-displVec.y * MOUSE_SENSITIVITY));
//        }
//    }
//
//    @Override
//    public void update(Window window, Scene scene, long diffTimeMillis) {
//        rotation += 1.5;
//        if (rotation > 360) {
//            rotation = 0;
//        }
//        for(Entity cubeEntity : entityList)
//            cubeEntity.updateModelMatrix();
//    }
//}