package com.tompkins_development.engine;

import com.tompkins_development.engine.entity.Window;
import com.tompkins_development.engine.scene.Scene;

public interface IGuiInstance {

    void drawGui();

    boolean handleGuiInput(Scene scene, Window window);
}