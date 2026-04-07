# Module 4: Wrapper Classes & Type Interoperability

## 1. Concept: The "Bridge" between Stack and Heap
Java is a hybrid language. It uses **Primitives** (Stack) for raw performance and **Objects** (Heap) for structural flexibility. Wrapper classes are the bridge that allows a primitive to exist as an object.

### The Full Mapping Table
| Primitive (Stack) | Wrapper Class (Heap) | Default Value |
| :--- | :--- | :--- |
| `byte` | `Byte` | `null` |
| `short` | `Short` | `null` |
| `int` | `Integer` | `null` |
| `long` | `Long` | `null` |
| `float` | `Float` | `null` |
| `double` | `Double` | `null` |
| `char` | `Character` | `null` |
| `boolean` | `Boolean` | `null` |

---

## 2. Autoboxing & Unboxing (The Automatic Translation)

### Autoboxing (Empaquetado Automático)
The compiler automatically converts a primitive into its corresponding Wrapper Object.
* **Trigger:** Assigning a primitive to a Wrapper variable or passing it to a method expecting an Object (e.g., `List.add(5)`).
* **Under the hood:** Calls `Wrapper.valueOf(primitive)`.

### Unboxing (Desempaquetado Automático)
The compiler automatically extracts the primitive value from a Wrapper Object.
* **Trigger:** Using a Wrapper in a mathematical operation (`+`, `-`, `*`) or comparing it with a primitive.
* **Under the hood:** Calls `wrapper.primitiveValue()` (e.g., `intValue()`).



---

## 3. The Integer Cache (Performance Optimization)
To avoid saturating the Heap with small, common numbers, Java maintains a "Pool" (Piscina) of pre-created objects.
* **Range:** `-128` to `127`.
* **Behavior:** When autoboxing a number in this range, Java returns a reference to a **shared object** in the cache rather than creating a new one.
* **Memory impact:** Comparing two cached Integers with `==` returns `true` (same address). Outside this range, it returns `false` (different addresses).



---

## 4. Critical Rules & Edge Cases (Attention Points)

### A. The NullPointerException (NPE) Trap
Since Wrappers are objects, they can be `null`.
* **The Danger:** Attempting to **Unbox** a `null` object (e.g., `int x = myNullInteger;`) will crash the program. You cannot extract a value from an address that doesn't exist.

### B. Comparison Logic (`==` vs `.equals()`)
* **Object vs Object:** `==` compares **Memory Addresses** (Referencias). Always use `.equals()` to compare the internal values of two Wrappers.
* **Object vs Primitive:** `==` triggers **Unboxing**. The object is converted to a primitive, and values are compared. This usually returns `true` if the numbers match.

### C. Type Strictness (The "Sibling" Rule)
You cannot compare two different Wrapper types (e.g., `Integer` vs `Long`) using `==`. The compiler identifies them as incompatible types, even if their numerical value is the same.

---

## 5. ADSO/CGI Best Practices
1. **Prefer Primitives for Logic:** Use `int`, `double`, etc., for loops and calculations to avoid the overhead of constant boxing/unboxing.
2. **Use Wrappers for Collections:** `List<Integer>`, `Map<String, Boolean>`, etc., require Wrappers.
3. **Database Nullability:** Use Wrappers when a value from a database can be `null`. A primitive `int` cannot represent a "missing" value; an `Integer` can.