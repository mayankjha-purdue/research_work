
//import org.cloudbus.cloudsim.Cloudlet;
//import org.cloudbus.cloudsim.Vm;
//import java.util.ArrayList;
import java.text.DecimalFormat;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.io.*;

//import java.util.Random;
//import java.lang.Object;






public class ssGA {
	
	private static Entity2[] population;
	private static Entity2[] populationOld;
	private static Entity2[] populationcopy;
	private static Entity2[] populationnew;
	
	private static int fcnNum = 0;
	private static int popNum = 0;
	private static int gens = 0;
	private static double xover = 0;
	private static double mutation = 0;
	
	private static double fit_Total = 0;
	private static double fit_Avg = 0;
	private static double maxFitness = 0;
	
	
	
	

	
	
	
	
	
	
	
	
	
	//STSRT
	
	
	
	
	
	public static Entity2[] CrossOver(Entity2 parent1,Entity2 parent2,double ETC[][],double fitres[],int minindex,int second)
	{
		
		double minpop0=Fitness1(population[minindex].getEnt(),ETC);
		double minpop1=Fitness1(population[second].getEnt(),ETC);
					double objective1=minpop0;
					double objective2=minpop1;
					double objective3;
				double objective4;
				Entity2[] offspring=new Entity2[2];
				Entity2 ent1=new Entity2(parent1.getEnt(),0,ETC);
				Entity2 ent2=new Entity2(parent2.getEnt(),0,ETC);
//				System.out.println("parent1"+minpop0);
				
//				do{
//					String s1=null;
//				Entity2 ent1=new Entity2(parent1.getEnt(),0,arr);
//				Entity2 ent2=new Entity2(parent2.getEnt(),0,arr);
//				Entity2[] offspring=new Entity2[2];
				ent1.setEnt(parent1.getEnt());
				ent2.setEnt(parent2.getEnt());
				int count=0;
					
//					System.out.println("xxxxx");
						Random generator = new Random();
					double xoverPercent = generator.nextInt(100) + 1;
					
					xoverPercent = xoverPercent/(double)100;
					
					if(xoverPercent <= 1) // Does crossover happen between this pair?
					{
						int xoverPoint = generator.nextInt((100-1)); // crossover starts at the index after the one given
						
						String p1 = new String(parent1.getEnt());
						String p2 = new String(parent2.getEnt());
						
						ent1.setEnt(p1.substring(0,xoverPoint+1) + p2.substring(xoverPoint+1, 100));
						ent2.setEnt(p2.substring(0,xoverPoint+1) + p1.substring(xoverPoint+1, 100));
//						String parent6 = new String(population[9].getEnt());
//						System.out.println("this is the HAHAHA at     ----"+parent6);
//						
						
//						offspring[0]=parent1;
//						offspring[1]=parent2;
					
					 offspring[0]=ent1;
					 offspring[1]=ent2;
					 
//				System.out.println("child1 "+objective3);
//				 System.out.println("child2 "+objective4);
					 
//				}while(true);
//					double a=getexec(cloudletList,vmList,population,mips);
//					double b=getexec(cloudletList,vmList,populationcopy,mips);
//					if(a<b)
//					{
//					
//					for( i = 0; i < 50; i++)
//					{
//						population[i] = new Entity2(populationcopy[i]);
//					}
//					
//					}
					offspring[0].setEnt(ent1.getEnt());
					offspring[1].setEnt(ent2.getEnt());
					
					}
					return offspring;
		}
	
	
	
	
	
//	public static Entity2[] CrossOver(Entity2 parent1,Entity2 parent2,double ETC[][],double fitres[],int minindex,int second)
//	{
//		
//		double minpop0=Fitness1(population[minindex].getEnt(),ETC);
//		double minpop1=Fitness1(population[second].getEnt(),ETC);
//					double objective1=minpop0;
//					double objective2=minpop1;
//					double objective3;
//				double objective4;
//				Entity2[] offspring=new Entity2[2];
//				Entity2 ent1=new Entity2(parent1.getEnt(),0,ETC);
//				Entity2 ent2=new Entity2(parent2.getEnt(),0,ETC);
////				System.out.println("parent1"+minpop0);
//				
////				do{
////					String s1=null;
////				Entity2 ent1=new Entity2(parent1.getEnt(),0,arr);
////				Entity2 ent2=new Entity2(parent2.getEnt(),0,arr);
////				Entity2[] offspring=new Entity2[2];
//				ent1.setEnt(parent1.getEnt());
//				ent2.setEnt(parent2.getEnt());
//				int count=0;
//					do{
////					System.out.println("xxxxx");
//						Random generator = new Random();
//					double xoverPercent = generator.nextInt(100) + 1;
//					
//					xoverPercent = xoverPercent/(double)100;
//					
//					if(xoverPercent <= xover) // Does crossover happen between this pair?
//					{
//						int xoverPoint = generator.nextInt((100-1)); // crossover starts at the index after the one given
//						
//						String p1 = new String(parent1.getEnt());
//						String p2 = new String(parent2.getEnt());
//						
//						ent1.setEnt(p1.substring(0,xoverPoint+1) + p2.substring(xoverPoint+1, 100));
//						ent2.setEnt(p2.substring(0,xoverPoint+1) + p1.substring(xoverPoint+1, 100));
////						String parent6 = new String(population[9].getEnt());
////						System.out.println("this is the HAHAHA at     ----"+parent6);
////						
//						
////						offspring[0]=parent1;
////						offspring[1]=parent2;
//					}
//					 objective3=Fitness1(ent1.getEnt(),ETC);;
//					 objective4=Fitness1(ent1.getEnt(),ETC);
//					 
//					 if(objective3<=objective1 ){
//						 
////						 String sobj1=null;
//						 String sobj1=ent1.getEnt();
//						 String s7=IntelligentMutation(ETC,sobj1,fitres,minindex);
//						 ent1.setEnt(s7);
////						 System.out.println("Fitness after amnip "+Fitness1(s7,ETC));
////						 System.out.println("Fitness after amnip "+Fitness1(ent1.getEnt(),ETC));
////						 System.out.println("FitnessS after amnip "+ent1.getEnt());
//						 
//						 
//					 }
//					 if(objective4<=objective1 ){
//						 
//						 String sobj2=parent1.getEnt();
//						 String s5=IntelligentMutation(ETC,sobj2,fitres,second);
//						
//						 ent2.setEnt(s5);
////						 System.out.println("Fitness after amnip "+Fitness1(s5,ETC));
////						 System.out.println("Fitness after amnip "+Fitness1(ent2.getEnt(),ETC));
////						 System.out.println("FitnessS after amnip "+ent2.getEnt());
//						 
//						 
//					 }
////					 if( objective3<=objective2 &&  objective4<=objective2 ){
////						 break;
////					 }
////				
//					 
//					 
//					 
////					 System.out.println("Parent1 "+objective1);
////					 System.out.println("Parent2 "+objective2);
//					 
//					 if(objective2>=objective4 && objective2>=objective3  && objective1>=objective4 && objective1>=objective3 ){
//						 break;
//					 }
//					 if(count>5){
//						 break;
//					 }
//					 count++;
//				}while(true);
//					 offspring[0]=ent1;
//					 offspring[1]=ent2;
//					 
////				System.out.println("child1 "+objective3);
////				 System.out.println("child2 "+objective4);
//					 
////				}while(true);
////					double a=getexec(cloudletList,vmList,population,mips);
////					double b=getexec(cloudletList,vmList,populationcopy,mips);
////					if(a<b)
////					{
////					
////					for( i = 0; i < 50; i++)
////					{
////						population[i] = new Entity2(populationcopy[i]);
////					}
////					
////					}
//					offspring[0].setEnt(ent1.getEnt());
//					offspring[1].setEnt(ent2.getEnt());
//					return offspring;
//		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
//	public static String IntelligentMutation(double ETC[][],String s1,double fitres[],int id)
//	{	String s3=null;
//		Random generator = new Random();
//		Entity2 min=new Entity2();
//		double trackres1[]=new double[2];
////		System.out.println("S1----" +s1);
//		double trackres2=0;
////		int i = 0;
//		double mutPercent = generator.nextInt(100) + 1;
//		mutPercent = mutPercent/(double)100;
////		 i=generator.nextInt(7);
//		
////		 Entity2 mut=pop;
////		 String s1=mut.getEnt();
//		 trackres1=Fitnesssub(ETC,s1);
//		 trackres2=Change(ETC,s1);
//		 
//		 double index1;
//		 double value1;
//		 double index2;
//		 double value2;
//		 index1=trackres1[0];
//		 value1=trackres1[1];
//		 index2=trackres2;
////		 System.out.println("value1  "+value1);
////		 value2=trackres2[1];
//		 int count=0;
//		 
//			 int id1=(int)index1;
//			 int id2=(int)index2;
//			 char c1 = (char) ('0' + id1);
//			 char c2 = (char) ('0' + id2);
//			 int rand=0;
////			 int index;
//			 int pos=0;
//			 int id11=0;
//			 do{
//				 
//			   pos= s1.indexOf( c1, id11);
//			   id11=pos+1;
////			   System.out.println("Index"+c2+" "+pos+" in "+s1);
//////			 System.out.println("s1  "+s1);
////			 System.out.println("index  "+pos);
////			 StringBuilder s2 = new StringBuilder(s1);
////			 s2.setCharAt(index, c1);
//			 if(pos!=-1){
////			 System.out.println("s2  "+s2);
//			 s3=replaceCharAt( s1,  pos,  c2);
//			 String snew=s3;
//			 double fit=Fitness1(snew,ETC);
////			 System.out.println("man==" +fit);
////			 System.out.println("fitC  "+fit+ "  "+s3+"  "+rand+"  "+s1);
//			 if(fit<=value1){
////				 System.out.println("s3  "+s3);
//				 
////				 System.out.println("fitCHANGED  "+value1);
//				 fitres[id]=fit;
//				 
//				 population[id].setEnt(s3);
//				 return s3;
//			 }
//			 }
//		 if(pos==(-1) || id11>=100){
//			 break;
//		 }
////			 count++;
//			 }while(true);
//		 return s1;
//		 
//	}
//	
//	
//	
//	
//	
//	public static String replaceCharAt(String s, int pos, char c) {
//		   return s.substring(0,pos) + c + s.substring(pos+1);
//		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String IntelligentMutation(double ETC[][],String s1,double fitres[],int id)
	{	String s3=null;
		Random generator = new Random();
		Entity2 min=new Entity2();
		Entity2 ret=new Entity2();
		double trackres1[]=new double[2];
//		System.out.println("S1----" +s1);
		double trackres2=0;
//		int i = 0;
		double mutPercent = generator.nextInt(100) + 1;
		mutPercent = mutPercent/(double)100;
//		 i=generator.nextInt(7);
		
//		 Entity2 mut=pop;
//		 String s1=mut.getEnt();
		 trackres1=Fitnesssub(ETC,s1);
//		 trackres2=Change(ETC,s1);
		 int index2=generator.nextInt(5);
		 double index1;
		 double value1;
//		 double index2;
//		 double value2;
		 index1=trackres1[0];
		 value1=trackres1[1];
//		 index2=trackres2;
//		 System.out.println("value1  "+value1);
//		 value2=trackres2[1];
		 int count=0;
		 
			 int id1=(int)index1;
			 int id2=(int)index2;
			 char c1 = (char) ('0' + id1);
			 char c2 = (char) ('0' + id2);
			 int rand=0;
//			 int index;
			 int pos=0;
			 int id11=0;
			 do{
				 
			   pos= s1.indexOf( c1, id11);
			   id11=pos+1;
//			   System.out.println("Index"+c2+" "+pos+" in "+s1);
////			 System.out.println("s1  "+s1);
//			 System.out.println("index  "+pos);
//			 StringBuilder s2 = new StringBuilder(s1);
//			 s2.setCharAt(index, c1);
			 if(pos!=-1){
//			 System.out.println("s2  "+s2);
			 s3=replaceCharAt( s1,  pos,  c2);
			 String snew=s3;
			 double fit=Fitness1(snew,ETC);
//			 System.out.println("man==" +fit);
//			 System.out.println("fitC  "+fit+ "  "+s3+"  "+rand+"  "+s1);
			 
//				 System.out.println("s3  "+s3);
				 
//				 System.out.println("fitCHANGED  "+value1);
//				 fitres[id]=fit;
				 
//				 population[id].setEnt(s3);
				 return s3;
			 }
			 
		 if(pos==(-1) || id11>=100){
			 break;
		 }
//			 count++;
			 }while(true);
		 return s1;
		 
	}
	
	
	
	
	
	public static String replaceCharAt(String s, int pos, char c) {
		   return s.substring(0,pos) + c + s.substring(pos+1);
		}
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	

	
	public static double[][] calCT(String s1,double ETC[][]){
		double[][] CT=new double[100][5];
		double[] MAT=new double[5];
		
		for(int i=0;i<100;i++){
			for(int l=0;l<5;l++){
				MAT[l]=0.0;
			}
			if(i>0){
			MAT=CalculateMAT(s1,i-1,ETC);
			}
//			if(i==9){
//			for(int k=0;k<7;k++){
//			System.out.println("MATIN at"+i+" level "+k +"--"+MAT[k]);}
//			}
			
//			}
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
		if(j==0){
			return MAT;
		}
		for(i=0;i<j;i++){
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
	
	

	
	
	
	
	
	
	
	
	
	
	public static double MAX(double CT[][],String s1){
		double max=0; int[] index=new int[5];
		index[0]=s1.lastIndexOf( '0' );
		index[1]=s1.lastIndexOf( '1' );
		index[2]=s1.lastIndexOf( '2' );
		index[3]=s1.lastIndexOf( '3' );
		index[4]=s1.lastIndexOf( '4' );
//		index[5]=s1.lastIndexOf( '5' );
//		index[6]=s1.lastIndexOf( '6' );
//		index[7]=s1.lastIndexOf( '7' );
//		index[8]=s1.lastIndexOf( '8' );
//		index[9]=s1.lastIndexOf( '9' );
		
		for(int j=0;j<5;j++){
			if(index[j]!=-1){
				if(CT[index[j]][j]>max){
					max=CT[index[j]][j];
				}
			}
		}
		

		return max;
	}
	
	
	
	
	
	
	
	
	
	
	public static double Fitness1(String s1,double ETC[][])
	{	 double CT[][]=new double[100][5];
		for(int i=0;i<100;i++){
			for(int j=0;j<5;j++){
				CT[i][j]=0.0;
			}
			CT=calCT(s1,ETC);
		}
	double max=MAX(CT,s1);
//	System.out.println("MAXINSIDE "+max);
	return max;
	
	}
	
	
	
public static void main(String[] args){
		
		// Vars in GA program
		// int image=50;
//		fcnNum = Integer.parseInt(argv[0]);
//		popNum = Integer.parseInt(argv[1]);
//		gens = Integer.parseInt(argv[2]);
//		xover = Double.parseDouble(argv[3]);
//		mutation = Double.parseDouble(argv[50]);
long[] arr=new long[100];
		
		int i;
		double exec;
		boolean[] seen=new boolean[100];
//		for(i=0;i<50;i++){
//		seen[i]=false;
//		}
		double[] VM=new double[5]; 
		double[] TASK=new double[100]; 
		double[][] ETC =new double[100][5];
		double  vm=20;
		double  task=5000;
		int m=5;
		int n=100;
		for(i=0;i<5;i++){
			vm=vm+5;
			VM[i]=vm;;
		}
		for(i=0;i<100;i++){
			task=task+50;
			TASK[i]=task;
		}
		
		for(i=0;i<n;i++){
			for(int j=0;j<m;j++){
				ETC[i][j]=TASK[i]/VM[j];
				
			}
		}
		
		
		
		
		
		
		
			System.out.println("Exec Time");
			
			for(i=0;i<n;i++){
				for(int j=0;j<m;j++){
					System.out.println("Exec Time at"+i+"--"+j+" "+ETC[i][j]);
					
				}
			}
//		double[][] CT=new double[50][7];
//		CT=calCT()
		
		fcnNum =1;
		popNum = 100;
		gens = 100;
		xover = 0.8;
		mutation = 0.8;
		// Population holders
		population = new Entity2[100];
		populationOld = new Entity2[100];
		populationcopy = new Entity2[100];
		populationnew = new Entity2[100];
		double solution = 0;
		String s1 = null;
		if(fcnNum == 1)
			solution = 100;
		else if(fcnNum == 2)
			solution = 1.2676506002282297E30;
		else
		{
			System.out.println("Wrong Function Number, should be 1 or 2");
			System.exit(0);
		}
	
		MakeRandomPop(ETC);
//		sort(population, 100, ETC);
		double fitres[]=new double[100];
		for(i=0;i<100;i++){
			fitres[i]=0.0;
		}
		for(i=0;i<100;i++){
			double id=Fitness1(population[i].getEnt(),ETC);
			
			System.out.println("Pop initial at  :" +i+"   "+id);
		fitres[i]=id;
			
		}
//		double[] m1=new double[7];
//		double m2[][]=new double[100][7];
//		for(i=0;i<100;i++){
//			for(int j=0;j<7;j++){
//				m2[i][j]=0.0;
//			}
//		}
//		m2=calCT(population[0].getEnt(),ETC);
		
//		for(i=0;i<100;i++){
//			for(int j=0;j<7;j++){
//				System.out.println("CT exec time at "+i+"--"+j+" "+m2[i][j]);
//				
//			}
//		}
//		double max=MAX(m2,population[0].getEnt());
//		System.out.println("max "+max);
		
		String su="0321150320";
		int j=5;
		double[] MAT=new double[5];
		for(i=0;i<5;i++){
			MAT[i]=0;
		}
		int id1=5;
		MAT=CalculateMAT(su,id1,ETC);
		
//		for(i=0;i<50;i++){
//			if(su.charAt(i)=='0'){
//				MAT[0]=MAT[0]+ETC[i][0];
//			}
//			if(su.charAt(i)=='1'){
//				MAT[1]=MAT[1]+ETC[i][1];
//			}
//			if(su.charAt(i)=='2'){
//				MAT[2]=MAT[2]+ETC[i][2];
//			}
//			if(su.charAt(i)=='3'){
//				MAT[3]=MAT[3]+ETC[i][3];
//			}
//		}
		
		
		
//		for(i=0;i<100;i++){
//			System.out.println("MT" +population[i].getEnt());
//		}
//		
	for(i=0;i<5;i++){
		System.out.println("MAT" +MAT[i]);
	}
	
//	double[][] CT=new double[50][7];
//	
//	for( i=0;i<50;i++){
////		MAT=CalculateMAT(s1,i,ETC);
//		for( j=0;j<7;j++){
//			
//			CT[i][j]=MAT[j]+ETC[i][j];
//		}
//	}
//	
//	for(i=0;i<n;i++){
//		for( j=0;j<m;j++){
//			System.out.println("Exec Time at"+i+"--"+j+" "+CT[i][j]);
//			
//		}
//	}
	
		
		
		
		
//		double[] m1=CalculateMAT(population[i].getEnt(),5,ETC);
//		System.out.println(ETC[1].length);


		
		
		
		int trick=0;
		int ind=0;
		
		//START
		
		int currentGen = 0;
		double min=50000;
		while(true)
		{
			/*Check population for fitness levels*/
			fit_Total = 0;
			fit_Avg = 0;
			
//			Entity2 max;
			
//			max=MaxIndvl(arr);
			
			
			if(currentGen >= gens)
			{
				break;
			}
			else if(maxFitness == solution)
			{
				System.out.println("Found Solution in Gen "+(currentGen)+" :: Tot-Avg-Max-Fit1-B "+ fit_Total+" "+fit_Avg+" "+maxFitness);
				break;
			}
			
			currentGen++;
			
			System.out.println("CURRENTGEN    ----"+ currentGen);
			// Create new population
			
			// Reproduction
//			Reproduction();
			
			// Crossover
			
			
			
			
			
			
			
			
			Random generator = new Random();
			
		int count=0;
			Entity2[] parent=new Entity2[2];
			Entity2[] offspring=new Entity2[2];
//			sort(population,50,arr);
			
//					for(i = 0; i < 509; i = i++){
			for(i = 1; i < 100; i = i+2){
				
//						sort(population,100,ETC);
//						System.out.println("check");
//						ind=minindex(fitres,100,ETC);
////						parent[0]=population[ind];
//						Entity2 minpop=min(fitres,100,ETC);
//						double min1=Fitness1(minpop.getEnt(),ETC);
//						
//						if(min1<min){
//							
//									 s1=minpop.getEnt();
//									 
//									min=min1;
//									
//						}
//						System.out.println("MIN STRING "+s1);
//						System.out.println("FITNESS MIN"+ Fitness1(s1,ETC));
						int second=generator.nextInt(99)+1;	
						int first=generator.nextInt(99)+1;
						parent[0]=population[first];
						parent[1]=population[second];
//						parent[1]=population[1];
						Entity2 cross1=new Entity2(parent[0].getEnt(),0,ETC);
						Entity2 cross2=new Entity2(parent[1].getEnt(),0,ETC);

					offspring=CrossOver(cross1,cross2,ETC,fitres,ind,second);
					
					double sample1=Fitness1(offspring[0].getEnt(),ETC);
					double sample2=Fitness1(offspring[1].getEnt(),ETC);
//					int wo[]=new int[2];
////					double p1=Fitness1(parent[0].getEnt(),ETC);
////					double p2=Fitness1(parent[1].getEnt(),ETC);
////					System.out.println("child1 "+sample1);
////					System.out.println("child2 "+sample2);
////					System.out.println("parent179 "+fitres[wo[0]]);
////					System.out.println("parent178 "+fitres[wo[1]]);
//					if(sample1<sample2){
//						if(sample1<=fitres[wo[1]]){
//							population[wo[1]]=offspring[0];
//							fitres[wo[1]]=sample1;
//						}
//						else if(sample2<=fitres[wo[0]]){
//							population[wo[0]]=offspring[1];
//							fitres[wo[0]]=sample2;
//						}
//						 if(fitres[wo[0]]>=sample1){
//							population[wo[0]]=offspring[0];
//							fitres[wo[0]]=sample1;
//						}
//						
//					}
//////			population[8]=offspring[0];
//////			population[9]=offspring[1];
////					
////					
////					
//					if(sample1<=sample2){
//						if(sample2<=fitres[wo[1]]){
//							population[wo[1]]=offspring[0];
//							fitres[wo[1]]=sample2;
//						}
//						else if(sample1<=fitres[wo[0]]){
//							population[wo[0]]=offspring[1];
//							fitres[wo[0]]=sample1;
//						}
//						 if(fitres[wo[0]]>=sample2){
//							population[wo[0]]=offspring[0];
//							fitres[wo[0]]=sample2;
//						}
//						
//					}
////					
////					System.out.println("parent99 "+Fitness1(population[99].getEnt(),ETC));
////					System.out.println("parent98 "+Fitness1(population[73].getEnt(),ETC));
////					
					
			// Mutation
//			Mutation();
//					sort(population,100,ETC);
//					for(i=0;i<100;i++){
//						double id=Fitness1(population[i].getEnt(),ETC);
////						System.out.println("Fitnessinside  :"+i+"  "+id);
//					}
//			

							
							
							
							
							
					Random generator2 = new Random();
					
					int id = 0;
//					double mutPercent = generator2.nextInt(70) ;
					//id=minindex(fitres,100,ETC);
					 id=generator.nextInt(100);
					
					 Entity2 mut=population[id];
					 Entity2 mut1=population[id];
					 double get=fitres[id];
					//System.out.println("ID MUTATION --"+id);
//					System.out.println("FITB4 MUTATION --"+get);
					
//							Entity2 now=Mutation(arr,mut,mut.getFit(arr));
					String s7=mut.getEnt();
					
					String s5=IntelligentMutation(ETC,s7,fitres,id);
					double IDFIT=Fitness1(s5,ETC);
//					System.out.println("ID FIT --"+IDFIT);
					
					
					int ind2=worstind(population,100,ETC);
					if(fitres[ind2]> IDFIT){
						population[ind2].setEnt(s5);
						fitres[ind2]=IDFIT;
					}
							
							
							
					}
//			sort(population,100,ETC);
					
			
			
			
			
			
			
			
			
			
			
			
			
			
			
					
		}


	
		
		
			
				int maxid=0;

//				sort(population,100,ETC);
//			String parent2 = new String(population[0].getEnt());
				int min1=minindex(fitres,100,ETC);
				
				String parent2=population[min1].getEnt();
//				for(i=0;i<50;i++){
//				String after=IntelligentMutation(ETC,s1,fitres,0);
////				s1=after;
//			parent2=after;
			
//			for(i=0;i<100;i++){
//				double id=Fitness1(population[i].getEnt(),ETC);
//				System.out.println("Fitnessoutside  :"+i+"  "+id);
//				fitres[i]=id;
//			}
			System.out.println("this is the best generation     "+parent2);
//			for(i=0;i<n;i++){
//				for( j=0;j<m;j++){
//					System.out.println("Exec Time at"+i+"--"+j+" "+ETC[i][j]);
//					
//				}
//			}
			char letter = parent2.charAt(8);
			double p = Fitness1(population[9].getEnt(),ETC);
			double pp = Fitness1(population[9].getEnt(),ETC);
//			System.out.println("FITNESS");
			for(i=0;i<100;i++){
//				System.out.println("Fitness at " +i+" Level--"+populationnew[i].getFit(arr));
			}
			
//			System.out.println("this is the first at     ----"+parent2+"  first     "+letter+"    fitness----"+p+" "+pp);
			int[] res =  new int[100];;
			
		     int t;
			for( t=0;t<100;t++){
			
				char letter1 = parent2.charAt(t);
				res[t]=(int)(letter1- '0');
				
				
			}
//			System.out.println("THIS IS THE MAKESPAN  "+population[0].getFit(arr));
			String s=parent2;
			Entity2 print=new Entity2();
			print.setEnt(s);
			double in=Fitness1(print.getEnt(),ETC);
			System.out.println("IN"+in);

			
			
//			return res;
		
	}
	

	
	

public static double[] Fitnesssub(double ETC[][],String ent)
{	 double[] fitnessNum=new double[2];
	double id=0;
	double max=Fitness1(ent,ETC);
	double m3[][]=new double[100][5];
	for(int i=0;i<100;i++){
		for(int l=0;l<5;l++){
			m3[i][l]=0.0;
		}
	}
	
		m3=calCT(ent,ETC);
		for(int i=0;i<100;i++){
			for(int l=0;l<5;l++){
				if(m3[i][l]==max){
					id=l;
				}
			}
		}
		fitnessNum[0]=id;
		fitnessNum[1]=max;
		return fitnessNum;
			
	
}
public static void sort (Entity2 arr[], int length,double ETC[][]){
// 	int j;
// 	Entity2 temp;
// 	
// 	Entity2 pop[]=new Entity2[100];
//	for(int m=0;m<100;m++){
//		pop[m].fitnessNum=Fitness1(arr[m].getEnt(),ETC);
//		pop[m].setEnt(arr[m].getEnt());
//		pop[m].setFitProb(0);
//	}
	Arrays.sort(arr);
//for (int i = 1; i < length; i++){
//	j = i;
//	
//	while (j > 0 && Fitness1(arr[j].getEnt(),ETC) < Fitness1(arr[j-1].getEnt(),ETC)){
//		  temp = arr[j];
//		  arr[j] = arr[j-1];
//		  arr[j-1] = temp;
//		  j--;
//		  }
//	System.out.println("xxxxxx");
//	}
	
}


public static double Change(double ETC[][],String s1)
{	 double[] fitnessNum=new double[2];
	double id=0;
//	double max=Fitness1(s1,ETC);
	double m3[][]=new double[100][5];
	for(int i=0;i<100;i++){
		for(int l=0;l<5;l++){
			m3[i][l]=0.0;
		}
	}
	double index1=0;
		m3=calCT(s1,ETC);
		double index[]=new double[5];
		double min=50000; 
		index[0]=(double)s1.lastIndexOf( '0' );
		index[1]=(double)s1.lastIndexOf( '1' );
		index[2]=(double)s1.lastIndexOf( '2' );
		index[3]=(double)s1.lastIndexOf( '3' );
		index[4]=(double)s1.lastIndexOf( '4' );
//		index[5]=(double)s1.lastIndexOf( '5' );
//		index[6]=(double)s1.lastIndexOf( '6' );
//		index[7]=(double)s1.lastIndexOf( '7' );
//		index[8]=(double)s1.lastIndexOf( '8' );
//		index[9]=(double)s1.lastIndexOf( '9' );
		
		for(int j=0;j<5;j++){
			if(index[j]!=-1){
				if(m3[(int) index[j]][j]<min){
					min=m3[(int) index[j]][j];
					index1=j;
				}
			}
		}
		
		return index1;
			
	
}



static double[] min(double arr[]){
	int i=0;
	double result[]=new double[2];
	double index=0;
	double high=arr[0];
	for(i=1;i<100;i++){
		if(arr[i]<high){
			high=arr[i];
			index=i;
		}
	}
	result[0]=index;
	result[1]=high;
	return result;
}

static double max(double arr[]){
	int i=0;
	double high=arr[0];
	for(i=1;i<100;i++){
		if(arr[i]>high){
			high=arr[i];
		}
	}
	return high;
}
	
	
static double[] maxind(double arr[]){
	int i=0;
	double index=0;
	double[] result=new double[2];
	double high=arr[0];
	for(i=1;i<100;i++){
		if(arr[i]>high){
			high=arr[i];
			index=i;
		}
	}
	result[0]=index;
	result[1]=high;
	return result;
}	
	
//public int compareTo(Entity compareFruit) {
//	 
//	int compareQuantity = ((Fruit) compareFruit).getQuantity(); 
//
//	//ascending order
//	return this.quantity - compareQuantity;
//	
	

	
//	public static void sort (Entity2 arr[], int length,double ETC[][]){
//	 	int j;
//	 	Entity2 temp;
//	 	
//	 	Entity2 pop[]=new Entity2[100];
//		for(int m=0;m<100;m++){
//			pop[m].fitnessNum=Fitness1(arr[m].getEnt(),ETC);
//			pop[m].setEnt(arr[m].getEnt());
//			pop[m].setFitProb(0);
//		}
//	for (int i = 1; i < length; i++){
//		j = i;
//		
//		while (j > 0 && Fitness1(arr[j].getEnt(),ETC) < Fitness1(arr[j-1].getEnt(),ETC)){
//			  temp = arr[j];
//			  arr[j] = arr[j-1];
//			  arr[j-1] = temp;
//			  j--;
//			  }
//		System.out.println("xxxxxx");
//		}
//	}
public static Entity2 min (double arr[], int length,double ETC[][]){
 	
 	Entity2 temp=new Entity2();
 	double id0=arr[0] ;
 	temp.setFitProb(0);
 	temp.setEnt(population[0].getEnt());
 	
 	
 
	for(int m=1;m<100;m++){
		
		if(arr[m]<id0){
		temp.setEnt(population[m].getEnt());
		id0=arr[m];
		}
	}
//	System.out.println("MINS--- " +temp.getEnt());
	System.out.println("MIN--- " +Fitness1(temp.getEnt(), ETC));
return temp;
}





public static int minindex (double arr[], int length,double ETC[][]){
 	
 	Entity2 temp=new Entity2();
 	int index=0;
 	double id0=arr[0] ;
 	temp.setFitProb(0);
 	temp.setEnt(population[0].getEnt());
 	
 	
 
	for(int m=1;m<100;m++){
		
		if(arr[m]<id0){
		temp.setEnt(population[m].getEnt());
		id0=arr[m];
		index=m;
		}
	}
//	System.out.println("MINindex--- " +Fitness1(temp.getEnt(), ETC));
return index;
}








//public static Entity2[] worst (Entity2 arr[], int length,double ETC[][]){
// 	
// 	Entity2 temp[]=new Entity2[2];
// 	double id0=Fitness1(arr[0].getEnt(),ETC);
// 	double id1=Fitness1(arr[1].getEnt(),ETC);
// 	temp[0].setFitProb(0);
// 	temp[1].setFitProb(0);
// 	if(id0<id1){
// 	temp[0].setEnt(arr[0].getEnt());
// 	temp[1].setEnt(arr[1].getEnt());
// 	}
// 	else{
// 		temp[0].setEnt(arr[1].getEnt());
// 	 	temp[1].setEnt(arr[0].getEnt());
// 	}
// 	
// 	
// 
//	for(int m=1;m<100;m++){
//		double id= Fitness1(arr[m].getEnt(),ETC) ;
//		if(id<id0){
//			String s1=temp[0].getEnt();
//		temp[0].setEnt(arr[m].getEnt());
//		temp[1].setEnt(s1);
//		id0=id;
//		id1=id0;
//		}
//		else if(id<id1 && id>id0 ){
//			String s1=temp[1].getEnt();
//			temp[1].setEnt(s1);
//			id1=id;
//		}
//	}
//return temp;
//}



//public static int[] worst (Entity2 arr[], int length,double ETC[][]){
// 	int index[]=new int[2];
// 	Entity2 temp[]=new Entity2[2];
// 	double id0=Fitness1(arr[0].getEnt(),ETC);
// 	double id1=Fitness1(arr[1].getEnt(),ETC);
// 	temp[0].setFitProb(0);
// 	temp[1].setFitProb(0);
// 	if(id0>id1){
// 	temp[0].setEnt(arr[0].getEnt());
// 	index[0]=0;
// 	index[1]=1;
// 	temp[1].setEnt(arr[1].getEnt());
// 	}
// 	else{
// 		temp[0].setEnt(arr[1].getEnt());
// 	 	temp[1].setEnt(arr[0].getEnt());
// 	 	index[0]=0;
// 	 	index[1]=1;
// 	}
// 	
// 	
// 
//	for(int m=1;m<100;m++){
//		double id= Fitness1(arr[m].getEnt(),ETC) ;
//		if(id<id0){
//			String s1=temp[0].getEnt();
//		temp[0].setEnt(arr[m].getEnt());
//		temp[1].setEnt(s1);
//		id0=id;
//		index[1]=index[0];
//		index[0]=m;
//		
//		id1=id0;
//		}
//		else if(id<id1 && id>id0 ){
//			String s1=temp[1].getEnt();
//			temp[1].setEnt(s1);
//			id1=id;
//			index[1]=m;
//		}
//	}
//return index;
//}

public static int worstind (Entity2 arr[], int length,double ETC[][]){
 	int index=0;
 	Entity2 temp=new Entity2();
 	double id0=Fitness1(arr[0].getEnt(),ETC);
// 	double id1=Fitness1(arr[1].getEnt(),ETC);
 	temp.setFitProb(0);
 	temp.setEnt(arr[0].getEnt());

 	
 	
 
	for(int m=1;m<100;m++){
		double id= Fitness1(arr[m].getEnt(),ETC) ;
		if(id>id0){
//			String s1=temp[0].getEnt();
		temp.setEnt(arr[m].getEnt());
//		temp[1].setEnt(s1);
		id0=id;
		index=m;

		
		}
	}
return index;
}


public static Entity2 worst (Entity2 arr[], int length,double ETC[][]){
 	int index=0;
 	Entity2 temp=new Entity2();
 	double id0=Fitness1(arr[0].getEnt(),ETC);
// 	double id1=Fitness1(arr[1].getEnt(),ETC);
 	temp.setFitProb(0);
 	temp.setEnt(arr[0].getEnt());

 	
 	
 
	for(int m=1;m<100;m++){
		double id= Fitness1(arr[m].getEnt(),ETC) ;
		if(id>id0){
//			String s1=temp[0].getEnt();
		temp.setEnt(arr[m].getEnt());
//		temp[1].setEnt(s1);
		id0=id;

		
		}
	}
return temp;
}





	// Sets up the starting population = strings of 50 bits
	public static void MakeRandomPop(double ETC[][])
	{
		Random generator = new Random();
		
		int i = 0;
		for(i =0; i < 100; i++)
		{
			String member = new String();
			
			int j = 0;
			for(j = 0; j < 100; j++)
			{
				int bit = generator.nextInt(5);
				
				String strI = Integer.toString(bit);
				
					member = member+strI;
				
			}
//			System.out.println(member);
//			double[][] CT=new double[100][7];
//			for(int l=0;l<100;l++){
//				for(int k=0;k<7;k++){
//					CT[l][k]=0.0;
//				}
//			}
//			CT=calCT(member,ETC);
			population[i] = new Entity2(member, fcnNum,ETC);
			
			
			
		}
//		sort(population,50,arr);
//		double fit=population[0].getFit(arr);
//		System.out.println("000000---"+fit);
//		for(i = 1; i < 50; i = i++){
//			System.out.println("Fitness" +population[i].getFit(arr));
//		}
	}
	
	
	
	

}



