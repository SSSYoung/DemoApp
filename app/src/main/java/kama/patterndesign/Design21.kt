package kama.patterndesign

/**
 *
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/6/7
 */
/**
 *
 * 责任链模式
 * 小明所在的公司请假需要在OA系统上发布申请，整个请求流程包括多个处理者，每个处理者负责处理不同范围的请假天数，
 * 如果一个处理者不能处理请求，就会将请求传递给下一个处理者，请你实现责任链模式，可以根据请求天数找到对应的处理者。
 *
 * 审批责任链由主管(Supervisor), 经理(Manager)和董事（Director)组成，他们分别能够处理3天、7天和10天的请假天数。如果超过10天，则进行否决。
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/6/7
 */
fun main() {
    val leaveRequest = LeaveRequest(
        "yangshuang",
        8
    )

    val supervisor = object : Handler() {
        override fun processLeaveRequest(request: LeaveRequest): Boolean {
            if (request.days <= 3) {
                println("${request.name} is approvaled by supervisor")
                return true
            }

            return false
        }
    }

    val manager = object : Handler() {
        override fun processLeaveRequest(request: LeaveRequest): Boolean {
            if (request.days <= 5) {
                println("${request.name} is approvaled by manager")
                return true
            }

            return false
        }
    }

    val director = object : Handler() {
        override fun processLeaveRequest(request: LeaveRequest): Boolean {
            if (request.days <= 10) {
                println("${request.name} is approvaled by director")
                return true
            } else {
                println("denied by director")
            }

            return false
        }
    }

    supervisor.setNextHandler(manager)
    manager.setNextHandler(director)

    supervisor.handleRequest(leaveRequest)
}


data class LeaveRequest(
    var name: String,
    var days: Int
)

abstract class Handler {
    private var nextHandler: Handler? = null

    fun setNextHandler(handler: Handler) {
        nextHandler = handler
    }

    fun handleRequest(request: LeaveRequest) {
        if (!processLeaveRequest(request)) {
            nextHandler?.handleRequest(request)
        }
    }

    abstract fun processLeaveRequest(request: LeaveRequest): Boolean
}