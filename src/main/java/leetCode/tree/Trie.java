package leetCode.tree;

/**
 * 208。实现trie
 */
class Trie {
    static final int ALPHABET_SIZE = 26;
    Trie[] children = new Trie[ALPHABET_SIZE];
    boolean isEndOfWorld = false;

    /** Initialize your data structure here. */
    public Trie() {
        this.isEndOfWorld = false;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            children[i] = null;
        }
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (!word.isEmpty()){
            Trie current = this;
            for (char c : word.toCharArray()) {
                int index = c -97;
                Trie child = current.children[index];
                if (child == null){
                    current.children[index] = new Trie();
                }
                current = current.children[index];
            }
            current.isEndOfWorld = true;
        }

    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word.isEmpty()){
            return false;
        }
        Trie cur = this;
        for (char c : word.toCharArray()) {
            int index = c-97;
            Trie child = cur.children[index];
            if (child == null){
                return false;
            }
            cur = cur.children[index];
        }
        return cur.isEndOfWorld;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()){
            return false;
        }
        Trie cur = this;
        for (char c : prefix.toCharArray()) {
            int index = c-97;
            Trie child = cur.children[index];
            if (child == null){
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
        System.out.println(6 & 11);
//        trie.insert("apple");
//        trie.search("apple");   // 返回 true
//        trie.search("app");     // 返回 false
//        trie.startsWith("app"); // 返回 true
//        trie.insert("app");
//        trie.search("app");     // 返回 true



    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */