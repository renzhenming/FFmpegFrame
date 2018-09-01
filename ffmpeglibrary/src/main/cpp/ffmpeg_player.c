#include "com_rzm_ffmpeglibrary_FFmpegUtils.h"

/*
 * Class:     com_rzm_ffmpeglibrary_FFmpegUtils
 * Method:    decode
 * Signature: ()V
 */
JNIEXPORT jstring JNICALL Java_com_rzm_ffmpeglibrary_FFmpegUtils_decode
(JNIEnv *env, jclass jclazz,jstring input,jstring output){
       return (*env)->NewStringUTF(env,"haha");
}