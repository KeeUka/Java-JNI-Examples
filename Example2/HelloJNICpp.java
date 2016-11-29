// javac HelloJNICpp.java
// javah HelloJNICpp
// g++ -dynamiclib -o libhello.jnilib -I/System/Library/Frameworks/JavaVM.framework/Headers HelloJNICpp.c HelloJNICppImpl.cpp -framework JavaVM
// java -Djava.library.path=. HelloJNICpp

/*
* Note:
*
* g++
*
* For compiling cpp, otherwise we will get this error:
* Undefined symbols for architecture x86_64:....
*
*/

/*
 * This example is taken from here.
 * https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaNativeInterface.html
 */
public class HelloJNICpp {

  static {
    System.loadLibrary("hello");
  }

  private native void sayHello();

  public static void main(String [] args){
    new HelloJNICpp().sayHello();
  }

}
