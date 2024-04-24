package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there
 * exists a direct path going from cityAi to cityBi. Return the destination
 * city, that is, the city without any path outgoing to another city. It is
 * guaranteed that the graph of paths forms a line without any loop, therefore,
 * there will be exactly one destination city.
 */
public class DestinationCity1436 {
	public String destCity(List<List<String>> paths) {
		Set<String> set = new HashSet<>();
		for (List<String> path : paths) {
			set.add(path.get(1));
		}
		
		for (List<String> path : paths) {
			set.remove(path.get(0));
		}
		
		return set.toArray(new String[1])[0];
	}

}
