package edu.ap.spring;

import java.awt.Point;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class Exam {
	
	// Maak gebruik van lambdas en streams om een array met alle
	// priemgetallen terug te geven
	// 2 punten
	public int[] getPrimes(int[] numbers) {
		int[] primesArray = Arrays.stream(numbers)
				//intStream.rangeClosed returns a sequential ordered IntStream from startInclusive to endInclusive by an incremental step of 1
				.filter(i -> IntStream.rangeClosed(2, (int)Math.sqrt(i)).allMatch(j -> i%j != 0))
				.toArray();
		return primesArray;
	}
	
	// Maak gebruik van lambdas en streams om de gegeven zin
	// omgekeerd terug te geven
	// 2 punten
	public String getReverse(String sentence) {
		String reverse = sentence.chars()
				.collect(StringBuilder::new, (b,c) -> b.insert(0,(char)c), (b1,b2) -> b1.insert(0, b2))
				.toString();
		return reverse;
	}
	
	// Maak gebruik van lambdas en streams om het gemiddelde van de Y coordinaten
	// te vinden
	// 2 punten
	public int getAverageY(List<Point> points) {
		int averageY = (int) points
				.stream()
				.mapToInt(p->p.y).average().orElse(Double.NaN);
		return averageY;
	}	
}