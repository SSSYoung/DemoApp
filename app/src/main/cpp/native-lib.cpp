#include <jni.h>
#include <string>
#include <stdio.h>
#include <stdlib.h>
#include <fstream>
#include <fcntl.h>
#include <sys/mman.h>
#include <sys/stat.h>
#include <unistd.h>
#include <android/log.h>

/**
 * 日志打印
 */
#define TAG "yangshuang JniLog"
// __VA_ARGS__ 代表 ...的可变参数
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, TAG, __VA_ARGS__);
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, TAG, __VA_ARGS__);
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, TAG, __VA_ARGS__);
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN, TAG, __VA_ARGS__);
#define LOGV(...) __android_log_print(ANDROID_LOG_VERBOSE, TAG, __VA_ARGS__);

char *jstringToChar(JNIEnv *env, jstring jstr) {
    char *rtn = NULL;
    jclass clsstring = env->FindClass("java/lang/String");
    jstring strencode = env->NewStringUTF("GB2312");
    jmethodID mid = env->GetMethodID(clsstring, "getBytes", "(Ljava/lang/String;)[B");
    jbyteArray barr = (jbyteArray) env->CallObjectMethod(jstr, mid, strencode);
    jsize alen = env->GetArrayLength(barr);
    jbyte *ba = env->GetByteArrayElements(barr, JNI_FALSE);
    if (alen > 0) {
        rtn = (char *) malloc(alen + 1);
        memcpy(rtn, ba, alen);
        rtn[alen] = 0;
    }
    env->ReleaseByteArrayElements(barr, ba, 0);
    return rtn;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_demoapp_jetpackdemo_JniActivity_stringFromJNI(JNIEnv *env, jobject thiz) {
    std::string hello = "Hello from C++ yangshuang";
    return env->NewStringUTF(hello.c_str());
//    char *hello = "yangshuang";
//    return env->NewStringUTF(hello);
}

int addFun(int x, int y) {
    return x + y;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_example_demoapp_jetpackdemo_JniActivity_add(JNIEnv *env, jobject thiz, jint x, jint y) {
    // TODO: implement add()
    int (*addExt)(int x, int y) = addFun;
    return addExt(x, y);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_demoapp_jetpackdemo_JniActivity_sayHello(JNIEnv *env, jobject thiz, jstring s) {
    // TODO: implement sayHello()
    //jString转化为char*
    //
    char *s2 = "i am From C";
    char *s1 = jstringToChar(env, s);
    //C标准函数字符串拼接
    strcat(s1, s2);
    //*env->NewStringUTF(env,s1);
    return env->NewStringUTF(s1);
}
extern "C"
JNIEXPORT jintArray JNICALL
Java_com_example_demoapp_jetpackdemo_JniActivity_increaseArrayEles(JNIEnv *env, jobject thiz,
                                                                   jintArray jArray) {
    // TODO: implement increaseArrayEles()
    //得到数组长度
    jsize length = env->GetArrayLength(jArray);
    //获取头指针
    jint *intArray = env->GetIntArrayElements(jArray, JNI_FALSE);
    //遍历元素
    for (int i = 0; i < length; ++i) {
        *(intArray + i) += 10;
    }

    return jArray;
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_demoapp_jetpackdemo_JniActivity_callBackAdd(JNIEnv *env, jobject thiz) {
    /**
     * 本质就是反射
     */
    //step1：得到字节码 jclass FindClass(const char* name)
    jclass jclazz = env->FindClass("com/example/demoapp/jetpackdemo/JniHelper");
    //step2:得到方法
    //jmethodID GetMethodID(jclass clazz, const char* name, const char* sig)
    //(II)I 是方法签名
    jmethodID jmethodId = env->GetMethodID(jclazz, "add", "(II)I");
    //step3:实例化该类
    //jobject AllocObject(jclass clazz)
    jobject jobject1 = env->AllocObject(jclazz);
    //step4:调用方法
    //_jtype Call##_jname##Method(jobject obj, jmethodID methodID, ...)
    jint rst = env->CallIntMethod(jobject1, jmethodId, 23, 4);
    jstring jstring1 = (*env).NewStringUTF("hello tya");
    //jstring  jstring1 = env->NewStringUTF("hello tya"); 等价于以上
    char *s1 = jstringToChar(env, jstring1);
    LOGD("jstring1 ==== %s\n", s1)
    LOGD("ret ===%d\n", rst)
}

//调用java的静态方法
extern "C"
JNIEXPORT void JNICALL
Java_com_example_demoapp_jetpackdemo_JniActivity_callStaticFromJava(JNIEnv *env, jobject thiz,
                                                                    jstring s) {
    // TODO: implement callStaticFromJava()
    jclass jclazz = env->FindClass("com/example/demoapp/jetpackdemo/JniHelper");
    jmethodID jmethodId = env->GetStaticMethodID(jclazz, "sayHello", "(Ljava/lang/String;)V");
    //jmethodID jmethodId = env->GetStaticMethodID(jclazz,"sayHello")
    //void        (*CallStaticVoidMethodV)(JNIEnv*, jclass, jmethodID, va_list);
    char *s2 = ", i am From C";
    char *s1 = jstringToChar(env, s);
    //C标准函数字符串拼接
    strcat(s1, s2);
    jstring rst = env->NewStringUTF(s1);

    env->CallStaticVoidMethod(jclazz, jmethodId, rst);
}

bool judge(char *str) {
    int length = strlen(str);
    int left = 0;
    int right = length - 1;

    while (left < right) {
        if (*(str + left) != *(str + right)) {
            return false;
        }
        left++;
        right--;
    }

    return true;
}

extern "C"
JNIEXPORT jintArray JNICALL
Java_camera2_Camera2BasicFragment_decodeYUV420SP(JNIEnv *env, jobject thiz, jbyteArray yuv420sp,
                                                 jint width, jint height, jintArray rgbOut) {
    // TODO: implement decodeYUV420SP()
    int sz;
    int i;
    int j;
    int Y;
    int Cr = 0;
    int Cb = 0;
    int pixPtr = 0;
    int jDiv2 = 0;


    int R = 0;
    int G = 0;
    int B = 0;
    int cOff;


    int w = width;
    int h = height;
    sz = w * h;
    jint *rgbData = (jint *) (env->GetPrimitiveArrayCritical(rgbOut, 0));
    jbyte *yuv = (jbyte *) env->GetPrimitiveArrayCritical(yuv420sp, 0);
    for (j = 0; j < h; j++) {
        pixPtr = j * w;
        jDiv2 = j >> 1;
        for (i = 0; i < w; i++) {
            Y = yuv[pixPtr];
            if (Y < 0) {
                Y += 255;
            }
            if ((i & 0x1) != 1) {
                cOff = sz + jDiv2 * w + (i >> 1) * 2;
                Cb = yuv[cOff];
                if (Cb < 0) {
                    Cb += 127;
                } else {
                    Cb -= 128;
                }
                Cr = yuv[cOff + 1];
                if (Cr < 0) {
                    Cr += 127;
                } else {
                    Cr -= 128;
                }
            }
            R = Y + Cr + (Cr >> 2) + (Cr >> 3) + (Cr >> 5);
            if (R < 0) {
                R = 0;
            } else if (R > 255) {
                R = 255;
            }
            G = Y - (Cb >> 2) + (Cb >> 4) + (Cb >> 5) - (Cr >> 1) + (Cr >> 3) + (Cr >> 4) +
                (Cr >> 5);
            if (G < 0) {
                G = 0;
            } else if (G > 255) {
                G = 255;
            }
            B = Y + Cb + (Cb >> 1) + (Cb >> 2) + (Cb >> 6);
            if (B < 0) {
                B = 0;
            } else if (B > 255) {
                B = 255;
            }
            //rgbData[pixPtr++] = 0xff000000 + (B << 16) + (G << 8) + R;
            rgbData[pixPtr++] = 0xff000000 + (R << 16) + (G << 8) + B;
        }
    }
    //gaussBlur(rgbData,width,height,3);
    env->ReleasePrimitiveArrayCritical(rgbOut, rgbData, 0);
    env->ReleasePrimitiveArrayCritical(yuv420sp, yuv, 0);
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_example_demoapp_JNICLearnActivity_add(JNIEnv *env, jobject thiz, jint x, jint y) {
    jclass jclazz = env->FindClass("com/example/demoapp/jetpackdemo/JniHelper");
    jmethodID jmethodId = env->GetMethodID(jclazz, "add", "(II)I");
    jobject object = env->AllocObject(jclazz);
    jint rst = env->CallIntMethod(object, jmethodId, x, y);
    return rst;
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_demoapp_JNICLearnActivity_sayHello(JNIEnv *env, jobject thiz, jstring j_string) {
    // TODO: implement sayHello()
    char *s1 = jstringToChar(env, j_string);
    char *s2 = "i am from c";
    strcat(s1, s2);
    return env->NewStringUTF(s1);
}
extern "C"
JNIEXPORT void JNICALL
Java_com_example_demoapp_JNICLearnActivity_callStaticJavaMethod(JNIEnv *env, jobject thiz,
                                                                jstring s) {
    // TODO: implement callStaticJavaMethod()
    jclass clazz = env->FindClass("com/example/demoapp/jetpackdemo/JniHelper");
    jmethodID jmethodId = env->GetStaticMethodID(clazz, "sayHello", "(Ljava/lang/String;)V");
    env->CallStaticVoidMethod(clazz, jmethodId, s);
}
extern "C"
JNIEXPORT jintArray JNICALL
Java_com_example_demoapp_JNICLearnActivity_increaseArrayInC(JNIEnv *env, jobject thiz,
                                                            jintArray array) {
    //得到数组长度
    jsize size = env->GetArrayLength(array);
    //获取头指针
    jint *head = env->GetIntArrayElements(array, 0);

    for (int i = 0; i < size; ++i) {
        *(head + i) += 10;
    }

    return array;
    //遍历元素
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_demoapp_jetpackdemo_JniActivity_getStringFromC(JNIEnv *env, jobject thiz) {
    // TODO: implement getStringFromC()
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_demoapp_jetpackdemo_JniActivity_addExtraString(JNIEnv *env, jobject thiz,
                                                                jstring origin) {
    // TODO: implement addExtraString()
}

// mmap使用
extern "C"
JNIEXPORT void JNICALL
Java_com_example_demoapp_jetpackdemo_JniActivity_mmapReadFromJNI(JNIEnv *env, jobject thiz) {
}
extern "C"
JNIEXPORT void JNICALL
Java_com_example_demoapp_jetpackdemo_JniActivity_mmapWriteToJNI(JNIEnv *env, jobject thiz) {
    LOGD("mmapWriteToJNI start")
    std::string file = "/sdcard/mybinder";
    //打开文件
    int mFD = open(file.c_str(), O_RDWR | O_CREAT, S_IRWXU);
    //获得一页内存的大小
    //Linux采用了分页来管理内存，内存的管理中，内存是以页为单位，一般的32位系统一页为4096个字节
    //mmap映射区域大小必须是物理页大小(page_size)的整倍数（32位系统中通常是4k字节）。原因是，内存的最小粒度是页，而进程虚拟地址空间和内存的映射也是以页为单位
    int m_size = getpagesize();
    LOGD("m_size ===%d\n", m_size)
    //将文件设置为msize这么大 ftruncate改变文件的大小，
    ftruncate(mFD, m_size);
    //为什么需要static_cast强制转换？ void指针->其他类型指针
    //返回值：映射区的首地址-调用成功，MAP_FALED调用失败
    char *ptr = (char*)mmap(nullptr, m_size, PROT_READ | PROT_WRITE, MAP_SHARED,
         mFD, 0);
    if (ptr == MAP_FAILED) {
        LOGE("mmap 失败 %s", strerror(errno))
    } else {
        ptr[0] = 'a';
        ptr[1] = 'b';
        LOGD("写入数据成功");
    }
//    int8_t *m_prt = static_cast<int8_t *>(mmap(nullptr, m_size, PROT_READ | PROT_WRITE, MAP_SHARED,
//                                               mFD, 0));
    //std::string data("mmap 测试代码");
    //memcpy(m_prt, data.data(), data.size());

}