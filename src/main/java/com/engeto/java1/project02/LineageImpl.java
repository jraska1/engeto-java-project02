/**
 * 
 */
package com.engeto.java1.project02;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author ...
 *
 */
public class LineageImpl implements Lineage {

	@Override
	public void add(Integer id, String name, Date birthDate, Date deathDate, Sex sex, Set<Integer> parents)	throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getBirthDate(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getDeathDate(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sex getSex(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Integer> getParents(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Integer> getChildren(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Integer> getDescendants(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Integer> getAncestors(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Integer> getSiblings(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> findAllByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> findAllAlive() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> sort(List<Integer> ids, SortColumn col) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> sort(List<Integer> ids, SortColumn col, boolean desc) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
