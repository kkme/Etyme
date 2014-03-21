package com.etyme.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.etyme.model.Skills;

public class ListUtil {
	public static Map markSelectedSkills(Collection items, Collection selectedItems) {
		Map<String, Object> selectedMap = new HashMap();
		Iterator itemsItr = items.iterator();
		int c = 0;
		while (itemsItr.hasNext()) {
			Skills skill = (Skills)itemsItr.next();
			String key = "" + c; 
			Iterator selItr = selectedItems.iterator();
			while(selItr.hasNext()) {
				Skills selSkill = (Skills)selItr.next();
				if (skill.getSkillId() ==  selSkill.getSkillId())
					key = "S" + c;							
			}
			selectedMap.put(key, skill);
			c++;
		}
		return selectedMap; 
	}
}
