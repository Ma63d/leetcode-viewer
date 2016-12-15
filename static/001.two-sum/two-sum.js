/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    var i = 0;
    var dict = {}
    for(;i<nums.length;i++){
        if(dict[nums[i]] !== undefined){
            return [dict[nums[i]],i];
        }else{
            dict[target-nums[i]] = i;
        }
    }
    return []
};