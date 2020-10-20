//Q1.subsets
Solution : To generate all the element in any given array, select an element and follow the path that adds to target
and if in the path we solution is > targett in the output then remove 

Time complexity : exponential
Space : exponential

List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,candidates,target,new ArrayList<Integer>(),0);
        return result;
    }
    
    private void helper(int currSum, int[] candidates, int target , ArrayList<Integer> out , int index ){
        
        if(currSum > target) return ;
        if(currSum == target){
            
            result.add(new ArrayList<Integer>(out));
            //passing by reference.Whatever list ,create referrence coz it's get modified every time
                
            return;
        }
        
        for(int i = index ; i< candidates.length ;i++){
            
            int val = candidates[i];
            //make a choice
            out.add(val);

            //follow path
            helper(currSum + val,candidates,target,out,i);
            //undo the choice
            out.remove(out.size()-1);
            
        }
        
        
    }
    
}