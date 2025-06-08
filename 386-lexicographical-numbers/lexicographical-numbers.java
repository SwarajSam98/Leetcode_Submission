class Solution {
    List<Integer> ans = new ArrayList();
    public List<Integer> lexicalOrder(int n) {
        helper(0, n);
        return ans;
    }
    
    private void helper(int i, int n){
        if(i > n){
            return;
        }
        for(int j = 0; j <= 9; ++j){
            if(i + j == 0){
                continue;
            }else if(i + j > n){
                break;
            }
            ans.add(i + j);
            helper((i + j) * 10, n); 
    }
    }
}