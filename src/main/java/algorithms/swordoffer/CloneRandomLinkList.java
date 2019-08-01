package algorithms.swordoffer;

import java.util.HashMap;

/**
 * 复杂链表的复制
 *
 * 题目描述:
 *  输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
 *  返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * @author huliang
 * @date 2019-07-09 16:51
 */
public class CloneRandomLinkList {
    public static void main(String[] args) {

    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;

        RandomListNode head = new RandomListNode(pHead.label);
        HashMap<Integer, RandomListNode> cacheNode = new HashMap<>();

        if (pHead.random != null) {
            head.random = new RandomListNode(pHead.random.label);
            cacheNode.put(pHead.random.label, head.random);
        }

        RandomListNode prev = head;
        RandomListNode next = pHead.next;
        while (next != null) {
            int nextLabel = next.label;
            RandomListNode cloneNext;
            // 获取缓存中是否已经创建了节点
            if (cacheNode.containsKey(nextLabel)) {
                cloneNext = cacheNode.get(nextLabel);
            } else {
                cloneNext = new RandomListNode(next.label);
            }

            if (next.random != null) {
                int randomLabel = next.random.label;
                if (cacheNode.containsKey(randomLabel)) {
                    cloneNext.random = cacheNode.get(randomLabel);
                } else {
                    cloneNext.random = new RandomListNode(next.random.label);
                    cacheNode.put(randomLabel, cloneNext.random);
                }
            }

            prev.next = cloneNext;
            prev = cloneNext;
            next = next.next;
        }

        return head;
    }

}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
