package edu.univdhaka.iit.twitter.utils;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class DataConnectionPoolTest {

	@Test
	public void testGetConnection() {
		Connection conn = DataConnectionPool.getConnection();
		assertNotNull(conn);
	}

}
