//How do we actually determine if three points are on the same line?
//if slope is same. So we calculate slope from each point and keep the count in map
//and base cases are 1: if there are 2 points they are always in the same line
//and slope will be inifinite for points which are in vertical line
//and same with duplicate points
//so we keep track of duplicates and vertical vertices
//we have to keep a note that duplicate points are also vertical points
//and duplicates are also part of normal cases
//so when calculating the max points, we have to start 1(because 1 point is always on line)
//here we are limited by double value
//if we get slope to be too smaller than what double can fit in its decimal value
//then we loose track of it
//instead if we can use GCD for (x1-x2) and (y1-y2) which is restricted by Double.MAX_VALUE
public int maxPoints(Point[] points) {
	Map<Double, Integer> map = new HashMap<>();
	int max = 0;
	map.put(Double.MAX_VALUE, 0);
	int n = points.length;
	for(int i = 0; i < n; i++){
		int x1 = points[i].x;
		int y1 = points[i].y;
		//one point is always on the same line with itself. 
		int dups = 1;
		int verts = 0;
		for(int j = i+1; j < n; j++){
			int x2 = points[j].x;
			int y2 = points[j].y;
			if(x1 == x2 && y1 == y2){
				dups++;
			}else if(x1 == x2){
				verts++;
			}else if(y1 == y2){
                double slope = 0.0;
                map.put(slope, map.getOrDefault(slope, 0)+1);
            }else{
				double slope = (1.0)*(y2-y1)/(x2-x1);
				map.put(slope, map.getOrDefault(slope, 0)+1);
			}
		}

		for(Integer count: map.values()){
			max = Math.max(count+dups, max);
		}
		max = Math.max(dups+verts, max);
		map = new HashMap<>();
	}
	return max;
}