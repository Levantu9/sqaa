package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Semester;

class SemesterdaoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAll() {

		Semesterdao dao = new Semesterdao();

		assertEquals(dao.getAll().get(0).getSemester(),"hoc ky 1");
		assertEquals(dao.getAll().get(1).getSemester(),"hoc ky 2");
		assertEquals(dao.getAll().get(2).getSemester(),"hoc ky 3");
	}

}
