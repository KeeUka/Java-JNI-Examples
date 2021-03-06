# Example1 - JNI with pure C

## Credits

This example is taken from
[Here](https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaNativeInterface.html)
with modifications in a few commands.

## Notes

This repository contains all compiled files. To start fresh, just assume that
there is no file at all and you have to write HelloJNI.java in step 1.

## Steps

1. Look at HelloJNI.java. This class will load a C library called 'hello' and
execute a native method called 'sayHello'.

2. Compile the java file using this command.
  ```
  javac HelloJNI.java
  ```
  You will get HelloJNI.class

3. Generate a C header file of HelloJNI using this command.
  ```
  javah HelloJNI
  ```
  Now you will get a header file HelloJNI.h.
4. Write a C file to implement the header. You can look at HelloJNI.c
5. Compile the C program with this command.
  ```
  gcc -dynamiclib -o libhello.jnilib \
  -I/System/Library/Frameworks/JavaVM.framework/Headers HelloJNI.c \
  -framework JavaVM
  ```
  Not that I am running on OS X. You might want to find a suitable command
  depending on your operating system.

  Also, you need to name it with a prefix 'lib' and a file extension .jnilib.
  In our case libhello.jnilib. If you don't, in step 6 you wouldn't be able to
  link the library.
6. To run the program, use this command
  ```
  java -Djava.library.path=. HelloJNI
  ```
