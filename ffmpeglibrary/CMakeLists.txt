cmake_minimum_required(VERSION 3.4.1)


#引入头文件位置
include_directories(src/main/cpp/include/ffmpeg)
include_directories(src/main/cpp/include/owner)

find_library(
    android-lib
    android
)

find_library(
    log-lib
    log
)

find_library(
    jnigraphics-lib
    jnigraphics
)

#自己的库
add_library(
    newffmpeg
    SHARED
    src/main/cpp/ffmpeg_player.c
)

# 编解码(最重要的库)
add_library(
    avcodec
    SHARED
    IMPORTED
)

#指定编码库的位置
set_target_properties(
    avcodec
    PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libavcodec-56.so
)

#设备信息
add_library(
    avdevice
    SHARED
    IMPORTED
)

#指定设备信息的位置
set_target_properties(
    avdevice
    PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libavdevice-56.so
)

#滤镜特效处理库
add_library(
    avfilter
    SHARED
    IMPORTED
)

#指定滤镜库位置
set_target_properties(
    avfilter
    PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libavfilter-5.so
)

#封装格式处理库
add_library(
    avformat
    SHARED
    IMPORTED
)

#指定格式库路径
set_target_properties(
    avformat
    PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libavformat-56.so
)

#工具库(大部分库都需要这个库的支持)
add_library(
    avutil
    SHARED
    IMPORTED
)

#指定工具库路径
set_target_properties(
    avutil
    PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libavutil-54.so
)

#后期处理
add_library(
    postproc
    SHARED
    IMPORTED
)

#指定后期处理库路径
set_target_properties(
    postproc
    PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libpostproc-53.so
)

#数据格式转换库
add_library(
    swresample
    SHARED
    IMPORTED
)

#指定库位置
set_target_properties(
    swresample
    PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libswresample-1.so
)

#视频像素数据格式转换
add_library(
    swscale
    SHARED
    IMPORTED
)
#视频像素格式转换库位置
set_target_properties(
    swscale
    PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libswscale-3.so
)

# 将预构建库与本地库相连
target_link_libraries(
    newffmpeg
    avcodec
    avdevice
    avfilter
    avformat
    avutil
    postproc
    swresample
    swscale
    ${android-lib}
    ${jnigraphics-lib}
    ${log-lib}
)





























