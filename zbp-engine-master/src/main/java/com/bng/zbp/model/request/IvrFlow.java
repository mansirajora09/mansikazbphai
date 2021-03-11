package com.bng.zbp.model.request;

import java.util.HashMap;
import java.util.List;

import com.bng.zbp.model.enums.ActionType;

public class IvrFlow {
	private String[] language;
	private HashMap<String, String> main_audio_file;
	private ActionType type;
	private List<Actions> actions;
	public String[] getLanguage() {
		return language;
	}
	public HashMap<String, String> getMain_audio_file() {
		return main_audio_file;
	}
	public ActionType getType() {
		return type;
	}
	public void setLanguage(String[] language) {
		this.language = language;
	}
	public void setMain_audio_file(HashMap<String, String> main_audio_file) {
		this.main_audio_file = main_audio_file;
	}
	public void setType(ActionType type) {
		this.type = type;
	}
	public List<Actions> getActions() {
		return actions;
	}
	public void setActions(List<Actions> actions) {
		this.actions = actions;
	}
	
}
