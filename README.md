# Cryptographer Project

## Introduction

The Cryptographer project is a Java-based application that provides a set of cryptographic functionalities (encryption, decryption, hacking).

### **Caesar Cipher Implementation:**

The project currently features a sophisticated implementation of the Caesar cipher, a classic encryption technique. The Caesar cipher allows users to perform encryption, decryption, and exploration of hacking techniques within a user-friendly interface.

### **Extensibility and SOLID Principles:**

The Cryptographer project is built on the SOLID principles, ensuring a modular and extensible architecture. This design philosophy allows for straightforward integration of new types of ciphers. Whether you wish to add modern cryptographic algorithms or experiment with historical ciphers, the project's structure facilitates easy expansion.


### **Design Patterns Integration**
In the Cryptographer project, we've intelligently incorporated key design patterns:

**Facade Pattern**:
Simplifies complex cryptographic tasks, providing users with an easy-to-use interface while efficiently managing behind-the-scenes intricacies.

**Abstract Factory Pattern**:
Streamlines the creation of related command sets, ensuring a consistent approach to cryptographic components. This promotes flexibility and upholds SOLID principles.

**Command Pattern**:
Packages cryptographic operations into distinct objects, allowing users to customize requests for enhanced flexibility and user-friendliness.

**Strategy Pattern**:
Enables users to dynamically choose between encryption, decryption, or hacking strategies. This design promotes adaptability without requiring modifications to existing code.

### **Usage Examples**
To showcase the Cryptographer project in action, we've provided a series of usage examples with detailed explanations.

### **Example 1: Encryption Operation**
Configuration Setup:

Created a configuration named ENCRYPT.
Set default arguments, including the command, file path, and encryption key.

![1](https://github.com/Kirill1308/cryptographer/assets/104222407/b03612fd-c3d1-452a-96a0-a6179797ddf1)


Console Execution (NoArgsRun):

In the run() method of the Runner class, set RunOperation as NoArgsRun to demonstrate program execution in the console.
Result: Created text.txt[ENCRYPTED] after encryption.

![2](https://github.com/Kirill1308/cryptographer/assets/104222407/6900e4d3-c0f6-45fc-a167-e1757e5f4ae0)

### **Example 2: Decryption Operation**
Console Execution (NoArgsRun - DECRYPT):

Tested the DECRYPT command to decrypt the previously encrypted file.
Result: Successfully decrypted text.txt[DECRYPTED].

![3](https://github.com/Kirill1308/cryptographer/assets/104222407/8106b7fa-c1fd-4f0e-84f4-e64873382bc0)

### **Example 3: Hacking Operation**
Console Execution (NoArgsRun - HACK):

Tested the HACK command to demonstrate the program's hacking capabilities.
Result: Executed the hacking operation successfully.

![4](https://github.com/Kirill1308/cryptographer/assets/104222407/84f56221-44d1-4735-9eb8-c8bcc6ba5ff7)

### **Example 4: Terminal Arguments**
Terminal Execution (Command-Line Arguments):

Packaged the project into a JAR file.
Executed the program in the terminal using the command java -jar jar-fileName command filepath key.
Result: Demonstrated the program's functionality with terminal arguments.

![5](https://github.com/Kirill1308/cryptographer/assets/104222407/752b7050-22d2-4263-ab81-96f992331d1f)

### **Example 5: Hacking Without Key**
Console Execution (HACK - No Key):

Showcased the program's ability to hack a file without requiring a key.
Result: Successfully hacked the file.

![6](https://github.com/Kirill1308/cryptographer/assets/104222407/96c4800c-269a-4135-bebf-b0ea69ff20e4)

### **Example 6: Encryption and Hacking Workflow**
Console Execution (Encryption and Hacking):

Demonstrated the encryption and subsequent hacking of the text.txt file.
Result: Showcased the full encryption and hacking workflow.

![7](https://github.com/Kirill1308/cryptographer/assets/104222407/a212dcdf-6280-4ffc-998f-cae279ef08fe)
