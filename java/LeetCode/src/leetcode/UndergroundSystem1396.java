package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndergroundSystem1396 {
	class UndergroundSystem {
		Map<Integer, Record> store = new HashMap<>();
		Map<String, List<Double>> averageStore = new HashMap<>();
		private static final String IN_KEY = "in";
		private static final String OUT_KEY = "out";

		public UndergroundSystem() {

		}

		public void checkIn(int id, String stationName, int t) {
			Record inRecord = new Record();
			inRecord.inStationName = stationName;
			inRecord.inTime = t;
			store.put(id, inRecord);
		}

		public void checkOut(int id, String stationName, int t) {
			Record record = store.get(id);
			String key =  IN_KEY + record.inStationName + OUT_KEY + stationName;
			double cut = t - record.inTime;
			if (averageStore.containsKey(key)) {
				averageStore.get(key).add(cut);
			} else {
				List<Double> list = new ArrayList<>(); 
				list.add(cut);
				averageStore.put(key, list);
			}
		}

		public double getAverageTime(String startStation, String endStation) {
			String key =  IN_KEY + startStation + OUT_KEY + endStation;
			if (!averageStore.containsKey(key)) {
				return 0;
			} else {
				double sum = 0;
				List<Double> list = averageStore.get(key);
				for (int i = 0; i < list.size(); i++) {
					sum +=list.get(i);
				} 
				return sum / list.size();
			}
		}

		class Record {
			String inStationName;
			int inTime;
		}
	}

}
