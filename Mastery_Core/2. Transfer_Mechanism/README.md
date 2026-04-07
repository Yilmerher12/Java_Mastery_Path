# Module 3: Java Pass-by-Value - Technical Documentation
## 1. The Universal Rule: Absolute Pass-by-Value
In the JVM (Java Virtual Machine) architecture, **Pass-by-Value** is the only mechanism for transferring data between methods.

* **What it means:** When you call a method, you are not giving it your variable; you are giving it a **copy of the data** held by that variable.
* **The "Reference" Myth:** While many languages allow "Pass-by-Reference" (where a method gets a direct pointer to the original variable's memory slot), Java strictly forbids this to ensure memory safety and thread isolation. In Java, even when dealing with objects, we only pass the **value of the reference** (the address), never the reference itself.

## 2. Technical Definition of "Value"
In the context of the Stack, a "Value" is the literal binary content (bits) stored in a variable's reserved memory slot.

* **Primitives (Immediate Data):** For types like `int`, `double`, or `boolean`, the value is the **actual numerical or logical data**.
    * *Example:* If `int x = 10;`, the slot in the Stack contains the binary representation of `10`.
* **Objects (Address Data):** For any class instance, the value is a **64-bit Memory Address** (e.g., `0xABC`).
    * *Crucial Note:* The variable does NOT contain the object; it contains the "map" to find the object in the Heap. The "Value" being passed is that map.

## 3. The Transfer Process: Bit-for-Bit Copy
When a method is invoked, the JVM performs a **Bit-for-Bit Copy**. This is a low-level operation where the CPU reads the exact binary sequence of the caller's variable and writes an identical sequence into the parameter's slot in the new Stack Frame.

### Key Architectural Principles:

* **Physical Isolation:** * Every method call generates a new **Stack Frame**.
    * The original variable (in the caller frame) and the parameter (in the receiver frame) are located at **different physical addresses** in the RAM.
    * There is no "wire" or "alias" connecting them; they are two separate boxes in different rooms.

* **Binary Independence:** * Since the transfer is a copy, once the bits are written into the new frame, the two variables are **completely independent**.
    * If the method changes the bits in its local parameter (e.g., changing a `10` to a `50`, or a memory address `0xABC` to `0xZZZ`), the bits in the original variable's memory address remain untouched.
    * The original variable is "blind" to any operations performed inside the called method's frame.

* **Memory Safety:** * This isolation ensures that a method cannot accidentally destroy or reassign a variable belonging to another part of the program, which is critical for enterprise-grade stability.
---

## 4. Behavior by Data Type

### A. Primitives (Immutable by Copy)
Since the copy is the actual data, modifying the parameter only affects the local Stack Frame. The original remains unchanged.

### B. Mutable Objects (Content Modification)
Since the copy is a **Memory Address**, both the original variable and the parameter point to the **same block in the Heap**.
* **Result:** You can modify the *internal data* of the object (Mutation), but you cannot change which object the original variable points to (Reassignment).

### C. Strings (The Special Case)
Strings are objects, but they are **Immutable**.
* When you "change" a String in a method (e.g., `s = "new"`), Java creates a new entry in the **String Pool** and updates the local parameter to point to the new address.
* The original variable in the caller method continues pointing to the original address in the Pool.

---

## 5. Summary Table

| Data Type | Stack Content | Copy Content | Can Modify Original? |
| :--- | :--- | :--- | :--- |
| **Primitive** | Actual Data | Actual Data | **No** |
| **Object** | Address (0xABC) | Address (0xABC) | **Yes (Content only)** |
| **String** | Address (0x111) | Address (0x111) | **No** |

---

## 6. Code Resources
* [Technical Implementation of data transfer Mechanism](./PassByValueChallenge/src/Main.java)