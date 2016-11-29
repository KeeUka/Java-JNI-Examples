/*
 * This example is taken from here.
 * https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaNativeInterface.html
 */
public class HelloJNI {

  static {
    System.loadLibrary("hello");
  }

  private native void sayHello();

  public static void main(String [] args) {
    new HelloJNI().sayHello();
  }

}
