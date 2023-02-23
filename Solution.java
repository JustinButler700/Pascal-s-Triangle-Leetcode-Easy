class Solution {
    public List<List<Integer>> generate(int numRows) {
        //Init row 1.
        List<Integer> r1 = new ArrayList<>();
        //Init row 2
        List<Integer> r2 = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        r1.add(1);
        res.add(r1);
        //check range of our numrows.
        if(numRows == 1){
            return res;
        }
        r2.add(1);
        r2.add(1);
        res.add(r2);
        if(numRows ==2){
            return res;
        }
        //if numRows > 2, then we generate the remaining rows.
        return generateRows(numRows, 2, r2, res);
        
    }
    //Helper function to recursively generate all elements in the next row.
    public List<List<Integer>> generateRows(int numRows, int curr, List<Integer> last, List<List<Integer>> res) {
        if(curr == numRows){
            return res;
        }
        else{
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for(int i = 0; i < last.size()-1; i++){
                next.add(last.get(i)+last.get(i+1));
            }
            next.add(1);
            curr++;
            res.add(new ArrayList<>(next));
            generateRows(numRows, curr, next, res);
        }
        return res;
}
}
