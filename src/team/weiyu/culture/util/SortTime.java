package team.weiyu.culture.util;

import java.util.ArrayList;

import org.apache.jena.ontology.OntResource;

public class SortTime {

	public static void sortTime(ArrayList<OntResource> times){
		
		sort(times,0,times.size()-1);
	}
	
	private static void sort(ArrayList<OntResource> times, int start, int end){
		
		if(start>end){
			return ;
		}
		int i = start;
		int j = end;
		int key = Integer.parseInt(times.get(start).getLocalName().substring(1));
		boolean flag = true;
		
		while(i!=j){
			
			if(flag){
				
				if(Integer.parseInt(times.get(j).getLocalName().substring(1))<key){
					swap(times,i,j);
					flag = false;
				}else{
					j--;
				}
			}else{
				
				if(Integer.parseInt(times.get(i).getLocalName().substring(1))>key){
					swap(times,i,j);
					flag = true;
				}else{
					i++;
				}
			}
		}
		
		sort(times,start,i-1);
		sort(times,j+1,end);
	}
	
	private static void swap(ArrayList<OntResource> times,int i,int j){
		OntResource temp = times.get(i);
		times.set(i, times.get(j));
		times.set(j, temp);
	}
}
