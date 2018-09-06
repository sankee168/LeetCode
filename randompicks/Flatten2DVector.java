//This is simple itself. we have to try to accomodate all the usecases
public class Vector2D implements Iterator<Integer> {

	Iterator<List<Integer>> mainIter;
	Iterator<Integer> levelIter;
    public Vector2D(List<List<Integer>> vec2d) {
        mainIter = vec2d.iterator();
        if(mainIter.hasNext()) levelIter = mainIter.next().iterator();
    }

    @Override
    public Integer next() {
        return levelIter.next();
    }

    @Override
    public boolean hasNext() {
    	if(levelIter == null) return false;
        if(levelIter.hasNext()) return true;
        while(mainIter.hasNext()){
        	levelIteror = mainIter.next().iterator();
        	if(levelIter.hasNext()) return true;
        }
        return false;
    }
}