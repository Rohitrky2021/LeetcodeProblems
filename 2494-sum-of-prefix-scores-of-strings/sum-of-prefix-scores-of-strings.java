class Node{
    Node[] links = new Node[26];
    int countPrefix=0;
    Node(){}
    public boolean containsKey(char c){
        return links[c-'a']!=null;
    }
    public Node get(char c){
        return links[c-'a'];
    }
    public void put(char c , Node node){
        links[c-'a']=node;
    }
    public void increasePrefix(){
        countPrefix++;
    }
    public int getPrefix(){
        return countPrefix;
    }
}
public class Trie{
    private Node root;
    Trie(){
        root = new Node();
    }
    public  void insert(String s){
         Node node = root;
        for(int i=0;i<s.length();i++){
            if(!node.containsKey(s.charAt(i))){
                node.put(s.charAt(i),new Node());
            }
            node = node.get(s.charAt(i));
            node.increasePrefix();
        }
    }
    public int total_prefix(String s){
        Node node = root;
        int total=0;
        for(int i=0;i<s.length();i++){

            if(!node.containsKey(s.charAt(i))) return 0;
            node = node.get(s.charAt(i));
            total+= node.getPrefix();
        }
        return total;
    }
}
class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for(int i=0;i<words.length;i++){
            trie.insert(words[i]);
        }
        int[] answer = new int[words.length];
        for(int i=0;i<words.length;i++){
            answer[i]=trie.total_prefix(words[i]);
        }
        return answer;   
    }
}