package com.vibecoded.game.engine;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.system.MemoryUtil.memAllocFloat;
import static org.lwjgl.system.MemoryUtil.memFree;

/**
 * Basic renderer for drawing simple shapes and sprites
 */
public class Renderer {
    private int vao;
    private int vbo;
    private int ebo;
    
    // Simple quad vertices for rendering
    private final float[] quadVertices = {
        // positions     // colors
        -0.5f,  0.5f,   1.0f, 0.0f, 0.0f, 1.0f,  // top left
         0.5f,  0.5f,   0.0f, 1.0f, 0.0f, 1.0f,  // top right
         0.5f, -0.5f,   0.0f, 0.0f, 1.0f, 1.0f,  // bottom right
        -0.5f, -0.5f,   1.0f, 1.0f, 0.0f, 1.0f   // bottom left
    };
    
    private final int[] quadIndices = {
        0, 1, 2,  // first triangle
        2, 3, 0   // second triangle
    };
    
    /**
     * Initialize the renderer
     */
    public void init() {
        setupQuad();
        System.out.println("Renderer initialized");
    }
    
    /**
     * Set up a simple quad for rendering
     */
    private void setupQuad() {
        // Generate and bind VAO
        vao = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(vao);
        
        // Generate and bind VBO
        vbo = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
        
        // Upload vertex data
        FloatBuffer vertexBuffer = memAllocFloat(quadVertices.length);
        vertexBuffer.put(quadVertices).flip();
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertexBuffer, GL15.GL_STATIC_DRAW);
        memFree(vertexBuffer);
        
        // Generate and bind EBO
        ebo = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, ebo);
        
        // Upload index data
        IntBuffer indexBuffer = memAllocFloat(quadIndices.length);
        indexBuffer.put(quadIndices).flip();
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indexBuffer, GL15.GL_STATIC_DRAW);
        memFree(indexBuffer);
        
        // Set vertex attributes
        // Position attribute
        GL20.glVertexAttribPointer(0, 2, GL11.GL_FLOAT, false, 6 * Float.BYTES, 0);
        GL20.glEnableVertexAttribArray(0);
        
        // Color attribute
        GL20.glVertexAttribPointer(1, 4, GL11.GL_FLOAT, false, 6 * Float.BYTES, 2 * Float.BYTES);
        GL20.glEnableVertexAttribArray(1);
        
        // Unbind VAO
        GL30.glBindVertexArray(0);
    }
    
    /**
     * Render the game state
     */
    public void render(GameState gameState) {
        // Set clear color (dark blue)
        GL11.glClearColor(0.1f, 0.1f, 0.3f, 1.0f);
        
        // Render all entities in the game state
        for (Entity entity : gameState.getEntities()) {
            renderEntity(entity);
        }
    }
    
    /**
     * Render a single entity
     */
    private void renderEntity(Entity entity) {
        // Bind VAO
        GL30.glBindVertexArray(vao);
        
        // Draw the quad
        GL11.glDrawElements(GL11.GL_TRIANGLES, 6, GL11.GL_UNSIGNED_INT, 0);
        
        // Unbind VAO
        GL30.glBindVertexArray(0);
    }
    
    /**
     * Cleanup renderer resources
     */
    public void cleanup() {
        GL30.glDeleteVertexArrays(vao);
        GL15.glDeleteBuffers(vbo);
        GL15.glDeleteBuffers(ebo);
        System.out.println("Renderer cleaned up");
    }
}
