package day_146;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author 王文涛
 * @date 2025/5/25
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        String[] wordlist = {"KiTe", "kite", "hare", "Hare"};
        String[] queries = {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
        spellchecker(wordlist, queries);
    }

    /**
     * 预编译正则表达式
     */
    Pattern VOWEL_PATTERN = Pattern.compile("[aeiou]");

    public String[] spellchecker(String[] wordlist, String[] queries) {

        Map<String, String> exactMatch = new HashMap<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();

        for (String word : wordlist) {
            // 精确匹配
            exactMatch.putIfAbsent(word, word);

            // 大小写不敏感匹配
            String lowerWord = word.toLowerCase();
            caseInsensitive.putIfAbsent(lowerWord, word);

            // 元音不敏感匹配
            String vowelReplaced = VOWEL_PATTERN.matcher(lowerWord).replaceAll("#");
            vowelInsensitive.putIfAbsent(vowelReplaced, word);
        }

        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            // 1. 检查精确匹配
            if (exactMatch.containsKey(query)) {
                result[i] = exactMatch.get(query);
                continue;
            }

            // 2. 检查大小写不敏感匹配
            String lowerQuery = query.toLowerCase();
            if (caseInsensitive.containsKey(lowerQuery)) {
                result[i] = caseInsensitive.get(lowerQuery);
                continue;
            }

            // 3. 检查元音不敏感匹配
            String vowelReplacedQuery = VOWEL_PATTERN.matcher(lowerQuery).replaceAll("#");
            if (vowelInsensitive.containsKey(vowelReplacedQuery)) {
                result[i] = vowelInsensitive.get(vowelReplacedQuery);
                continue;
            }

            result[i] = "";
        }

        return result;
    }

}
