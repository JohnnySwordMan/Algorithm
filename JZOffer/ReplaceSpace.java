/**
 * 替换空格
 * Created by geyan on 2018/8/9.
 */
public class ReplaceSpace {

    /**
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<chars.length;i++){
            if(chars[i] != ' '){
                sb.append(chars[i]);
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }


}
