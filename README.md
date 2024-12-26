# Factory Design Pattern Implementation

## Overview

This diagram illustrates an implementation of the **Factory Design Pattern**. The factory pattern provides a way to create objects without specifying the exact class of the object that will be created. It promotes loose coupling between client code and the classes it instantiates.

![image](https://github.com/user-attachments/assets/9ab3b9b8-95cc-4ef7-aece-a472cf9271ee)
---

## Class Diagram Explanation

### **Classes and Interfaces**

1. **`App`**:
   - **Purpose**: The main entry point of the application.
   - **Attributes**:
     - `LOGGER`: A static `Logger` instance used for logging messages.
   - **Methods**:
     - `App()`: Constructor for the `App` class.
     - `main(String[] args)`: Static method that serves as the application's starting point.

2. **`Coin` (Interface)**:
   - **Purpose**: Defines the blueprint for coin classes.
   - **Methods**:
     - `getDescription()`: Abstract method to retrieve a coin's description. Must be implemented by subclasses.

3. **`CoinFactory`**:
   - **Purpose**: A factory class responsible for creating instances of different `Coin` types.
   - **Methods**:
     - `CoinFactory()`: Constructor for the `CoinFactory` class.
     - `getCoin(CoinType type)`: Static method that returns an instance of a coin (`CopperCoin` or `GoldCoin`) based on the provided `CoinType`.

4. **`CoinType` (Enum)**:
   - **Purpose**: Enumerates the different types of coins supported by the factory.
   - **Attributes**:
     - `COPPER` and `GOLD`: Static enum values representing coin types.
     - `constructor`: A supplier that provides the corresponding `Coin` implementation.
   - **Methods**:
     - `getConstructor()`: Returns the constructor for the given `CoinType`.
     - `valueOf(String name)`: Static method to retrieve the `CoinType` by name.
     - `values()`: Static method to get all available `CoinType` values.

5. **`CopperCoin`**:
   - **Purpose**: Represents a copper coin.
   - **Attributes**:
     - `DESCRIPTION`: A static string describing the coin (package-private visibility).
   - **Methods**:
     - `CopperCoin()`: Constructor for the `CopperCoin` class.
     - `getDescription()`: Provides the description of the copper coin.

6. **`GoldCoin`**:
   - **Purpose**: Represents a gold coin.
   - **Attributes**:
     - `DESCRIPTION`: A static string describing the coin (package-private visibility).
   - **Methods**:
     - `GoldCoin()`: Constructor for the `GoldCoin` class.
     - `getDescription()`: Provides the description of the gold coin.

---

### **Relationships**

1. **Inheritance**:
   - `CopperCoin` and `GoldCoin` implement the `Coin` interface. This ensures that both coin types provide their own implementation of the `getDescription()` method.

2. **Factory Relationship**:
   - The `CoinFactory` class uses the `CoinType` enum to determine which `Coin` implementation to create and return.

3. **Enum Integration**:
   - The `CoinType` enum stores a supplier for each coin type and provides methods to retrieve the appropriate constructor for instantiation.

---

## How It Works

1. **Client Code**:
   The `App` class invokes the `CoinFactory.getCoin(CoinType)` method, passing the desired `CoinType` (e.g., `COPPER` or `GOLD`).

2. **Factory Logic**:
   The `CoinFactory` uses the `CoinType` enum to decide which `Coin` subclass to instantiate. This eliminates the need for the client code to directly create instances of `CopperCoin` or `GoldCoin`.

3. **Result**:
   The client receives an object of type `Coin`, which is either a `CopperCoin` or a `GoldCoin`. The client can then call the `getDescription()` method to retrieve the specific description of the coin.

---

## Advantages of Using the Factory Pattern

- **Encapsulation**: The creation logic is encapsulated in the factory class, reducing complexity for the client.
- **Flexibility**: Adding new coin types (e.g., `SilverCoin`) only requires modifying the factory and enum without impacting the client code.
- **Decoupling**: The client code is decoupled from the concrete implementations of the `Coin` interface.
