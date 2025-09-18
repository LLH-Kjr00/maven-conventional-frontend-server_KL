#include "rwl_exp.h"
#include "RwlAdapter.h"
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <array>

using namespace std;

#ifdef __cplusplus					
extern "C" {
#endif

/*
 * Class:     com_cmt_octopus_RwlAdapter
 * Method:    InitComm
 * Signature: (III)Lcom/cmt/octopus/RwlReturn;
 */
JNIEXPORT jobject JNICALL Java_com_cmt_octopus_RwlAdapter_InitComm
  (JNIEnv *env, jobject, jint port, jint rate, jint control){
	int result = InitComm(port, rate, control);
	
	// make RwlReturn obj
	jclass cls = (env)->FindClass("com/cmt/octopus/RwlReturn");
	jobject obj = (env)->AllocObject(cls);
	jfieldID fid = (env)->GetFieldID(cls,"returnCode","I");
	env->SetIntField(obj, fid, result);
	return obj;
}

/*
 * Class:     com_cmt_octopus_RwlAdapter
 * Method:    TxnAmt
 * Signature: (IICC)Lcom/cmt/octopus/RwlReturn;
 */
JNIEXPORT jobject JNICALL Java_com_cmt_octopus_RwlAdapter_TxnAmt
  (JNIEnv *env, jobject, jint v, jint rv, jchar led, jchar sound){
	int result = TxnAmt(v, rv, led, sound);
	
	// make RwlReturn obj
	jclass cls = (env)->FindClass("com/cmt/octopus/RwlReturn");
	jobject obj = (env)->AllocObject(cls);
	jfieldID fid = (env)->GetFieldID(cls,"returnCode","I");
	env->SetIntField(obj, fid, result);
	return obj;
}

/*
 * Class:     com_cmt_octopus_RwlAdapter
 * Method:    TimeVer
 * Signature: ()Lcom/cmt/octopus/RwlReturn;
 */
JNIEXPORT jobject JNICALL Java_com_cmt_octopus_RwlAdapter_TimeVer
  (JNIEnv *env, jobject){
	/*unsigned char* ver = new unsigned char[48];
    memset(ver, 0, 48);
	int result = TimeVer(ver);
    jint cArray[11];
	for (int x = 0; x<12 ; x++){
		cArray[x] = ver[x];
	}*/
	unsigned char ver[48];
    memset(ver, 0, 48);
	int result  = TimeVer(ver);
	printf("TimeVer executed! return [%i]\n", result);
	stDevVer* theVER = (stDevVer*) ver;
	int DevID = theVER->DevID;
	int OperID = theVER->OperID;
	int DevTime = theVER->DevTime;
	int CompID = theVER->CompID;
	int KeyVer = theVER->KeyVer;
	int EODVer = theVER->EODVer;
	int BLVer = theVER->BLVer;
	int FIRMVer = theVER->FIRMVer;
	int CCHSVer = theVER->CCHSVer;
	int CSSer = theVER->CSSer;
	int IntBLVer = theVER->IntBLVer;
	int FuncBLVer = theVER->FuncBLVer;
	/*
	// make jintArray
	jintArray returnData;
    returnData = (env)-> NewIntArray(11);
	// put cArray into returnData
    (env)->SetIntArrayRegion(returnData, 0, 11, cArray);
	*/
	// make TimeVerData obj
	jclass timeVer_cls = (env)->FindClass("com/cmt/octopus/TimeVerData"); 
	jobject timeVer_obj = (env)->AllocObject(timeVer_cls);
	jfieldID fid = (env)->GetFieldID(timeVer_cls,"DevID","I");
    (env)->SetIntField(timeVer_obj, fid, DevID);
	fid = (env)->GetFieldID(timeVer_cls,"OperID","I");
    (env)->SetIntField(timeVer_obj, fid, OperID);
	fid = (env)->GetFieldID(timeVer_cls,"DevTime","I");
    (env)->SetIntField(timeVer_obj, fid, DevTime);
	fid = (env)->GetFieldID(timeVer_cls,"CompID","I");
    (env)->SetIntField(timeVer_obj, fid, CompID);
	fid = (env)->GetFieldID(timeVer_cls,"KeyVer","I");
    (env)->SetIntField(timeVer_obj, fid, KeyVer);
	fid = (env)->GetFieldID(timeVer_cls,"EODVer","I");
    (env)->SetIntField(timeVer_obj, fid, EODVer);
	fid = (env)->GetFieldID(timeVer_cls,"BLVer","I");
    (env)->SetIntField(timeVer_obj, fid, BLVer);
	fid = (env)->GetFieldID(timeVer_cls,"FIRMVer","I");
    (env)->SetIntField(timeVer_obj, fid, FIRMVer);
	fid = (env)->GetFieldID(timeVer_cls,"CCHSVer","I");
    (env)->SetIntField(timeVer_obj, fid, CCHSVer);
	fid = (env)->GetFieldID(timeVer_cls,"CSSer","I");
    (env)->SetIntField(timeVer_obj, fid, CSSer);
	fid = (env)->GetFieldID(timeVer_cls,"IntBLVer","I");
    (env)->SetIntField(timeVer_obj, fid, IntBLVer);
	fid = (env)->GetFieldID(timeVer_cls,"FuncBLVer","I");
    (env)->SetIntField(timeVer_obj, fid, FuncBLVer);
	
	// make RwlReturn obj
	jclass cls = (env)->FindClass("com/cmt/octopus/RwlReturn");
	jobject obj = (env)->AllocObject(cls);
	fid = (env)->GetFieldID(cls,"returnCode","I");
	(env)->SetIntField(obj, fid, result);
	fid = (env)->GetFieldID(cls,"returnData","Ljava/lang/Object;");
    (env)->SetObjectField(obj, fid, timeVer_obj);
	
	return obj;
}

/*
 * Class:     com_cmt_octopus_RwlAdapter
 * Method:    Poll
 * Signature: (CC)Lcom/cmt/octopus/RwlReturn;
 */
JNIEXPORT jobject JNICALL Java_com_cmt_octopus_RwlAdapter_Poll
  (JNIEnv *env, jobject, jchar sub_com, jchar timeout){
	char* card_info = new char[512];
    memset(card_info, 0, 512);
	//unsigned int result = Poll(sub_com, (unsigned char)timeout, (unsigned char)card_info);
	unsigned int result = Poll((unsigned char)sub_com, (unsigned char)timeout, card_info);
	jstring pollData = (env)->NewStringUTF(card_info);
	
	// make PollData obj
	jclass poll_cls = (env)->FindClass("com/cmt/octopus/PollData"); 
	jobject poll_obj = (env)->AllocObject(poll_cls);
	jfieldID fid = (env)->GetFieldID(poll_cls,"returnData","Ljava/lang/String;");
    (env)->SetObjectField(poll_obj, fid, pollData);
	
	// make RwlReturn obj
	jclass cls = (env)->FindClass("com/cmt/octopus/RwlReturn");
	jobject obj = (env)->AllocObject(cls);
	fid = (env)->GetFieldID(cls,"returnCode","I");
	(env)->SetIntField(obj, fid, result);
	fid = (env)->GetFieldID(cls,"returnData","Ljava/lang/Object;");
    (env)->SetObjectField(obj, fid, poll_obj);
	
	return obj;
}
    
/*
 * Class:     com_cmt_octopus_RwlAdapter
 * Method:    PollEx
 * Signature: (CC)Lcom/cmt/octopus/RwlReturn;
 */
JNIEXPORT jobject JNICALL Java_com_cmt_octopus_RwlAdapter_PollEx
    (JNIEnv *env, jobject, jchar sub_com, jchar timeout){
    char* card_info = new char[1088];
    memset(card_info, 0, 1088);
    
    unsigned int result = PollEx((unsigned char)sub_com, (unsigned char)timeout, card_info);
    jstring pollExData = (env)->NewStringUTF(card_info);
        
    // make PollExData obj
    jclass pollEx_cls = (env)->FindClass("com/cmt/octopus/PollExData");
    jobject pollEx_obj = (env)->AllocObject(pollEx_cls);
    jfieldID fid = (env)->GetFieldID(pollEx_cls, "returnData", "Ljava/lang/String;");
    (env)->SetObjectField(pollEx_obj, fid, pollExData);
    
    // make RwlReturn obj
    jclass cls = (env)->FindClass("com/cmt/octopus/RwlReturn");
    jobject obj = (env)->AllocObject(cls);
    fid = (env)->GetFieldID(cls,"returnCode","I");
    (env)->SetIntField(obj, fid, result);
    fid = (env)->GetFieldID(cls,"returnData","Ljava/lang/Object;");
    (env)->SetObjectField(obj, fid, pollEx_obj);
        
    return obj;
}

/*
 * Class:     com_cmt_octopus_RwlAdapter
 * Method:    Deduct
 * Signature: (IIII)Lcom/cmt/octopus/RwlReturn;
 */
JNIEXPORT jobject JNICALL Java_com_cmt_octopus_RwlAdapter_Deduct
  (JNIEnv *env, jobject, jint value, jint AI1, jint AI2, jint defer){
//    //jchar * array = (jchar *)(env)->GetCharArrayElements(jAI,0);
//
//    //char AI[] = {11,22,00,00,00,11,22};
//    char AI[1024];
//    memset(AI, 0, 10);
//    AI[0] = (char)AI1;
//    AI[1] = (char)AI2;
//    AI[5] = (char)AI1;
//    AI[6] = (char)AI2;
////    AI[1] = (char)AI2;
////    AI[1] = (char)AI2;
////    AI[1] = (char)AI2;
//    // add '\0' at the end of AI2
////    int length = strlen((const char *)array);
////    unsigned char* AI = (unsigned char*)malloc(length+1);
////    memcpy(AI, array, length);
////    AI[length] = '\0';
//
//    int result = Deduct(value, (unsigned char *)AI, defer);
      
      //jchar * array = (jchar *)(env)->GetCharArrayElements(jAI,0);
      
      //char AI[] = {11,22,00,00,00,11,22};
      unsigned char AI[1024];
      memset(AI, 0, 10);
      AI[0] = (char)AI1;
      AI[1] = (char)AI2;
      AI[2] = 00;
      AI[3] = 00;
      AI[4] = 00;
      AI[5] = (char)AI1;
      AI[6] = (char)AI2;
      
      
      
      // add '\0' at the end of AI2
      //  int length = strlen((const char *)array);
      //  unsigned char* AI = (unsigned char*)malloc(length+1);
      //  memcpy(AI, array, length);
      //  AI[length] = '\0';
      
      int result = Deduct(value, AI, defer);

	// make RwlReturn obj
	jclass cls = (env)->FindClass("com/cmt/octopus/RwlReturn");
	jobject obj = (env)->AllocObject(cls);
	jfieldID fid = (env)->GetFieldID(cls,"returnCode","I");
	(env)->SetIntField(obj, fid, result);
	
	// free array memory
//	env->ReleaseCharArrayElements(jAI, array, len);
//	free(AI);

	return obj;
}

/*
 * Class:     com_cmt_octopus_RwlAdapter
 * Method:    XFile
 * Signature: ()Lcom/cmt/octopus/RwlReturn;
 */
JNIEXPORT jobject JNICALL Java_com_cmt_octopus_RwlAdapter_XFile
  (JNIEnv *env, jobject){
	char * name = new char[40];
	unsigned int result = XFile(name);
	jstring fileName = (env)->NewStringUTF(name);
	
	// make XFileData obj
	jclass xfile_cls = (env)->FindClass("com/cmt/octopus/XFileData"); 
	jobject xfile_obj = (env)->AllocObject(xfile_cls);
	jfieldID fid = (env)->GetFieldID(xfile_cls,"returnData","Ljava/lang/String;");
    (env)->SetObjectField(xfile_obj, fid, fileName);
	
	// make RwlReturn obj
	jclass cls = (env)->FindClass("com/cmt/octopus/RwlReturn");
	jobject obj = (env)->AllocObject(cls);
	fid = (env)->GetFieldID(cls,"returnCode","I");
	(env)->SetIntField(obj, fid, result);
	fid = (env)->GetFieldID(cls,"returnData","Ljava/lang/Object;");
    (env)->SetObjectField(obj, fid, xfile_obj);
	
	return obj;
	
/*	jclass cls;
	jfieldID fid;
    cls = (env)->GetObjectClass(obj);
	// put return id
    fid = (env)->GetFieldID(cls, "code", "I");
    (env)->SetShortField(obj, fid, result);
	// put file name
    fid = (env)->GetFieldID(cls, "fileName", "Ljava/lang/String;");
    (env)->SetObjectField(obj, fid, fileName);
	return obj;*/
}

/*
 * Class:     com_cmt_octopus_RwlAdapter
 * Method:    Reset
 * Signature: ()Lcom/cmt/octopus/RwlReturn;
 */
JNIEXPORT jobject JNICALL Java_com_cmt_octopus_RwlAdapter_Reset
  (JNIEnv *env, jobject){
	int result = Reset();
	// make RwlReturn obj
	jclass cls = (env)->FindClass("com/cmt/octopus/RwlReturn");
	jobject obj = (env)->AllocObject(cls);
	jfieldID fid = (env)->GetFieldID(cls,"returnCode","I");
	env->SetIntField(obj, fid, result);
	return obj;
}

/*
 * Class:     com_cmt_octopus_RwlAdapter
 * Method:    WriteID
 * Signature: (I)Lcom/cmt/octopus/RwlReturn;
 */
JNIEXPORT jobject Java_com_cmt_octopus_RwlAdapter_WriteID
  (JNIEnv * env, jobject, jint id){
	int result = WriteID(id);
	// make RwlReturn obj
	jclass cls = (env)->FindClass("com/cmt/octopus/RwlReturn");
	jobject obj = (env)->AllocObject(cls);
	jfieldID fid = (env)->GetFieldID(cls,"returnCode","I");
	env->SetIntField(obj, fid, result);
	return obj;
}

/*
 * Class:     com_cmt_octopus_RwlAdapter
 * Method:    HouseKeeping
 * Signature: ()Lcom/cmt/octopus/RwlReturn;
 */
JNIEXPORT jobject JNICALL Java_com_cmt_octopus_RwlAdapter_HouseKeeping
  (JNIEnv *env, jobject){
	int result = HouseKeeping();
	// make RwlReturn obj
	jclass cls = (env)->FindClass("com/cmt/octopus/RwlReturn");
	jobject obj = (env)->AllocObject(cls);
	jfieldID fid = (env)->GetFieldID(cls,"returnCode","I");
	env->SetIntField(obj, fid, result);
	return obj;
}

/*
 * Class:     com_cmt_octopus_RwlAdapter
 * Method:    PortClose
 * Signature: ()Lcom/cmt/octopus/RwlReturn;
 */
JNIEXPORT jobject JNICALL Java_com_cmt_octopus_RwlAdapter_PortClose
  (JNIEnv *env, jobject){
	int result = PortClose();
	// make RwlReturn obj
	jclass cls = (env)->FindClass("com/cmt/octopus/RwlReturn");
	jobject obj = (env)->AllocObject(cls);
	jfieldID fid = (env)->GetFieldID(cls,"returnCode","I");
	env->SetIntField(obj, fid, result);
	return obj;
}
    
/*
 * Class:     com_cmt_octopus_RwlAdapter
 * Method:    GetExtraInfo
 * Signature: (II)Lcom/cmt/octopus/RwlReturn;
 */
JNIEXPORT jobject JNICALL Java_com_cmt_octopus_RwlAdapter_GetExtraInfo
  (JNIEnv *env, jobject, jint cmd_code, jint paras_code){
      char* extra_info = new char[512];
      memset(extra_info, 0, 512);
      
      unsigned int result = GetExtraInfo((unsigned int) cmd_code, (unsigned int)paras_code, (unsigned char*)extra_info);
      jstring extraInfoData = (env)->NewStringUTF(extra_info);
      
      // make ExtraInfoData obj
      jclass extraInfo_cls = (env)->FindClass("com/cmt/octopus/ExtraInfoData");
      jobject extraInfo_obj = (env)->AllocObject(extraInfo_cls);
      jfieldID fid = (env)->GetFieldID(extraInfo_cls, "returnData", "Ljava/lang/String;");
      (env)->SetObjectField(extraInfo_obj, fid, extraInfoData);
      
      // make RwlReturn obj
      jclass cls = (env)->FindClass("com/cmt/octopus/RwlReturn");
      jobject obj = (env)->AllocObject(cls);
      fid = (env)->GetFieldID(cls,"returnCode","I");
      (env)->SetIntField(obj, fid, result);
      fid = (env)->GetFieldID(cls,"returnData","Ljava/lang/Object;");
      (env)->SetObjectField(obj, fid, extraInfo_obj);
      
      return obj;

}

#ifdef __cplusplus
}
#endif
