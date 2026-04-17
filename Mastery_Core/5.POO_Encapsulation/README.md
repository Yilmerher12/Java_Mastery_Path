# Module 5: OOP Encapsulation & Memory Safety(Encapsulamiento y seguridad de memoria)

## 1. Overview
Encapsulation is the first pillar of Object-Oriented Programming (POO). It is the mechanism of bundling data (attributes) and methods into a single unit (Class) while restricting direct access to the internal state. This creates a "Memory Firewall" (barrera de memoria) between the object's implementation and the outside world.

## 2. The Architectural Trinity

### A. Interface (The Signature)
The **Method Signature** (Name + Parameters) is the "What". It is the public button that other classes are allowed to press.
> **Rule:** Never change the Signature once it is public, as it defines the **Contract**.

### B. Implementation (The "How")
The logic inside the curly braces `{ ... }` and the `private` attributes. This is the "machinery".
- **Metaspace:** Where the method instructions live.
- **Heap:** Where the actual object data resides.
- **Rule:** Implementation can be changed/optimized at any time without breaking external code, provided the Interface remains identical.

### C. The Contract (Stability)
The agreement between the developer and the user of the class. It guarantees that as long as the caller respects the Interface, the object will perform its duty, regardless of internal changes.

## 3. Defensive Copying (Memory Integrity)
Since Java handles objects by **Reference** ([watch the transfer_Mechanism module](../2.%20Transfer_Mechanism/README.md)), simply making an attribute `private` is not enough. If we leak a memory address, we break encapsulation.

### The "Double-Gate" Strategy:
1.  **Incoming (Constructors/Setters):** Use `new` or `.clone()` to create a local copy of external objects. This prevents the caller from modifying your internal state from the outside.
2.  **Outgoing (Getters):** Never return the original reference (`this.attribute`). Return a **newly created copy**. This prevents the caller from modifying your data after reading it.



---

## 4. Summary Table

| Concept | Scope | Visibility | Modifiable? |
| :--- | :--- | :--- | :--- |
| **Attribute** | State | `private` | Only via methods |
| **Signature** | Contract | `public` | NO (Breaks Contract) |
| **Body** | Logic | Hidden | YES (Encapsulated) |

## 5. Code Resources
* [Technical Implementation of Encapsulation](../5.POO_Encapsulation/EncapsulatioChallenge/src/Main.java)