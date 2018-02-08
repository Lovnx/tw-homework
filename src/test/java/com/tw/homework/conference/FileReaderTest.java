package com.tw.homework.conference;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class FileReaderTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws Exception {
		Context context;
		
		context = new Context(new FileReader());
		context.operate(Constant.FILE_NAME);
		
		System.out.println(1111111);
	}

}
