#include <jni.h>
#include <stdio.h>
#include "include/jnitest_HelloJNI.h"

JNIEXPORT void JNICALL Java_jnitest_HelloJNI_sayHello(JNIEnv *env, jobject thisObj) {
   printf("Hello World!\n");
   return;
}
