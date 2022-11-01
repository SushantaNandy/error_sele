package stream;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class concept {
	@Test(enabled = false)
	public void testcase1() {
		// Tradational ways
		ArrayList<String> a = new ArrayList<String>(); // making an object
		a.add("sus");
		a.add("lulla"); // passing the values
		a.add("surya");
		a.add("sita");
		int count = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).startsWith("s")) {
				count++;
			}
		}
		System.out.println(count);
	}

	@Test(enabled = false)
	public void testcase2() {
		ArrayList<String> b = new ArrayList<String>(); // making an object
		b.add("sus");
		b.add("lulla"); // passing the values
		b.add("surya"); 
		b.add("sita");
		long c = b.stream().filter(s -> s.startsWith("s")).count();
		System.out.println(c);
	}

	@Test(enabled=false)
	public void testcase3() {
		long a = Stream.of("sus", "lulla", "surya", "sita").filter(s -> {
			s.startsWith("l");
			return true;
		}).count();
	}

	@Test(enabled = false)
	public void testcase4() {
		ArrayList<String> c = new ArrayList<String>(); // making an object
		c.add("sus");
		c.add("lulla"); // passing the values
		c.add("surya");
		c.add("sita");
		// for name greater then 3 character
		c.stream().filter(s -> s.length() > 3).forEach(s -> System.out.println(s));
		// for limiting the result to 1
		c.stream().filter(s -> s.length() > 3).limit(1).forEach(s -> System.out.println(s));
	}

	@Test(enabled=false)
	public void testcase5() {
		// find each letter ending with letter a and changing it to upper case by ussing
		// MAP
		// used for string manupulation
		Stream.of("sus", "lulla", "surya", "sita").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
	}
	
	@Test(enabled=false)
	public void testcase6() {
		// converting an array into array list
		List<String>names = Arrays.asList("sus","lulla","surya","sita");
		//sorting of strings starts with "s" and in upper case 
		names.stream().filter(s->s.startsWith("s")).sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
		
		// concanating two array list
		List<String>names1 = Arrays.asList("nandy","swain","prasad","maa");
		Stream<String> newStream =Stream.concat(names.stream(), names1.stream());
		newStream.sorted().forEach(s->System.out.println(s));
		
		// for finding a particualr name present in the stream
		Boolean bn=  newStream.anyMatch(s->s.equalsIgnoreCase("SWAIN"));
		System.out.println(bn);
		assertTrue(bn);
	}
	
	@Test()
	public void testcase7() {
	List<String> str1=Stream.of("sus","swain","maa","lulla").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
	System.out.println(str1.get(0));
	}
}
