public class permute_46 {

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new ArrayList();
        backtrack(track,nums);
        return list;
    }

    private void backtrack(List<Integer> track,int[] nums) {
        if (track.size() == nums.length) {
            list.add(new ArrayList(track));
            return ;
        }
        for (int i=0;i<nums.length;i++) {
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            backtrack(track,nums);
            track.remove(track.size()-1);
        }
    }
}
