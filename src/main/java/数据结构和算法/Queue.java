package 数据结构和算法;

import com.sun.corba.se.spi.orbutil.threadpool.NoSuchWorkQueueException;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yuanxindong
 * @date 2020/7/10  10:38 下午
 */
public class Queue<T> {
    /**
     * 初始化队列大小
     */
    private  static final int  INIT_CAPACITY = Integer.MAX_VALUE;

    /**
     * 队列的尾部节点
     *
     */
    private  int  tail;
    /**
     * 队列的头节点
     */
    private  int  head;
    /**
     * 队列本身
     */
    private  Object[]  items;

    /**
     * 获取这个queue的值
     * @return
     */
    public Object  getQueue(){
    return Arrays.asList(items).toString();
}
    /**
     * 队列下标
      */
    private  int n = INIT_CAPACITY;


    public Queue() {
        this.items = new Object[INIT_CAPACITY];
    }

    /**
     * 自定义的队列大小
     */
    public Queue(int initSize) {
        items = new Object [initSize];
        n = initSize;
    }

    /**
     * 入队
     */
    public boolean enqueue(T item) {

        // 入队操作，将item放入队尾
            // tail == n表示队列末尾没有空间了
            if (tail == n) {
                // tail ==n && head==0，表示整个队列都占满了
                if (head == 0) {
                    return false;
                }
                // 数据搬移
                for (int i = head; i < tail; ++i) {
                    items[i-head] = items[i];
                }
                // 搬移完之后重新更新head和tail
                tail -= head;
                head = 0;
            }

            items[tail] = item;
            ++tail;
            return true;
        }

    /**
     * 出队
     * @return
     */
    public Object dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail){
            return null;
        }
        // 将队列头部拿出来
        Object ret = items[head];
        //设置为null 这段内存就会被回收
        items[head] = null;
        //头节点也就是数组的其实位置
        ++head;
        return ret;
    }

    public static void main(String[] args) {

        Queue<String> queue = new Queue<String>(10);
        for(int i = 0; i<10 ;i++){
            queue.enqueue("入队————"+i);
        }
        System.out.println(queue.getQueue());
        for(int i =0;i<5;i++){
            queue.dequeue();
        }
        System.out.println(queue.getQueue());
        for(int i = 0; i<10 ;i++){
            queue.enqueue("再入队————"+i);
        }
        System.out.println(queue.getQueue());
        }
    }

