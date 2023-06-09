package com.tompkins_development.engine.entity;

import org.joml.Vector4f;

import java.util.*;

public class Material {

    public static final Vector4f DEFAULT_COLOR = new Vector4f(0.0f, 0.0f, 0.0f, 1.0f);

    private Vector4f diffuseColor;
    private List<Mesh> meshList;
    private String texturePath;

    private Vector4f ambientColor;
    private float reflectance;
    private Vector4f specularColor;

    public Material() {
        diffuseColor = DEFAULT_COLOR;
        ambientColor = DEFAULT_COLOR;
        meshList = new ArrayList<>();
    }

    public void cleanup() {
        meshList.stream().forEach(Mesh::cleanup);
    }

    public Vector4f getDiffuseColor() {
        return diffuseColor;
    }

    public List<Mesh> getMeshList() {
        return meshList;
    }

    public String getTexturePath() {
        return texturePath;
    }

    public void setDiffuseColor(Vector4f diffuseColor) {
        this.diffuseColor = diffuseColor;
    }

    public void setTexturePath(String texturePath) {
        this.texturePath = texturePath;
    }

    public Vector4f getAmbientColor() {
        return ambientColor;
    }

    public void setAmbientColor(Vector4f ambientColor) {
        this.ambientColor = ambientColor;
    }

    public float getReflectance() {
        return reflectance;
    }

    public void setReflectance(float reflectance) {
        this.reflectance = reflectance;
    }

    public Vector4f getSpecularColor() {
        return specularColor;
    }

    public void setSpecularColor(Vector4f specularColor) {
        this.specularColor = specularColor;
    }
}