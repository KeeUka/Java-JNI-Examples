# Example2 - JNI with C hooking with C++

## Credits

This example is taken from
[Here](https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaNativeInterface.html)
with modifications in a few commands.

## Notes

This repository contains all compiled files. To start fresh, just assume that
there is no file at all and you have to write HelloJNICpp.java in step 1.

## Steps

1. Look at HelloJNICpp.java. This class will load a C library called 'hello' and
execute a native method called 'sayHello'.

2. Compile the java file using this command.
  ```
  javac HelloJNICpp.java
  ```
  You will get HelloJNICpp.class

3. Generate a C header file of HelloJNI using this command.
  ```
  javah HelloJNICpp
  ```
  Now you will get a header file HelloJNICpp.h.

4. Create a C++ Header file called HelloJNICppImpl.h. We will declare what we
will implement here.

5. Create a C++ Implementation in HelloJNICppImpl.cpp.

6. Write a C file to implement the header. You can look at HelloJNICpp.c

5. Compile the C program with this command.
  ```
  g++ -dynamiclib -o libhello.jnilib
  -I/System/Library/Frameworks/JavaVM.framework/Headers HelloJNICpp.c
  HelloJNICppImpl.cpp -framework JavaVM
  ```
  Not that I am running on OS X. You might want to find a suitable command
  depending on your operating system.

  Note that you need to name it with a prefix 'lib' and a file extension .jnilib.
  In our case libhello.jnilib. If you don't, in step 6 you wouldn't be able to
  link the library.
6. To run the program, use this command
  ```
  java -Djava.library.path=. HelloJNICpp
  ```
