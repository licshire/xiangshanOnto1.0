package team.weiyu.culture.util;

import java.util.List;

import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.rulesys.GenericRuleReasoner;
import org.apache.jena.reasoner.rulesys.Rule;

public class OntoInfer {
	
	public Model Infer(Model model, List<Rule> rules) {

		Reasoner reasoner = new GenericRuleReasoner(rules);
		// 将List形式的规则放入Reason推理机中，GenericRuleReasoner是Reasoner中的通用推理规则推理机

		InfModel inf = ModelFactory.createInfModel(reasoner, model);
		// 构建一个InfModel，是本体的推理模型，将我们的推理机和本体数据放入其中即可实现推理

		Model deductions = inf.getDeductionsModel();
		// InfModel中的getDeductionsModel()方法是获取推理模型中被推理出来的三元组的方法。注：InfModel中包含了推理前和推理后的所有三元组

		// System.out.println("Jena推理机推理成功！");
		
		return deductions;
		// 以Model格式返回推理后的本体数据

	}
}
