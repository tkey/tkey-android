#include <jni.h>
#include <tkey.h>
#include "common/jniCommon.cpp"

extern "C"
JNIEXPORT jlong JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKeyGetMetadata(
        JNIEnv *env, jobject jthis, jthrowable error) {
    int errorCode = 0;
    int *error_ptr = &errorCode;
    jlong pObject = GetPointerField(env, jthis);
    FFIThresholdKey *pThreshold = reinterpret_cast<FFIThresholdKey *>(pObject);
    Metadata *pResult = threshold_key_get_metadata(pThreshold,error_ptr);
    setErrorCode(env, error, errorCode);
    return reinterpret_cast<jlong>(pResult);
}

extern "C"
JNIEXPORT jlong JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKeyReconstruct(
        JNIEnv *env, jobject jthis, jstring curve_n, jthrowable error) {
    int errorCode = 0;
    int *error_ptr = &errorCode;
    jlong pObject = GetPointerField(env, jthis);
    FFIThresholdKey *pThreshold = reinterpret_cast<FFIThresholdKey *>(pObject);
    const char *pCurve = env->GetStringUTFChars(curve_n, JNI_FALSE);
    KeyReconstructionDetails* pResult = threshold_key_reconstruct(pThreshold, const_cast<char*>(pCurve),error_ptr);
    env->ReleaseStringUTFChars(curve_n, pCurve);
    setErrorCode(env, error, errorCode);
    return reinterpret_cast<jlong>(pResult);
}

extern "C"
JNIEXPORT jlong JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKeyGenerateNewShare(
        JNIEnv *env, jobject jthis, jstring curve_n, jthrowable error) {
    int errorCode = 0;
    int *error_ptr = &errorCode;
    jlong pObject = GetPointerField(env, jthis);
    FFIThresholdKey *pThreshold = reinterpret_cast<FFIThresholdKey *>(pObject);
    const char *pCurve = env->GetStringUTFChars(curve_n, JNI_FALSE);
    GenerateShareStoreResult* pResult = threshold_key_generate_share(pThreshold, const_cast<char*>(pCurve),error_ptr);
    env->ReleaseStringUTFChars(curve_n, pCurve);
    setErrorCode(env, error, errorCode);
    return reinterpret_cast<jlong>(pResult);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKeyDeleteShare(
        JNIEnv *env, jobject jthis, jstring share_index,
        jstring curve_n, jthrowable error) {
    int errorCode = 0;
    int *error_ptr = &errorCode;
    jlong pObject = GetPointerField(env, jthis);
    FFIThresholdKey *pThreshold = reinterpret_cast<FFIThresholdKey *>(pObject);
    const char *pCurve = env->GetStringUTFChars(curve_n, JNI_FALSE);
    const char *pIndex = env->GetStringUTFChars(share_index, JNI_FALSE);
    threshold_key_delete_share(pThreshold, const_cast<char*>(pIndex), const_cast<char*>(pCurve),error_ptr);
    env->ReleaseStringUTFChars(share_index, pIndex);
    env->ReleaseStringUTFChars(curve_n, pCurve);
    setErrorCode(env, error, errorCode);
}

extern "C"
JNIEXPORT jlong JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKeyGetKeyDetails(
        JNIEnv *env, jobject jthis, jthrowable error) {
    int errorCode = 0;
    int *error_ptr = &errorCode;
    jlong pObject = GetPointerField(env, jthis);
    FFIThresholdKey *pThreshold = reinterpret_cast<FFIThresholdKey *>(pObject);
    KeyDetails* pResult = threshold_key_get_key_details(pThreshold,error_ptr);
    setErrorCode(env, error, errorCode);
    return reinterpret_cast<jlong>(pResult);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKeyOutputShare(
        JNIEnv *env, jobject jthis, jstring share_index,
        jstring share_type, jstring curve_n,
        jthrowable error) {
    int errorCode = 0;
    int *error_ptr = &errorCode;
    jlong pObject = GetPointerField(env, jthis);
    FFIThresholdKey *pThreshold = reinterpret_cast<FFIThresholdKey *>(pObject);
    const char *pCurve = env->GetStringUTFChars(curve_n, JNI_FALSE);
    const char *pIndex = env->GetStringUTFChars(share_index, JNI_FALSE);
    const char *pShareType = nullptr;
    if (share_type != NULL) {
        pShareType = env->GetStringUTFChars(share_type, JNI_FALSE);
    }
    char *pResult = threshold_key_output_share(pThreshold, const_cast<char*>(pIndex), const_cast<char*>(pShareType), const_cast<char*>(pCurve), error_ptr);
    env->ReleaseStringUTFChars(share_index, pIndex);
    env->ReleaseStringUTFChars(curve_n, pCurve);
    if (pShareType != nullptr) {
        env->ReleaseStringUTFChars(share_type, pShareType);
    }
    setErrorCode(env, error, errorCode);
    jstring result = env->NewStringUTF(pResult);
    string_free(pResult);
    return result;
}

extern "C"
JNIEXPORT jlong JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKeyOutputShareStore(
        JNIEnv *env, jobject jthis, jstring share_index,
        jstring poly_id, jstring curve_n,
        jthrowable error) {
    int errorCode = 0;
    int *error_ptr = &errorCode;
    jlong pObject = GetPointerField(env, jthis);
    FFIThresholdKey *pThreshold = reinterpret_cast<FFIThresholdKey *>(pObject);
    const char *pCurve = env->GetStringUTFChars(curve_n, JNI_FALSE);
    const char *pIndex = env->GetStringUTFChars(share_index, JNI_FALSE);
    const char *pPolyId = nullptr;
    if (poly_id != NULL) {
        pPolyId = env->GetStringUTFChars(poly_id, JNI_FALSE);
    }
    ShareStore *pResult = threshold_key_output_share_store(pThreshold, const_cast<char*>(pIndex), const_cast<char*>(pPolyId), const_cast<char*>(pCurve), error_ptr);
    env->ReleaseStringUTFChars(share_index, pIndex);
    env->ReleaseStringUTFChars(curve_n, pCurve);
    if (pPolyId != nullptr) {
        env->ReleaseStringUTFChars(poly_id, pPolyId);
    }
    setErrorCode(env, error, errorCode);
    return reinterpret_cast<jlong>(pResult);
}

extern "C"
JNIEXPORT jlong JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKeyShareToShareStore(
        JNIEnv *env, jobject jthis, jstring share,
        jstring curve_n, jthrowable error) {
    int errorCode = 0;
    int *error_ptr = &errorCode;
    jlong pObject = GetPointerField(env, jthis);
    FFIThresholdKey *pThreshold = reinterpret_cast<FFIThresholdKey *>(pObject);
    const char *pCurve = env->GetStringUTFChars(curve_n, JNI_FALSE);
    const char *pShare = env->GetStringUTFChars(share, JNI_FALSE);
    ShareStore *pResult = threshold_key_share_to_share_store(pThreshold, const_cast<char*>(pShare), const_cast<char*>(pCurve), error_ptr);
    env->ReleaseStringUTFChars(share, pShare);
    env->ReleaseStringUTFChars(curve_n, pCurve);
    setErrorCode(env, error, errorCode);
    return reinterpret_cast<jlong>(pResult);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKeyInputShare(
        JNIEnv *env, jobject jthis, jstring share,
        jstring share_type, jstring curve_n,
        jthrowable error) {
    int errorCode = 0;
    int *error_ptr = &errorCode;
    jlong pObject = GetPointerField(env, jthis);
    FFIThresholdKey *pThreshold = reinterpret_cast<FFIThresholdKey *>(pObject);
    const char *pCurve = env->GetStringUTFChars(curve_n, JNI_FALSE);
    const char *pShare = env->GetStringUTFChars(share, JNI_FALSE);
    const char *pShareType = nullptr;
    if (share_type != NULL) {
        pShareType = env->GetStringUTFChars(share_type, JNI_FALSE);
    }
    threshold_key_input_share(pThreshold, const_cast<char*>(pShare), const_cast<char*>(pShareType), const_cast<char*>(pCurve), error_ptr);
    env->ReleaseStringUTFChars(share, pShare);
    env->ReleaseStringUTFChars(curve_n, pCurve);
    if (pShareType != nullptr) {
        env->ReleaseStringUTFChars(share_type, pShareType);
    }
    setErrorCode(env, error, errorCode);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKeyInputShareStore(
        JNIEnv *env, jobject jthis, jlong share, jthrowable error) {
    int errorCode = 0;
    int *error_ptr = &errorCode;
    jlong pObject = GetPointerField(env, jthis);
    FFIThresholdKey *pThreshold = reinterpret_cast<FFIThresholdKey *>(pObject);
    ShareStore *pShareStore = reinterpret_cast<ShareStore *>(share);
    threshold_key_input_share_store(pThreshold, pShareStore, error_ptr);
    setErrorCode(env, error, errorCode);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKeyGetShareIndexes(
        JNIEnv *env ,jobject jthis, jthrowable error) {
    int errorCode = 0;
    int *error_ptr = &errorCode;
    jlong pObject = GetPointerField(env, jthis);
    FFIThresholdKey *pThreshold = reinterpret_cast<FFIThresholdKey *>(pObject);
    char* pResult = threshold_key_get_shares_indexes(pThreshold, error_ptr);
    setErrorCode(env, error, errorCode);
    jstring result = env->NewStringUTF(pResult);
    string_free(pResult);
    return result;
}

extern "C"
JNIEXPORT jlong JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKeyGetLastFetchedCloudMetadata(
        JNIEnv *env, jobject jthis, jthrowable error) {
    int errorCode = 0;
    int *error_ptr = &errorCode;
    jlong pObject = GetPointerField(env, jthis);
    FFIThresholdKey *pThreshold = reinterpret_cast<FFIThresholdKey *>(pObject);
    Metadata* pResult = threshold_key_get_last_fetched_cloud_metadata(pThreshold, error_ptr);
    setErrorCode(env, error, errorCode);
    return reinterpret_cast<jlong>(pResult);
}

extern "C"
JNIEXPORT jlong JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKeyGetLocalMetadataTransitions(
        JNIEnv *env, jobject jthis, jthrowable error) {
    int errorCode = 0;
    int *error_ptr = &errorCode;
    jlong pObject = GetPointerField(env, jthis);
    FFIThresholdKey *pThreshold = reinterpret_cast<FFIThresholdKey *>(pObject);
    LocalMetadataTransitions* pResult = threshold_key_get_local_metadata_transitions(pThreshold, error_ptr);
    setErrorCode(env, error, errorCode);
    return reinterpret_cast<jlong>(pResult);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKeyGetTKeyStore(
        JNIEnv *env, jobject jthis, jstring module_name, jthrowable error) {
    int errorCode = 0;
    int *error_ptr = &errorCode;
    jlong pObject = GetPointerField(env, jthis);
    FFIThresholdKey *pThreshold = reinterpret_cast<FFIThresholdKey *>(pObject);
    const char *pModule = env->GetStringUTFChars(module_name, JNI_FALSE);
    char* pResult = threshold_key_get_tkey_store(pThreshold, const_cast<char*>(pModule), error_ptr);
    env->ReleaseStringUTFChars(module_name, pModule);
    setErrorCode(env, error, errorCode);
    jstring result = env->NewStringUTF(pResult);
    string_free(pResult);
    return result;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKeyGetTKeyStoreItem(
        JNIEnv *env, jobject jthis, jstring module_name,
        jstring id, jthrowable error) {
    int errorCode = 0;
    int *error_ptr = &errorCode;
    jlong pObject = GetPointerField(env, jthis);
    FFIThresholdKey *pThreshold = reinterpret_cast<FFIThresholdKey *>(pObject);
    const char *pModule = env->GetStringUTFChars(module_name, JNI_FALSE);
    const char *pId = env->GetStringUTFChars(id, JNI_FALSE);
    char* pResult = threshold_key_get_tkey_store_item(pThreshold, const_cast<char*>(pModule),const_cast<char*>(pId), error_ptr);
    env->ReleaseStringUTFChars(module_name, pModule);
    env->ReleaseStringUTFChars(id, pId);
    setErrorCode(env, error, errorCode);
    jstring result = env->NewStringUTF(pResult);
    string_free(pResult);
    return result;
}

extern "C"
JNIEXPORT void JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKeySyncLocalMetadataTransitions(
        JNIEnv *env, jobject jthis, jstring curveN, jthrowable error) {
    int errorCode = 0;
    int *error_ptr = &errorCode;
    jlong pObject = GetPointerField(env, jthis);
    FFIThresholdKey *pThreshold = reinterpret_cast<FFIThresholdKey *>(pObject);
    const char *pCurve = env->GetStringUTFChars(curveN, JNI_FALSE);
    threshold_key_sync_local_metadata_transitions(pThreshold, const_cast<char*>(pCurve), error_ptr);
    env->ReleaseStringUTFChars(curveN, pCurve);
    setErrorCode(env, error, errorCode);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKeyFree(
        JNIEnv *env, jobject jthis) {
    jlong pObject = GetPointerField(env, jthis);
    FFIThresholdKey *pThreshold = reinterpret_cast<FFIThresholdKey *>(pObject);
    threshold_key_free(pThreshold);
}

extern "C"
JNIEXPORT jlong JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKey(JNIEnv *env,
                                                                                        jobject jthis,
                                                                                        jobject metadata,
                                                                                        jobject shares,
                                                                                        jobject storage_layer,
                                                                                        jobject service_provider,
                                                                                        jobject local_transitions,
                                                                                        jobject last_fetched_cloud_metadata,
                                                                                        jboolean enable_logging,
                                                                                        jboolean manual_sync,
                                                                                        jthrowable error) {
    int errorCode = 0;
    int *error_ptr = &errorCode;
    Metadata* pMetadata = nullptr;
    if (metadata != NULL) {
        long pObject = GetPointerField(env, metadata);
        pMetadata = reinterpret_cast<Metadata *>(pObject);
    }

    ShareStorePolyIDShareIndexMap* pShares = nullptr;
    if (shares != NULL) {
        long pObject = GetPointerField(env, shares);
        pShares = reinterpret_cast<ShareStorePolyIDShareIndexMap *>(pObject);
    }

    ServiceProvider* pServiceProvider = nullptr;
    if (service_provider != NULL) {
        long pObject = GetPointerField(env, service_provider);
        pServiceProvider = reinterpret_cast<ServiceProvider *>(pObject);
    }

    LocalMetadataTransitions* pTransitions = nullptr;
    if (local_transitions != NULL) {
        long pObject = GetPointerField(env, local_transitions);
        pTransitions = reinterpret_cast<LocalMetadataTransitions *>(pObject);
    }

    Metadata* pCloudMetadata = nullptr;
    if (last_fetched_cloud_metadata!= NULL) {
        long pObject = GetPointerField(env, last_fetched_cloud_metadata);
        pCloudMetadata = reinterpret_cast<Metadata *>(pObject);
    }

    long pObject = GetPointerField(env, storage_layer);
    FFIStorageLayer* pStorage = reinterpret_cast<FFIStorageLayer *>(pObject);

    FFIThresholdKey* pThreshold = threshold_key(pMetadata, pShares, pStorage, pServiceProvider, pTransitions, pCloudMetadata, enable_logging, manual_sync, error_ptr);
    setErrorCode(env, error, errorCode);
    return reinterpret_cast<jlong>(pThreshold);
}

extern "C"
JNIEXPORT jlong JNICALL
Java_com_web3auth_tkey_1android_1distribution_ThresholdKey_ThresholdKey_jniThresholdKeyInitialize(
        JNIEnv *env, jobject jthis, jstring share, jobject input, jboolean never_initialized_new_key,
        jboolean include_local_metadata_transitions, jstring curve_n, jthrowable error) {
    int errorCode = 0;
    int *error_ptr = &errorCode;
    jlong pObject = GetPointerField(env, jthis);
    FFIThresholdKey *pThreshold = reinterpret_cast<FFIThresholdKey *>(pObject);
    const char* pShare = nullptr;
    if (share != NULL) {
        pShare = env->GetStringUTFChars(share, JNI_FALSE);
    }
    ShareStore* pInput = nullptr;
    if (input != NULL) {
        jlong lInput = GetPointerField(env, input);
        pInput = reinterpret_cast<ShareStore *>(lInput);
    }
    const char *pCurve = env->GetStringUTFChars(curve_n, JNI_FALSE);
    KeyDetails* pDetails = threshold_key_initialize(pThreshold,const_cast<char*>(pShare),pInput,never_initialized_new_key,include_local_metadata_transitions,const_cast<char*>(pCurve),error_ptr);
    env->ReleaseStringUTFChars(curve_n, pCurve);
    if (pShare != nullptr) {
        env->ReleaseStringUTFChars(share, pShare);
    }
    setErrorCode(env, error, errorCode);
    return reinterpret_cast<jlong>(pDetails);


}