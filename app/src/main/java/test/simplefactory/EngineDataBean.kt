package test.simplefactory

/**
 *
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/2/5
 */
data class EngineDataBean(
    val context: String? = null,
    val customInnerType: String = "",
    val dmInput: String = "",
    val intentName: String = "",
    val `object`: String = "",
    val part: String = "",
    val part_raw: String = "",
    val skillId: String = "",
    val skillName: String = "",
    val taskName: String = "",
    val value: String = "",
    val module: String = "",
    val mode: String = "",
    val action: String = "",
    val type: String = "",
    val appName: String = "",
    val feature: String = "",
    val progress: String = ""
) {
    fun equalsNonEmptyStrings(other: Any?): Boolean {
        if (this === other) return true
        if (other !is EngineDataBean) return false

        val thisStrings = this.getNonEmptyStrings()
        val otherStrings = other.getNonEmptyStrings()

        return otherStrings.all { entry->
            entry.value == thisStrings[entry.key]
        }
    }

    private fun getNonEmptyStrings(): Map<String, String> {
        val fields = this.javaClass.declaredFields
        val nonEmptyStrings = mutableMapOf<String, String>()

        for (field in fields) {
            field.isAccessible = true
            val fieldName = field.name
            val fieldValue = field.get(this)

            if (field.type == String::class.java && fieldValue != null && fieldValue.toString().isNotEmpty()) {
                nonEmptyStrings[fieldName] = fieldValue.toString()
            }
        }

        return nonEmptyStrings
    }
}