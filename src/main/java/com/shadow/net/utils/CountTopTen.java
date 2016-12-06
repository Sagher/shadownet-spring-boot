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

	/*
	 * Count top 10 countries
	 * 
	 * @param (List<Packet>)
	 * 
	 * return Map<String,Integer>
	 */
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

	/*
	 * Count top 10 ips
	 * 
	 * @param (List<Packet>)
	 * 
	 * return Map<String,Integer>
	 */
	public static Map<String, Integer> countByIps(List<Packet> packets) {

		Map<String, Integer> map = new HashMap<String, Integer>();

		ArrayList<String> ips = new ArrayList<String>();

		for (int i = 0; i < packets.size(); i++) {
			if (packets.get(i).direction.equals("INCOMING")) {
				ips.add(packets.get(i).sourceIP);
			} else if (packets.get(i).direction.equals("OUTGOING")) {
				ips.add(packets.get(i).destinationIP);

			}
		}
		for (String temp : ips) {
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

	/*
	 * Count top 10 urls
	 * 
	 * @param (List<Packet>)
	 * 
	 * return Map<String,Integer>
	 */
	public static Object countByUrls(List<Packet> packets) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		ArrayList<String> urls = new ArrayList<String>();

		for (int i = 0; i < packets.size(); i++) {
			if (packets.get(i).requestUrl != null)
				urls.add(packets.get(i).requestUrl);
		}
		for (String temp : urls) {
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

	/*
	 * Count top 10 hashes
	 * 
	 * @param (List<Packet>)
	 * 
	 * return Map<String,Integer>
	 */
	public static Object countByHash(List<Packet> packets) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		ArrayList<String> hashes = new ArrayList<String>();

		for (int i = 0; i < packets.size(); i++) {
			if (packets.get(i).hash != null)
				hashes.add(packets.get(i).hash);
		}
		for (String temp : hashes) {
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
