package com.vibecoded.game;

import com.vibecoded.game.entity.Entity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Basic tests for the game
 */
public class GameTest {
    
    private Entity testEntity;
    
    @BeforeEach
    void setUp() {
        testEntity = new Entity();
    }
    
    @Test
    void testEntityCreation() {
        assertNotNull(testEntity);
        assertTrue(testEntity.isActive());
        assertEquals(0.0f, testEntity.getX());
        assertEquals(0.0f, testEntity.getY());
    }
    
    @Test
    void testEntityPosition() {
        testEntity.setPosition(10.0f, 20.0f);
        assertEquals(10.0f, testEntity.getX());
        assertEquals(20.0f, testEntity.getY());
    }
    
    @Test
    void testEntityScale() {
        testEntity.setScale(2.0f, 3.0f);
        assertEquals(2.0f, testEntity.getScaleX());
        assertEquals(3.0f, testEntity.getScaleY());
    }
    
    @Test
    void testEntityRotation() {
        testEntity.setRotation(45.0f);
        assertEquals(45.0f, testEntity.getRotation());
    }
    
    @Test
    void testEntityActiveState() {
        testEntity.setActive(false);
        assertFalse(testEntity.isActive());
        
        testEntity.setActive(true);
        assertTrue(testEntity.isActive());
    }
}
