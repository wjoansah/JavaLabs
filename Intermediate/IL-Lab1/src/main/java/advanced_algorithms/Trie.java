package advanced_algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {

    private static class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isWord;

        public TrieNode() {
            this.children = new HashMap<>();
            isWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        var node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        var node = root;
        for (char c : word.toCharArray()) {
            node = node.children.get(c);
            if (node == null) return false;
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        var node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) return false;
        }
        return true;
    }

    public List<String> getWordsWithPrefix(String prefix) {
        var list = new ArrayList<String>();
        var node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) return list;
        }
        findAllWords(node, new StringBuilder(prefix), list);
        return list;
    }

    private void findAllWords(TrieNode node, StringBuilder prefix, List<String> list) {
        if (node.isWord) {
            list.add(prefix.toString());
        }
        for (var c : node.children.keySet()) {
            findAllWords(node.children.get(c), prefix.append(c), list);
            prefix.deleteCharAt(prefix.length() - 1);
        }

    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apricot");
        trie.insert("banana");

        System.out.println("Search 'apple': " + trie.search("apple")); // true
        System.out.println("Search 'app': " + trie.search("app")); // true
        System.out.println("Search 'apricot': " + trie.search("apricot")); // true
        System.out.println("Search 'banana': " + trie.search("banana")); // true
        System.out.println("Search 'bat': " + trie.search("bat")); // false

        System.out.println("StartsWith 'app': " + trie.startsWith("app")); // true
        System.out.println("StartsWith 'ban': " + trie.startsWith("ban")); // true
        System.out.println("StartsWith 'cat': " + trie.startsWith("cat")); // false

        System.out.println("Words with prefix 'ap': " + trie.getWordsWithPrefix("ap")); // [apple, app, apricot]
        System.out.println("Words with prefix 'ba': " + trie.getWordsWithPrefix("ba")); // [banana]
        System.out.println("Words with prefix 'c': " + trie.getWordsWithPrefix("c")); // []
    }
}
