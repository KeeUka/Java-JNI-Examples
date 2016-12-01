# Example2 - JNI with C (Java Package)

## Credits

This example is taken from
[Here](https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaNativeInterface.html)
with modifications in a few commands.

## Notes

This repository contains all compiled files. To start fresh, just assume that
there is no file at all and you have to write jnitest/HelloJNI.java in step 1.

## Steps

1. Create a folder named jnitest

1. Write HelloJNI.java in jnitest folder.

2. Compile the java file using this command.
  ```
  javac jnitest/HelloJNI.java
  ```
  You will get jnitest/HelloJNI.class

3. Generate a C header file of HelloJNI using this command.
  ```
  javah -d include jnitest.HelloJNI
  ```
  Now you will get a header file jnitest_HelloJNI.h in folder include.

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
  java -Djava.library.path=. jnitest.HelloJNI
  ```
