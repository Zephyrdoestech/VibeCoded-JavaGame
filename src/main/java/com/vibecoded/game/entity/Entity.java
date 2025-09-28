package com.vibecoded.game.entity;

/**
 * Basic entity class representing game objects
 */
public class Entity {
    private float x, y;           // Position
    private float scaleX, scaleY; // Scale
    private float rotation;       // Rotation in degrees
    private boolean active;       // Whether entity is active
    
    public Entity() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.rotation = 0.0f;
        this.active = true;
    }
    
    /**
     * Update the entity
     */
    public void update(long deltaTime) {
        if (!active) {
            return;
        }
        
        // Basic entity update logic
        // This can be overridden by subclasses
    }
    
    /**
     * Set position
     */
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Get X position
     */
    public float getX() {
        return x;
    }
    
    /**
     * Get Y position
     */
    public float getY() {
        return y;
    }
    
    /**
     * Set scale
     */
    public void setScale(float scaleX, float scaleY) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }
    
    /**
     * Get scale X
     */
    public float getScaleX() {
        return scaleX;
    }
    
    /**
     * Get scale Y
     */
    public float getScaleY() {
        return scaleY;
    }
    
    /**
     * Set rotation
     */
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
    
    /**
     * Get rotation
     */
    public float getRotation() {
        return rotation;
    }
    
    /**
     * Set active state
     */
    public void setActive(boolean active) {
        this.active = active;
    }
    
    /**
     * Check if entity is active
     */
    public boolean isActive() {
        return active;
    }
}
