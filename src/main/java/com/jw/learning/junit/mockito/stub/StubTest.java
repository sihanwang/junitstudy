package com.jw.learning.junit.mockito.stub;

import static org.mockito.Mockito.*;
import java.util.LinkedList;

public class StubTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// You can mock concrete classes, not just interfaces
		LinkedList mockedList = mock(LinkedList.class);

		// stubbing
		when(mockedList.get(0)).thenReturn("first");
		when(mockedList.get(1)).thenThrow(new RuntimeException());

		// following prints "first"
		System.out.println(mockedList.get(0));

		// following throws runtime exception
		// System.out.println(mockedList.get(1));

		// following prints "null" because get(999) was not stubbed
		System.out.println(mockedList.get(999));

		verify(mockedList).get(0);
		verify(mockedList).get(999);

		// will return error, because get(100) was never called
		verify(mockedList).get(100);

		// stubbing using built-in anyInt() argument matcher
		when(mockedList.get(anyInt())).thenReturn("element");

		// following prints "element"
		System.out.println(mockedList.get(999));

		// you can also verify using an argument matcher
		verify(mockedList).get(anyInt());

		// using mock
		mockedList.add("once");

		mockedList.add("twice");
		mockedList.add("twice");

		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");

		// following two verifications work exactly the same - times(1) is used
		// by default
		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");

		// exact number of invocations verification
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");

		// verification using never(). never() is an alias to times(0)
		verify(mockedList, never()).add("never happened");

		// verification using atLeast()/atMost()
		verify(mockedList, atLeastOnce()).add("three times");
		verify(mockedList, atLeast(2)).add("five times");
		verify(mockedList, atMost(5)).add("three times");
		// times(1) 是默认的，因此，使用的 times(1) 可以显示的省略。

		/*
		 * when(mock.someMethod("some arg")) .thenThrow(new RuntimeException())
		 * .thenReturn("foo");
		 * 
		 * //First call: throws runtime exception: mock.someMethod("some arg");
		 * 
		 * //Second call: prints "foo" System.out.println(mock.someMethod(
		 * "some arg"));
		 * 
		 * //Any consecutive call: prints "foo" as well (last stubbing wins).
		 * System.out.println(mock.someMethod("some arg")); 下面是一个精简版本：
		 * 
		 * when(mock.someMethod("some arg")) .thenReturn("one", "two", "three");
		 * //stubbing using custom matcher (let's say isValid() returns your own
		 * matcher implementation):
		 * when(mockedList.contains(argThat(isValid()))).thenReturn("element");
		 * 
		 * verify(mock).someMethod(anyInt(), anyString(), eq("third argument"));
		 * //above is correct - eq() is also an argument matcher
		 * 
		 * verify(mock).someMethod(anyInt(), anyString(), "third argument");
		 * //above is incorrect - exception will be thrown because third
		 * argument is given without an argument matcher.
		 */

	}

}
