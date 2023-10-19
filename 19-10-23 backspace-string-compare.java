Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 

Constraints:

1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.
 

Follow up: Can you solve it in O(n) time and O(1) space?








  // /*
// Algorithm:
// 1. Maintain two stacks for each of the two strings which contain the final
//    resultant strings of the same.
// 2. Perform the `keyboard typing` action by iterating character by character 
//    over the input strings and putting them into their respective stacks.
// 3. During the above operation, if the `#` letter occurs, perform `pop()`
//    operation on the stacks if the stacks are not empty. Else perform `push()`
//    on the same.
// 4. Thus the stacks are left with characters of resultant strings. 
// 5. Construct the strings from the stacks and return if they are same.
// */

// class Solution {
//     public boolean backspaceCompare(String s, String t) {
//         Stack<Character> s1 = new Stack<Character>();
//         Stack<Character> s2 = new Stack<Character>();
//         for(char ch : s.toCharArray()){
//             if(ch == '#'){
//                 if(!s1.isEmpty())
//                     s1.pop();
//                 continue;
//             }
//             s1.push(ch);
//         }
//         for(char ch : t.toCharArray()){
//             if(ch == '#'){
//                 if(!s2.isEmpty())
//                     s2.pop();
//                 continue;
//             }
//             s2.push(ch);
//         }
//         String res1 = "";
//         String res2 = "";
//         while(!s1.isEmpty())
//             res1 += s1.pop();
//         while(!s2.isEmpty())
//             res2 += s2.pop();
//         return res1.equals(res2);
//     }
// }




import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        
        // Build stacks for string s
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!s1.isEmpty()) {
                    s1.pop();
                }
            } else {
                s1.push(ch);
            }
        }
        
        // Build stacks for string t
        for (char ch : t.toCharArray()) {
            if (ch == '#') {
                if (!s2.isEmpty()) {
                    s2.pop();
                }
            } else {
                s2.push(ch);
            }
        }
        
        // Compare characters directly from the stacks
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.pop() != s2.pop()) {
                return false;
            }
        }
        
        // If one stack is empty and the other is not, the strings are not equal
        return s1.isEmpty() && s2.isEmpty();
    }
}

