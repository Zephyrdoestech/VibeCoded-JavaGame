package com.vibecoded.game.engine;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallbackI;
import org.lwjgl.glfw.GLFWMouseButtonCallbackI;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;

/**
 * Handles keyboard and mouse input
 */
public class InputHandler {
    private long windowHandle;
    private boolean[] keys = new boolean[GLFW.GLFW_KEY_LAST];
    private boolean[] mouseButtons = new boolean[GLFW.GLFW_MOUSE_BUTTON_LAST];
    private double mouseX = 0.0;
    private double mouseY = 0.0;
    
    // Callbacks
    private GLFWKeyCallbackI keyCallback;
    private GLFWMouseButtonCallbackI mouseButtonCallback;
    private GLFWCursorPosCallbackI cursorPosCallback;
    
    /**
     * Initialize the input handler
     */
    public void init(long windowHandle) {
        this.windowHandle = windowHandle;
        setupCallbacks();
        System.out.println("Input handler initialized");
    }
    
    /**
     * Set up GLFW callbacks for input
     */
    private void setupCallbacks() {
        // Keyboard callback
        keyCallback = (window, key, scancode, action, mods) -> {
            if (key >= 0 && key < keys.length) {
                keys[key] = action != GLFW.GLFW_RELEASE;
            }
        };
        GLFW.glfwSetKeyCallback(windowHandle, keyCallback);
        
        // Mouse button callback
        mouseButtonCallback = (window, button, action, mods) -> {
            if (button >= 0 && button < mouseButtons.length) {
                mouseButtons[button] = action != GLFW.GLFW_RELEASE;
            }
        };
        GLFW.glfwSetMouseButtonCallback(windowHandle, mouseButtonCallback);
        
        // Mouse position callback
        cursorPosCallback = (window, xpos, ypos) -> {
            mouseX = xpos;
            mouseY = ypos;
        };
        GLFW.glfwSetCursorPosCallback(windowHandle, cursorPosCallback);
    }
    
    /**
     * Update input state (called each frame)
     */
    public void update() {
        // Input state is updated via callbacks
        // This method can be used for additional input processing
    }
    
    /**
     * Check if a key is currently pressed
     */
    public boolean isKeyPressed(int keyCode) {
        return keyCode >= 0 && keyCode < keys.length && keys[keyCode];
    }
    
    /**
     * Check if a key was just pressed (not held)
     */
    public boolean isKeyJustPressed(int keyCode) {
        // This would require tracking previous frame state
        // For now, just return current state
        return isKeyPressed(keyCode);
    }
    
    /**
     * Check if a mouse button is currently pressed
     */
    public boolean isMouseButtonPressed(int button) {
        return button >= 0 && button < mouseButtons.length && mouseButtons[button];
    }
    
    /**
     * Get mouse X position
     */
    public double getMouseX() {
        return mouseX;
    }
    
    /**
     * Get mouse Y position
     */
    public double getMouseY() {
        return mouseY;
    }
    
    /**
     * Check if escape key is pressed
     */
    public boolean isEscapePressed() {
        return isKeyPressed(GLFW.GLFW_KEY_ESCAPE);
    }
    
    /**
     * Check if W key is pressed (for movement)
     */
    public boolean isWPressed() {
        return isKeyPressed(GLFW.GLFW_KEY_W);
    }
    
    /**
     * Check if A key is pressed (for movement)
     */
    public boolean isAPressed() {
        return isKeyPressed(GLFW.GLFW_KEY_A);
    }
    
    /**
     * Check if S key is pressed (for movement)
     */
    public boolean isSPressed() {
        return isKeyPressed(GLFW.GLFW_KEY_S);
    }
    
    /**
     * Check if D key is pressed (for movement)
     */
    public boolean isDPressed() {
        return isKeyPressed(GLFW.GLFW_KEY_D);
    }
}
