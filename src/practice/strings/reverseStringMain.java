package practice.strings;

import static practice.strings.reverseStringMethods.reverseWithArray;
import static practice.strings.reverseStringMethods.reverseWithBuilder;

public class reverseStringMain
	{



		static void main()
			{

				String a = "automation";
				System.err.println(reverseWithBuilder(a));
				System.err.println(reverseWithArray(a));
			}

	}
