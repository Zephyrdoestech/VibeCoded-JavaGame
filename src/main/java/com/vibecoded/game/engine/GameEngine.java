package com.vibecoded.game.engine;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

/**
 * Core game engine that manages the game loop and rendering
 */
public class GameEngine {
    private Window window;
    private boolean running = false;
    private GameState gameState;
    private Renderer renderer;
    private InputHandler inputHandler;
    
    // Game loop timing
    private static final int TARGET_FPS = 60;
    private static final long OPTIMAL_TIME = 1000000000L / TARGET_FPS;
    
    public GameEngine() {
        this.renderer = new Renderer();
        this.inputHandler = new InputHandler();
        this.gameState = new GameState();
    }
    
    /**
     * Initialize the game engine with a window
     */
    public void init(Window window) {
        this.window = window;
        
        // Initialize OpenGL context
        GL.createCapabilities();
        
        // Set up OpenGL settings
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        
        // Initialize renderer
        renderer.init();
        
        // Initialize input handler
        inputHandler.init(window.getWindowHandle());
        
        // Initialize game state
        gameState.init();
        
        System.out.println("Game Engine initialized successfully");
    }
    
    /**
     * Start the main game loop
     */
    public void start() {
        running = true;
        gameLoop();
    }
    
    /**
     * Stop the game engine
     */
    public void stop() {
        running = false;
    }
    
    /**
     * Main game loop
     */
    private void gameLoop() {
        long lastTime = System.nanoTime();
        
        while (running && !window.shouldClose()) {
            long currentTime = System.nanoTime();
            long deltaTime = currentTime - lastTime;
            lastTime = currentTime;
            
            // Update game logic
            update(deltaTime);
            
            // Render the game
            render();
            
            // Swap buffers and poll events
            window.swapBuffers();
            GLFW.glfwPollEvents();
            
            // Cap frame rate
            long sleepTime = OPTIMAL_TIME - (System.nanoTime() - currentTime);
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime / 1000000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        
        cleanup();
    }
    
    /**
     * Update game logic
     */
    private void update(long deltaTime) {
        // Update input handler
        inputHandler.update();
        
        // Update game state
        gameState.update(deltaTime);
    }
    
    /**
     * Render the game
     */
    private void render() {
        // Clear the screen
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        
        // Render game state
        renderer.render(gameState);
    }
    
    /**
     * Cleanup resources
     */
    private void cleanup() {
        gameState.cleanup();
        renderer.cleanup();
        window.destroy();
        GLFW.glfwTerminate();
        
        System.out.println("Game Engine cleaned up successfully");
    }
}
