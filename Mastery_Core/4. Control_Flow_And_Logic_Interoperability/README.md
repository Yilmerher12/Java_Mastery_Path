# Module 5: Control Flow & Logic Optimization (Flujo de Control y Optimización Lógica)

This module explores how the **JVM (Java Virtual Machine)** processes logical decisions and repetitions. For a professional developer, writing code that "works" is not enough; one must understand how these structures interact with the **Stack**, **RAM**, and **CPU**.

---

## 1. Short-Circuiting (Evaluación de Cortocircuito)

Java uses Short-Circuit Operators (`&&` and `||`) to optimize execution. This means the JVM will stop evaluating an expression as soon as the final result is guaranteed.

### El Mecanismo Técnico:
* **AND (`&&`):** If the left side is `false`, the right side is ignored.
* **OR (`||`):** If the left side is `true`, the right side is ignored.

### Why it matters (Memory Safety):
We use this as a Guard Clause **(Cláusula de Guardia)** to prevent NullPointerExceptions or arithmetic errors.

```java
// Logic Safety Example
String text = null;

// The JVM evaluates 'text != null' as false and STOPS.
// It never tries to call '.length()', preventing a crash.
if (text != null && text.length() > 5) {
        System.out.println("Valid text");
};
```

## 2. The Ternary Operator & Implicit Unboxing (Operador Ternario y Desempaquetado Implícito)

 The Ternary Operator (`?` `:`) is an Expression (Expresión), meaning it must resolve to a single value of a single type. This leads to a hidden danger when mixing data types.
### The "Hidden Trap":

When you mix a Wrapper Class (Object) and a Primitive, Java performs Implicit Unboxing to make the types match.

```java
Double salary = null; // Address in Stack is null
// Java sees 'double 0.0' and tries to convert 'salary' to a primitive double.
double finalPay = (false) ? salary : 0.0; 
// CRASH: NullPointerException during forced unboxing of 'salary'.
```
## 3. Modern Switch Expressions (Expresiones Switch Modernas)

Introduced in Java 14, these turn the switch from a statement into an Expression (Expresión) that returns a value.

### Improvements over the Old Switch:
* **Arrow Syntax (`->`):** Eliminates the need for break, preventing "Fall-through" bugs (errores de continuidad).
* **Exhaustiveness (Exhaustividad):** The compiler forces you to cover all possible cases (usually via default).
* **The (`yield`) Keyword:** Used in multi-line blocks { } to return a value from the switch without exiting the entire method.

## 4. Loops vs. Recursion (Bucles vs. Recursividad)

To manage resources correctly, a developer must distinguish between CPU usage and RAM (Stack) usage.

### A. Loops (Bucles)
A loop (`while`, `for`, `do-while`) is a repetition that stays inside the same Stack Frame.

* **Behavior:** Reuses the same memory address for local variables.

* **Failure:** An Infinite Loop (`Bucle infinito`) consumes 100% of the CPU, causing the program to hang (`freeze`), but it does not crash the memory.

### B. Recursion (Recursividad)
Recursion occurs when a method calls itself.

* **Behavior:** Every call creates a NEW Stack Frame (`nuevo bloque de memoria`) on top of the previous one.

* **Failure:** Infinite Recursion fills the Stack memory until there is no space left.

* **Result:** *java.lang.StackOverflowError* (`The program crashes instantly`).

```java
int priority = switch (status) {
    case "CRITICAL" -> 1;
    case "HIGH", "MEDIUM" -> {
        System.out.println("Standard processing...");
        yield 2; // Returns 2 to the variable 'priority'
    }
    default -> 3;
};
```


## 6. Code Example
* [Technical Implementation of Control Flow](./MemoryDeepDive/src/Main.java)