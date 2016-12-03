package com.shadow.net.utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.shadow.net.model.Packet;

public class CountTopTen {

	public static Map<String, Integer> countByCountries(List<Packet> packets) {

		Map<String, Integer> map = new HashMap<String, Integer>();

		ArrayList<String> location = new ArrayList<String>();

		for (int i = 0; i < packets.size(); i++) {

			location.add(packets.get(i).location);

		}
		for (String temp : location) {
			Integer count = map.get(temp);
			map.put(temp, (count == null) ? 1 : count + 1);
		}

		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> one, Entry<String, Integer> two) {

				return (two.getValue()).compareTo(one.getValue());
			}
		});

		int count = 0;
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : list) {
			if (count >= 10)
				break;
			sortedMap.put(entry.getKey(), entry.getValue());
			count++;
		}

		return sortedMap;
	}

	public static Map<String, Integer> countByIps(List<Packet> packets) {

		Map<String, Integer> map = new HashMap<String, Integer>();

		ArrayList<String> location = new ArrayList<String>();

		for (int i = 0; i < packets.size(); i++) {
			if (packets.get(i).direction.equals("INCOMING")) {
				location.add(packets.get(i).sourceIP);
			}
			else if(packets.get(i).direction.equals("OUTGOING")){
				location.add(packets.get(i).destinationIP);

			}
		}
		for (String temp : location) {
			Integer count = map.get(temp);
			map.put(temp, (count == null) ? 1 : count + 1);
		}

		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> one, Entry<String, Integer> two) {

				return (two.getValue()).compareTo(one.getValue());
			}
		});

		int count = 0;
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : list) {

			if (count >= 10)
				break;
			sortedMap.put(entry.getKey(), entry.getValue());
			count++;
		}

		return sortedMap;
	}

}
