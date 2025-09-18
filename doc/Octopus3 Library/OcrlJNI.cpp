#include "ocrl.h"
#include "OcrlINI.h"
#include <cstring>
#include <cstdio>

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     com_cmt_octopus_RwlAdapter
 * Method:    Connect
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_com_cmt_octopus_RwlAdapter_Connect
  (JNIEnv *env, jobject, jstring comm) {
    // Convert Java string to C string
    const char* commStr = env->GetStringUTFChars(comm, NULL);
    if (commStr == NULL) {
        return -1; // Out of memory
    }

    // Call the native function
    int result = Connect((char*)commStr);

    // Release the Java string
    env->ReleaseStringUTFChars(comm, commStr);

    return result;
}

/*
 * Class:     com_cmt_octopus_RwlAdapter
 * Method:    Disconnect
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_cmt_octopus_RwlAdapter_Disconnect
  (JNIEnv *env, jobject) {
    // Call the native function
    Disconnect();
}

/*
 * Class:     com_cmt_octopus_RwlAdapter
 * Method:    CmdExchange
 * Signature: (Ljava/lang/String;Ljava/lang/StringBuffer;I)I
 */
JNIEXPORT jint JNICALL Java_com_cmt_octopus_RwlAdapter_CmdExchange
  (JNIEnv *env, jobject, jstring reqJson, jobject respJsonBuffer, jint length) {
    // Convert Java string to C string
    const char* reqJsonStr = env->GetStringUTFChars(reqJson, NULL);
    if (reqJsonStr == NULL) {
        return -1; // Out of memory
    }

    // Allocate memory for the response JSON
    char* respJson = new char[length];
    memset(respJson, 0, length);

    // Call the native function
    int result = CmdExchange((char*)reqJsonStr, respJson, length);

    // Release the request JSON string
    env->ReleaseStringUTFChars(reqJson, reqJsonStr);

    // Set the response JSON to the Java StringBuffer
    jclass stringBufferClass = env->GetObjectClass(respJsonBuffer);
    jmethodID appendMethod = env->GetMethodID(stringBufferClass, "append", "(Ljava/lang/String;)Ljava/lang/StringBuffer;");
    if (appendMethod == NULL) {
        delete[] respJson;
        return -1; // Failed to find the append method
    }

    jstring respJsonStr = env->NewStringUTF(respJson);
    env->CallObjectMethod(respJsonBuffer, appendMethod, respJsonStr);

    // Clean up
    delete[] respJson;

    return result;
}

#ifdef __cplusplus
}
#endif
