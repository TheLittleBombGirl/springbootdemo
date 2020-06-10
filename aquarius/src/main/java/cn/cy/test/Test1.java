package cn.cy.test;

public class Test1 {
	public static void main(String[] args) {
		String a = "12qw34";
		String b = "5qw789";
		String test = test(a, b);
		System.out.println(test);
	}

	private static String test(String a,String b) {
		String min = (a.length() < b.length())?a:b;
		String max = (a == min)?b:a;
		for(int i = 0; i < min.length(); i++) {
			for(int j = 0,z = min.length() - i; z < min.length(); j++,z++) {
				if(max.contains(min.substring(j, z))) {
					return min.substring(j, z);
				}
			}
		}
		return null;
	}

}
