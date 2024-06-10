# Java Hotel Management System

## Project Overview
This project is a Hotel Management System developed in Java, utilizing Object-Oriented Programming (OOP) principles. The system is designed to manage various aspects of hotel operations including guest information, room reservations, food orders, and overall hotel management.

## Classes and Structure

### 1. `FoodItem.java`
- Represents a food item available in the hotel.
- Contains attributes like `name`, `price`, and `description`.
- Methods to get and set these attributes.

### 2. `Guest.java`
- Represents a guest staying in the hotel.
- Contains attributes like `guestID`, `name`, `contactInfo`, and `room`.
- Methods to manage guest details and retrieve guest information.

### 3. `Hotel.java`
- Represents the hotel itself.
- Contains lists of `Room`, `Guest`, and `FoodItem`.
- Methods to add/remove guests, rooms, and food items.

### 4. `HotelManagementSystem.java`
- The controller/main class.
- Initializes the hotel, handles user interactions, and invokes methods from other classes to perform operations.
- Manages the main application flow.

### 5. `Order.java`
- Represents an order placed by a guest.
- Contains attributes like `orderID`, `guest`, `foodItems`, and `totalPrice`.
- Methods to calculate the total price and manage the order details.

### 6. `Room.java`
- Represents a room in the hotel.
- Contains attributes like `roomNumber`, `type`, `price`, and `availability`.
- Methods to check availability, book the room, and manage room details.

## OOP Principles Applied

### Encapsulation
- **Description**: Encapsulation is the concept of wrapping data and methods that operate on the data within a single unit or class.
- **Implementation**: Each class (`FoodItem`, `Guest`, `Hotel`, `Order`, `Room`) encapsulates its attributes and provides public getter and setter methods to access and modify them.

### Inheritance
- **Description**: Inheritance allows a class to inherit properties and behavior from another class.
- **Implementation**: While not explicitly detailed in the class list, potential for inheritance could be seen in a structure where `Room` could inherit from a more general `Accommodation` class if extended for more types of accommodations.

### Polymorphism
- **Description**: Polymorphism allows methods to do different things based on the object it is acting upon, even though they share the same name.
- **Implementation**: Methods like `addGuest()`, `bookRoom()`, and `placeOrder()` in `Hotel` class could be examples where polymorphism is utilized if there are overloaded methods or interfaces implemented.

### Abstraction
- **Description**: Abstraction simplifies complex systems by modeling classes appropriate to the problem, while exposing only the necessary parts.
- **Implementation**: The project abstracts real-world entities (Guest, Room, FoodItem) into simplified classes that expose only the necessary functionalities to interact with them.

## Conclusion
The Java Hotel Management System project showcases the effective use of OOP principles to create a modular, maintainable, and scalable software solution for managing hotel operations. Each class represents a specific part of the hotel, encapsulating relevant data and behavior, while the main controller class (`HotelManagementSystem.java`) coordinates the overall workflow.
