package team.weiyu.culture.util;

import java.util.ArrayList;

import team.weiyu.culture.model.QueryResult;
import team.weiyu.culture.model.TripleObject;

public class RemoveSameElement {

	public static void removeQueryResult(ArrayList<QueryResult> results){
		
		for(int i = 0;i<results.size();i++){
			QueryResult result = results.get(i);
			String subject = result.getName();
			String object = result.getChildren().get(0).getName();
			for(int j = i;j<results.size();j++){
				QueryResult temp = results.get(j);
				if(temp.getName().equals(object)&&temp.getChildren().get(0).getName().equals(subject)){
					results.remove(temp);
					j--;
				}
			}
		}
	}
	
	public static void removeTripleObject(ArrayList<TripleObject> results){
			
			for(int i = 0;i<results.size();i++){
				TripleObject result = results.get(i);
				String subject = result.getSubject();
				String object = result.getObject();
				for(int j = i;j<results.size();j++){
					TripleObject temp = results.get(j);
					if(temp.getSubject().equals(object)&&temp.getObject().equals(subject)){
						results.remove(temp);
						j--;
					}
				}
			}
		}

}
