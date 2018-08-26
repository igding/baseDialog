package dialog;

/**
 * <pre>
 *     author : handler
 *     e-mail : dingchao314@gmail.com
 *     time   : 2018/08/26
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ViewTool {

    /**
     * 字符串为空
     *
     * @param tag
     * @return
     */
    public static boolean isEmpty(String tag) {
        if (tag == null || "".equals(tag)) {
            return true;
        }
        return false;
    }
}
