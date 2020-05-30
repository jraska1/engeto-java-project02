/**
 * 
 */
package com.engeto.java1.project02.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.engeto.java1.project02.Lineage;
import com.engeto.java1.project02.Sex;
import com.engeto.java1.project02.SortColumn;

/**
 * @author raska
 *
 */
public class LineageImpl implements Lineage {

	private final Map<Integer, Person> data = new HashMap<Integer, Person>();
	
	public LineageImpl() {
		super();
	}

	@Override
	public void add(Integer id, String name, Date birthDate, Date deathDate, Sex sex, Set<Integer> parents)	throws Exception {

		validate(id, name, birthDate, deathDate, sex, parents);
		
		if (data.containsKey(id))
			throw new IllegalArgumentException("Argument 'id' already exists!");
		
		Person person = new Person(name, birthDate, deathDate, sex, parents);
		if (parents != null)
			for (Integer i : parents)
				data.get(i).addChild(id);
		
		data.put(id, person);
	}

	@Override
	public void delete(Integer id) throws Exception {

		if (!data.containsKey(id))
			throw new IllegalArgumentException("Argument 'id' does not exist!");
		
		Person person = data.get(id);
		
		if (person.getChildren() == null || person.getChildren().size() == 0) {
			if (person.getParents() != null)
				for (Integer i : person.getParents())
					data.get(i).removeChild(id);
			data.remove(id);
		}
		else
			throw new Exception("Cannot remove person record due to child association.");
	}

	@Override
	public String getName(Integer id) throws Exception {
		if (!data.containsKey(id))
			throw new IllegalArgumentException("Argument 'id' does not exist!");
		return data.get(id).getName();
	}

	@Override
	public Date getBirthDate(Integer id) throws Exception {
		if (!data.containsKey(id))
			throw new IllegalArgumentException("Argument 'id' does not exist!");
		return data.get(id).getBirthDate();
	}

	@Override
	public Date getDeathDate(Integer id) throws Exception {
		if (!data.containsKey(id))
			throw new IllegalArgumentException("Argument 'id' does not exist!");
		return data.get(id).getDeathDate();
	}

	@Override
	public Sex getSex(Integer id) throws Exception {
		if (!data.containsKey(id))
			throw new IllegalArgumentException("Argument 'id' does not exist!");
		return data.get(id).getSex();
	}

	@Override
	public Set<Integer> getParents(Integer id) throws Exception {
		if (!data.containsKey(id))
			throw new IllegalArgumentException("Argument 'id' does not exist!");
		return data.get(id).getParents();
	}

	@Override
	public Set<Integer> getChildren(Integer id) throws Exception {
		if (!data.containsKey(id))
			throw new IllegalArgumentException("Argument 'id' does not exist!");
		return data.get(id).getChildren();
	}

	@Override
	public Set<Integer> getDescendants(Integer id) throws Exception {
		Set<Integer> res = new HashSet<Integer>();
		if (getChildren(id) != null) {
			for (Integer i : getChildren(id)) {
				res.add(i);
				res.addAll(getDescendants(i));
			}
		}
		return res;
	}

	@Override
	public Set<Integer> getAncestors(Integer id) throws Exception {
		Set<Integer> res = new HashSet<Integer>();
		if (getParents(id) != null) {
			for (Integer i : getParents(id)) {
				res.add(i);
				res.addAll(getAncestors(i));
			}
		}
		return res;
	}

	@Override
	public Set<Integer> getSiblings(Integer id) throws Exception {
		Set<Integer> res = new HashSet<Integer>();
		if (getParents(id) != null) {
			for (Integer i : getParents(id)) {
				if (getChildren(i) != null)
					res.addAll(getChildren(i));
			}
		}
		res.remove(id);
		return res;
	}

	@Override
	public int count() {
		return data.size();
	}

	@Override
	public List<Integer> findAll() {
		return new ArrayList<Integer>(data.keySet());
	}

	@Override
	public List<Integer> findAllByName(String name) throws Exception {
		List<Integer> res = new ArrayList<Integer>();
		if (name != null) {
			for (Entry<Integer, Person> ent : data.entrySet()) {
				if (ent.getValue().getName().toLowerCase().startsWith(name.toLowerCase()))
					res.add(ent.getKey());
			}
		}
		return res;
	}

	@Override
	public List<Integer> findAllAlive() throws Exception {
		List<Integer> res = new ArrayList<Integer>();
		for (Entry<Integer, Person> ent : data.entrySet()) {
			if (ent.getValue().getDeathDate() == null)
				res.add(ent.getKey());
		}
		return res;
	}

	@Override
	public List<Integer> sort(List<Integer> ids, SortColumn col) throws Exception {
		return sort(ids, col, false);
	}

	@Override
	public List<Integer> sort(List<Integer> ids, SortColumn col, boolean desc) throws Exception {
		if (ids != null) {
			ids.sort(new Comparator<Integer>() {

				@Override
				public int compare(Integer id1, Integer id2) {
					int res = 0;
					
					try {
						switch (col) {
						case birth:
							res = getBirthDate(id1).compareTo(getBirthDate(id2));
							break;
						case name:
							res = getName(id1).compareTo(getName(id2));
							break;
						case sex:
							res = getSex(id1).compareTo(getSex(id2));
							break;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return (desc) ? -res : res;
				}
			});
		}
		return ids;
	}

	private void validate(Integer id, String name, Date birthDate, Date deathDate, Sex sex, Set<Integer> parents) throws Exception {

		if (id == null)
			throw new IllegalArgumentException("Argument 'id' should be specified!");
		
		if (name == null || name.length() == 0)
			throw new IllegalArgumentException("Argument 'name' should be specified!");

		if (birthDate == null)
			throw new IllegalArgumentException("Argument 'birthDate' should be specified!");
		
		if (deathDate != null && deathDate.before(birthDate))
			throw new IllegalArgumentException("Bad 'deathDate' argument");

		if (sex == null)
			throw new IllegalArgumentException("Argument 'sex' should be specified!");
		
		if (parents != null) {
			int maleCount = 0;
			int femaleCount = 0;
			for (Integer i : parents) {
				if (getSex(i).equals(Sex.MALE))
					maleCount += 1;
				else if (getSex(i).equals(Sex.FEMALE))
					femaleCount += 1;
				if (getBirthDate(i).after(birthDate))
					throw new IllegalArgumentException("Bad 'parents' argument, parent cannot be younger than his/her child!");
			}
			if (maleCount > 1 || femaleCount > 1) 
				throw new IllegalArgumentException("Bad 'parents' argument, max. one male and female could be specified!");
		}

	}

}
