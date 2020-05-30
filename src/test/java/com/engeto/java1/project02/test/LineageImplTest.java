/**
 * 
 */
package com.engeto.java1.project02.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.engeto.java1.project02.Sex;
import com.engeto.java1.project02.SortColumn;
import com.engeto.java1.project02.LineageImpl;


/**
 * @author raska
 *
 */
class LineageImplTest {

	private LineageImpl l = new LineageImpl();
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.l = new LineageImpl();
		
		this.l.add(1, "Adam", new GregorianCalendar(1900, 1, 1).getTime(), new GregorianCalendar(1999, 5, 13).getTime(), Sex.MALE, null);
		this.l.add(2, "Eva", new GregorianCalendar(1902, 10, 11).getTime(), new GregorianCalendar(1988, 12, 5).getTime(), Sex.FEMALE, null);

		this.l.add(4, "Bedřich", new GregorianCalendar(1948, 9, 5).getTime(), new GregorianCalendar(1998, 3, 28).getTime(), Sex.MALE, null);
		this.l.add(5, "Božena", new GregorianCalendar(1945, 2, 24).getTime(), null, Sex.FEMALE, null);

		this.l.add(10, "Cecilie", new GregorianCalendar(1945, 1, 11).getTime(), new GregorianCalendar(2005, 1, 1).getTime(), Sex.FEMALE, Stream.of(1, 2).collect(Collectors.toSet()));
		this.l.add(11, "Dušan", new GregorianCalendar(1947, 1, 12).getTime(), null, Sex.MALE, Stream.of(1, 2).collect(Collectors.toSet()));
		this.l.add(12, "Emanuel", new GregorianCalendar(1952, 4, 2).getTime(), new GregorianCalendar(2015, 12, 9).getTime(), Sex.MALE, Stream.of(1, 5).collect(Collectors.toSet()));

		this.l.add(21, "David", new GregorianCalendar(1982, 12, 31).getTime(), new GregorianCalendar(2019, 2, 25).getTime(), Sex.MALE, Stream.of(5).collect(Collectors.toSet()));
		this.l.add(22, "Evžen", new GregorianCalendar(1963, 11, 3).getTime(), null, Sex.MALE, Stream.of(4, 5).collect(Collectors.toSet()));
		this.l.add(23, "František", new GregorianCalendar(1965, 10, 2).getTime(), new GregorianCalendar(2009, 3, 22).getTime(), Sex.MALE, Stream.of(4, 5).collect(Collectors.toSet()));
		this.l.add(24, "Gustava", new GregorianCalendar(1968, 5, 12).getTime(), null, Sex.FEMALE, Stream.of(4, 5).collect(Collectors.toSet()));
		
		this.l.add(31, "Honza", new GregorianCalendar(1981, 1, 22).getTime(), null, Sex.MALE, Stream.of(10, 22).collect(Collectors.toSet()));
		this.l.add(32, "Ivan", new GregorianCalendar(1982, 3, 12).getTime(), new GregorianCalendar(1982, 4, 12).getTime(), Sex.MALE, Stream.of(10, 22).collect(Collectors.toSet()));
		this.l.add(33, "Jaromír", new GregorianCalendar(1983, 3, 22).getTime(), null, Sex.MALE, Stream.of(10, 22).collect(Collectors.toSet()));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.engeto.java1.project02.impl.LineageImpl#LineageImpl()}.
	 */
	@Test
	void testLineageImpl() {
		assertNotNull(l);
	}

	/**
	 * Test method for {@link com.engeto.java1.project02.impl.LineageImpl#add(java.lang.Integer, java.lang.String, java.util.Date, java.util.Date, com.engeto.java1.project02.Sex, java.util.Set)}.
	 * @throws Exception 
	 */
	@Test
	void testAdd() throws Exception {

		Assertions.assertThrows(Exception.class, () -> {
			l.add(null, null, null, null, null, null);
		});
		Assertions.assertThrows(Exception.class, () -> {
			l.add(10, null, null, null, null, null);
		});
		Assertions.assertThrows(Exception.class, () -> {
			l.add(10, "Cecil", null, null, null, null);
		});
		Assertions.assertThrows(Exception.class, () -> {
			l.add(10, "Cecil", new GregorianCalendar(1945, 1, 11).getTime(), null, null, null);
		});
		Assertions.assertThrows(Exception.class, () -> {
			l.add(10, "Cecil", new GregorianCalendar(1945, 1, 11).getTime(),  new GregorianCalendar(1945, 1, 1).getTime(), Sex.FEMALE, null);
		});
		
		Assertions.assertThrows(Exception.class, () -> {
			l.add(22, "Evzen", new GregorianCalendar(1921, 1, 3).getTime(), null, Sex.MALE, Stream.of(100, 222).collect(Collectors.toSet()));
		});
		Assertions.assertThrows(Exception.class, () -> {
			l.add(22, "Evzen", new GregorianCalendar(1921, 1, 3).getTime(), null, Sex.MALE, Stream.of(1, 21).collect(Collectors.toSet()));
		});
		Assertions.assertThrows(Exception.class, () -> {
			l.add(22, "Evzen", new GregorianCalendar(1988, 1, 3).getTime(), null, Sex.MALE, Stream.of(1, 21).collect(Collectors.toSet()));
		});
	}

	/**
	 * Test method for {@link com.engeto.java1.project02.impl.LineageImpl#delete(java.lang.Integer)}.
	 * @throws Exception 
	 */
	@Test
	void testDelete() throws Exception {
		l.delete(33);
		
		Assertions.assertThrows(Exception.class, () -> {
			l.delete(10);
		});

		l.delete(31);
		l.delete(32);

		l.delete(10);	
	}

	/**
	 * Test method for {@link com.engeto.java1.project02.impl.LineageImpl#getName(java.lang.Integer)}.
	 * @throws Exception 
	 */
	@Test
	void testGetName() throws Exception {

		assertEquals("Adam", l.getName(1));
		Assertions.assertThrows(Exception.class, () -> l.getName(99));
	}

	/**
	 * Test method for {@link com.engeto.java1.project02.impl.LineageImpl#getBirthDate(java.lang.Integer)}.
	 */
	@Test
	void testGetBirthDate() throws Exception {
		
		assertEquals(new GregorianCalendar(1902, 10, 11).getTime(), l.getBirthDate(2));
		Assertions.assertThrows(Exception.class, () -> {
			l.getBirthDate(99);
		});
	}

	/**
	 * Test method for {@link com.engeto.java1.project02.impl.LineageImpl#getDeathDate(java.lang.Integer)}.
	 * @throws Exception 
	 */
	@Test
	void testGetDeathDate() throws Exception {
		
		assertEquals(new GregorianCalendar(1998, 3, 28).getTime(), l.getDeathDate(4));
		Assertions.assertThrows(Exception.class, () -> {
			l.getDeathDate(99);
		});
	}

	/**
	 * Test method for {@link com.engeto.java1.project02.impl.LineageImpl#getSex(java.lang.Integer)}.
	 * @throws Exception 
	 */
	@Test
	void testGetSex() throws Exception {

		assertEquals(Sex.MALE, l.getSex(1));
		Assertions.assertThrows(Exception.class, () -> l.getSex(99));
	}

	/**
	 * Test method for {@link com.engeto.java1.project02.impl.LineageImpl#getParents(java.lang.Integer)}.
	 */
	@Test
	void testGetParents() throws Exception {
		
		assertTrue(l.getParents(2) == null || l.getParents(2).equals(Stream.of().collect(Collectors.toSet())));
		assertTrue(l.getParents(10).equals(Stream.of(1, 2).collect(Collectors.toSet())));
		assertTrue(l.getParents(21).equals(Stream.of(5).collect(Collectors.toSet())));
	}

	/**
	 * Test method for {@link com.engeto.java1.project02.impl.LineageImpl#getChildren(java.lang.Integer)}.
	 */
	@Test
	void testGetChildren() throws Exception {

		assertTrue(l.getChildren(1).equals(Stream.of(10, 11, 12).collect(Collectors.toSet())));
		assertTrue(l.getChildren(5).equals(Stream.of(12, 21, 22, 23, 24).collect(Collectors.toSet())));

		assertTrue(l.getChildren(21) == null || l.getChildren(21).equals(Stream.of().collect(Collectors.toSet())));
	}

	/**
	 * Test method for {@link com.engeto.java1.project02.impl.LineageImpl#getDescendants(java.lang.Integer)}.
	 * @throws Exception 
	 */
	@Test
	void testGetDescendants() throws Exception {

		assertTrue(l.getDescendants(1).equals(Stream.of(10, 11, 12, 31, 32, 33).collect(Collectors.toSet())));

		assertTrue(l.getDescendants(21) == null || l.getDescendants(21).equals(Stream.of().collect(Collectors.toSet())));
	}

	/**
	 * Test method for {@link com.engeto.java1.project02.impl.LineageImpl#getAncestors(java.lang.Integer)}.
	 */
	@Test
	void testGetAncestors() throws Exception {
		
		assertTrue(l.getAncestors(33).equals(Stream.of(1, 2, 4, 5, 10, 22).collect(Collectors.toSet())));
		assertTrue(l.getAncestors(21).equals(Stream.of(5).collect(Collectors.toSet())));

		assertTrue(l.getAncestors(5) == null || l.getAncestors(5).equals(Stream.of().collect(Collectors.toSet())));
	}

	/**
	 * Test method for {@link com.engeto.java1.project02.impl.LineageImpl#getSiblings(java.lang.Integer)}.
	 */
	@Test
	void testGetSiblings() throws Exception {

		assertTrue(l.getSiblings(21).equals(Stream.of(12, 22, 23, 24).collect(Collectors.toSet())));
		assertTrue(l.getSiblings(33).equals(Stream.of(31, 32).collect(Collectors.toSet())));

		assertTrue(l.getSiblings(5) == null || l.getSiblings(5).equals(Stream.of().collect(Collectors.toSet())));
	}

	/**
	 * Test method for {@link com.engeto.java1.project02.impl.LineageImpl#count()}.
	 * @throws Exception 
	 */
	@Test
	void testCount() throws Exception {
		
		assertEquals(14, l.count());
	}

	/**
	 * Test method for {@link com.engeto.java1.project02.impl.LineageImpl#findAll()}.
	 */
	@Test
	void testFindAll() {
		List<Integer> res = l.findAll();
		
		assertEquals(14, res.size());
		res.stream().collect(Collectors.toSet()).equals(Stream.of(1, 2, 4, 5, 10, 11, 12, 21, 22, 23, 24, 31, 32, 33).collect(Collectors.toSet()));
	}

	/**
	 * Test method for {@link com.engeto.java1.project02.impl.LineageImpl#findAllByName(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	void testFindAllByName() throws Exception {
		List<Integer> res = l.findAllByName("b");
		
		assertEquals(2, res.size());
		res.stream().collect(Collectors.toSet()).equals(Stream.of(4, 5).collect(Collectors.toSet()));
	}

	/**
	 * Test method for {@link com.engeto.java1.project02.impl.LineageImpl#findAllAlive()}.
	 * @throws Exception 
	 */
	@Test
	void testFindAllAlive() throws Exception {
		List<Integer> res = l.findAllAlive();
		
		assertEquals(6, res.size());
		res.stream().collect(Collectors.toSet()).equals(Stream.of(5, 11, 22, 24, 31, 33).collect(Collectors.toSet()));
	}

	/**
	 * Test method for {@link com.engeto.java1.project02.impl.LineageImpl#sort(java.util.List, com.engeto.java1.project02.SortColumn)}.
	 * @throws Exception 
	 */
	@Test
	void testSortListOfIntegerSortColumn() throws Exception {
		assertTrue(l.sort(l.findAll(), SortColumn.name).stream().map(x -> {
			try {
				return l.getName(x);
			} catch (Exception e) {
				return null;
			}
		}).collect(Collectors.toList())
		.equals(Stream.of("Adam", "Bedřich", "Božena", "Cecilie", "David", "Dušan", "Emanuel", "Eva", "Evžen", "František", "Gustava", "Honza", "Ivan", "Jaromír").collect(Collectors.toList())));

		assertTrue(l.sort(l.findAll(), SortColumn.sex).stream().map(x -> {
			try {
				return l.getSex(x).toString();
			} catch (Exception e) {
				return null;
			}
		}).collect(Collectors.toList())
		.equals(Stream.of("MALE", "MALE", "MALE", "MALE", "MALE", "MALE", "MALE", "MALE", "MALE", "MALE", "FEMALE", "FEMALE", "FEMALE", "FEMALE").collect(Collectors.toList())));
	}

	/**
	 * Test method for {@link com.engeto.java1.project02.impl.LineageImpl#sort(java.util.List, com.engeto.java1.project02.SortColumn, boolean)}.
	 * @throws Exception 
	 */
	@Test
	void testSortListOfIntegerSortColumnBoolean() throws Exception {
		
		List<String> names = Stream.of("Adam", "Bedřich", "Božena", "Cecilie", "David", "Dušan", "Emanuel", "Eva", "Evžen", "František", "Gustava", "Honza", "Ivan", "Jaromír").collect(Collectors.toList());
		Collections.sort(names, Collections.reverseOrder());
		
		assertTrue(l.sort(l.findAll(), SortColumn.name, true).stream().map(x -> {
			try {
				return l.getName(x);
			} catch (Exception e) {
				return null;
			}
		}).collect(Collectors.toList()).equals(names));
	}
}
