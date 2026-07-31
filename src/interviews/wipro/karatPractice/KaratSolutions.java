package interviews.wipro.karatPractice;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solutions {

	static List<String> highFailureDetection( String[] logs ) {

		// List<String> result = List.of(logs);
		List<String> result = new ArrayList<>(List.of(logs));


		HashMap<String, Integer> map = new HashMap<>();

		for ( String s : logs ) {

			String[] log = s.split(",");
			String[] time = log[0].split(":");
			int hour = Integer.parseInt(time[0]);
			int min = Integer.parseInt(time[1]);
			String gateway = log[1];
			String service = log[2];
			int code = Integer.parseInt(log[3]);

			if ( code == 500 ) {
				map.put(service, map.getOrDefault(service, 0) + 1);
			}
		}
		map.forEach(( key, value ) -> {
			System.out.println("key: " + key + " value: " + value);
			if ( value > 1 ) {
				result.add(key);
			}
		});

		return result;
	}

	static void main( String[] args ) {

		String[] logs = {
				"10:00,AuthService,DatabaseService,500",
				"10:01,Gateway,AuthService,200",
				"10:02,PaymentService,DatabaseService,500",
				"10:03,AuthService,CacheService,500",
				"10:04,Gateway,DatabaseService,200"
		};

		List<String> list = highFailureDetection(logs);

		for ( String s : list ) {
			System.out.println(s + " had the highest failure rate");
		}
	}
}
