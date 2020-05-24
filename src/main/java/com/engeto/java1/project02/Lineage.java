/**
 * 
 */
package com.engeto.java1.project02;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author raska
 *
 */
public interface Lineage {
	
	public void add(Integer id, String name, Date birthDate, Date deathDate, Sex sex, Set<Integer> parents) throws Exception;
	public void delete(Integer id) throws Exception;
	
	public String getName(Integer id) throws Exception;
	public Date getBirthDate(Integer id) throws Exception;
	public Date getDeathDate(Integer id) throws Exception;
	public Sex getSex(Integer id) throws Exception;
	public Set<Integer> getParents(Integer id) throws Exception;

	public Set<Integer> getChildren(Integer id) throws Exception;
	public Set<Integer> getDescendants(Integer id) throws Exception;
	public Set<Integer> getAncestors(Integer id) throws Exception;
	public Set<Integer> getSiblings(Integer id) throws Exception;
	
	public int count();
	
	List<Integer> findAll();
	List<Integer> findAllByName(String name) throws Exception;
	List<Integer> findAllAlive() throws Exception;
	
	List<Integer> sort(List<Integer> ids, SortColumn col) throws Exception; 
	List<Integer> sort(List<Integer> ids, SortColumn col, boolean desc) throws Exception; 
}
