package problems.tree;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 21/10/20 23:44
 *
 * Trie implementation.
 * This trie implementation is strictly based on small case alphabetical characters.
 * This restriction on input allows us to optimize the runtime
 */
public class Trie {

    private TrieNode head;

    public Trie() {
        head = new TrieNode(' ');
    }

    public void insert(String s) {
        insert(s.toCharArray());
    }

    public boolean exist(String s) {
        return exist(s.toCharArray());
    }

    private void insert(char[] s) {
        TrieNode curr = head;
        for (char c : s) {
            TrieNode subNode = curr.subNode(c);
            if (subNode == null) {
                subNode = new TrieNode(c);
                curr.child[c - 'a'] = subNode;
            }
            curr = subNode;
        }
        curr.end = true;
    }

    private boolean exist(char[] s) {
        TrieNode curr = head;
        for (char c : s) {
            TrieNode subNode = curr.subNode(c);
            if (subNode == null)
                return false;
            else
                curr = subNode;
        }
        return curr.end;
    }

    class TrieNode {
        char c;
        boolean end = false;
        TrieNode[] child;

        public TrieNode(char c) {
            this.c = c;
            child = new TrieNode[26];
        }

        public TrieNode subNode(char c) {
            return child[c - 'a'];
        }
    }

}
