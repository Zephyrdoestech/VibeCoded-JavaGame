# VibeCoded Java Game

A Java-based game built with LWJGL (Lightweight Java Game Library) for OpenGL rendering and GLFW for window management.

## Features

- **Modern Java**: Built with Java 17
- **LWJGL Integration**: Uses LWJGL 3.3.3 for OpenGL rendering
- **Entity System**: Basic Entity-Component-System architecture
- **Cross-platform**: Windows native libraries included
- **Maven Build**: Easy dependency management and building

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/vibecoded/game/
│   │       ├── Main.java                 # Entry point
│   │       ├── engine/                   # Core engine classes
│   │       │   ├── GameEngine.java       # Main game loop
│   │       │   ├── Window.java           # Window management
│   │       │   ├── Renderer.java         # Rendering system
│   │       │   ├── InputHandler.java     # Input handling
│   │       │   └── GameState.java        # Game state management
│   │       └── entity/                   # Entity system
│   │           ├── Entity.java           # Base entity class
│   │           ├── Component.java        # Component base class
│   │           └── System.java           # System base class
│   └── resources/
│       ├── shaders/                      # GLSL shaders
│       ├── textures/                     # Image assets
│       └── sounds/                       # Audio assets
└── test/
    └── java/
        └── com/vibecoded/game/
            └── GameTest.java             # Unit tests
```

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## Building and Running

### Build the project

```bash
mvn clean compile
```

### Run the game

```bash
mvn exec:java -Dexec.mainClass="com.vibecoded.game.Main"
```

### Package the game

```bash
mvn clean package
```

### Run tests

```bash
mvn test
```

## Controls

- **WASD**: Movement (when implemented)
- **ESC**: Exit game
- **Mouse**: Input handling ready for implementation

## Development

### Adding New Entities

1. Create a new class extending `Entity`
2. Override the `update()` method for custom behavior
3. Add the entity to the `GameState`

### Adding Components

1. Create a new class extending `Component`
2. Implement the required methods: `init()`, `update()`, `cleanup()`
3. Attach components to entities as needed

### Adding Systems

1. Create a new class extending `System`
2. Implement the `update()` and `matches()` methods
3. Register the system in the game engine

## Dependencies

- **LWJGL 3.3.3**: Core library for OpenGL, GLFW, and other native bindings
- **JUnit 5**: Testing framework
- **Maven**: Build and dependency management

## Future Enhancements

- [ ] Sprite rendering system
- [ ] Audio system integration
- [ ] Physics engine integration
- [ ] Scene management
- [ ] Asset loading system
- [ ] Configuration system
- [ ] Save/load functionality

## License

This project is open source. Feel free to use and modify as needed.

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## Troubleshooting

### Common Issues

1. **Native library errors**: Ensure you're running on Windows or add appropriate native libraries for your platform
2. **OpenGL context errors**: Check that your graphics drivers are up to date
3. **Maven build failures**: Ensure Java 17+ is installed and Maven is properly configured

### Getting Help

If you encounter issues:

1. Check the console output for error messages
2. Ensure all dependencies are properly installed
3. Verify your Java version compatibility
4. Check the LWJGL documentation for OpenGL-related issues
