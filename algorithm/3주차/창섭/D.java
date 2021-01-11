package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class D {

	public static void main(String[] args) {
		String[] genres ={"classic", "pop", "classic", "classic", "pop"};
		int[] plays ={500, 600, 150, 800, 2500};
		int [] answer = solution(genres, plays);
		System.out.println(Arrays.toString(answer));

	}
	
	 public static int[] solution(String[] genres, int[] plays) {
	       	ArrayList<Integer> l = new ArrayList<>();
	        HashMap<String, PriorityQueue<Music>> map = new HashMap<>();
	        TreeMap<String, Integer> rank = new TreeMap<>();
	        for(int i =0; i<genres.length; i++){
	        		if(!map.containsKey(genres[i])){
	        			PriorityQueue<Music> q = new PriorityQueue<>();
	        			q.add(new Music(i, plays[i]));
	        			map.put(genres[i], q);
	        			rank.put(genres[i], plays[i]);
	        		}
	        		else{
	        			PriorityQueue<Music> q = map.get(genres[i]);
	        			q.add(new Music(i, plays[i]));
	        			map.replace(genres[i], q);
	        			Integer value = rank.get(genres[i]);
	        			rank.replace(genres[i], value+plays[i]);
	        		}
	        }
	        ArrayList<Map.Entry<String, Integer>> list = (ArrayList<Entry<String, Integer>>) rank.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
	        for(int i=list.size()-1; i>=0; i--){
	        		Entry<String, Integer> temp = list.get(i);
	        		String key = temp.getKey();
	        		PriorityQueue<Music> q = map.get(key);
	        		if(q.size()<=2){
	        			while(!q.isEmpty()){
	        				l.add(q.poll().index);	
	        			}
	        		}
	        		else{
	        			for(int j=0; j<2; j++){
	        				l.add(q.poll().index);
	        			}
	        		}
	        }
	        return Arrays.stream(l.toArray(new Integer[l.size()])).mapToInt(Integer::intValue).toArray();
	    }

}

class Music implements Comparable<Music>{
	int index;
	int play;
	
	public Music(int index, int play) {
		this.index = index;
		this.play = play;
	}

	@Override
	public int compareTo(Music o) {
		if(this.play>o.play){
			return -1;
		}
		else if(this.play==o.play){
			return this.index-o.index;
		}
		else{
			return 1;
		}
		
	}
	
}
