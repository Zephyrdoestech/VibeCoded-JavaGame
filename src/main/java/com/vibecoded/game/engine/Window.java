package com.vibecoded.game.engine;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

/**
 * Window management class using GLFW
 */
public class Window {
    private long windowHandle;
    private String title;
    private int width;
    private int height;
    private boolean resized = false;
    
    public Window(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        init();
    }
    
    /**
     * Initialize the window
     */
    private void init() {
        // Set error callback
        GLFWErrorCallback.createPrint(System.err).set();
        
        // Initialize GLFW
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        
        // Configure GLFW
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 3);
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, GLFW.GLFW_TRUE);
        
        // Create the window
        windowHandle = GLFW.glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);
        if (windowHandle == MemoryUtil.NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }
        
        // Set up resize callback
        GLFW.glfwSetFramebufferSizeCallback(windowHandle, (window, w, h) -> {
            this.width = w;
            this.height = h;
            this.resized = true;
            GL11.glViewport(0, 0, w, h);
        });
        
        // Make the OpenGL context current
        GLFW.glfwMakeContextCurrent(windowHandle);
        
        // Enable v-sync
        GLFW.glfwSwapInterval(1);
        
        // Show the window
        GLFW.glfwShowWindow(windowHandle);
        
        System.out.println("Window created: " + title + " (" + width + "x" + height + ")");
    }
    
    /**
     * Check if the window should close
     */
    public boolean shouldClose() {
        return GLFW.glfwWindowShouldClose(windowHandle);
    }
    
    /**
     * Swap the front and back buffers
     */
    public void swapBuffers() {
        GLFW.glfwSwapBuffers(windowHandle);
    }
    
    /**
     * Destroy the window
     */
    public void destroy() {
        GLFW.glfwDestroyWindow(windowHandle);
    }
    
    /**
     * Get the window handle
     */
    public long getWindowHandle() {
        return windowHandle;
    }
    
    /**
     * Get window width
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Get window height
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * Check if window was resized
     */
    public boolean isResized() {
        return resized;
    }
    
    /**
     * Set resized flag
     */
    public void setResized(boolean resized) {
        this.resized = resized;
    }
    
    /**
     * Get window title
     */
    public String getTitle() {
        return title;
    }
}
