package com.mindtree.service;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.Test;

public class NumberToWordTest {

	NumberToWord num2Word=new NumberToWord();

	@Test
	void testInvalidInputPositiveNumbers() {
		try {
			NumberToWord.getNumberToWord(1000);
			fail("Exception");
		}catch(Exception e) {
			assertTrue("Invalid Number".equals(e.getMessage()));
		}
	}
	
	@Test
	void testInvalidInputNegativeNumbers() {
		try {
			NumberToWord.getNumberToWord(-1);
			fail("Exception");
		}catch(Exception e) {
			assertTrue("Invalid Number".equals(e.getMessage()));
		}
		
	}
	
	@Test
	void testValidInput() {
		String input;
		try {

			String path=getClass().getClassLoader().getResource("").getPath();
			System.out.println("Input file path:"+path);
			File fin = new File(path.substring(1)+File.separator+"input_file.txt");
			FileReader reader = new FileReader(fin);
			BufferedReader bufferedReader = new BufferedReader(reader);
			while ((input = bufferedReader.readLine()) != null) {
				String temp[] = input.split("-");
				String output=NumberToWord.getNumberToWord(Integer.parseInt(temp[0])).trim();
				assertTrue(temp[1].trim().equalsIgnoreCase(output));
			}
			bufferedReader.close();

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}
}
