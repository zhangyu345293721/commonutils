package com.tool.base.sort;

public class SelectSort{
	public static void main(String[] args){
	    int [] arr={2,3,1,4,6,0,9,3,5};
	    selectSort(arr);

		for(int number:arr){
			 System.out.print(number+" ");		
		}
	}

	private static void selectSort(int [] arr){
	    for(int i=0;i<arr.length-1;i++){		
		    for(int j=i+1;j<arr.length;j++){			 
				 if(arr[i]>arr[j]){
				     temp(arr,i,j);
				 }				  
			}
		}   
	}
	
	private static void temp(int[] arr,int i,int j){
	    int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}