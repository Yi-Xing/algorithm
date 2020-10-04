package 力扣.普通题.中等.SerialNumber71;

import java.util.Arrays;

/**
 * @date 2020-09-05
 */
public class Solution2 {

    public String simplifyPath(String path) {
        path += '/';
        char[] chs = path.toCharArray();
        // 指针指向当前下标的字符
        int top = -1;
        for (char c : chs) {
            // 如果现在没有字符或不等于斜杠则添加
            if (top == -1 || c != '/') {
                chs[++top] = c;
                continue;
            }
            if (chs[top] == '/') {
                continue;
            }
            if (chs[top] == '.' && chs[top - 1] == '/') {
                top--;
                continue;
            }
            // 回到父级目录
            if (chs[top] == '.' && chs[top - 1] == '.' && chs[top - 2] == '/') {
                top-=2;
                while (top>0 && chs[--top]!='/');
                continue;
            }
            chs[++top] = c;
        }
        // 判断末尾是否有斜杠
        if (top > 0 && chs[top] == '/') top--;
        return new String(chs, 0, top + 1);
    }
}
