//To check if two rectangles overlap or not, we check if they dont overlap
//if they don't overlap, that means first rectangle is in either left, right, top or bottom
//we check that using the vertices
public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] || rec1[0] >= rec2[2] || rec1[1] >= rec2[3] || rec1[3] <= rec2[1]);
    }