package com.ashwini.Trie;

public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
    }
}

class Trie {
    TrieNode masterNode;
    public  Trie(){
        masterNode = new TrieNode();
    }

    public void insert(String s){
        TrieNode current = masterNode;
        for(char c:s.toCharArray()){
            if(current.pointers[c-'a'] == null){
                TrieNode newNode = new TrieNode();
                newNode.data = c;
                current.pointers[c-'a']=newNode;
            }
            current=current.pointers[c-'a'];
        }
        current.countOfOccurence++;
    }

    public boolean startsWith(String s){
        TrieNode current = masterNode;
        for(char c:s.toCharArray()){
            if(current.pointers[c-'a'] !=null){
                current = current.pointers[c-'a'];
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean search(String s){
        TrieNode current = masterNode;
        for(char c:s.toCharArray()){
            if(current.pointers[c-'a'] !=null){
                current = current.pointers[c-'a'];
            }else{
                return false;
            }
        }
        if(current.countOfOccurence != 0){
            return true;
        }
        return false;
    }
}

class TrieNode {
    public TrieNode(){
        pointers= new TrieNode[26];
    }
    char data;
    TrieNode[] pointers;
    Integer countOfOccurence =0;
}