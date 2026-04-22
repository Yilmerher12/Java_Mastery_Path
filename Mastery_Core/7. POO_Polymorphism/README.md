# Module 7: Polymorphism

This module delves into **Polymorphism**, the third pillar of OOP. It is the ability of an object to take multiple forms and respond to the same command in different ways depending on its reality in memory.

---

## 1. What is Polymorphism?

It is not a class or an object, but a **property** of the language. It allows a "Parent" type reference to point to a "Child" type object.

* **Principle:** "One interface, many methods."
* **Purpose:** To create flexible and scalable systems. It allows code to be agnostic to the specific type of object (decoupling).
* **Relationship:** It is based entirely on Inheritance (Module 6).

---

## 2. The Two Mechanisms of Polymorphism

Java implements polymorphism in two different ways, depending on **when** the decision of which code to execute is made.

### A. Static Polymorphism (Overloading)
Occurs at **Compile Time**. Java decides which method to call based on the **parameters** (the signature).
* **Decision Location:** The **Stack**.
* **Technical Name:** *Static Binding*.
* **Example:** `sumar(int a, int b)` vs `sumar(double a, double b)`.

### B. Dynamic Polymorphism (Overriding)
Occurs at **Runtime**. Java decides which code to execute based on the **Actual Object** living in memory.
* **Decision Location:** The **Metaspace** (V-Table).
* **Technical Name:** *Dynamic Binding*.
* **Requirement:** A Parent type variable pointing to a Child object.

---

## 3. Integration with Memory (The JVM's "Journey")

For dynamic polymorphism to work, Java performs a three-step process when you call a method:

1.  **The Stack (The Mask):** Java verifies that the variable (Reference) has the legal permission to call the method.
2.  **The Heap (The Reality):** Java travels to the object's memory address and reads its **Object Header**. There it finds the **Klass Pointer** (the object's DNA).
3.  **The Metaspace (The Manual):** Following the Klass Pointer, Java reaches the **V-Table** of the actual class. If the method was overridden (`@Override`), it executes the Child's version; if not, it executes the Parent's.

---

## 4. Casting Mechanisms (Changing Masks)

Casting is the process of changing the **Reference Type** in the Stack to gain or lose visibility over the object's methods.

### A. Upcasting
Treating a Child as if it were a Parent.
* **Syntax:** `Parent p = new Child();` (It is automatic).
* **Effect:** Methods exclusive to the Child are hidden. The ability to treat many different children as a single generic list of parents is gained.

### B. Downcasting
Treating a Parent reference as the Child it actually is.
* **Syntax:** `Child h = (Child) p;` (It is manual and mandatory).
* **Effect:** The "special powers" (unique methods) of the Child are recovered.
* **Risk:** If the object in the Heap does not match the type you are trying to convert it to, Java throws a `ClassCastException`.

---

## 5. The `instanceof` Operator (Real-Time Safety)

It is a **binary operator** that acts as a security scanner before performing a Downcasting.

* **What does it evaluate?:** It goes to the **Heap**, reads the object header, and confirms if it belongs to the lineage of the queried class.
* **Result:** Returns `true` or `false`.

```java
if (user instanceof Administrator) { // 1. DNA Scan
Administrator admin = (Administrator) user; // 2. Safe Downcasting
    admin.deleteDatabase(); // 3. Specific Action
}
```
## 6. Final Comparative Summary

| Concept | Based on... | Decision (When) | Location (Where) |
| :--- | :--- | :--- | :--- |
| **Overloading** | Parameters (`int`, `String`) | Compilation | Stack |
| **Overriding** | Object Identity | Runtime | Metaspace (V-Table) |
| **Upcasting** | Generalization | Automatic | Class Hierarchy |
| **Downcasting** | Specialization | Manual | Class Hierarchy |
| **instanceof** | Object DNA | Runtime | Heap (Klass Pointer) |

---

## 7. Anatomy of a Polymorphic Call

```java
Component c = new Sensor();
c.connect();
```

1. **Compiler:** "Does `Component` have the `connect()`method?". Yes $\rightarrow$  Permission granted.
2. **JVM (Runtime):** "Going to the Heap... the object is a `Sensor`. Going to the V-Table of `Sensor` in the Metaspace. Executing the code for `Sensor.connect()`".

---

### Architect's Note

**Polymorphism** is the foundation of **Clean Code**. Avoid the excessive use `if-else` o `switch` to check types. Simply give an order to the Parent and let each Child react according to its own nature.8. Code Resources

## 8. Code Resources
* [Technical Implementation of Polymorphism](../7.%20POO_Polymorphism/PolymorphismExercise/src/Main.java)