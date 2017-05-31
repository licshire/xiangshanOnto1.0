package team.weiyu.culture.util;

import java.util.HashMap;

public class GetClassURI {

	public static final HashMap<String,String> CLASS_URI = new HashMap<String,String>();
	
	static{
		CLASS_URI.put("民俗", "http://www.owl-ontologies.com/Folk.owl#");
		CLASS_URI.put("方言", "http://www.owl-ontologies.com/Localism.owl#");
		CLASS_URI.put("艺术", "http://www.owl-ontologies.com/Art.owl#");
		CLASS_URI.put("历史事件", "http://www.owl-ontologies.com/Event.owl#");
		CLASS_URI.put("思想精神文化", "http://www.owl-ontologies.com/Think.owl#");
		CLASS_URI.put("组织机构", "http://www.owl-ontologies.com/Organization.owl#");
		CLASS_URI.put("文化遗存", "http://www.owl-ontologies.com/Relics.owl#");
		CLASS_URI.put("香山人物", "http://www.owl-ontologies.com/Individual.owl#");
		CLASS_URI.put("职务和称号", "http://www.owl-ontologies.com/Duty_Title.owl#");
		CLASS_URI.put("地点", "http://www.owl-ontologies.com/Location.owl#");
		CLASS_URI.put("时间", "http://www.owl-ontologies.com/Time.owl#");
	}
}
