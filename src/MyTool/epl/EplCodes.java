package MyTool.epl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.EolSystem;
import org.eclipse.epsilon.eol.execute.context.IEolContext;//
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.epl.EplModule;//
import org.eclipse.epsilon.eol.userinput.IUserInput;//
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.models.IModel;

import MyTool.CallEpsilonInJava;

public class EplCodes extends CallEpsilonInJava {
	
public String modelPath;
public String MMPath;
public String codePath;
	
	public  EplCodes(String modelP,String MMP,String codeP)
	{
		modelPath=modelP;
		MMPath=MMP;
		codePath=codeP;
	}
	
	@Override
	public IEolExecutableModule createModule() {
		EplModule module = new EplModule();
		EolSystem system = new EolSystem();
		system.setContext(module.getContext());
		module.getContext().getFrameStack().putGlobal(Variable.createReadOnlyVariable("System",system));
		return module;
		//return new EplModule();
	}

	
	@Override
	public List<IModel> getModels() throws Exception {
		List<IModel> models = new ArrayList<IModel>();
		models.add(createEmfModel("Model", modelPath, 
				 MMPath, true, true));
		return models;
	}

	@Override
	public String getSource() throws Exception {
		return  codePath;
	}

	@Override
	public void postProcess() {
		
	}

	

	
}
