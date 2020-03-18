package day_24;

import java.util.Scanner;
import java.util.Random;

public class Bingo_Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		int[][] Bingo_player1 = new int[5][5];		//5*5 2���� �迭 ����
		int[][] Bingo_player2 = new int[5][5];		//5*5 2���� �迭 ����
		
		int[] temp_player1 = new int[25];
		int[] temp_player2 = new int[25];
		// [1] temp�� 1~50������ ���� ���� 25���� �ߺ����� ����(�ߺ����ڱ���)
		// [2] 1���� temp�� ���� 2���� Bingo�� �־��ֱ�
		//��ȭ ���� 3��
		
		int i = 0;
		while(i<25)			// [1] temp�� 1~50������ ���� ���� 25���� �ߺ����� ����(�ߺ����ڱ���)
		{
			int num = ran.nextInt(50) + 1;
			
			int check = 1;
			int j = 0;
			while(j<i)
			{
				if(num==temp_player1[j])
				{
					check = -1;
				}
				j++;
			}
			
			if(check == 1)
			{
				temp_player1[i] = num;					//temp�迭�� 1-50�� �ߺ����� ���� ���� 25���� ����ִ�
				i++;
			}
		}
		
		i = 0;
		while(i<25)			// [1] temp�� 1~50������ ���� ���� 25���� �ߺ����� ����(�ߺ����ڱ���)
		{
			int num = ran.nextInt(50) + 1;
			
			int check = 1;
			int j = 0;
			while(j<i)
			{
				if(num==temp_player2[j])
				{
					check = -1;
				}
				j++;
			}
			
			if(check == 1)
			{
				temp_player2[i] = num;					//temp�迭�� 1-50�� �ߺ����� ���� ���� 25���� ����ִ�
				i++;
			}
		}
		
		int count = 0;
		for(int j=0;j<5;j++)
		{
			for(int k=0;k<5;k++)
			{
				Bingo_player1[j][k] = temp_player1[count];
				count++;
			}
		}
		
		count = 0;
		for(int j=0;j<5;j++)
		{
			for(int k=0;k<5;k++)
			{
				Bingo_player2[j][k] = temp_player2[count];
				count++;
			}
		}
		
		int p1x = 0;		int p1y = 0;
		int p2x = 0;		int p2y = 0;
		int win1 = 0;		int win2 = 0;
		int turn = 0;
		int idx1_j=0;		int idx1_k=0;
		int idx2_j=0;		int idx2_k=0;
		
		System.out.println("How many player");
		System.out.println("[1] one player [2] two player");
		int menu = sc.nextInt();
		
		while(true)
		{	
			System.out.println("==========Bingo Game==========");
			System.out.println();
			
			
			if(menu == 1)
			{
				System.out.println("player1 Bingo Board");
				
				for(int j=0;j<5;j++)					//�ߺ��Ǵ� ���ڰ� ���� ������ �ϼ�
				{
					for(int k=0;k<5;k++)
					{
						if(Bingo_player1[j][k] == 0)
						{
							System.out.print("[X ] ");
						}
					    else if(Bingo_player1[j][k] < 10)
						{
							System.out.print("["+Bingo_player1[j][k]+" ] ");
						}
						else
						{
							System.out.print("["+Bingo_player1[j][k]+"] ");
						}
						
					}
					System.out.println();
				}
				System.out.println();
			}
			else if(menu == 2)
			{
				System.out.println("player1 Bingo Board");
				
				for(int j=0;j<5;j++)					//�ߺ��Ǵ� ���ڰ� ���� ������ �ϼ�
				{
					for(int k=0;k<5;k++)
					{
						if(Bingo_player1[j][k] == 0)
						{
							System.out.print("[X ] ");
						}
					    else if(Bingo_player1[j][k] < 10)
						{
							System.out.print("["+Bingo_player1[j][k]+" ] ");
						}
						else
						{
							System.out.print("["+Bingo_player1[j][k]+"] ");
						}
						
					}
					System.out.println();
				}
				System.out.println();
				
				System.out.println("player2 Bingo Board");
				for(int j=0;j<5;j++)					//�ߺ��Ǵ� ���ڰ� ���� ������ �ϼ�
				{
					for(int k=0;k<5;k++)
					{
						if(Bingo_player2[j][k] == 0)
						{
							System.out.print("[X ] ");
						}
					    else if(Bingo_player2[j][k] < 10)
						{
							System.out.print("["+Bingo_player2[j][k]+" ] ");
						}
						else
						{
							System.out.print("["+Bingo_player2[j][k]+"] ");
						}
						
					}
					System.out.println();
				}

				System.out.println();
			}
			if(win1 == 1)				//player1 �¸�
			{
				System.out.println("player 1 �¸�!!!");
				System.out.println("������ �����ϰڽ��ϴ�");
				break;
			}
			else if(win2 == 1)				//player2 �¸�
			{
				System.out.println("player 2 �¸�!!!");
				System.out.println("������ �����ϰڽ��ϴ�");
				break;
			}
			
			if(turn%2 == 0)				//player1 ��
			{
				System.out.println("player1�� x��ǥ�� �Է��Ͽ���");
				p1x = sc.nextInt();
				System.out.println("player1�� y��ǥ�� �Է��Ͽ���");
				p1y = sc.nextInt();
				
				idx1_j = p1y;
				idx1_k = p1x;
				
				for(int j=0;j<5;j++)					//�ߺ��Ǵ� ���ڰ� ���� ������ �ϼ�
				{
					for(int k=0;k<5;k++)
					{
						if(Bingo_player1[idx1_j][idx1_j] == Bingo_player2[j][k])
						{
							idx2_j = j;
							idx2_k = k;
							Bingo_player2[idx2_j][idx2_k] = 0;
						}
					}

				}
				Bingo_player1[idx1_j][idx1_k] = 0;
	
				if(menu == 1)
				{
					turn = 0;
				}
				else if(menu == 2)
				{
					turn++;
				}
				
				//���� player1���� �����ϰ� ������ turn���� ������Ű�� ���ǹ� �ɾ��༭ Ư�� ���� �Է��ϸ� �ٽ� �޴��� ���ư��� ����� �÷��� ���ٰ�����
				//���ϰ� �ϴ� �޴��� ������ �� �� ������  -> ���� ó������ if�� ����Ͽ� �޴��� �����Ͽ� �Ȱ��� �ڵ� �ι� ����ϸ� �޸� ����� ȿ���� �������� ������?
			}
			else if(turn%2 == 1)				//player2 ��
			{
				System.out.println("player2�� x��ǥ�� �Է��Ͽ���");
				p2x = sc.nextInt();
				System.out.println("player2�� y��ǥ�� �Է��Ͽ���");
				p2y = sc.nextInt();
				
				
				idx2_j = p2y;
				idx2_k = p2x;
				for(int j=0;j<5;j++)					//�ߺ��Ǵ� ���ڰ� ���� ������ �ϼ�
				{
					for(int k=0;k<5;k++)
					{	
						if(Bingo_player1[j][k] == Bingo_player2[idx2_j][idx2_k])
						{
							idx1_j = j;
							idx1_k = k;
							Bingo_player1[idx1_j][idx1_k] = 0;
						}
					}
				}
				
				Bingo_player2[idx2_j][idx2_k] = 0;
				turn++;
			}
			
			//<���� �ϼ� �Ǳ� ���� ����>
			
			//1) ���� ���� 5��
			for(int j=0;j<5;j++)					
			{
				int bingo_check = 0;
				for(int k=0;k<5;k++)
				{
					if(Bingo_player1[j][k] == 0)
					{
						bingo_check++;
					}
				}
				if(bingo_check == 5)
				{
					win1 = 1;
				}
			}
			
			for(int j=0;j<5;j++)					
			{
				int bingo_check = 0;
				for(int k=0;k<5;k++)
				{
					if(Bingo_player2[j][k] == 0)
					{
						bingo_check++;
					}
				}
				if(bingo_check == 5)
				{
					win2 = 1;
				}
			}
			
			//2) ���� ���� 5��
			for(int k=0;k<5;k++)					
			{
				int bingo_check = 0;
				for(int j=0;j<5;j++)
				{
					if(Bingo_player1[j][k] == 0)
					{
						bingo_check++;
					}
				}
				if(bingo_check == 5)
				{
					win1 = 1;
				}
			}
			
			for(int k=0;k<5;k++)					
			{
				int bingo_check = 0;
				for(int j=0;j<5;j++)
				{
					if(Bingo_player2[j][k] == 0)
					{
						bingo_check++;
					}
				}
				if(bingo_check == 5)
				{
					win2 = 1;
				}
			}
			
			//3) �밢�� 2��
			int bingo_check = 0;
			for(int j=0;j<5;j++)					
			{
				for(int k=0;k<5;k++)
				{
					if(j == k && Bingo_player1[j][k] == 0)
					{
						bingo_check++;
					}
				}
				if(bingo_check == 5)
				{
					win1 = 1;
				}
			}
			
			bingo_check = 0;
			for(int j=0;j<5;j++)					
			{
				for(int k=0;k<5;k++)
				{
					if(j == k && Bingo_player2[j][k] == 0)
					{
						bingo_check++;
					}
				}
				if(bingo_check == 5)
				{
					win2 = 1;
				}
			}
			
			bingo_check = 0;
			for(int j=0;j<5;j++)					
			{
				if(Bingo_player1[j][4-j] == 0)
				{
					bingo_check++;
				}
				
				if(bingo_check == 5)
				{
					win1 = 1;
				}
			}
			
			bingo_check = 0;
			for(int j=0;j<5;j++)					
			{
				if(Bingo_player2[j][4-j] == 0)
				{
					bingo_check++;
				}
				
				if(bingo_check == 5)
				{
					win2 = 1;
				}
			}
			
		}
		
	}
}