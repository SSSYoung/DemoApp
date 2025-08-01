package offer

import java.util.Stack

//https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=295&tqId=23286&ru=/exam/company&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Fcompany

 class ListNodeKt(var value: Int) {
     var next: ListNodeKt? = null

     companion object {
         fun print(node: ListNodeKt?) {
             val stringBuilder = StringBuilder()
             var tmp = node
             while (tmp != null) {
                 stringBuilder.append(tmp.value).append(",")
                 tmp = tmp.next
             }
             println(stringBuilder.toString())
         }
     }
 }

object P1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *build.gradle
     * @param head ListNode类
     * @return ListNode类
     */
    fun ReverseList(head: ListNodeKt?): ListNodeKt?  {
        val stack = Stack<ListNodeKt>()
        var tmpHeader = head
        while (tmpHeader != null) {
            stack.push(tmpHeader)
            tmpHeader = tmpHeader.next
        }

        val rstHeader = stack.pop()
        var tmpRstHeader = rstHeader

        while (!stack.isEmpty()) {
            val tmpNode = stack.pop()
            tmpRstHeader.next = tmpNode
            tmpRstHeader = tmpRstHeader.next
        }

        tmpRstHeader.next = null

        return rstHeader
    }
}


fun main() {
    println("this is test")
}