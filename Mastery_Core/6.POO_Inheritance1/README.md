# Module 6: Inheritance (Herencia)

This module covers **Inheritance**, a core pillar of OOP that allows one class **(Child class)** to use the logic and structure of another **(Parent Class)**.

---

## 1. What is Inheritance?

Inheritance is a link between a **Superclass (Parent)** and a **Subclass (Child)**. The child class "inherits" everything the parent has (attributes and methods). In Java, we use the keyword `extends`.

* **Why use it?** To avoid repeating code: If 10 classes need an `id`, you put it in one Parent class.
* **Relationships:** It defines that an object **"Is-A"** type of another (e.g., a User is a Person).

---

## 2. Memory Behavior (The "Hard" Part made Simple)
When you create a child object, Java doesn't just "copy-paste" code. It organizes the RAM in a specific way:

### A. The Heap (The Physical Object)
Think of the Heap as a storage room. When you do `new User()`, Java reserves one single block of memory.

* **Object Header:** The "ID card" of the object. It tells Java: "I am a User".
* **Offsets (Coordinates):** Inside the block, parent variables come first, then child variables. An "Offset" is just the distance (in bytes) from the start of the block to find a specific variable.
* **Padding:** Extra empty space Java adds just to keep the memory block size neat (multiples of 8).

### B. The Metaspace (The Manual)
The Metaspace is the library where Java stores the "Manuals" (Class definitions).

* **V-Table (Virtual Table):** An index of methods. If the child doesn't change a method, the index points to the parent's version.
* **Hierarchy Link:** A physical pointer in the manual that says "My parent is Class X".

---

## 3. Constructors and the `super()` Keyword
Java has a strict rule: **You cannot build the roof without the foundation.**

1.  When you call `new Child()`, Java immediately jumps to the Parent's constructor first.
2.  **`super()`**: This command calls the parent's constructor. If you don't write it, Java adds it for you secretly.
3.  **The Order:** Parent constructor runs $\rightarrow$ Child constructor runs. This ensures the inherited variables are ready before the child tries to use them.

### Example:
```java
public class Entity {
    protected int id;
    public Entity(int id) { 
        this.id = id; // 1. Foundations first
    } 
}

public class User extends Entity {
    private String name;
    public User(int id, String name) {
        super(id); // 2. Call the parent!
        this.name = name; // 3. Now build the rest
    }
} 
```

## 4. Method Overriding (@Override)
   Overriding is when a child says: "I know my parent does this, but I want to do it differently."

 
* **Rule:** The method name and parameters `(The Signature)` must be identical.
* **Visibility:** You cannot make a method more private than the parent's version.
* **@Override:** A safety tag. It tells the compiler: *"Check if I am actually overriding something. If I make a typo, tell me!"*


## 5. Attribute Shadowing (The Tricky Part)
* **Warning:** Unlike methods, attributes **`(variables)`** do not override.
   If Parent and Child have a variable named x, both exist in memory at the same time in different spots (Offsets).
* **Reference (The Label):** If your variable is type Parent, Java looks at the Parent's variable.
* **Object (The Reality):** Methods always look at the real object's version.

| Element | Decision Maker | Location |
| :--- | :--- | :--- |
| Methods | The Object (Real Type) | Heap |
| Attributes | The Variable (Label Type) | Stack |



## 6. Security and Limits
* **java.lang.Object:**  `The "Great-Grandfather"` of every class in Java. If you don't extend anything, you extend Object.
* **final Keyword:**
   * **On a Class:** No one can inherit from it. (The end of the family tree).
   * **On a Method:** No child can override it.
   * **protected Access:** A variable that is private to the world, but visible to its children.

## 7. Anatomy of an Instance (Reference vs. Object)

When you write a line to create an object, you are dealing with two different worlds:

`Componente c = new Sensor();`

1.  **`Componente` (Reference Type):** This is the **Mask**. It tells the compiler: *"Treat this object as a Componente"*. It defines your **Permissions** (which methods you can call).
2.  **`c` (Variable/Identifier):** The name you use to call the object.
3.  **`new` (Instantiation):** The command to reserve space in the Heap.
4.  **`Sensor()` (Object Type):** This is the **Reality**. It defines the **Behavior**. It tells Java: *"I am physically a Sensor, even if you call me a Componente"*.

### ⚠️ Architect's Note: The Danger of Inheritance

It creates Strong Coupling. If you change a single line in the Parent class, you might accidentally break 100 Child classes. Use it only when there is a true **"Is-A"** relationship.

## 8. Code Resources
* [Technical Implementation of Inheritance](../6.POO_Inheritance/InheritanceExercise/src/Main.java)