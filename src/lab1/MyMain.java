package lab1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class MyMain {
	
	public static void main(String[] args) throws IOException {
		List<String> lists = new ArrayList<String>();
		lists = MyRead.read();
		
		List<VNode> adjustList = new AdList(lists).getAdList();
		
		while(true)
		{
			System.out.println("\n��ѡ���ܣ�������ţ���");
			System.out.println("1.չʾͼ");
			System.out.println("2.��ѯ�ŽӴ�");
			System.out.println("3.�������ı�");
			System.out.println("4.��ѯ���·");
			System.out.println("5.�������");
			System.out.println("6.�˳�����");
			Scanner input=new Scanner(System.in);
			System.out.println("��������ţ�");
			int func = input.nextInt();
			if(func == 1)
			{
				new DisplayGraph(adjustList);
			}
			else if(func == 2)
			{
				System.out.println("��������������");
				String word1 = input.next();
				String word2 = input.next();
				BridgeWords search = new BridgeWords(word1, word2, adjustList);
				search.Display();
			}
			else if(func == 3)
			{
				InsertBridgeWords insert = new InsertBridgeWords(adjustList);
				insert.DisplayResult();
			}
			else if(func == 4)
			{
				System.out.println("��������������");
				String word1 = input.next();
				String word2 = input.next();
				MyShortestPath M = new MyShortestPath(adjustList);
				String result1 = M.calcShortestPath(word1, word2);
				if(result1 != "����������δ�������ı��е�" && result1 != "���ɴ�")
						new DisplayShortestPath(result1, adjustList);
				System.out.println(result1);
			}
			else if(func == 5)
			{
				System.out.println("����quit�ֶ������������.");
				MyRandomWalk W = new MyRandomWalk(adjustList);
				String result = W.randomWalk();
				System.out.println("����·����������ansForFunc6.txt��");
				System.out.println(result);
			}
			else if(func == 6)
			{
				input.close();
				break;
			}
			else
			{
				System.out.println("������������������������");
			}
		}
		
		
		/*
		DisplayGraph G = new DisplayGraph(adjustList);
		
		
		
		BridgeWords search = new BridgeWords("to", "out", adjustList);
		search.Display();
		
		
		InsertBridgeWords insert = new InsertBridgeWords(adjustList);
		insert.DisplayResult();
		
		MyRandomWalk W = new MyRandomWalk(adjustList);
		String result = W.randomWalk();
		

		MyShortestPath M = new MyShortestPath(adjustList);
		String result1 = M.calcShortestPath("to", "out");
		DisplayShortestPath D = new DisplayShortestPath(result1, adjustList);
		
		
		//System.out.println(result);
		System.out.println(result1);
		
		*/
	}
}
