package cn.com.weye.core.utils;

import java.util.*;

/**
 * SQL分析器
 * @author 李超（lc3）
 */
public class SqlTokenizer {

    /**
     * 子句起始关键字
     */
    public static final Collection<String> CLAUSE_KEYWORDS = Collections.unmodifiableCollection(
            new HashSet<String>(Arrays.asList("select", "from", "where", "order")));    // group by 做 where 子句，不做为单独关键字

    /**
     * 分隔符
     */
    public static final Set<Character> SPLIT_CHAR_SET =
            Collections.unmodifiableSet(new HashSet<Character>(Arrays.asList(',')));

    /**
     * 匹配字符对，如“()”，的开始字符
     */
    public static final List<Character> MATCH_START_CHAR = Collections.unmodifiableList(
            Arrays.asList('(', '\'', '"'));

    /**
     * 匹配字符对，如“()”，的结束字符
     */
    public static final List<Character> MATCH_END_CHAR = Collections.unmodifiableList(
            Arrays.asList(')', '\'', '"'));

    private int offset = 0; // 词结束偏移量
    private int prevOffset = 0; // 上一个词结束偏移量
    private int cursor = 0; // 词开始偏移量
    private final int length;
    private final String sql;

    public SqlTokenizer(String sql) {
        length = sql.length();
        this.sql = sql;
    }

    /**
     * 获得下一个词，对于括号包括的，当做一个词处理
     * @return 下一个词
     */
    public String nextWord() {
        if(0 > offset || length < offset) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = offset;
        StringBuilder rs = null;
        Deque<Character> lookupCharDeque = new LinkedList<Character>(); // 记录需要查找的结束匹配字符，如"("对应的")"
        boolean isStarted = false;  // 词是否开始
        boolean isInner = false;    // 是否在子句中，即“()”、“''”中
        while(i < length) {
            char c = sql.charAt(i++);
            if(!isInner && SPLIT_CHAR_SET.contains(c)) {    // 顶级分隔符，做为单独处理
                if(isStarted) {
                    i--;
                } else {
                    rs = new StringBuilder();
                    rs.append(c);
                }
                break;
            } else if(!isInner && Character.isWhitespace(c)) {
                if(isStarted) { // 词结束
                    break;
                } else { // 忽略词开头空白
                    continue;
                }
            } else if(!isStarted) { // 开始分析，初始化
                isStarted = true;
                cursor = i;
                rs = new StringBuilder();
            }
            if(isInner) {   // 处理词内
                char lookupChar = lookupCharDeque.peekFirst();
                if(lookupChar == c) {   // 查找最近匹配
                    lookupCharDeque.pollFirst();
                    isInner = !lookupCharDeque.isEmpty();
                    rs.append(c);
                    if(isInner) {
                        continue;
                    } else {    // 顶级子句单独处理
                        break;
                    }
                }
            }
            int idx = MATCH_START_CHAR.indexOf(c);
            if(-1 != idx) { // 是否是词内开始
                if(rs.length() > 0 && !isInner) {   // 子句单独起关键字
                    i--;
                    break;
                } else {
                    lookupCharDeque.addFirst(MATCH_END_CHAR.get(idx));
                    isInner = true;
                }
            }
            rs.append(c);
        }
        prevOffset = offset;
        offset = i;
        return null == rs ? null : rs.toString();
    }

    /**
     * 获得下一个关键字
     * @return
     */
    public String nextClauseKeyword() {
        String word = null;
        //noinspection StatementWithEmptyBody
        while(null != (word = nextWord()) &&
                !isClauseKeyword(word)) {
            // 空语句
        }
        return null == word ? null : word.toLowerCase();
    }

    /**
     * 得到最后一个词的结束偏移量
     * @return
     */
    public int getOffset() {
        return offset;
    }

    /**
     * 得到最后一个词的开始偏移量
     * @return
     */
    public int getCursor() {
        return cursor;
    }

    /**
     * 得到上一个词的结束偏移量
     * @return
     */
    public int getPrevOffset() {
        return prevOffset;
    }

    /**
     * 清除分析，从头开始
     */
    public void clean() {
        offset = 0;
        prevOffset = 0;
        cursor = 0;
    }

    /**
     * 判断关键字是否是子句开始关键字
     * @param key 关键字
     * @return
     */
    public static boolean isClauseKeyword(String key) {
        return null != key && CLAUSE_KEYWORDS.contains(key.toLowerCase());
    }

    /**
     * 得到原始SQL
     * @return
     */
    public String getSql() {
        return sql;
    }
}
