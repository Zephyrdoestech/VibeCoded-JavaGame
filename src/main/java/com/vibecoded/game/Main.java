package com.vibecoded.game;

import com.vibecoded.game.engine.GameEngine;
import com.vibecoded.game.engine.Window;

/**
 * Main entry point for the VibeCoded Java Game
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Initialize the game engine
            GameEngine gameEngine = new GameEngine();
            
            // Create and configure the game window
            Window window = new Window("VibeCoded Java Game", 1280, 720);
            
            // Initialize the game engine with the window
            gameEngine.init(window);
            
            // Start the game loop
            gameEngine.start();
            
        } catch (Exception e) {
            System.err.println("Failed to start the game: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
