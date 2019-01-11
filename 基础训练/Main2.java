import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		int n = sc1.nextInt();
		student[] s = new student[n+1];

		for(int i=1;i<=n;i++) {
			final String zkz = sc1.next();
			final int sj =sc1.nextInt();
			final int zs =sc1.nextInt();
			
			s[n].setinfo(zkz, sj, zs);
		}
		
		
		//System.out.printf(s[1].zkz + s[1].sj + s[1].zs);
		
	}
}
class student {
	String zkz;
	int sj,zs;
	void setinfo(String s1,int s2,int s3) {
		this.zkz=s1;
		this.sj=s2;
		this.zs=s3;
	}
}

