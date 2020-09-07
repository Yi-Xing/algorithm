package 力扣.普通题.中等.SerialNumber347;

import java.util.*;

/**
 * @date 2020-09-05
 */
public class Solution {

    /**
     * 官方写法
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

    /**
     * 我自己的写法，思路一样，效率没官网高。
     */
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i : nums) {
            // 如果存在则+1
            map.put(i,map.getOrDefault(i,0)+1);
        }
        // 使用优先队列实现小顶堆
        Queue<Integer> priorityQueue=new PriorityQueue<>(Comparator.comparingInt(map::get));
        // 遍历map，用最小堆保存频率最大的k个元素
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(priorityQueue.size()<k){
                priorityQueue.add(entry.getKey());
            }else if(map.get(entry.getKey())>map.get(priorityQueue.peek())){
                priorityQueue.remove();
                priorityQueue.add(entry.getKey());
            }
        }
        int[] res=new int[k];
        int index=0;
        // 取出小顶堆的元素
        while (!priorityQueue.isEmpty()){
            res[index++]=priorityQueue.poll();
        }
        return res;
    }
}
