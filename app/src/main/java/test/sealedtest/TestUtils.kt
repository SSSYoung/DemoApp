package test.sealedtest

fun String.lastChar():Char {
    return this.get(length - 1)
}

fun topLevelFunc(string: String):String {
    return "topLevelFunc"
}