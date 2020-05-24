/**
 * 
 */
package com.engeto.java1.project02.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.engeto.java1.project02.Sex;

/**
 * @author raska
 *
 */
public class Person {

	private String name;
	private Date birthDate;
	private Date deathDate;
	private Sex sex;
	private Set<Integer> parents;
	private Set<Integer> children;
	
	public Person(String name, Date birthDate, Date deathDate, Sex sex, Set<Integer> parents) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.deathDate = deathDate;
		this.sex = sex;
		this.parents = parents;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Date getDeathDate() {
		return deathDate;
	}
	
	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Set<Integer> getParents() {
		return parents;
	}

	public void setParents(Set<Integer> parents) {
		this.parents = parents;
	}

	public Set<Integer> getChildren() {
		return children;
	}

	public void setChildren(Set<Integer> children) {
		this.children = children;
	}
	
	public void addChild(Integer id) {
		if (children == null)
			children = new HashSet<Integer>();
		children.add(id);
	}

	public void removeChild(Integer id) {
		if (children != null)
			children.remove(id);
	}
}
