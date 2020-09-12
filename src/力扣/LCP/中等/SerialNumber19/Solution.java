package 力扣.LCP.中等.SerialNumber19;

/**
 * @date 2020-09-12
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumOperations("rrryyyrryyyrr"));
    }

    /**
     * 错的
     */
    public int minimumOperations(String leaves) {
        char[] array = leaves.toCharArray();
        int index = 0;
        int indexTemp = 0;
        boolean head = true;
        for (; index < array.length; index++) {
            if (array[index] == 'y') {
                break;
            }
            head = false;
        }
        indexTemp=index;
        boolean tail = true;
        int ending = array.length - 1;
        for (; ending >= index; ending--) {
            if (array[ending] == 'y') {
                break;
            }
            tail = false;
        }
//        System.out.println("头部是y"+head);
//        System.out.println("头部第一个y"+index);
//        System.out.println("尾部是y"+tail);
//        System.out.println("尾部第一个y"+ending);
        int sumHead = 0;
        // 记录y的个数
        int countY = 0;
        int countR = 0;
        // 判断有没有走捷径
        boolean isR = true;
        for (; index < ending; index++) {
            while (index <= ending && array[index] == 'y') {
                index++;
                countY++;
            }
            while (index < ending && array[index] == 'r') {
                index++;
                countR++;
            }
//            System.out.println("countR:"+countR);
//            System.out.println("countY:"+countY);
            if(countR!=0)
            if (countR <= countY) {
                sumHead += countR;
                countR=0;
                countY=countY-countR;
                isR = false;
            } else {
                sumHead += countY;
                countR=0;
                countY=0;
            }
        }
//        System.out.println("头有没有走捷径"+isR);
        // 如果有一次没走捷径,且尾部是y 就不需要+1
        if (isR && tail) {
            sumHead++;
        }

        int sumTail = 0;
        // 记录y的个数
        countY = 0;
        countR = 0;
        // 判断有没有走捷径
        isR = true;
        for (; indexTemp < ending; ending--) {
            while (indexTemp <= ending && array[ending] == 'y') {
                ending--;
                countY++;
            }
            while (indexTemp < ending && array[ending] == 'r') {
                ending--;
                countR++;
            }
//            System.out.println("countR:"+countR);
//            System.out.println("countY:"+countY);
            if(countR!=0)
            if (countR <= countY) {
                sumTail += countR;
                countR=0;
                countY=countY-countR;
                isR = false;
            } else {
                sumTail += countY;
                countR=0;
                countY=0;
            }
        }
        // 如果有一次没走捷径,且尾部是y 就不需要+1
        if (isR && head) {
//            System.out.println("====");
            sumTail++;
        }
//        System.out.println(sumHead);
//        System.out.println(sumTail);
        return Math.min(sumHead,sumTail);
    }
}
