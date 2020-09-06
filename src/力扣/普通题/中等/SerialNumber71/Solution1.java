package 力扣.普通题.中等.SerialNumber71;

import java.util.Arrays;

/**
 * @date 2020-09-05
 */
public class Solution1 {

    public String simplifyPath(String path) {
        // 首先对路径按 / 进行切割
        String[] paths = path.split("/");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/");
        for (String s : paths) {
            // 如果为两个点则向上回退
            if ("..".equals(s)) {
                // 如果为根目录则不动
                if (stringBuilder.length() != 1) {
                    // 先删除斜杠
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    for (int j = stringBuilder.length() - 1; j > 0; j--) {
                        // 只要当前字符不为斜杠则一直删除
                        if (stringBuilder.charAt(j) != '/') {
                            stringBuilder.deleteCharAt(j);
                        } else {
                            break;
                        }
                    }
                }
                // 如果字符串不为.和空字符串，则必为字符串，添加到路径中并加上斜杠
            } else if (!".".equals(s) && !"".equals(s)) {
                stringBuilder.append(s).append("/");
            }
        }
        // 如果不是跟目录，则删除最后的斜杠
        if (stringBuilder.length() != 1) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
