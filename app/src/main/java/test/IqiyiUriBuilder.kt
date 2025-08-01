package test

import android.net.Uri

/**
 *
 * @ProjectName:  DsvVrControl
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/2/2
 */
object IqiyiUriBuilder {
    fun buildUri(path: String, command: String, param: String): Uri {
        val builder = Uri.Builder()

        // 设置 URI 的 scheme 和 authority
        builder.scheme("iqiyi").authority("com.qiyi.video.iv")

        // 设置路径
        builder.path(path)

        // 添加查询参数
        builder.appendQueryParameter("command", command)
            .appendQueryParameter("param", param)

        // 构建 Uri 对象并返回
        return builder.build()
    }
}