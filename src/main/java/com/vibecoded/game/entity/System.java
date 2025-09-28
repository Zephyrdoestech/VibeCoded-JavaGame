package com.vibecoded.game.entity;

import java.util.List;

/**
 * Base class for entity systems in an ECS (Entity Component System) architecture
 */
public abstract class System {
    /**
     * Update the system with all entities
     */
    public abstract void update(List<Entity> entities, long deltaTime);
    
    /**
     * Check if an entity matches this system's requirements
     */
    public abstract boolean matches(Entity entity);
}
