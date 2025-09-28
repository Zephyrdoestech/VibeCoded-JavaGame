package com.vibecoded.game.engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the current state of the game including entities and game logic
 */
public class GameState {
    private List<Entity> entities;
    private boolean initialized = false;
    
    public GameState() {
        this.entities = new ArrayList<>();
    }
    
    /**
     * Initialize the game state
     */
    public void init() {
        if (initialized) {
            return;
        }
        
        // Create some test entities
        createTestEntities();
        
        initialized = true;
        System.out.println("Game state initialized with " + entities.size() + " entities");
    }
    
    /**
     * Create some test entities for demonstration
     */
    private void createTestEntities() {
        // Create a few test entities
        for (int i = 0; i < 3; i++) {
            Entity entity = new Entity();
            entity.setPosition(i * 2.0f - 2.0f, 0.0f);
            entity.setScale(0.5f, 0.5f);
            entities.add(entity);
        }
    }
    
    /**
     * Update game state
     */
    public void update(long deltaTime) {
        if (!initialized) {
            return;
        }
        
        // Update all entities
        for (Entity entity : entities) {
            entity.update(deltaTime);
        }
        
        // Add any additional game logic here
    }
    
    /**
     * Add an entity to the game state
     */
    public void addEntity(Entity entity) {
        entities.add(entity);
    }
    
    /**
     * Remove an entity from the game state
     */
    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }
    
    /**
     * Get all entities
     */
    public List<Entity> getEntities() {
        return entities;
    }
    
    /**
     * Cleanup game state
     */
    public void cleanup() {
        entities.clear();
        initialized = false;
        System.out.println("Game state cleaned up");
    }
}
