package com.tompkins_development.engine.scene;

import com.tompkins_development.engine.IGuiInstance;
import com.tompkins_development.engine.entity.Camera;
import com.tompkins_development.engine.entity.Entity;
import com.tompkins_development.engine.entity.Model;
import com.tompkins_development.engine.entity.SkyBox;
import com.tompkins_development.engine.rendering.TextureCache;

import java.util.*;

public class Scene {

    private Camera camera;
    private IGuiInstance guiInstance;
    private Map<String, Model> modelMap;
    private Projection projection;
    private TextureCache textureCache;
    private SceneLights sceneLights;
    private SkyBox skyBox;

    public Scene(int width, int height) {
        modelMap = new HashMap<>();
        projection = new Projection(width, height);
        textureCache = new TextureCache();
        camera = new Camera();
    }

    public void addEntity(Entity entity) {
        String modelId = entity.getModelId();
        Model model = modelMap.get(modelId);
        if (model == null) {
            throw new RuntimeException("Could not find model [" + modelId + "]");
        }
        model.getEntitiesList().add(entity);
    }

    public void addModel(Model model) {
        modelMap.put(model.getId(), model);
    }

    public void cleanup() {
        modelMap.values().stream().forEach(Model::cleanup);
    }

    public Camera getCamera() {
        return camera;
    }

    public IGuiInstance getGuiInstance() {
        return guiInstance;
    }

    public Map<String, Model> getModelMap() {
        return modelMap;
    }

    public Projection getProjection() {
        return projection;
    }

    public TextureCache getTextureCache() {
        return textureCache;
    }

    public void resize(int width, int height) {
        projection.updateProjMatrix(width, height);
    }

    public void setGuiInstance(IGuiInstance guiInstance) {
        this.guiInstance = guiInstance;
    }

    public SceneLights getSceneLights() {
        return sceneLights;
    }

    public void setSceneLights(SceneLights sceneLights) {
        this.sceneLights = sceneLights;
    }

    public SkyBox getSkyBox() {
        return skyBox;
    }

    public void setSkyBox(SkyBox skyBox) {
        this.skyBox = skyBox;
    }
}