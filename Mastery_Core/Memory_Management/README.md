# Module 1: Java Memory Management - Technical Documentation

## 1. Introduction
Memory management in Java is the process by which the Java Virtual Machine (JVM) allocates and deallocates RAM for data storage and execution flow. Understanding the distinction between the **Stack** and the **Heap** is fundamental for developing high-performance, enterprise-grade applications.

## 2. The Stack (Execution Memory)
The Stack is a memory area reserved for **thread-specific** execution.

### Characteristics:
* **Privacy:** Each thread has its own private Stack.
* **Structure:** Follows a **LIFO** (Last-In, First-Out) organization.
* **Management:** Handled automatically by the CPU using a **Stack Pointer**.
* **Speed:** Extremely fast due to its simple pointer-based allocation.

### The Stack Frame:
Every method call pushes a **Frame** onto the stack. A frame contains:
1. **Local Variable Table:** Stores primitives (`int`, `boolean`, `double`, etc.) and **References** (64-bit hexadecimal memory addresses).
2. **Operand Stack:** Workspace for intermediate calculations.
3. **Return Address:** Pointer to the next instruction in the calling method.

---

## 3. The Heap (Object Storage)
The Heap is a large, **shared** memory area where all objects are stored.

### Characteristics:
* **Accessibility:** Accessible by all threads in the application.
* **Sizing:** Dynamically sized (can grow/shrink).
* **Persistence:** Objects remain until they are no longer referenced.
* **Garbage Collection:** Managed by the **Garbage Collector (GC)**, which removes unreachable objects.

### Object Allocation:
When the `new` keyword is used, the JVM allocates space in the Heap and returns a memory address (Reference) to the Stack.

---

## 4. The String Pool (Memory Optimization)
The String Pool is a specialized area **within the Heap** used for **String Interning**.

* **String Literals (`""`):** The JVM checks if the string already exists in the Pool. If so, it reuses the address.
* **`new String()`:** Forces the creation of a new object in the General Heap, bypassing Pool optimization. This is considered an anti-pattern as it wastes RAM.

---

## 5. Lifecycle and Interaction Summary
* **Stack Data:** Deleted immediately when the method's closing brace `}` is reached and the Frame is popped.
* **Heap Data:** Becomes "Unreachable" once the last Stack Reference to it is deleted. It is eventually removed by the Garbage Collector.
* **References:** The Stack holds the **Address** (e.g., `0x777`), while the Heap holds the **Object Data**.
* 
## 6. Code Example
* [Technical Implementation of Memory Concepts](./MemoryDeepDive/src/Main.java)