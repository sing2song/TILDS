package example1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {

	public static List<String> Solution(int[] answer) {
		// TODO Auto-generated method stub
		int[] str1= {1,2,3,4,5};
		int[] str2= {2,1,2,3,2,4,2,5};
		int[] str3= {3,3,1,1,2,2,4,4,5,5};
		int str4 = (int)(Math.random()*5)+1;//인공지능 1~5랜덤
		
		int[] score = new int[4];//정답갯수
		int[] incorect = new int[4];//오답갯수
		
		for(int i=0;i<answer.length;i++) {
			if(answer[i]==str1[i%5]) {
				score[0]++;
			}else if(answer[i]==str1[i%5]) {
				incorect[0]++;
			}
			
			if(answer[i]==str2[i%8]) {
				score[1]++;
			}else if(answer[i]==str1[i%5]) {
				incorect[1]++;
			}
			
			if(answer[i]==str3[i%10]) {
				score[2]++;
			}else if(answer[i]==str1[i%5]) {
				incorect[2]++;
			}
			
			if(answer[i]==str4) {
				score[3]++;
			}else if(answer[i]==str1[i%5]) {
				incorect[3]++;
			}
			
		}
		
		//확인용
		/*
		System.out.println("score0:"+score[0]+", incorect0:"+incorect[0]);
		System.out.println("score1:"+score[1]+", incorect1:"+incorect[1]);
		System.out.println("score2:"+score[2]+", incorect2:"+incorect[2]);
		System.out.println("score3:"+score[3]+", incorect3:"+incorect[3]);
		*/
		
		for(int i=0;i<3;i++)
			System.out.println("수포자"+(i+1) +"[ 정답 : "+score[i]+"개, 오답 : "+incorect[i]+"개]");
		System.out.println("무늬만 인공지능 [ 정답 : "+score[3]+"개, 오답 : "+incorect[3]+"개]");
		
		List<String> list = new ArrayList<>();

		String[] result=new String[4];
		
		for(int i=0;i<score.length;i++) {			
			result[i]+=(i+1)+",";
			result[i]+=score[i]+",";
			result[i]+=incorect[i]+"";
			
			list.add(result[i]);	
		}
		int max = Math.max(Math.max(Math.max(score[0], score[1]),score[2]),score[3]);
		System.out.println("가장 높은 점수는 " +max+" 입니다.");
		return list;		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("문제 수를 입력하세요 : ");
		int num=sc.nextInt();
		
		int[] answers = new int[num];
		
		for(int i=0;i<num;i++) {
			answers[i]=(int)(Math.random()*5)+1;
		}
		
		System.out.println("채점 결과입니다.");
		Solution(answers);
	
	}

}
