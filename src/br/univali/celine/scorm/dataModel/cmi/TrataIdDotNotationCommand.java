package br.univali.celine.scorm.dataModel.cmi;

import br.univali.celine.scorm.rteApi.ErrorManager;
import br.univali.celine.scorm.sn.model.ActivityTree;

public class TrataIdDotNotationCommand implements DotNotationCommand {

	private String keyDataModel;

	public TrataIdDotNotationCommand(String keyDataModel) {
		this.keyDataModel = keyDataModel + ".";
	}

	protected String getKeyDataModel(ErrorManager errorManager) {
		return this.keyDataModel;
	}
	
	
	public String getValue(ErrorManager errorManager, int n, int size) {
		if (n >= size) {
			errorManager.attribError(ErrorManager.GeneralGetFailure);
			return "";
		}
	
		return errorManager.getTree().getDataModel(getKeyDataModel(errorManager)+n);
	}

	protected boolean addItemDataModel(ActivityTree tree, String id, int size, String keyDataModel) {
		
		for (int i = 0; i < size; i++) {
			if (id.equals(tree.getDataModel(keyDataModel+i)))
				return false;
		}
		
		tree.putDataModel(keyDataModel + size, id);
		tree.putDataModel(keyDataModel + "count", String.valueOf(size+1));
		
		return true;
	}
	
	
	public boolean setValue(ErrorManager errorManager, int n, int size, String novoValor) {
		if (n != size) {
			errorManager.attribError(ErrorManager.GeneralSetFailure);
			return false;
		}
		
		// se o indice for diferente do que deveria ser ou o id j� existe 
		if (!addItemDataModel(errorManager.getTree(), novoValor, size, getKeyDataModel(errorManager))) {
			errorManager.attribError(ErrorManager.GeneralSetFailure);
			return false;
		}
		
		return true;
	}

}
