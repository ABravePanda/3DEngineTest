package com.tompkins_development.engine;

import com.tompkins_development.engine.rendering.Render;
import com.tompkins_development.engine.scene.Scene;
import com.tompkins_development.engine.entity.Window;

public interface IAppLogic {

    void cleanup();

    void init(Window window, Scene scene, Render render);

    void input(Window window, Scene scene, long diffTimeMillis, boolean inputConsumed);

    void update(Window window, Scene scene, long diffTimeMillis);
}