class Solution:
    def isMonotonic(self, nums: List[int]) -> bool:
        if len(nums) == 0:
            return True
    
        first = nums[0]
        last = nums[-1]

        if first == last:
            for i in range(len(nums) - 1):
                if nums[i + 1] != nums[i]:
                    return False
        elif first < last:
            # non-decreasing
            for i in range(len(nums) - 1):
                if nums[i + 1] < nums[i]:
                    return False
        else:
            # non-increasing
            for i in range(len(nums) - 1):
                if nums[i + 1] > nums[i]:
                    return False
        
        return True