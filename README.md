# Hexagonal Architecture - Spring boot

<img width="1189" alt="Screen Shot 2024-10-11 at 04 14 22" src="https://github.com/user-attachments/assets/21543266-fad9-4dcf-9f1a-432d5980b3ec">

## Layered Architecture

<img width="679" alt="Screen Shot 2024-10-11 at 04 25 24" src="https://github.com/user-attachments/assets/6c4c3ac2-9bc9-4aa7-a89f-cde1f16a4ac2">

Our application follows the **Layered Architecture** design pattern, which separates concerns across different layers to promote modularity, maintainability, and scalability. Each layer has a specific responsibility, ensuring a clean separation of logic and improving the overall organization of the codebase.

The key layers in our architecture are:

1. **Presentation Layer (UI Layer)**:
   - This layer handles user interaction and is responsible for rendering the user interface and processing user inputs.
   - Example: Web interface or mobile app.

2. **Application Layer (Service Layer)**:
   - Acts as a mediator between the Presentation and Business Logic layers. It coordinates requests, enforces business rules, and manages transactions.
   - Example: API services and application logic.

3. **Business Logic Layer (Domain Layer)**:
   - The core of the application, encapsulating business rules and domain logic. This layer defines how data can be created, processed, and transformed according to business requirements.
   - Example: Services managing business entities like `Order`, `User`, or `Post`.

4. **Data Access Layer (Persistence Layer)**:
   - Manages communication with the database. It abstracts the underlying data source, providing an interface for CRUD operations.
   - Example: Repositories handling database transactions.

5. **Database Layer (Data Source Layer)**:
   - This is where the actual data is stored, such as relational databases, NoSQL databases, or file systems.
   - Example: MySQL, MongoDB, or other data stores.

By organizing our code into these layers, we ensure a scalable and maintainable application architecture that can evolve over time.


## Drawbacks of Layered Architecture 

1. **Decreased Performance**: Each layer adds processing overhead. Even for simple tasks, data must flow through multiple layers (e.g., UI, business logic, data access), which can slow down the system, particularly in systems with many layers.

2. **Difficult Scalability**: While the architecture provides clear separation of concerns, it doesn't inherently support scalability. As the system grows, layers may become bottlenecks unless specifically designed for scalability.

3. **Tight Coupling**: Layers can become tightly coupled, meaning changes in one layer may impact others. This creates a ripple effect, reducing flexibility and maintainability.

4. **Slow Development**: Due to strict boundaries between layers, making changes can be time-consuming, especially if multiple layers need modifications for a single feature.

5. **Over-Engineering**: For small projects or systems with straightforward requirements, using layered architecture can introduce unnecessary complexity. Simple tasks may become cumbersome due to the strict adherence to the layered structure.

6. **Violation of Layer Rules**: Teams may bypass certain layers (e.g., calling the data access layer directly from the UI), which can lead to inconsistencies, poor modularity, and maintainability issues.

7. **Difficult Unit Testing**: Testing individual layers in isolation can be challenging, especially when business logic heavily relies on the data access layer. Mocking dependencies for each layer can be cumbersome and complex.


## Hexagonal Architecture 

The Hexagonal Architecture, also referred to as Ports and Adapters, is an architectural pattern that allows input by users or external systems to arrive into the Application at 
a Port via an Adapter, and allows output to be sent out from the Application through a Port to an Adapter. This creates an abstraction layer that protects the core of an application
and isolates it from external — and somehow irrelevant — tools and technologies.


<img width="651" alt="Screen Shot 2024-10-11 at 04 31 35" src="https://github.com/user-attachments/assets/0d51239e-ba45-47cb-896f-69e2000a0662">


### Ports

The interactions between actors and the application are organized at the hexagon boundary by the reason why they are interacting with the application. Each group of interactions with a given purpose/intention is a port.

Ports should be named according to what they are for, not according to any technology. So, in order to name a port, we should use a verb ending with “ing” and we should say “this port is for …ing something”. For example:

This driver port is for “adding products to the shopping cart”.
This driven port (repository) is “for obtaining information about orders”.
This driven port (recipient) is for “sending notifications”.
Ports are the application boundary, in the picture a port is an edge of the hexagon. From the outside world, actors can only interact with the hexagon ports, they shouldn’t be able to access the inside of the hexagon. Ports are interfaces that the application offers to the outside world for allowing actors interact with the application. So the application should follow the Information Hiding Principle. An important thing to remark is that ports belong to the application.

Driver Ports offer the application functionality to drivers of the outside world. Thus, driver ports are said to be the use case boundary of the application. They are the API of the application.

Depending on the granularity we apply when grouping functionality, we can have a port interface with many use cases or with just a few. If we want to follow the Single Responsibility Principle, then we would have a lot of ports, each one for a use case. In this case a better option is applying the command bus design pattern to the port, with a command handler for each use case. Same idea could be applied to queries, so that we would satisfy the CQRS pattern as well. We would have a port for executing commands and another port for executing queries.

A driven port is an interface for a functionality, needed by the application for implementing the business logic. Such functionality is provided by a driven actor. So driven ports are the SPI (Service Provider Interface) required by the application. A driven port would be like a Required Interface.


### Adapter

Actors interact with hexagon ports through adapters using a specific technology. An adapter is a software component that allows a technology to interact with a port of the hexagon. Given a port, there may be an adapter for each desired technology that we want to use. Adapters are outside the application.

A driver adapter uses a driver port interface, converting a specific technology request into a technology agnostic request to a driver port.

#### Driver Adapter 

1. An automated test framework: Converts test cases into requests to a driver port.
2. A CLI (Command Line Interface): Converts text entered in a console.
3. A GUI of a desktop application: Converts events triggered by graphical components.
4. An MVC web application: The Controller receives from the View the action requested by the user, and converts it into a request to a driver port.
5. A REST API controller: Converts REST API requests.
6. An event subscriber: Converts messages (events) from a message queue to which the application is subscribed.
7. For each driver port, there should be at least two adapters: one for the real driver that is going to run it, and another one for testing the behaviour of the port.

#### Driven Adapter

1. A mock adapter: It mimics the behaviour of a real secondary actor, for example an inmemory database.
2. A SQL adapter: Implements a driven port for persisting data by accessing a SQL database.
3. An email adapter: Implements a driven port for notifying people by sending an email to them.
4. An App-To-App adapter: Implements a driven port for getting some data by requesting them to a remote application.
5.An event publisher: Implements a driven port for publishing events by sending them to a message queue, so that they are available for subscribers.


## Advantages of Hexagonal Architecture Over Layered Architecture

- **Flexibility and Independence:** In layered architecture, there is tighter coupling between layers, with dependencies on lower layers like the database. In hexagonal architecture, the business logic is isolated from the external world, leading to a more flexible structure.
  
- **Dependency Management:** In hexagonal architecture, external systems (UI, database, services) do not create dependencies, making it easier to switch to different technologies or systems.

- **Better Testability:** In layered architecture, testing the whole system can be challenging due to dependencies on external systems. However, in hexagonal architecture, the business logic can be isolated and tested independently from these external components.

### Reference Sources

1. [Hexagonal Architecture - GitHub Repository by rbailen](https://github.com/rbailen/Hexagonal-Architecture)
2. [Modular Architecture Hexagonal Demo Project - GitHub Repository by Alican Akkus](https://github.com/AlicanAkkus/Modular-Architecture-Hexagonal-Demo-Project)
3. [Articles by JM Garrido Paz](https://jmgarridopaz.github.io/content/articles.html)
4. [Hexagonal Architecture: There Are Always Two Sides to Every Story - Medium Article](https://medium.com/ssense-tech/hexagonal-architecture-there-are-always-two-sides-to-every-story-bc0780ed7d9c)

