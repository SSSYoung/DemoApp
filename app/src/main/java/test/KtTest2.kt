package test



class Protobuf {
//    var block:(Int)->Int = {para->
//        para * 2
//    }
}

fun isPureChinese(str: String): Boolean {
    // 匹配所有中文字符的正则表达式，包括汉字字符。
    // 这里使用了 \u4e00-\u9fa5 范围来匹配基本的汉字字符，根据需要可以扩展
    return str.matches(Regex("^[\u4e00-\u9fa5]+$"))
}

fun main() {
    val list = listOf(
        "语文",
        "打开CLTV",
        "英语"
    )

    println("hello world")

    for (example in list) {
        println("$example: ${isPureChinese(example)}")
    }
//    val message = TestData.testData
//        .newBuilder()
//        .addAllCourage(list)
//        .setName("杨爽")
//        .setPassword("123456")
//        .build()
//
//    val msg = JsonFormat.printer().print(message)
//
//
//    println(msg)
//
//    println(JsonFormat.printer().print(message))


//    val weather = WeatherOuterClass.Weather.newBuilder()
//        .setSeason(WeatherOuterClass.Weather.Season.SUMMER)
//        .setQuery(1)
//        .build()
//
//    val json = JsonFormat.printer().print(weather)
//    println(json)

//    val byteArray = weather.toByteArray()
//
//    val weather1 = WeatherOuterClass.Weather.parseFrom(byteArray)
//    println("yangshuang weather1:$weather1")
}