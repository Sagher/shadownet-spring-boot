package com.shadow.net.utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.shadow.net.model.Packet;

public class countByCountry {

	public static TreeMap<String, Integer> countByCountries(List<Packet> packets) {

		ArrayList<String> location = new ArrayList<String>();

		for (int i = 0; i < packets.size(); i++) {
			location.add(packets.get(i).location);
		}

		Map<String, Integer> occurrencies = new HashMap<String, Integer>();
		HashMap<String, Integer> topTen = new HashMap<String, Integer>();

		for (String word : location) {
			occurrencies.put(word, occurrencies.containsKey(word) ? occurrencies.get(word) + 1 : 1);
		}


		java.util.List<Entry<String, Integer>> greatest = findGreatest(occurrencies, 10);
		System.out.println("Top 10 entries:");
		for (Entry<String, Integer> entry : greatest) {
			System.out.println(entry);
			topTen.put(entry.getKey(), entry.getValue());
		}
		ValueComparator bvc = new ValueComparator(topTen);
        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);
        sorted_map.putAll(topTen);
		
		return sorted_map;

	}

	private static <K, V extends Comparable<? super V>> ArrayList<Entry<K, V>> findGreatest(Map<K, V> map, int n) {
		Comparator<? super Entry<K, V>> comparator = new Comparator<Entry<K, V>>() {
			@Override
			public int compare(Entry<K, V> e0, Entry<K, V> e1) {
				V v0 = e0.getValue();
				V v1 = e1.getValue();
				return v0.compareTo(v1);
			}
		};
		PriorityQueue<Entry<K, V>> highest = new PriorityQueue<Entry<K, V>>(n, comparator);
		for (Entry<K, V> entry : map.entrySet()) {
			highest.offer(entry);
			while (highest.size() > n) {
				highest.poll();
			}
		}

		ArrayList<Entry<K, V>> result = new ArrayList<Map.Entry<K, V>>();
		while (highest.size() > 0) {
			result.add(highest.poll());
		}
		return result;
	}

}

class ValueComparator implements Comparator<String> {
	Map<String, Integer> base;

	public ValueComparator(HashMap<String, Integer> mostips) {
		this.base = mostips;
	}

	// Note: this comparator imposes orderings that are inconsistent with
	// equals.
	public int compare(String a, String b) {
		if (base.get(a) >= base.get(b)) {
			return -1;
		} else {
			return 1;
		} // returning 0 would merge keys
	}
}
