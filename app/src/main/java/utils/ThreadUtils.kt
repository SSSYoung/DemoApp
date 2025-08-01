package utils

import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

/**
 *
 * @ProjectName:  DsvVrControl
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/3/5
 */
object ThreadUtils {
    // 创建一个可缓存的线程池
    private val cachedExecutorService = Executors.newCachedThreadPool()

    private val scheduledExecutorService = Executors.newScheduledThreadPool(1)
    /**
     * 提交一个任务给线程池执行
     *
     * @param task 要执行的任务
     * @return Future<?> 可用于获取任务执行结果或取消任务
     */
    fun submit(task: Runnable): Future<*> {
        return cachedExecutorService.submit(task)
    }

    /**
     * 关闭线程池
     * 注意：关闭线程池后，将不能再向它提交任何任务
     */
    fun shutdown() {
        cachedExecutorService.shutdown()
    }

    /**
     * 提交一个Callable任务给线程池执行，并返回结果
     *
     * @param task 要执行的Callable任务
     * @return Future<T> 可用于获取任务的执行结果
     */
    fun <T> submitCallable(task: java.util.concurrent.Callable<T>): Future<T> {
        return cachedExecutorService.submit(task)
    }

    /**
     * 在后台线程中执行一个任务
     *
     * @param task 要执行的任务
     */
    fun executeOnBackground(task: Runnable) {
        cachedExecutorService.execute(task)
    }

    /**
     * 在后台线程中执行一个延时任务
     *
     * @param task 要执行的任务
     * @param delay 延迟时间
     * @param unit 延迟时间的单位
     */
    fun executeWithDelay(task: Runnable, delay: Long, unit: TimeUnit = TimeUnit.MILLISECONDS) {
        scheduledExecutorService.schedule(task, delay, unit)
    }
}