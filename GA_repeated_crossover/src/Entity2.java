import java.util.Comparator;
import java.util.Arrays;
import java.util.Random;
import java.lang.Object;
import java.lang.Math;


public class Entity2 implements Comparable<Entity2> {
	
	private String ent = new String();
	
	public double fitnessNum ;
	private double fitnessProb = 0;

	
	
	//----------Constructors----------------//
	
	
	
	
	
	
	// Starting off
	public Entity2(String ent, int fcnNum,double ETC[][])
	{
		this.ent = ent;
		if(fcnNum == 1)
			Fitness1(ent,ETC);
		else
			Fitness2();
	}
	public Entity2()
	{
		ent=null;
		fitnessNum=0;
		fitnessProb = 0;
	}
	
	// Cloning
	public Entity2(Entity2 another)
	{
		this.ent = another.ent;
		this.fitnessNum = another.fitnessNum;
		this.fitnessProb = another.fitnessProb;
	}
	
	
	//----------Setters----------------//
	
	public void setEnt(String ent)
	{
		this.ent = ent;
	}
	
	
	public void setFitProb(double fitTotal)
	{
		this.fitnessProb = fitnessNum / fitTotal;
	}
	public void setFit(double fitNum)
	{
		this.fitnessNum = fitnessNum ;
	}
	
	//----------Getters----------------//
	
	public String getEnt()
	{
		return ent;
	}
	
	public double getFit(String ent,double ETC[][])
	{	
//		if(ent==null){
//			return 0;
//		}
		Fitness1(ent,ETC);
		return fitnessNum;
	}
	
	public double getFitProb()
	{
		return fitnessProb;	
	}
	
//	public double MAX(double CT[][]){
//		double max=0;
//		for(int i=0;i<100;i++){
//			for(int j=0;j<5;j++){
//				if(CT[i][j]>max){
//					max=CT[i][j];
//				}
//			}
//		}
//		return max;
//	}
	
	
	
	
	
	
	
	public static double[][] calCT(String s1,double ETC[][]){
		double[][] CT=new double[100][5];
		double[] MAT=new double[5];
		for(int i=0;i<100;i++){
			MAT=CalculateMAT(s1,i,ETC);
			for(int j=0;j<5;j++){
				
				CT[i][j]=MAT[j]+ETC[i][j];
			}
		}
		return CT;
	}
	
	
	public static double[] CalculateMAT(String s1,int j,double ETC[][]){
		
		
		int i;
		double[] MAT=new double[5];
		for(i=0;i<5;i++){
			MAT[i]=0;
		}
		for(i=0;i<j-1;i++){
			if(s1.charAt(i)=='0'){
				MAT[0]=MAT[0]+ETC[i][0];
			}
			if(s1.charAt(i)=='1'){
				MAT[1]=MAT[1]+ETC[i][1];
			}
			if(s1.charAt(i)=='2'){
				MAT[2]=MAT[2]+ETC[i][2];
			}
			if(s1.charAt(i)=='3'){
				MAT[3]=MAT[3]+ETC[i][3];
			}
			if(s1.charAt(i)=='4'){
				MAT[4]=MAT[4]+ETC[i][4];
			}
//			if(s1.charAt(i)=='5'){
//				MAT[5]=MAT[5]+ETC[i][5];
//			}
//			if(s1.charAt(i)=='6'){
//				MAT[6]=MAT[6]+ETC[i][6];
//			}
//			if(s1.charAt(i)=='7'){
//				MAT[7]=MAT[7]+ETC[i][7];
//			}
//			if(s1.charAt(i)=='8'){
//				MAT[8]=MAT[8]+ETC[i][8];
//			}
//			if(s1.charAt(i)=='9'){
//				MAT[9]=MAT[9]+ETC[i][9];
//			}
		}
		
		
		return MAT;
		
		
	}
	
	
	public static double MAX1(double TC[][]){
		double max=0;
		for(int i=0;i<100;i++){
			for(int j=0;j<5;j++){
				if(TC[i][j]>max){
					max=TC[i][j];
				}
			}
		}
		return max;
	}
	
	
	
	
	public static double Fitness1(String ent,double ETC[][])
	{	 double CT[][]=new double[100][5];
		for(int i=0;i<100;i++){
			for(int j=0;j<5;j++){
				CT[i][j]=0.0;
			}
			CT=calCT(ent,ETC);
		}
	double max=MAX1(CT);
//	System.out.println("MAXINSIDE "+max);
	return max;
	
	}
		
	
	
	
	//----------Fitness Functions----------------//
	
	// Counts number of 1's in the member
//	public double Fitness1(long arr[])
//	{	 fitnessNum=0;
//		double[] Num = new double[5];
//		
//		int i = 0;
//		for(i=0;i<5;i++){
//			Num[i]=0.0;
//		}
//		for(i = 0; i < 100 ; i ++)
//		{
//////			if( ent.charAt(i)  == '9')
//////				Num[9]  += arr[9];
//////			if( ent.charAt(i)  == '8')
////				Num[8]  += arr[8];
//////				if( ent.charAt(i)  == '7')
////					Num[7] += arr[7];
//////				if( ent.charAt(i)  == '6')
////					Num[6] += arr[6];
//////				if( ent.charAt(i)  == '5')
////					Num[5]  += arr[5];
//////				if( ent.charAt(i)  == '5')
////					Num[5]  += arr[5];
//				if( ent.charAt(i)  == '3')
//					Num[3] += arr[3];
//				if( ent.charAt(i)  == '2')
//					Num[2] += arr[2];
//				if( ent.charAt(i)  == '1')
//					Num[1]  += arr[1];
//				if( ent.charAt(i)  == '0')
//					Num[0]  += arr[0];
//		}
//		fitnessNum=max(Num);
////		System.out.println("HERE"+ fitnessNum);
//		return fitnessNum;
//	}
	
//	double max(double arr[]){
//		int i=0;
//		double high=arr[0];
//		for(i=1;i<5;i++){
//			if(arr[i]>high){
//				high=arr[i];
//			}
//		}
//		return high;
//	}
	
	// Changes the binary string into the int representation
	public void Fitness2()
	{
		fitnessNum = 0;
		
		int i = 0;
		for(i = 0; i < 100 ; i ++)
		{
			if( ent.charAt(i)  == '1')
			{
				fitnessNum += Math.pow(2, (double)i);
			}
		}
	}
	public int compareTo(Entity2 compareFruit) {
		 
		double compareQuantity = ((Entity2) compareFruit).fitnessNum; 

		//ascending order
		return (int)(this.fitnessNum - compareQuantity);
		
	}

		
		public static void sort (Entity2 arr[], int length,double ETC[][]){
//		 	int j;
//		 	Entity2 temp;
//		 	
//		 	Entity2 pop[]=new Entity2[100];
//			for(int m=0;m<100;m++){
//				pop[m].fitnessNum=Fitness1(arr[m].getEnt(),ETC);
//				pop[m].setEnt(arr[m].getEnt());
//				pop[m].setFitProb(0);
//			}
			Arrays.sort(arr);
//		for (int i = 1; i < length; i++){
//			j = i;
//			
//			while (j > 0 && Fitness1(arr[j].getEnt(),ETC) < Fitness1(arr[j-1].getEnt(),ETC)){
//				  temp = arr[j];
//				  arr[j] = arr[j-1];
//				  arr[j-1] = temp;
//				  j--;
//				  }
//			System.out.println("xxxxxx");
//			}
			
		}

	
	
	public static void main(String argv[]) {
	}
	
}
