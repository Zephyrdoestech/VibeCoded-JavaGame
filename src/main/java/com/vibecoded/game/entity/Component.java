package com.vibecoded.game.entity;

/**
 * Base class for entity components in an ECS (Entity Component System) architecture
 */
public abstract class Component {
    protected Entity entity;
    
    /**
     * Set the entity this component belongs to
     */
    public void setEntity(Entity entity) {
        this.entity = entity;
    }
    
    /**
     * Get the entity this component belongs to
     */
    public Entity getEntity() {
        return entity;
    }
    
    /**
     * Initialize the component
     */
    public abstract void init();
    
    /**
     * Update the component
     */
    public abstract void update(long deltaTime);
    
    /**
     * Cleanup the component
     */
    public abstract void cleanup();
}
