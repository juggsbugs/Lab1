package lab1;
<<<<<<< HEAD
//qwer
=======
<<<<<<< HEAD
//aabbcc
=======
//112358
>>>>>>> C4
>>>>>>> B1
//yuan lai ni shi
import java.util.ArrayList;
import java.util.List;

class ENode
{
	int pos;
	int weight;
	ENode next;
	public ENode(int pos, int weight, ENode next){
		this.pos = pos;
		this.weight = weight;
		this.next = next;
	}
}
class VNode
{
	String word;
	ENode next;
	public VNode(String word, ENode next){
		this.word = word;
		this.next = next;
	}
}

class AdList {
	private List<VNode> AdList = new ArrayList<VNode>(); //此为返回值

	public  List<VNode> getAdList() {
		return AdList;
	}
	
	public AdList(List<String> lists){
		makeVNodeArray(lists);
		inputEdgeInfo(lists);
	}
	
	public  void inputEdgeInfo(List<String> Arr){
		for (int i = 0; i < Arr.size() - 1; i++) {
			addEdgeToList(Arr.get(i).toString(), 1, Arr.get(i + 1).toString());
		}
	}
	
	public  void addEdgeToList(String firstWord, int weight, String secondWord){
		if(judgeForAdd(firstWord, secondWord)){
			int pos_word1 = locate(firstWord);
			int pos_word2 = locate(secondWord);
			ENode e = AdList.get(pos_word1).next;
			while(e != null){
				if(e.pos == pos_word2){
					e.weight = e.weight + weight;
					break;
				}
				e = e.next;
			}
		}else{
			ENode enode = new ENode(locate(secondWord), weight, null);
			if (AdList.get(locate(firstWord)).next == null){
				AdList.get(locate(firstWord)).next = enode;
			}else{
				ENode temp = AdList.get(locate(firstWord)).next;
				while (temp.next != null){
					temp = temp.next;
				}
				temp.next = enode;
			}
		}
	}
	
	public  void makeVNodeArray(List<String> Arr){
		for (int i = 0; i < Arr.size();i++) {
			if(judge(Arr.get(i))){
				
			}else{
				AdList.add(new VNode(Arr.get(i), null));
			}
		}
		/*
		System.out.println("表头：");
		for(VNode v : AdList){
			System.out.println(v.word);
		}
		System.out.println("表尾结束");
		*/
	}
	
	public boolean judgeForAdd(String word1, String word2){
		int pos_word1 = locate(word1);
		int pos_word2 = locate(word2);
		ENode e = AdList.get(pos_word1).next;
		while(e != null){
			if(e.pos == pos_word2)
				return true;
			e = e.next;
		}
		return false;
	}
	
	public  boolean judge(String word){
		for (int i = 0; i < AdList.size(); i++) {
			if (word.equals(AdList.get(i).word)) {
				return true;
			}
		}
		return false;
	}
	
	public  int locate(String word){
		for (int pos = 0; pos < AdList.size(); pos++) {
			if(word.equals(AdList.get(pos).word)){
				return pos;
			}
		}
		return -1;
	}
}
