package com.jw.learning.junit.mockito.verify;

import static org.mockito.Mockito.*;
import java.util.List;

import org.junit.Test;

public class Verify {
	
	@Test
	public void VerifyTest()
	{
		//mock creation
		List mockedList = mock(List.class);
		
		//using mock object
		mockedList.add("one");
		mockedList.add("two");
		mockedList.clear();
		
		//verification
		verify(mockedList).add(eq("two"));
		verify(mockedList).add(eq("one"));
		
		verify(mockedList).clear();
		
		
	}


}
